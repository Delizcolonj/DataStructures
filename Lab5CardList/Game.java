package Lab5CardList;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArrayList<Card> userHand = new ArrayList<>();
		Pile deck = new Pile(52);
		deck.fill();
		
		Card card1 = new Card(Rank.ace, Suit.diamonds);
		//System.out.print(card1);
		
		userHand.add(card1);
		
		deck.remove(card1);
		//System.out.print(deck);
	}

}
