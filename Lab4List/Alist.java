package Lab4List;

import java.util.Arrays;

public class Alist<T> implements ListInterface<T> {
	private T[] list;
	private int numberOfEntries;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 10000;

	public Alist(int capacity) {
		if (capacity < DEFAULT_CAPACITY)
			capacity = DEFAULT_CAPACITY;
		else
			checkCapacity(capacity);
		this.capacity = capacity;
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[capacity];
		list = temp;
		numberOfEntries = 0;
	}

	private void checkCapacity(int capacity2) {
		if (capacity > MAX_CAPACITY) {
			throw new IllegalArgumentException();
		}
	}

	public Alist() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public void add(T anEntry) {
		list[numberOfEntries] = anEntry;
		numberOfEntries++;
		ensureCapacity();
	}

	@Override
	public Object[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for (int idx = 0; idx < numberOfEntries; idx++)
			result[idx] = list[idx];
		return result;
	}

	private void ensureCapacity() {
		if (numberOfEntries >= capacity) {
			capacity *= 2;
			checkCapacity(capacity); 
			list = Arrays.copyOf(list, capacity);
		}
	}

	private void makeRoom(int newPosition) {
		assert (newPosition >= 0 && newPosition <= numberOfEntries);
		for (int idx = numberOfEntries; idx > newPosition; idx--)
			list[idx] = list[idx - 1];
	}

	public void add(int newPosition, T newEntry) {
		if (newPosition < 0 || newPosition > numberOfEntries)
			throw new IndexOutOfBoundsException();
		makeRoom(newPosition);
		list[newPosition] = newEntry;
		numberOfEntries++;
		ensureCapacity();
	}

	private void removeGap(int givenPosition) {
		assert (givenPosition >= 0 && givenPosition < numberOfEntries);
		for (int index = givenPosition; index < numberOfEntries - 1; index++) {
			list[index] = list[index + 1];
		}
	}

	public T remove(int givenPosition) {
		T theEntry;
		if (givenPosition < 0 || givenPosition >= numberOfEntries)
			throw new IndexOutOfBoundsException("Illegal Position given to remove operation");
		theEntry = list[givenPosition];
		removeGap(givenPosition);
		numberOfEntries--;
		return theEntry;
	}

	@Override
	public boolean remove(T anEntry) {
		boolean result = false;
		int position = getEntry((int) anEntry);
		if (position > 0) {
			list[position] = remove(position);
			result = true;
		} // end if
		return result;
	}

	@Override
	public void clear() {
		int i = 0;
		while (i <= numberOfEntries) {
			list[numberOfEntries - i] = null;
			i++;
		}
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			T originalEntry = list[givenPosition];
			list[givenPosition] = newEntry;
			return originalEntry;
		} else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	}

	@Override
	public int getEntry(int givenPosition) {
		int length = list.length;
		givenPosition = 0;
		while ((givenPosition <= length) && (list.length > 0)) {
			givenPosition++;
		}

		if ((givenPosition > length) || (list.length) != 0) {
			givenPosition = -givenPosition;
		}
		return givenPosition;
	}

	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return list == null;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries)) {
			if (anEntry.equals(list[index]))
				found = true;
			index++;
		}
		return found;
	}

}
