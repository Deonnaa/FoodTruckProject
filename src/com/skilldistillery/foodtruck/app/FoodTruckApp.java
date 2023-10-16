package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	private Scanner scanner = new Scanner(System.in);
	private FoodTruck[] fleet = new FoodTruck[5];
	private int truckCount = 0;

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.run();
	}

	public void run() {

		System.out.println("Welcome to Food Truck Rating App!");

		for (int i = 0; i < fleet.length; i++) {
			System.out.println("Enter the name of Food Truck " + (i + 1) + " (or enter 'Quit' to stop): ");
			String name = scanner.nextLine();

			if ("Quit".equalsIgnoreCase(name)) {
				break; // Exit the loop if the user enters 'Quit'
			}

			System.out.println("Enter the type of food served by " + name + ": ");
			String foodType = scanner.nextLine();

			System.out.println("Enter the rating for " + name + ": ");
			double rating = scanner.nextDouble();
			scanner.nextLine();

			fleet[i] = new FoodTruck(name, foodType, rating);
			truckCount++;
		}

		while (true) {
			printMenu();

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			if (choice == 1) {
				listFoodTrucks();
			} else if (choice == 2) {
				calculateAverageRating();
			} else if (choice == 3) {
				displayHighestRatedTruck();
			} else if (choice == 4) {
				System.out.println("This is the 'end' of the line ... of code!");
				break; // Exit the loop if the user chooses to quit
			} else {
				System.out.println("Invalid choice. Please enter a number between 1 and 4.");
			}
		}
	}

	public void printMenu() {
		System.out.println("Choose an option: ");
		System.out.println("1: List all existing food trucks.");
		System.out.println("2: See the average rating of food trucks.");
		System.out.println("3: Display the highest-rated food truck.");
		System.out.println("4: Quit the program.");
	}

	public void listFoodTrucks() {
		if (truckCount == 0) {
			System.out.println("There are no food trucks in the list.");
		} else {
			System.out.println("List of Food Trucks:");
			for (int i = 0; i < truckCount; i++) {
				FoodTruck truck = fleet[i];
				System.out.println(truck.toString());
			}
		}
	}

	public void calculateAverageRating() {
		if (truckCount == 0) {
			System.out.println("There are no food trucks in the list.");
		} else {
			double totalRating = 0.0;
			for (int i = 0; i < truckCount; i++) {
				totalRating += fleet[i].getRating();
			}
			double averageRating = totalRating / truckCount;
			System.out.println("Average Rating of Food Trucks: " + averageRating);
		}
	}

	public void displayHighestRatedTruck() {
		if (truckCount == 0) {
			System.out.println("There are no food trucks in the list.");
		} else {
			double highestRating = fleet[0].getRating();
			String highestRatedTruck = fleet[0].getTruckName();

			for (int i = 1; i < truckCount; i++) {
				double currentRating = fleet[i].getRating();
				if (currentRating > highestRating) {
					highestRating = currentRating;
					highestRatedTruck = fleet[i].toString();
				}
			}
			System.out.println("Highest-Rated Food Truck: \n" + highestRatedTruck);
		}
	}
}
