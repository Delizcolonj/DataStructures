package Lab7DoublyLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ListIterator;
import java.util.Scanner;

public class PolygonTesting {

	public static void main(String[] args) {
		String filename = "polygon.txt";
			
		Polygon p = new Polygon(filename);
		DoublyLinkedList <Line2d> lines = p.getLines();
		//ListIterator <Line2d> it = lines.getListIterator();
			
		//Line2d prevLine = it.next();
		//Line2d firstLine = prevLine;
		//Line2d currLine, gapLine;

		//it = lines.getListIterator();
		//while (it.hasNext())
		//	System.out.println (it.next());

		//System.out.println ("======Now backwards======");
		//while (it.hasPrevious())
		//	System.out.println (it.previous());
		System.out.println ("======Reverse======");	
		p.reverse();
		p.display();
		}
		
}