package com.skilldistillery.foodtrucks;

import java.awt.List;
import java.util.Scanner;

public class FoodTruckApp {
	
	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		FoodTruck[] truck = null;
		app.run(truck);
	}
	
	public void run(FoodTruck[] truck) {
		Scanner kb = new Scanner(System.in);
		menuSelection(kb, truck);
		kb.close();
	}
	
	// Gets user input via scanner and returns a populated FoodTruck[] array.
	public FoodTruck[] getUserInput(Scanner kb, FoodTruck[] truck) {
		// Determines array size.
		System.out.print("How many food trucks are you adding? ");
		int numOfTrucks = kb.nextInt();
		kb.nextLine();  // resolves nextLine errors
		truck = new FoodTruck[numOfTrucks];
		
		// For Loop gets name, food type, and rating
		for (int i = 0; i < numOfTrucks; i++) {	
			System.out.println("\n-- Truck " + (i + 1) + " --");
			System.out.print("Food truck name: ");
			String truckName = kb.nextLine();
			System.out.print("Food type: ");
			String foodType = kb.nextLine();
			System.out.print("numeric rating (1-5): ");
			int rating = kb.nextInt();
			kb.nextLine(); // resolves nextLine errors

			truck[i] = new FoodTruck(truckName, foodType, rating);
		}
		System.out.println("\nDone with input.  Returning to menu.");
		// Updated menu.  Entering 2-4 will now return appropriate values.
		menuSelection(kb, truck);
		return truck;
	}

	// Menu selection and outputs
	public void menuSelection(Scanner kb, FoodTruck[] truck) {
		boolean run = true;
		while(run) {
			menu();
			// String used rather than int, so user entered strings or chars won't break program.
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
	
	// Visual menu
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

	// CASE 2:   List all existing food trucks.
	public void viewRatings(FoodTruck[] truckList) {
		if (truckList == null) {
			System.out.println("You have not entered any data in yet!");
		}
		else {
			for (int i = 0; i < truckList.length; i++) {
				System.out.println(truckList[i].output());
			}
		}
	}
	
	// Exception prevents user from accidently erasing list
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
	
	// Case 3:  Returns average rating
	public void averageRatings(FoodTruck[] truckList) {
		if (truckList == null) {
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
	
	// Case 4:  Returns best rated
	public void bestRated(FoodTruck[] truckList) {
		if (truckList == null) {
			System.out.println("You have not entered any data in yet!");
		}
		else {
			int highestRating = 0;
			String bestTruck = "";
			for (int i = 0; i < truckList.length; i++) {
				if (highestRating < truckList[i].getRating()){
					highestRating = truckList[i].getRating();
					bestTruck = truckList[i].output();
				}
			} System.out.println(bestTruck);
		}
	}
	
}