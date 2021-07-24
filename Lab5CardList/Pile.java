package Lab5CardList;

import java.util.Arrays;

public class Pile implements CardListInterface {
	private Card[] hand;
	private int numberOfCards;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 52; // for the deck
	private static final int MAX_CAPACITY = 52;// for the user

	public Pile(int capacity) {
		if (capacity < DEFAULT_CAPACITY)
			capacity = DEFAULT_CAPACITY;
		else
			checkCapacity(capacity);
		this.capacity = capacity;
		Card[] temp = (Card[]) new Card[capacity];
		hand = temp;
		numberOfCards = 0;
	}

	public Pile() {
		numberOfCards = 0;
		capacity = 0;
	}

	public void fill() {
		int i = 0;
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				hand[i] = new Card(r, s);
				i++;
				capacity++;
				numberOfCards++;
			}
		}
	}

	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY) {
			throw new IllegalArgumentException();
		}
	}

	private void ensureCapacity() {
		if (numberOfCards >= capacity) {
			capacity *= 2;
			checkCapacity(capacity);
			hand = Arrays.copyOf(hand, capacity);
		}
	}

	@Override
	public void add(Card newCard) {
		hand[numberOfCards] = newCard;
		numberOfCards++;
		ensureCapacity();
	}

	@Override
	public boolean remove(Card aCard) {
		boolean result = false;
		int position = 0;
		aCard = getCard((int) position);
		if (position > 0) {
			hand[position] = remove(position);
			result = true;
		} // end if
		return result;
	}

	public Card remove(int position) {
		Card aCard;
		if (position < 0 || position >= numberOfCards)
			throw new IndexOutOfBoundsException("Illegal Position given to remove operation");
		aCard = hand[position];
		removeGap(position);
		numberOfCards--;
		return aCard;
	}

	private void removeGap(int position) {
		assert (position >= 0 && position < numberOfCards);
		for (int index = position; index < numberOfCards - 1; index++) {
			hand[index] = hand[index + 1];
		}
	}

	@Override
	public void clear() {
		if (!handIsEmpty()) {
			for (int i = 0; i <= numberOfCards; i++) {
				hand[numberOfCards - i] = null;
				i++;
			}
		}
	}

	@Override
	public boolean contains(Card aCard) {
		boolean found = false;
		int index = 1;

		while (!found && (index <= numberOfCards)) {
			if (aCard.equals(hand[index]))
				found = true;
			index++;
		}
		return found;
	}

	@Override
	public boolean handIsEmpty() {
		return hand == null;
	}

	@Override
	public boolean handIsFull() {
		return numberOfCards == capacity;
	}

	@Override
	public int getLengthOfHand() {
		return numberOfCards;
	}

	@Override
	public Card getCard(int position) {
		int length = hand.length;
		position = 0;
		while ((position <= length) && (hand.length > 0)) {
			position++;
		}

		if ((position > length) || (hand.length) != 0) {
			position = -position;
		}
		return hand[position];
	}

	public void shuffle() {
		for (int i = 0; i < hand.length; i++) {
			int index = (int) (Math.random());
			Card temp = hand[i];
			hand[i] = hand[index];
			hand[index] = temp;
			numberOfCards--;
		}
	}
}
