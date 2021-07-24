package Lab7DoublyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements ListInterface<T>, Iterable<T> {

	private DoubleNode<T> head;
	private DoubleNode<T> tail;
	private int numberOfEntries;

	public DoublyLinkedList() {
		initializeDataFields();
	}

	private enum Move {
		NEXT, PREV
	};

	private class IteratorForLinkedList implements ListIterator<T> {

		private DoubleNode<T> nextNode;
		private DoubleNode<T> currNode;
		private DoubleNode<T> prevNode;
		private boolean nextWasCalled = false;
		private Move lastMove;

		public IteratorForLinkedList() {
			nextNode = head; // was getFirstNode();
			currNode = null;
			prevNode = null;
			if (nextNode == null) {
				throw new IllegalStateException();
			}
		}

		public boolean hasNext() {
			return (nextNode != null);
		}

		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			T result = nextNode.getData();
			prevNode = currNode;
			currNode = nextNode;
			nextNode = nextNode.getNext();
			nextWasCalled = true;
			lastMove = Move.NEXT;
			return result;
		}

		public void remove() {
			if (!nextWasCalled)
				throw new IllegalStateException();
			if (prevNode != null)
				prevNode.setNext(nextNode);
			else
				head = nextNode;
			currNode = prevNode;
			nextWasCalled = false;
			lastMove = Move.PREV;
		}

		public boolean hasPrevious() {
			return (currNode != null);
		}

		public T previous() {
			if (hasPrevious()) {
				T result = currNode.getData();
				nextNode = currNode;
				currNode = prevNode;
				if (hasPrevious())
					prevNode = prevNode.getPrev();
				nextWasCalled = true;
				return result;
			} else
				throw new NoSuchElementException();
		}

		public int nextIndex() {
			return DoublyLinkedList.this.getPosition(nextNode.getData());
		}

		public int previousIndex() {
			return DoublyLinkedList.this.getPosition(prevNode.getData());
		}

		public void add(T newEntry) {
			nextWasCalled = false;
			DoublyLinkedList.this.add(nextIndex(), newEntry);

		}

		public void set(T newEntry) {
			if (nextWasCalled) {
				if (lastMove.equals(Move.NEXT))
					prevNode.setData(newEntry);
				else {
					assert lastMove.equals(Move.PREV);
					nextNode.setData(newEntry);
				}
			} else
				throw new IllegalStateException();
		}

	}

	public ListIterator<T> getListIterator() {
		return iterator1();
	}

	public ListIterator<T> iterator1() {
		return new IteratorForLinkedList();
	}

	private void initializeDataFields() {
		head = null;
		tail = null;
		numberOfEntries = 0;
	}

	@Override
	public void add(int newPosition, T newEntry) {
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			DoubleNode<T> newNode = new DoubleNode<>(newEntry);
			if (newPosition == 1) {
				newNode.setNext(head);
				head = newNode;
				tail = newNode;
			} else if (newPosition == numberOfEntries) {
				newNode.setPrev(tail);
				tail.setNext(newNode);
				tail = newNode;
			} else {
				DoubleNode<T> nodeBefore = getNodeAt(newPosition - 1);
				DoubleNode<T> nodeAfter = nodeBefore.getNext();
				newNode.setNext(nodeAfter);
				newNode.setPrev(nodeBefore);
				nodeAfter.setPrev(newNode);
				nodeBefore.setNext(newNode);
			}
			numberOfEntries++;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	private DoubleNode<T> getNodeAt(int givenPosition) {
		assert (head != null) && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		DoubleNode<T> currentNode = head;
		for (int i = 1; i < givenPosition; i++) {
			currentNode = currentNode.getNext();
		}
		assert currentNode != null;
		return currentNode;
	}

	@Override
	public T remove(int givenPosition) {
		T result = null;
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			if (givenPosition == 1) {
				result = head.getData();
				head = head.getNext();
			} else if (givenPosition == numberOfEntries) {
				result = tail.getData();
				tail = tail.getPrev();
			} else {
				DoubleNode<T> nodeBefore = getNodeAt(givenPosition - 1);
				DoubleNode<T> nodeToRemove = nodeBefore.getNext();
				result = nodeToRemove.getData();
				DoubleNode<T> nodeAfter = nodeToRemove.getNext();
				nodeBefore.setNext(nodeAfter);
			}
			numberOfEntries--;
			return result;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void clear() {
		initializeDataFields();
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= getLength())) {
			assert !isEmpty();
			DoubleNode<T> desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return getNodeAt(givenPosition).getData();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];

		int i = 0;
		DoubleNode<T> currentNode = head;
		while ((i < numberOfEntries) && (currentNode != null)) {
			result[i] = currentNode.getData();
			currentNode = currentNode.getNext();
			i++;
		}
		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		DoubleNode<T> currentNode = head;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNext();
		}
		return found;
	}

	private int getPosition(T anEntry) {
		boolean found = false;
		int count = 0;
		DoubleNode<T> currentNode = head;
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNext();
			count++;
		}
		return count;
	}

	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		boolean result;
		if (numberOfEntries == 0) {
			assert head == null;
			assert tail == null;
			result = true;
		} else {
			assert head != null;
			assert tail != null;
			result = false;
		}
		return result;
	}

	public void reverse() {
		DoubleNode<T> temp = null;
		DoubleNode<T> curr = head;
		tail = curr;
		while (curr != null) {
			temp = curr.getPrev();
			curr.setPrev(curr.getNext());
			curr.setNext(temp);
			curr = curr.getPrev();
		}
		if (temp != null) {
			head = temp.getPrev();
		}

	}

	@Override
	public void add(T newEntry) {
		add(++numberOfEntries, newEntry);

	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}
}
