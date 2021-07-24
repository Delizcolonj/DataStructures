package Project3Queues;

public class Passengers {
	private int waitTime;
	private int boarded;
	private boolean boardedTrain;
	private int destination;

	public Passengers(int created, int dest) {
		waitTime = created;
		destination = dest;
		boardedTrain = false;
		System.out.println("\tCreated passenger at station " + created + "heading to " + dest);
	}

	public int getdest() {
		return destination;
	}

	public void boardTrain(int clock) {
		boarded = clock;
		boardedTrain = true;
	}

	public int waitTime(int clock) {
		int result = clock - waitTime;
		if (boardedTrain)
			result = boarded - waitTime;
		return result;
	}

	public boolean boarded() {
		return boardedTrain;
	}
}