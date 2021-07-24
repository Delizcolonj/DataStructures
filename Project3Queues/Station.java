package Project3Queues;

public class Station {
	@SuppressWarnings("rawtypes")
	private LinkedQueue waiting;
	private int timeToNextStation;
	
	@SuppressWarnings("rawtypes")
	public Station(int timeToNext) {
		waiting = new LinkedQueue();
		
	}
	@SuppressWarnings("unchecked")
	public void addPassenger(Passengers rider) {
		waiting.enqueue(rider);
	}
	public boolean isWaiting() {
		return !waiting.isEmpty();
	}
	public Passengers getPassenger() {
		return (Passengers) waiting.dequeue();
	}
	
	public int getTimeToNextStation() {
		return timeToNextStation;
	}
}