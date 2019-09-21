package com.skilldistillery.foodtrucks;

public class FoodTruck {

	// F I E L D S
	private static int truckId = 0;
	private String truckName;
	private String foodType;
	private int rating;
	
	
	// C O N S T R U C T O R S
	public FoodTruck() {
	}
	
	public FoodTruck(String truckName, String foodType, int rating) {
		this(0, truckName, foodType, rating);
	}
	
	public FoodTruck(int truckId, String truckName, String foodType, int rating) {
		this.truckId = truckId;
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
	}

	// M E T H O D S
	public String output() {
		return getTruckName() + " " + foodType + " " + rating;
	}
	
	public static int getTruckId() {
		return truckId;
	}


	public static void setTruckId(int truckId) {
		FoodTruck.truckId = truckId;
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
	
	public int getRating() {
		return rating;
	}


	public void setRating(String truckName) {
		this.rating = rating;
	}
	
	
}
