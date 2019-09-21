package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckApp {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		FoodTruckApp app = new FoodTruckApp();
		FoodTruck[] truck = null;
		app.menuSelection(kb, truck);
		kb.close();
	}

	// MENU
	public void menuSelection(Scanner kb, FoodTruck[] truck) {
		boolean run = true;
		while(run) {
			menu();
			// Note: String used rather than integer, so user entered strings or chars will throw default exception.
			String userSelection = kb.next();
			switch(userSelection) {
				case "1": if (exception(kb, truck, run)) {
							  getUserInput(kb, truck);
							  run = false;
						  }
						  break;
				case "2": viewRatings(truck);
						  break;
				case "3": averageRatings(truck);
						  break;
				case "4": bestRated(truck);
						  break;  
				case "5": System.out.println("~ Ciao! ~");
						  run = false;
						  break;
				default: System.out.println("\nInvalid reponse.  Please pick a number 1 - 5.");
						 break;
			}
		}
	}
	
	// VISUAL MENU
	public void menu() {
		StringBuilder menu = new StringBuilder
					   ("____________________\n")
				.append(" FOOD TRUCK REVIEWS  \n")
				.append("_____ - Menu - _____\n")
			    .append(" 1. Rate trucks\n")
			    .append(" 2. See ratings \u2b50\n")
			    .append(" 3. Average rating\n")
			    .append(" 4. Best truck\n")
			    .append(" 5. Quit\n");
		System.out.println(menu);
	}

	// CASE 1 - Rate trucks - Gets input and puts it in truck[] array
	public FoodTruck[] getUserInput(Scanner kb, FoodTruck[] truck) {
		
		// A) Determines array size.
		System.out.print("How many food trucks are you adding? ");
		int numOfTrucks = kb.nextInt();
		kb.nextLine();  // resolves nextLine errors
		truck = new FoodTruck[numOfTrucks];
		FoodTruck[] newTruck = null;
		
		// B) For Loop gets name, food type, and rating
		for (int i = 0; i < numOfTrucks; i++) {	
			System.out.println("\n-- Truck " + (i + 1) + " --");
			System.out.print("Food truck name: ");
			String truckName = kb.nextLine();
			
			// B1) If quit is entered, a newTruck[] is created and returned
			if (truckName.equalsIgnoreCase("quit")) {	
				newTruck = new FoodTruck[i];		
				for (int i2 = 0; i2 < newTruck.length; i2++) {
					newTruck[i2] = truck[i2];
				}
				menuSelection(kb, newTruck);
				return newTruck;
			} else {

			// B2) Continues loop is quit is not entered
			System.out.print("Food type: ");
			String foodType = kb.nextLine();
			System.out.print("numeric rating (1-5): ");
			int rating = kb.nextInt();
			kb.nextLine();

			//truck[i] = new FoodTruck(truckName, foodType, rating);
			truck[i] = new FoodTruck();
			truck[i].setFoodType(foodType);
			truck[i].setTruckName(truckName);
			truck[i].setRating(rating);
			}
		}
		
		// C) Returns truck (if B1 does not occur), and returns to menu.
		System.out.println("\nDone with input.  Returning to menu.");
		menuSelection(kb, truck);
		return truck;
	}
	
	// CASE 1 Exception: prevents user from accidently erasing list
	public boolean exception(Scanner kb, FoodTruck[] truckList, boolean run) {
		run = true;
		if (truckList != null) {
			System.out.print("This will reset the food truck list.  Continue?  (Y / N) ");
			String exceptionResponse = kb.next();
			if (exceptionResponse.equalsIgnoreCase("Y")) {
				run = true;
			}
			else if (exceptionResponse.equalsIgnoreCase("N")) {
				System.out.println("Roger! Returning to menu.\n");
				run = false;
			}
			else {
				System.out.println("Invalid response.  Returning to menu.\n");
				run = false;
			}
		}
		return run;
	}
	
	// CASE 2:   List all existing food trucks.
	public void viewRatings(FoodTruck[] truckList) {
		if (truckList == null || truckList.length == 0) {
			System.out.println("You have not entered any data in yet!");
		}
		else {
			System.out.println(truckList.length);
			System.out.println("ID \t Name \t Food Type \t Rating");
			for (int i = 0; i < truckList.length; i++) {
				System.out.println(truckList[i].toString());
			}
		}
	}
	
	// CASE 3:  Returns average rating
	public void averageRatings(FoodTruck[] truckList) {
		if (truckList == null || truckList.length == 0) {
			System.out.println("You have not entered any data in yet!");
		}
		else {
			double sum = 0;
			for (int i = 0; i < truckList.length; i++) {
				sum += truckList[i].getRating();
			}
			System.out.printf("The average food truck rating is %.2f%n", sum/truckList.length);
		}
	}
	
	// CASE 4:  Returns best rated
	public void bestRated(FoodTruck[] truckList) {
		if (truckList == null || truckList.length == 0) {
			System.out.println("You have not entered any data in yet!");
		}
		else {
			int highestRating = 0;
			String bestTruck = "";
			for (int i = 0; i < truckList.length; i++) {
				if (highestRating < truckList[i].getRating()){
					highestRating = truckList[i].getRating();
					bestTruck = truckList[i].toString();
				}
			} System.out.println(bestTruck);
		}
	}
	
}