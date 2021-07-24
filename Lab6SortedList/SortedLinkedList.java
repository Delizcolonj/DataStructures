package Lab6SortedList;

public class SortedLinkedList<T extends Comparable<? super T>> extends LinkedList<T> implements SortedListInterface<T> {
	private LinkedList<T> list;

	public SortedLinkedList() {
		list = new LinkedList<>();
	}

	public T remove(int givenPosition) {
		return list.remove(givenPosition);
	}

	@SuppressWarnings("unchecked")
	public T getEntry(int givenPosition) {
		return ((SortedListInterface<T>) list).getEntry(givenPosition);
	}

	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	}

	public void addEntry(T newEntry) {
		int position = getPosition(newEntry);
		if (position < 0)
			position = -position - 1;
		list.add(position, newEntry);
	}

	@SuppressWarnings("unchecked")
	public int getLength() {
		return ((SortedListInterface<T>) list).getLength();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int getPosition(T newEntry) {
		int position = 0;
		int length = getLength();

		while ((position < length) && (newEntry.compareTo(getEntry(position)) > 0)) {
			position++;
		}

		if ((position >= length) || (newEntry.compareTo(getEntry(position)) != 0)) {
			position = -position; // anEntry is not in list
		}
		return position;
	}

	public boolean removeEntry(T givenEntry) {
		boolean result = false;
		int position = getPosition(givenEntry);

		if (position > 0) {
			list.remove(position);
			result = true;
		}
		return result;
	}

	public Object[] toArray() {
		return list.toArray();
	}

	public void clear() {
		list.clear();
	}
}
