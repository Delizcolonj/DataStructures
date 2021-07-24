package Lab6SortedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Packet implements Comparable<Packet> {
	private String message;

	public Packet(String message) {
		this.message = message;
	}

	public int getNumber() {
		String number = "";
		try {
			Scanner file = new Scanner(new File("encoded.txt"));
			while (file.hasNext()) {
				message = file.nextLine();
				number = message.replaceAll("[^0-20]", "");
			}
			file.close();
		} catch (FileNotFoundException e) {
			System.out.print(e);
		}
		return Integer.parseInt(number);
	}

	public String getText() {
		String result = "";
		try {
			Scanner file = new Scanner(new File("encoded.txt"));
			while (file.hasNext()) {
				message = file.nextLine();
				result = message.replaceAll("", message);
			}
			file.close();
		} catch (FileNotFoundException e) {
			System.out.print(e);
		}
		return result;
	}

	public int compareTo(Packet p) {
		return this.getNumber() - p.getNumber();
	}
}