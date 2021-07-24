package Lab7DoublyLinkedList;


public class Line2d {
	private Point2d start;
	private Point2d end;
	
	public Line2d(double x1, double y1, double x2, double y2) {
		start = new Point2d(x1, y1);
		end = new Point2d(x2, y2);
	}

	public Line2d(Point2d start, Point2d end) {
		this.start = start;
		this.end = end;
	}

	public boolean equals(Object o) {
		if (start.equals(o) || end.equals(o)) {
			return true;
		}
		return false;
	}

	public String toString() {
		String point;

		point = "{" + start + ", " + end + "}";

		return point;
	}
	public Point2d getStart() {
		return start;
	}

	public void setStart(Point2d start) {
		this.start = start;
	}

	public Point2d getEnd() {
		return end;
	}

	public void setEnd(Point2d end) {
		this.end = end;
	}
	
	public void reverse() {
		Point2d temp = this.end;
		this.end = start;
		this.start = temp;
	}
}