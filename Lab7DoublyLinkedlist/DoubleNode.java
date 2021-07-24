package Lab7DoublyLinkedList;

public class DoubleNode<T> {
	
	private T data;
	private DoubleNode<T> next;
	private DoubleNode<T> prev;

	public DoubleNode(T data) {
		this.data = data;
		next = null;
		prev = null;
	}

	public T getData() {
		return data;
	}
	public DoubleNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}

	public DoubleNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DoubleNode<T> prev) {
		this.prev = prev;
	}

	public void setData(T newEntry) {
		this.data = newEntry;

	}
}