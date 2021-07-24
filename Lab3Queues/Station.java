package Lab3;

public class Station {
	private String name;
	private LinkedQueue<Passenger> passengers;

	public Station(String name) {
		this.setName(name);
		this.passengers = new LinkedQueue<Passenger>();
	}

	public boolean isFull() {
		 if (!passengers.isEmpty()) {
			return true;
	}
	return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void passengerArrival(Passenger p) {
		this.passengers.enqueue(p);
	}

	public Passenger passengerLeave() {
		return this.passengers.dequeue();
	}
	public String toString() {
		return this.name;
		}
}