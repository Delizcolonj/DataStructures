package Lab2Stacks;
import java.util.Scanner;
public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		PostfixEvaluator p = new PostfixEvaluator();
		
		System.out.println("Enter a string for evaluation, digits only:");
		String postfixTest1 = input.next();
		System.out.println("The result: ");
        System.out.println(p.EvaluatingPostFix(postfixTest1)); 
        
		InfixToPostfix test = new InfixToPostfix();
		String testString1 = "a+b*c";
		String testString2 = "a+b*c)";

		
		//returns true
		System.out.println(test.checkBalance(testString1));
		//returns false
		System.out.println(test.checkBalance(testString2));
		//returns false
		//System.out.println(test.checkBalance(testString3));
		//System.out.println('\n');
		
		System.out.println(test.postfixIt(testString1));
		System.out.println(test.postfixIt(testString2));
		input.close();
	}
}

