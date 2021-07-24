package Project3Queues;

public class Train {
	private LinkedQueue Train;
	private int numOnTrain;
	private int capacity;
	private int nextStation;
	private int timeToNextStation;
	private int trainNo;
	private static int trainsCreated = 0;

	public Train(int cap) {
		Train = (LinkedQueue) new LinkedQueue();
		numOnTrain = 0;
		capacity = cap;
		nextStation = 0;
		timeToNextStation = 1;
		trainsCreated++;
		trainNo = trainsCreated;
		System.out.println("\tCreated train" + trainNo);
	}

	public int nextStation() {
		return nextStation;
	}

	public int timeToNext() {
		return timeToNextStation;
	}

	public void move() {
		timeToNextStation--;
	}

	public void updateStation(int timeToNext) {
		timeToNextStation = timeToNext;
		nextStation++;
	}

	public int unloadPassengers(int station) {
		int con = numOnTrain;
		for (int i = 0; i < con; i++) {
			Passengers person = (Passengers) Train.dequeue();
			if (person.getdest() != station) {
				Train.enqueue(person);
			} else {
				numOnTrain--;
			}
		}
		int passLeaving = con - numOnTrain;
		System.out.println("\tTrain " + trainNo + "uploaded " + passLeaving + "passengers at station " + station);
		return passLeaving;
	}

	public int loadPassenfers(Station station, int clock) {
		int con = numOnTrain;
		boolean passengerWaiting = station.isWaiting();
		while ((numOnTrain < capacity) && passengerWaiting) {
			Passengers boarder = station.getPassenger();
			Train.enqueue(boarder);
			boarder.boardTrain(clock);
			passengerWaiting = station.isWaiting();
			numOnTrain++;
		}
		int passengerEntering = numOnTrain - con;
		System.out.println("\tloaded " + passengerEntering + "passengers");
		System.out.println("; Space left" + (capacity - numOnTrain));
		return passengerEntering;
	}

}

