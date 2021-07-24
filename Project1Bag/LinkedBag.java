package project1;


import java.util.Arrays;

public class LinkedBag<T> implements BagInterface<T> {
	private Node<T> firstNode;
	private int numberOfEntries;


	public LinkedBag() { // empty bag
		firstNode = null;
		numberOfEntries = 0;
	}
	public LinkedBag(int bagSize) {
		numberOfEntries = bagSize;
	}
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		if (firstNode == null) {
			assert (numberOfEntries == 0);
			return true;
		}
		return false;
	}

	@Override
	public boolean add(T newEntry) {// core method
		Node<T> aNode = new Node<T>(newEntry);
		aNode.setNext(firstNode);
		firstNode = aNode;
		numberOfEntries++;
		return true;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean remove(T anEntry) {
		for (Node<T> curr = firstNode; curr != null; curr = curr.getNext()) {
			if (anEntry.equals(curr.getData())) {
				curr.setData(firstNode.getData());
				firstNode = firstNode.getNext();
				numberOfEntries--;
				return true;
			}
		}
		return false;
	}

	@Override
	public T remove() {
		if ((isEmpty())) {
			return null;
		}
		T item = firstNode.getData();
		firstNode = firstNode.getNext();
		numberOfEntries--;
		return item;
	}

	@Override
	public void clear() {
		while (!isEmpty()) {
			remove();
		}
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node<T> currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNext();
		} // end while

		return found;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int counter = 0;
		Node<T> currentNode = firstNode;

		while ((counter < numberOfEntries) && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData())) {
				frequency++;
			}
			counter++;
			currentNode = currentNode.getNext();
		}
		return frequency;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[numberOfEntries];
		int index = 0;
		for (Node<T> curr = firstNode; curr != null; curr = curr.getNext()) {
			array[index++] = curr.getData();
		}
		return array;
	}

	@Override
	public T[] toArray(T[] a) {
		T[] result = Arrays.copyOf(a, numberOfEntries);
		int index = 0;
		for (Node<T> curr = firstNode; curr != null; curr = curr.getNext()) {
			result[index] = (T) a[index];
		}
		return result;
	}

	public boolean equals(Object obj) {
		// return true if both the objects are the same
		if (this == obj) {
			return true;
		}
		// return false if the parameter obj is null
		if (obj == null) {
			return false;
		}
		// convert obj from Object to LinkedBag<T>
		@SuppressWarnings("unchecked")
		LinkedBag<T> other = (LinkedBag<T>) obj;

		// return false if the number of entries in
		// two objects are not equal
		if (numberOfEntries != other.numberOfEntries) {
			return false;
		}
		// get the first node from this bag
		Node<T> thisCurrent = firstNode;

		// get the first node from other bag
		Node<T> otherCurrent = other.firstNode;

		// repeat the loop for all nodes in the bag
		while (thisCurrent != null) {
			// return false if the data in any of the
			// corresponding nodes are not equal
			if (!thisCurrent.getData().equals(otherCurrent.getData())) {
				return false;
			}
			// get the next node from this bag
			thisCurrent = thisCurrent.getNext();
			// get the next node from other bag
			otherCurrent = otherCurrent.getNext();
		}
		// return true if the content in both objects are equal
		return true;

	}

	public LinkedBag<T> intersection(LinkedBag<T> anotherBag) {
		// declare the required objects and variables
		LinkedBag<T> intersectionBag = new LinkedBag<T>();
		LinkedBag<T> anotherBagCopy = new LinkedBag<T>();
		Node<T> current;

		// copy all entries from anotherBag to anotherBagCopy
		current = ((LinkedBag<T>) anotherBag).firstNode;
		while (current != null) {
			anotherBagCopy.add(current.getData());
			current = current.getNext();
		}
		// repeat the loop for all entries in this bag
		current = firstNode;
		while (current != null) {
			// verify whether the anotherBagCopy
			// contains the current entry of this bag
			if (anotherBagCopy.contains(current.getData())) {
				// add the current entry of this bag to
				// intersectionBag
				intersectionBag.add(current.getData());
				// remove the current entry of this bag
				// from anotherBagCopy
				anotherBagCopy.remove(current.getData());
			}
			// move to the next node
			current = current.getNext();
		}
		// return the intersectionBag
		return intersectionBag;
	}

	public LinkedBag<T> union(LinkedBag<T> anotherBag) {
		// declare the required objects and variables
		LinkedBag<T> unionBag = new LinkedBag<T>();
		Node<T> current;

		// copy all entries from this bag to unionBag
		current = firstNode;
		while (current != null) {
			unionBag.add(current.getData());
			current = current.getNext();
		}

		// copy all entries from anotherBag to unionBag
		current = ((LinkedBag<T>) anotherBag).firstNode;
		while (current != null) {
			unionBag.add(current.getData());
			current = current.getNext();
		}

		// return the unionBag
		return unionBag;

	}
	public LinkedBag<Integer> copy() {
		// TODO Auto-generated method stub
		return null;
	}
}
