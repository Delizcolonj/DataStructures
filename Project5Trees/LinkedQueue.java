package Project5SortedTreeList;

public class LinkedQueue<T> implements QueueInterface<T> {

	private Node firstNode;
	private Node lastNode;

	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	}

	private class Node {
		private T data;
		private Node next;

		public T getData() {
			return data;
		}

		private void setData(T data) {
			this.data = data;
		}

		private Node getNext() {
			return next;
		}

		private void setNext(Node next) {
			this.next = next;
		}

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	@Override
	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNext(newNode);
		lastNode = newNode;
	}

	@Override
	public T dequeue() {
		T front = getFront();
		assert firstNode != null;
		firstNode.setData(null);
		firstNode = firstNode.getNext();
		if (firstNode == null)
			lastNode = null;
		return front;
	}

	@Override
	public T getFront() {
		if (isEmpty())
			throw new EmptyQueueException();
		else
			return firstNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}

}
