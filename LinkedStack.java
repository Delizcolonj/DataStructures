package Lab2Stacks;

import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {
	 
	private Node<T> topNode;
	
	public LinkedStack () {
        topNode = null;
    }

	@Override
	public void push(T anEntry) {
		Node<T> dataNode = new Node<T>(anEntry);
		dataNode.setNext(topNode);
		topNode = dataNode;
	}

	@Override
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T outData = topNode.getData();
		topNode = topNode.getNext();
		return outData;
	}

	@Override
	public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


	@Override
	public boolean isEmpty() {
		return (topNode==null);
	}

	@Override
	public void clear() {
		topNode = null;
	}


}
