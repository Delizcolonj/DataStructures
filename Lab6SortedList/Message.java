package Lab6SortedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Message {

	private SortedLinkedList<Packet> sortedMessage;

	public Message(String fileName) {
		try {
			Scanner file = new Scanner(new File(fileName));

			while (file.hasNext()) {
				sortedMessage.addEntry(new Packet(file.nextLine()));
			}
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found! " + e);
		}
	}

	public String compose() {
		String output = "";

		Packet[] packets = (Packet[]) sortedMessage.toArray();

		for (Packet p : packets)
			output += p.getText();
		return output;
	}
}