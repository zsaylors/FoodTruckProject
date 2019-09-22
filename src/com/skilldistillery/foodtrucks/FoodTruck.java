package com.skilldistillery.foodtrucks;

public class FoodTruck {

	// F I E L D S
	private static int truckId = 1;
	private int newTruckId = 0;
	private String truckName;
	private String foodType;
	private int rating;

	// C O N S T R U C T O R S
	public FoodTruck() {
	}

	public FoodTruck(String truckName, String foodType, int rating) {
		this(0, truckName, foodType, rating);
		newTruckId = assignId();
	}

	public FoodTruck(int newTruckId, String truckName, String foodType, int rating) {
		this.newTruckId = newTruckId;
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
	}

	// M E T H O D S
	public String toString() {
		StringBuilder menu = new StringBuilder("ID: ").append(newTruckId)
				.append(",  Truck Name: ")
				.append(truckName)
				.append(",  Food Type: ")
				.append(foodType)
				.append(",  Rating: ")
				.append("(" + rating + "/5) ")
				.append(getStars());
		return menu.toString();
	}

	public int assignId() {
		this.newTruckId = truckId++;
		return newTruckId;
	}
	
	public void setId() {
		truckId = 1;
	}

	public int getRating() {
		return rating;
	}
	

	private String getStars() {
		String stars = "";
		for (int i = 0; i < getRating() && i < 5; i++) {
			stars += " \u2b50";
		}
		return stars;
	}

//  Below setters and getters not used, as program stands.
//
//	public String getFoodType() {
//	return foodType;
//	}	
//	
//	public String getTruckName() {
//		return truckName;
//	}
//
//	public void setTruckName(String truckName) {
//		this.truckName = truckName;
//	}
//
//	public void setFoodType(String foodType) {
//		this.foodType = foodType;
//	}
//
//	public void setRating(int rating) {
//		this.rating = rating;
//	}
	
}