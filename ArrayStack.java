package Lab2Stacks;

import java.util.EmptyStackException;

import Lab1StackImplementation.ArrayStack;

public class ArrayStack<T> implements StackInterface<T> {

	private T[] stackArray;
	private int stackLength;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 50;
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {//creates an empty stack using default capacity
		capacity = 5;
		stackArray = (T[]) (new Object[DEFAULT_CAPACITY]);
	}
	@Override
	public void push(T anEntry) {//same as add in bag
		if (isFull())
			ensureCapacity();
		stackArray[capacity] = anEntry;
		capacity++;
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
	    T[] larger = (T[])(new Object[stackArray.length*2]); 
	    
	    for (int index=0; index < stackArray.length; index++)
	      larger[index] = stackArray[index];
	    
	    stackArray = larger;
	  }
	private boolean isFull() {
		return capacity == stackLength;
	}

	@Override
	public T pop() {//same as remove in bag
		if (isEmpty()) {
			throw new EmptyStackException();
		}
			T outData = stackArray[stackLength-1];
			stackArray[stackLength-1] = null;
			stackLength--;
			return outData;
		}
	@Override
	public T peek() {//is similar to pop
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stackArray[capacity - 1];
	}
	public void Display(ArrayStack<T> stack) {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		System.out.println(stack.pop());
	}

	@Override
	public boolean isEmpty() {
		return capacity == 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public T[] getStackArray() {
		return stackArray;
	}

	public void setStackArray(T[] stackArray) {
		this.stackArray = stackArray;
	}

	public int getStackLength() {
		return stackLength;
	}

	public void setStackLength(int stackLength) {
		this.stackLength = stackLength;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public static int getDefaultCapacity() {
		return DEFAULT_CAPACITY;
	}

public static void main(String[] args) {
	ArrayStack<Integer> stack = new ArrayStack<Integer>();
	
	for(int i = 0; i<= 5; i++) {
		stack.push(i);
	}
	for(int j = 0; j<= 5; j++) {
		stack.Display(stack);
	}
}
}
