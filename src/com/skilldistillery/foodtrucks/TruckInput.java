package com.skilldistillery.foodtrucks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TruckInput extends FoodTruckApp {
	FoodTruck reset = new FoodTruck();
	
	// *** CASE 1:
	// *** Rate trucks - Gets input and puts it in truck[] array
	public FoodTruck[] getUserInput(Scanner kb, FoodTruck[] truck) {

		// A) Determines array size.
		int numOfTrucks = 0;
		do {
			try {
				System.out.print("How many food trucks are you adding? ");
				numOfTrucks = kb.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("Invalid entry. ");
				kb.next();
			}
		} while (numOfTrucks <= 0);
		kb.nextLine(); // resolves nextLine errors

		// B) Creates new truck array and initializes newTruck in case "quit" is entered.
		// Also resets ID (mainly added for when getUserInput() runs more than once).  
		// To keep incrementing Id, this can be deleted.
		truck = new FoodTruck[numOfTrucks];
		reset.setId();
		FoodTruck[] newTruck = null;

		// C) For Loop gets name, food type, and rating
		for (int i = 0; i < numOfTrucks; i++) {
			System.out.println("\n-- Truck " + (i + 1) + " --");
			System.out.print("Food truck name: ");
			String truckName = kb.nextLine();

			// C1) If quit is entered, a newTruck[] is created and returned
			if (truckName.equalsIgnoreCase("quit")) {
				newTruck = new FoodTruck[i];
				for (int i2 = 0; i2 < newTruck.length; i2++) {
					newTruck[i2] = truck[i2];
				}
				menuSelection(kb, newTruck);
				return newTruck;
			} else {

				// D) Continues loop if quit is not entered. Enter food type
				System.out.print("Food type: ");
				String foodType = kb.nextLine();

				// E) Enter rating. Do loop prevents InputMismatchException error.
				int rating = -1;
				while (rating > 5 || rating < 0) {
					do {
						try {
							System.out.print("Numeric rating (0-5): ");
							rating = kb.nextInt();
							if (rating > 5 || rating < 0) {
								System.out.print("Invalid entry. ");
							}
						} catch (InputMismatchException e) {
							System.out.print("Invalid entry. ");
							kb.next();
						}
					} while (rating == -1);
				}
				kb.nextLine(); // resolves nextLine errors

				// F) New food truck is created
				truck[i] = new FoodTruck(truckName, foodType, rating);
//			truck[i] = new FoodTruck();
//			truck[i].setFoodType(foodType);
//			truck[i].setTruckName(truckName);
//			truck[i].setRating(rating);
			}
		}

		// G) Returns truck and returns to menu.
		System.out.println("\nDone with input.  Returning to menu.");
		menuSelection(kb, truck);
		return truck;
	}

	// *** CASE 1 EXCEPTION:
	// *** Prevents user from accidently creating new list
	public boolean exception(Scanner kb, FoodTruck[] truckList, boolean run) {
		run = true;
		if (truckList != null) {
			System.out.print("This will remove the current truck list.  Continue?  (Y / N) ");
			String exceptionResponse = kb.next();
			if (exceptionResponse.equalsIgnoreCase("Y")) {
				run = true;
			} else if (exceptionResponse.equalsIgnoreCase("N")) {
				System.out.println("Roger! Returning to menu.\n");
				run = false;
			} else {
				System.out.println("Invalid response.  Returning to menu.\n");
				run = false;
			}
		}
		return run;
	}
}