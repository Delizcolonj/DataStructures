package Lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Route {

	private Station[] routeStations;
	public int numStations;

	public Route(String filename) {

		try {
			File orange = new File("orange.txt");
			Scanner input = new Scanner(orange);
			numStations = 0;
			
			//looping through the file to check how many stations are in it
			while (input.hasNextLine()) { 
				String val = input.nextLine();
				numStations++;
			}

			input.close();

			routeStations = new Station[numStations];
			Scanner input2 = new Scanner(orange);
			int i = 0;

			while (input2.hasNextLine()) {
				String name = input2.nextLine();
				routeStations[i] = new Station(name);
				i++;
			}
			input2.close();

		} 
		catch (FileNotFoundException ex) {
			System.out.println("orange.txt not found");
			throw new AssertionError();
		}

		// Add random amount of passengers to station
		Random rand = new Random();
		int randValue = 0;

		for (int i = 0; i < routeStations.length; i++) {
			randValue = rand.nextInt(5);
			for (int j = 0; j < randValue; j++) {
				Passenger newPassenger = new Passenger(routeStations);
				routeStations[i].passengerArrival(newPassenger);
			}
		}

		// Print each station and their passengers
		for (int i = 0; i < routeStations.length; i++) {
			
			System.out.println("---------------------------");
			System.out.println(routeStations[i].getName());
			System.out.println(" Passengers:\n");

			while (routeStations[i].isFull()) {
				Passenger p = routeStations[i].passengerLeave();
				System.out.println(p);
			}

			System.out.println("===========================\n");
		}
	}
}