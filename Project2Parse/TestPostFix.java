package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TestPostFix {

	public static void main(String[] args) {
		try {
			Scanner file = new Scanner(new File("InfixToPostfix"));
			String[] result = new String[9];
			
			for(int i = 0; i < result.length; i++) {
				result[i] = file.nextLine();
				
				System.out.print("Original Expression:\n" + result[i] + "\n");
				
				String temp = result[i];
				
				String temp2 = InfixToPostFix.convert(temp);
                String temp3 = PostfixToInfix.convert(temp2);
                System.out.println("Infix to Postfix:\n" + temp2);
                System.out.println("Postfix to Infix:\n" + temp3 + "\n\n");
			}

			file.close();
		} 
		
		catch (FileNotFoundException ex) {
			System.out.println("expressions.txt not found! " + ex);
		}
	}	
}