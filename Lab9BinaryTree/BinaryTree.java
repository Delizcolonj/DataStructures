package Lab9BinaryTree;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree<T> implements BinaryTreeInterface<T> {
	private BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		initializeTree(rootData, leftTree, rightTree);
	}

	private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<>(rootData);
		if (leftTree != null && !leftTree.isEmpty())
			root.setLeftChild(leftTree.getRoot());
		if (rightTree != null && !rightTree.isEmpty()) {
			if (rightTree == leftTree)
				root.setRightChild(rightTree.getRoot().copy());
			else
				root.setRightChild(rightTree.getRoot());
		}
		if (leftTree != null && leftTree != this)
			leftTree.clear();
		if (rightTree != null && rightTree != this)
			rightTree.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getRootData() {
		return (T) root;
	}

	public BinaryNode<T> getRoot() {
		return root;
	}

	@Override
	public int getHeight() {
		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public Iterator<T> getPreorderIterator() {
		return new PreorderIterator();
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		return new PostorderIterator();
	}

	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}

	@Override
	public Iterator<T> getLevelorderIterator() {
		return new LevelorderIterator();
	}

	@Override
	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);

	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		initializeTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);

	}

	public class PreorderIterator implements Iterator<T> {
		private ArrayStack<BinaryNode<T>> nodeStack;

		public PreorderIterator() {
			nodeStack = new ArrayStack<BinaryNode<T>>();
			nodeStack.push(root);
		}

		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			BinaryNode<T> currNode = nodeStack.pop();
			T item = currNode.getData();
			if (currNode.hasRightChild())
				nodeStack.push(currNode.getRightChild());
			if (currNode.hasLeftChild())
				nodeStack.push(currNode.getLeftChild());
			return item;
		}

		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public class PostorderIterator implements Iterator<T> {
		private ArrayStack<BinaryNode<T>> nodeStack;

		public PostorderIterator() {
			nodeStack = new ArrayStack<>();
			addToStack(root);
		}

		private void addToStack(BinaryNode<T> aNode) {
			if (aNode == null)
				return;
			BinaryNode<T> right = (BinaryNode<T>) aNode.getRightChild();
			BinaryNode<T> left = (BinaryNode<T>) aNode.getLeftChild();
			nodeStack.push(aNode);
			addToStack(right);
			addToStack(left);
		}

		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}

		public T next() {
			return nodeStack.pop().getData();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class InorderIterator implements Iterator<T> {
		private ArrayStack<BinaryNode<T>> nodeStack;

		public InorderIterator() {
			nodeStack = new ArrayStack<>();
			addToStack(root);
		}

		private void addToStack(BinaryNode<T> aNode) {
			if (aNode == null)
				return;
			BinaryNode<T> right = (BinaryNode<T>) aNode.getRightChild();
			BinaryNode<T> left = (BinaryNode<T>) aNode.getLeftChild();
			addToStack(right);
			nodeStack.push(aNode);
			addToStack(left);
		}

		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}

		public T next() {
			return nodeStack.pop().getData();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	public class LevelorderIterator implements Iterator<T> {
		private LinkedQueue<BinaryNode<T>> nodeQueue;

		public LevelorderIterator() {
			nodeQueue = new LinkedQueue<>();
			nodeQueue.enqueue(root);
		}

		public T next() {
			BinaryNode<T> currNode = nodeQueue.dequeue();
			T item = currNode.getData();
			if (currNode.hasLeftChild())
				nodeQueue.enqueue(currNode.getLeftChild());
			if (currNode.hasRightChild())
				nodeQueue.enqueue(currNode.getRightChild());
			return item;
		}

		public boolean hasNext() {
			return (!nodeQueue.isEmpty());
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}