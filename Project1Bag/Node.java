package project1;

public class Node<T> {
	private T data;
	private Node<T> next;
	
	Node (T data, Node<T> nextNode) {
		this.setData(data);
		setNext(nextNode);
	}
	Node (T data) {
		this (data, null);
	}
	
	//Getters and setters for private variables
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = (Node<T>) next;
	}
}
