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
		boolean loop = true;
		MenuItems select = new MenuItems();
		TruckInput run = new TruckInput();

		while (loop) {
			menu();
			// Note: String used rather than integer, so user entered strings or chars will
			// throw default exception.
			String userSelection = kb.next();
			switch (userSelection) {
			case "1":
				if (run.exception(kb, truck, loop)) {
					run.getUserInput(kb, truck);
					loop = false;
				}
				break;
			case "2":
				select.viewRatings(truck);
				break;
			case "3":
				select.averageRatings(truck);
				break;
			case "4":
				select.bestRated(truck);
				break;
			case "5":
				select.goodbye();
				loop = false;
				break;
			default:
				System.out.println("\nInvalid reponse.  Please pick a number 1 - 5.");
				break;
			}
		}
	}

	// VISUAL MENU
	public void menu() {
		StringBuilder menu = new StringBuilder("____________________\n")
				.append(" HELLO, FOOD TRUCK! \n")
				.append("\uD83C\uDF2E\uD83C\uDF2D - Menu - \uD83E\uDD68\uD83C\uDF55\n")
				.append(" 1. Rate trucks\n")
				.append(" 2. See ratings\n")
				.append(" 3. Average rating\n")
				.append(" 4. Best truck\n")
				.append(" 5. Quit");
		System.out.println(menu);
	}
}