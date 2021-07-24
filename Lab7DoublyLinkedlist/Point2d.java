package Lab7DoublyLinkedList;

public class Point2d {

	private double x;
	private double y;

	public Point2d(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (o.equals(x)) {
			return true;
		} else if (o.equals(y)) {
			return true;
		} else {
			return false;
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}