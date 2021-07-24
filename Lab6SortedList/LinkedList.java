package Lab6SortedList;

import Lab4List.Node;

public class LinkedList<T> implements ListInterface<T> {
	private Node<T> firstNode;
	private int numberOfEntries;

	public LinkedList() {
		firstNode = null;
		numberOfEntries = 0;
	}
	@Override
	public void add(T newEntry) {
		Node<T> toInsert = new Node<>(newEntry);
		numberOfEntries++;

		if (firstNode == null) {
			firstNode = toInsert;
			return;
		}
		boolean endFound;
		Node<T> currNode = firstNode;
		Node<T> nextNode = firstNode.getNext();

		do {
			endFound = (nextNode == null);
			if (!endFound) {
				currNode = nextNode;
				assert (nextNode != null);
				nextNode = nextNode.getNext();
			}
		} while (!endFound);
		assert (currNode != null);
		currNode.setNext(toInsert);
	}

	@Override
	public void add(int newPosition, T newEntry) {
		if (newPosition < 0 || newPosition > getLength())
			throw new IndexOutOfBoundsException();

		Node<T> toInsert = new Node<>(newEntry);
		numberOfEntries++;

		if (newPosition == 0) {
			toInsert.setNext(firstNode);
			firstNode = toInsert;
			return;
		}
		int idx = 0;
		boolean found = false;
		Node<T> after = firstNode, before = null;
		do {
			if (idx == newPosition) {
				found = true;
				assert (before != null);
				before.setNext(toInsert);
				toInsert.setNext(after);
			} else {
				before = after;
				after = after.getNext();
				idx++;
			}
		} while (!found);
	}

	@Override
	public T remove(int givenPosition) {
		if (isEmpty())
			throw new NullPointerException();
		if (givenPosition < 0 || givenPosition >= getLength())
			throw new IndexOutOfBoundsException();
		T dataItem = firstNode.getData();
		Node<T> nextNode;
		numberOfEntries--;

		if (givenPosition == 0)
			firstNode = firstNode.getNext();
		else {
			Node<T> currNode = getNodeAt(givenPosition - 1);
			nextNode = currNode.getNext();
			dataItem = nextNode.getData();
			currNode.setNext(nextNode.getNext());
		}
		return dataItem;
	}

	@Override
	public boolean remove(T anEntry) {
		boolean result = false;
		Node<T> node = getReferenceTo(anEntry);

		if (node != null) {
			node.setData(firstNode.getData());
			firstNode = firstNode.getNext();
			numberOfEntries--;
			result = true;
		}
		return result;
	}

	@Override
	public void clear() {
		if (!isEmpty()) {
			firstNode = null;
		}
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			Node<T> Node = getNodeAt(givenPosition);
			T originalEntry = (T) Node.getData();
			Node.setData(newEntry);
			return originalEntry;
		} else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	}

	@Override
	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return (T) getNodeAt(givenPosition).getData();
		} else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	}

	@Override
	public int getLength() {
		int numEntries = 0;
		for (Node<T> currNode = firstNode; currNode != null; currNode = currNode.getNext())
			numEntries++;
		return numEntries;
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node<T> currNode = firstNode;

		while (!found && (currNode != null)) {
			if (anEntry.equals(currNode.getData()))
				found = true;
			else
				currNode = currNode.getNext();
		}
		return found;
	}

	@Override
	public Object[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		int index = 0;
		Node<T> currNode = firstNode;

		while ((index < numberOfEntries) && (currNode != null)) {
			result[index] = (T) currNode.getData();
			index++;
			currNode = currNode.getNext();
		}
		return result;
	}

	private Node<T> getNodeAt(int index) {
		assert (index >= 0 && index < getLength());

		Node<T> currNode = firstNode;
		for (int i = 0; i < index; i++)
			currNode = currNode.getNext();
		return currNode;
	}

	private Node<T> getReferenceTo(T anEntry) {
		boolean found = false;
		Node<T> currNode = firstNode;
		while (!found && (currNode != null)) {
			if (anEntry.equals(currNode.getData()))
				found = true;
			else
				currNode = currNode.getNext();
		}
		return currNode;
	}
}
