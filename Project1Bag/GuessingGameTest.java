package project1;
import java.util.Scanner;
import java.util.Random;
public class GuessingGameTest {//use methods to clean the main class more

	private LinkedBag <Integer> gameBag;
	private LinkedBag <Integer> userBag;
	
	private void fillRandom() {
		
	}
	
	private void fillFromUser(Scanner sc) {
		
	}
	public static void main(String[] args) {
	
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the size of the bag: " + "any random integers");
		int n = scnr.nextInt();
		System.out.println("Enter range of integers: ");
		int m = scnr.nextInt();
		LinkedBag<Integer> bag = new LinkedBag<Integer>(n);
		Random r = new Random();
		for (int i = 1; i <= n; i++) {
			int num = r.nextInt(m + 1);
			if (num == 0) {
				i--;
			}
			else
				bag.add(num);
		}
		int guess = 0;
		String choice = "Yes";
		int correct;
		while (choice.equals("Yes")) {
			System.out.println("Enter your guesses for the " + n + " intergers in the range that have been selected");
			int intVal;
			correct = 0;
			for (int i = 1; i <= n; i++) {//bag 1234 user guess 2222 it will say correct because it checks for the same 2
				intVal = scnr.nextInt();
				if (bag.contains(intVal))
					correct++;
			}
			if (n == correct) {
				correct = 0;
				System.out.println("You are correct! Do you want to play agian?");
				choice = scnr.next();
			} else {
				if (guess == 5) {
					break;
				}
				System.out.println(correct + " of your guesses are correct. Guess again!");
				guess++;
			}
		}
		System.out.println("Good-bye!");
		scnr.close();
	}
}
