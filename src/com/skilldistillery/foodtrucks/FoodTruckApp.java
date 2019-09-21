package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckApp {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FoodTruckApp f = new FoodTruckApp();
		
		// Allows user selection and prints menu
		f.menuSelection(scanner);
		

		scanner.close();
	}
	
	// Menu selection and outputs
	public void menuSelection(Scanner kb) {
		boolean run = true;
		while(run) {
			menu();
			// String used rather than int, so user entered strings or chars won't break program.
			String userSelection = kb.next();
			switch(userSelection) {
	//			case "1": break;
	//			case "2": break;
	//			case "3": break;
	//			case "4": break;
				case "5": run = false;
						  System.out.println("\n~ Ciao! ~");
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
			    .append("\n")
			    .append(" 1. Rate trucks\n")
			    .append(" 2. See ratings\n")
			    .append(" 3. Average rating\n")
			    .append(" 4. Best truck\n")
			    .append(" 5. Quit\n");
		System.out.println(menu);
	}
}