package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private static int nextTruckId = 1; // Each truck gets a unique ID
	private int truckId;
	private String truckName;
	private String foodType;
	private double rating;

	public FoodTruck(String truckName, String foodType, double rating) {
		this.truckId = nextTruckId++;
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
	}

	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Truck ID: " + truckId + "\nTruck Name: " + truckName + "\nFood Type: " + foodType + "\nRating: "
				+ rating;
	}
}
