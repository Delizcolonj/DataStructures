package Lab5CardList;

public interface CardListInterface {

	public void add(Card newCard);
	
	public boolean remove(Card aCard);
	
	public Card remove(int position);
	
	public void clear();
	
	public boolean contains(Card aCard);
	
	public boolean handIsEmpty();
	
	public boolean handIsFull();
	
	public int getLengthOfHand();
	
	public Card getCard(int position); //getEntry?
	
	//private void checkHand(int numberOfCards);
	
	//private void ensureEnoughInHand();
	
	
}
