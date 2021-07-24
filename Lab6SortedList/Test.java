package Lab6SortedList;

public class Test {
	public static void main(String[] args) {
		Message encoded = new Message ("encoded.txt");
		
		String output = encoded.compose();
		
		System.out.println(output);
	}
}
