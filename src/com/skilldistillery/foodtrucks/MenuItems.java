package com.skilldistillery.foodtrucks;

public class MenuItems {

	// *** CASE 2:
	// *** Returns list of entered food trucks
	public void viewRatings(FoodTruck[] truckList) {
		if (truckList == null || truckList.length == 0) {
			System.out.println("You have not entered any data in yet!");
		} else {
			for (int i = 0; i < truckList.length; i++) {
				System.out.println(truckList[i].toString());
			}
		}
	}

	// *** CASE 3:
	// *** Returns average rating
	public void averageRatings(FoodTruck[] truckList) {
		if (truckList == null || truckList.length == 0) {
			System.out.println("You have not entered any data in yet!");
		} else {
			double sum = 0;
			for (int i = 0; i < truckList.length; i++) {
				sum += truckList[i].getRating();
			}
			System.out.printf("The average food truck rating is %.2f%n", sum / truckList.length);
		}
	}

	// *** CASE 4:
	// *** Returns best rated
	public void bestRated(FoodTruck[] truckList) {
		if (truckList == null || truckList.length == 0) {
			System.out.println("You have not entered any data in yet!");
		} else {
			int highestRating = 0;
			String bestTruck = "";
			for (int i = 0; i < truckList.length; i++) {
				if (highestRating < truckList[i].getRating()) {
					highestRating = truckList[i].getRating();
					bestTruck = truckList[i].toString();
				}
			}
			System.out.println(bestTruck);
		}
	}

	// *** CASE 5:
	// *** Different ways to say goodbye
	public void goodbye() {
		String[] bye = { "Godspeed!", "Ciao!", "Bye!", "So long, and thanks for all the fish!", "Adios!",
				"I bid you adieu.", "Hasta la vista, baby!", "Auf wiedersehen!" };
		System.out.println("~ " + bye[(int) Math.round(Math.random() * (bye.length - 1))] + " ~");
	}

}