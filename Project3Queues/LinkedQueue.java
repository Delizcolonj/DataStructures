package Project3Queues;

import Lab3.EmptyQueueException;
import Lab3.Node;
import Lab3.QueueInterface;

public class LinkedQueue<T> implements QueueInterface<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;

	public LinkedQueue() {
		setFirstNode(null);
		setLastNode(null);
	}

	@Override
	public void enqueue(T newEntry) {
		Node<T> newNode = new Node<>(newEntry, null);
		if (isEmpty()) {
			firstNode= newNode;
		} else {
			firstNode.setNext(newNode);
			setLastNode(newNode);
		}

	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		T front = firstNode.getData();
		firstNode = firstNode.getNext();
		if (firstNode == null) {
			setLastNode(null);
		}
		return front;
	}

	@Override
	public T getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return firstNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null;
	}

	@Override
	public void clear() {
		if (!isEmpty()) {
			firstNode = null;
			setLastNode(null);
		}

	}

	public Node<T> getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(Node<T> firstNode) {
		this.firstNode = firstNode;
	}

	public Node<T> getLastNode() {
		return lastNode;
	}

	public void setLastNode(Node<T> lastNode) {
		this.lastNode = lastNode;
	}

}