package Lab1;

import java.util.Arrays;

public class ResizeableArrayBag<T> implements BagInterface<T> {
	private static final int DEFAULT_CAPACITY = 50;
	private T[] bagArray;
	private int numberOfEntries;
	private int capacity;

	public ResizeableArrayBag(int defaultCapacity) {
		@SuppressWarnings("unchecked")
		T[] temparray = (T[]) new Object[defaultCapacity];
		bagArray = temparray;
		numberOfEntries = 0;
		this.capacity = defaultCapacity;
	}

	public ResizeableArrayBag() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unused")
	private boolean isFull() {
		return (numberOfEntries == capacity);
	}

	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		if (isFull()) {
			return false;
		}
		bagArray[numberOfEntries] = newEntry;
		numberOfEntries++;
		return true;
	}

	@Override
	public boolean remove(T anEntry) {
		boolean found = false;
		for (int index = 0; index < numberOfEntries && !found; index++) {
			if (anEntry.equals(bagArray[index])) {
				found = true;
				bagArray[index] = bagArray[numberOfEntries - 1];
				bagArray[numberOfEntries - 1] = null;
				numberOfEntries--;
			}
		}
		return found;
	}

	@Override
	public T remove() {
		if (isEmpty()) {
			return null;
		}
		T temp = bagArray[numberOfEntries - 1];
		numberOfEntries--;

		return temp;
	}

	@Override
	public void clear() {
		while (!isEmpty()) {
			remove();
		}

	}

	@Override
	public boolean contains(T anEntry) {
		for (int index = 0; index < numberOfEntries; index++) {
			if (bagArray[index] == anEntry) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		for (int index = 0; index < numberOfEntries; index++) {
			if (anEntry.equals(bagArray[index])) {
				counter = counter + index;
				return counter;
			}
		}
		return 0;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for (int count = 0; count < numberOfEntries; count++)
			result[count] = bagArray[count];
		return result;
	}

	@Override
	public T[] toArray(T[] a) {
		T[] result = Arrays.copyOf(bagArray, numberOfEntries);
		for (int index = 0; index < numberOfEntries; index++)
			result[index] = (T) bagArray[index];
		return result;
	}

	public boolean equals(ResizeableArrayBag<T> other) {
		T[] array1 = toArray();

		ResizeableArrayBag<T> copybag = other.copy();

		for (int i = 0; i < array1.length; i++) {
			if (!copybag.remove(array1[i])) {
				return false;
			}
		}
		return copybag.isEmpty();
	}
	private ResizeableArrayBag<T> copy() {
		return this;
	}
	public ResizeableArrayBag<T> intersection(ResizeableArrayBag<T> bag1) {
        ResizeableArrayBag<T> bag2 = new ResizeableArrayBag<>(); 

        for(int index = 0; index < numberOfEntries; index++) {
        	if (bag2.getFrequencyOf(bagArray[index])>0) {
        		bag2.add(bagArray[index]);
        	}
        }
		return bag2;
        }
	public ResizeableArrayBag<T> union(ResizeableArrayBag<T> bag1) {
		ResizeableArrayBag<T> bag2 = new ResizeableArrayBag<T>();
		int length = numberOfEntries + bag1.numberOfEntries;
		for(int index = 0; index<length; index++) {
			if(index<numberOfEntries) {
				bag2.add(bagArray[index]);
			}
			else {
				bag2.add(bag2.bagArray[index-numberOfEntries]);
			}
		}
		return bag2;
	}

}
