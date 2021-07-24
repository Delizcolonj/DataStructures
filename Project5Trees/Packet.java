package Project5SortedTreeList;

public class Packet implements Comparable<Packet> {
	int number;
	Message message;

	public Packet(int number, char c1, char c2, char c3) {
		this.number = number;
		this.message = new Message(c1, c2, c3);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Message getMsg() {
		return message;
	}

	public void setMsg(Message msg) {
		this.message = msg;
	}

	@Override
	public int compareTo(Packet packet) {
		return this.getNumber() - packet.getNumber();
	}

}
