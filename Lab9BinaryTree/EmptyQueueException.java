package Lab9BinaryTree;

@SuppressWarnings("serial")
public class EmptyQueueException extends RuntimeException {
	public EmptyQueueException() {
		super ();
	}
	
	public EmptyQueueException(String message) {
		super (message);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}