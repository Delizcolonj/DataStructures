package Project3Queues;
import java.util.Random;
public class TrainRoute {

	public static Station[] allStations;
	public static LinkedQueue allPassengers;
	public static LinkedQueue allTrains;
	public static int trainCon = 0;
	public static int passengerCreated;
	public static int passengersOnTrains;
	public static int passengersDelivered;
	public static int STATIONS = 5;
	public static int TRAIN_INTERVAL = 10;
	public static int TRAIN_CAPACITY = 5;
	public static int DURATION = 100;
	public static Random generator;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		allStations = new Station[STATIONS];
		allTrains = new LinkedQueue();
		allPassengers = new LinkedQueue();
		trainCon = 0;
		generator = new Random();
		generateStations();
		for (int clock = 0; clock < DURATION; clock++) {
			report(clock);
			startNewTrain(clock);
			generatePassengers(clock);
			moveTrains(clock);
		}
		finalReport(DURATION);
	}

	private static void finalReport(int clock) {
		// TODO Auto-generated method stub
		System.out.println("Final Report of train route simulation");
		System.out.println("The total number of passengers"+"are " +passengerCreated);
		System.out.println("The total number of passengers"+"currently exist on a train "+passengersOnTrains);
		System.out.println("The total number of passengers"+"delivered is "+passengersDelivered);
		int waitBoardSum=0;
		int waitNotBoardSum=0;
		for(int i=0;i<passengerCreated;i++) {
			Passengers p=(Passengers) allPassengers.dequeue();
			if(p.boarded())
				waitBoardSum+=p.waitTime(clock);
			else
				waitNotBoardSum+=p.waitTime(clock);
		}
		System.out.println("The average wait time for passengers that have boarded is "+(double)waitNotBoardSum/(passengersDelivered-passengersOnTrains-passengerCreated));
		
	}

	private static void startNewTrain(int simulationTime) {
		// TODO Auto-generated method stub
		if((simulationTime%TRAIN_INTERVAL)==0) {
			allTrains.enqueue(new Train(TRAIN_CAPACITY));
			trainCon++;
		}
	}

	public static void report(int simulationTime) {
		// TODO Auto-generated method stub
		int passengerWaiting=passengerCreated-passengersOnTrains-passengersDelivered;
		System.out.println();
		System.out.println("Time Marker"+simulationTime+"\twaiting"+passengerWaiting+"\t on trains: "+passengersOnTrains);
	}

	public static void moveTrains(int clock) {
		// TODO Auto-generated method stub
		int trains=trainCon;
		for(int i=0;i<trains;i++){
			Train moveMe=(Train) allTrains.dequeue();
			moveMe.move();
			int timeToNext=moveMe.timeToNext();
			if(timeToNext==0) {
				int stationNo=moveMe.nextStation();
				int gotOff=moveMe.unloadPassengers(stationNo);
				int goton=moveMe.loadPassenfers(allStations[stationNo], clock);
				passengersOnTrains+=goton;
				passengersOnTrains-=gotOff;
				passengersDelivered+=gotOff;
			}
			else if(moveMe.nextStation()<STATIONS) {
				allTrains.enqueue(moveMe);
			}else {
				trainCon--;
			}
		}
	}

	public static void generatePassengers(int clock) {
		// TODO Auto-generated method stub
		int newPassengers = generator.nextInt(10);
		for (int i = 0; i < newPassengers; i++) {
			int start = 10;
			int stop = 1;
			while (start >= stop) {
				start = generator.nextInt(STATIONS);
				stop = generator.nextInt(STATIONS);
			}
			Passengers rider = newPassenger(start, stop);
			allStations[start].addPassenger(rider);
			allPassengers.enqueue(rider);
			passengerCreated++;
		}
	}

	private static Passengers newPassenger(int start, int stop) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void generateStations() {
		// TODO Auto-generated method stub
		for (int i = 0; i < STATIONS; i++) {
			int timeToNext = 10 + generator.nextInt(10);
			allStations[i] = new Station(timeToNext);
			System.out.println("\tCreated station " + i + "time to next is " + timeToNext);
		}
	}

}

