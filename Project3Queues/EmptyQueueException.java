package Project3Queues;

public class EmptyQueueException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyQueueException() {
		super();
	}

	public EmptyQueueException(String info) {
		super(info);
	}

	public String getMessage() {
		return super.getMessage();
	}

}