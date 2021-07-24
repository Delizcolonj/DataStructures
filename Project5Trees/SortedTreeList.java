package Project5SortedTreeList;

import java.util.Iterator;

public class SortedTreeList<T extends Comparable<? super T>> implements SortedListInterface<T>, Iterable<T> {

	private BinarySearchTree<T> tree;

	// Constructor
	public SortedTreeList() {
		tree = new BinarySearchTree<T>();
	}

	public void addEntry(T newEntry) {
		if (tree.getRootData() == null) {
			tree.setTree(newEntry);
		} else {
			tree.add(newEntry);
		}

	}

	public boolean removeEntry(T anEntry) {
		return tree.remove(anEntry) == anEntry;
	}

	public int getPosition(T newEntry) {
		Iterator<T> iter = iterator();
		int counter = 0;
		while (iter.hasNext()) {
			if (newEntry.equals(iter.next())) {
				return counter;
			} else {
				counter++;
			}
		}
		return counter;
	}

	public T getEntry(int givenPosition) {
		Iterator<T> iter = iterator();
		int counter = 0;
		while (iter.hasNext()) {
			if (counter == givenPosition) {
				return iter.next();
			} else {
				iter.next();
				counter++;
			}
		}
		return null;
	}

	public boolean contains(T anEntry) {
		return tree.contains(anEntry);
	}

	public T remove(int givenPosition) {
		return tree.remove(getEntry(givenPosition));

	}

	public void clear() {
		tree.clear();
	}

	public int getLength() {
		if (tree.getRootData() == null) {
			return 0;
		}
		return tree.getNumberOfNodes();
	}

	public boolean isEmpty() {
		return (getLength() == 0);
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() {
		Iterator<T> iter = iterator();
		T[] temp = (T[]) new Comparable[getLength()];
		int index = 0;
		while (iter.hasNext()) {
			temp[index] = iter.next();
			index++;
		}

		return temp;
	}

	@Override
	public Iterator<T> iterator() {
		return tree.getInorderIterator();
	}
}