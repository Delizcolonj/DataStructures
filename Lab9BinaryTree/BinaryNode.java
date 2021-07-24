package Lab9BinaryTree;

public class BinaryNode<T> implements BinaryNodeInterface <T> {
	private T data;
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;

	public BinaryNode () {
		this (null);
	}

	public BinaryNode (T rootData) {
		this (rootData, null, null);
	}

	public BinaryNode (T rootData, BinaryNode <T> newLeftChild, BinaryNode <T> newRightChild) {
		data = rootData;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}

	public T getData() {
		return data;
	}

	public void setData (T newData) {
		data = newData;
	}

	public BinaryNode<T> getLeftChild () {
		return leftChild;
	}

	public void setLeftChild (BinaryNode <T> newLeftChild) {
		leftChild = newLeftChild;
	}

	public boolean hasLeftChild () {
		return (leftChild != null);
	}

	public boolean isLeaf () {
		return (leftChild == null && rightChild == null);
	}

	@Override
	public BinaryNode<T> getRightChild() {
		return rightChild;
	}

	@Override
	public void setLeftChild(BinaryNodeInterface<T> leftChild) {
		this.leftChild =  (BinaryNode<T>) leftChild;

	}

	@Override
	public void setRightChild(BinaryNodeInterface<T> rightChild) {
		this.rightChild =  (BinaryNode<T>) rightChild;

	}

	@Override
	public boolean hasRightChild() {
		return (rightChild != null);
	}
	
	@Override
	public int getNumberOfNodes() {
		int leftNumber = 0;
		int rightNumber = 0;
		if (leftChild != null)
		leftNumber = leftChild.getNumberOfNodes();
		if (rightChild != null)
		rightNumber = rightChild.getNumberOfNodes();
		return 1 + leftNumber + rightNumber;
	}

	@Override
	public int getHeight() {
		int leftHeight = hasLeftChild() ? leftChild.getHeight() : 0;
		int rightHeight = hasRightChild() ? rightChild.getHeight() : 0;

		return 1 + Math.max (leftHeight, rightHeight);
	}
	
	@Override
	public BinaryNodeInterface<T> copy() {
		BinaryNode <T> newRoot = new BinaryNode <> (data);

		if (leftChild != null ) {
			newRoot.leftChild = (BinaryNode<T>) leftChild.copy();
		}
		else if (rightChild != null) {
			newRoot.rightChild = (BinaryNode<T>) rightChild.copy();
		}
		return (BinaryNodeInterface<T>) newRoot;
	}
}
