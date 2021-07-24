package Lab8DictionaryApplication;

public class Name implements Comparable<Name> {
	private String firstName;
	private String lastName;

	public Name(String first, String last) {
		firstName = first;
		lastName = last;
	}

	public Name(String fullName) {
		String[] temp = fullName.split("\\s", 2);
		firstName = temp[0];
		lastName = temp[1];
	}

	public String getFirst() {
		return firstName;
	}

	public String getLast() {
		return lastName;
	}

	public String toString() {
		return (firstName + " " + lastName);
	}

	public boolean equals(Object o) {
		Name other = (Name) o;
		return (other.getFirst().equals(firstName) && other.getLast().equals(lastName));
	}

	public int compareTo(Name other) {
		return (firstName.compareTo(other.getFirst()));
	}
}