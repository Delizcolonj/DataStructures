package Project5SortedTreeList;

public class Message {
	char[] message;

	public Message(char c1, char c2, char c3) {
		this.message = new char[3];

		message[0] = c1;
		message[1] = c2;
		message[2] = c3;
	}

	public char[] getMsg() {
		return message;
	}

	public void setMsg(char[] msg) {
		this.message = msg;
	}

	public String toString() {
		return Character.toString(message[0]) + Character.toString(message[1]) + Character.toString(message[2]);
	}

}