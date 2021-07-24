package Lab2Stacks;

public class InfixToPostfix {
	
	public static boolean checkBalance(String expression) {
		
		LinkedStack<Character> openDelimiterStack = new LinkedStack<>();
		boolean isBalanced = true;
		int index = 0;
		int characterCount = expression.length();
		char nextCharacter;

		while (isBalanced && index < characterCount) {
			nextCharacter = expression.charAt(index);
			switch (nextCharacter) {
			case '(':
			case '[':
			case '{':
				openDelimiterStack.push(nextCharacter);
				break;
			case ')':
			case ']':
			case '}':
				if (openDelimiterStack.isEmpty())
					isBalanced = false;
				else {
					char openDelimiter = openDelimiterStack.pop();
					isBalanced = isPaired(openDelimiter, nextCharacter);
				}
				break;
			default: // irelevant character
				break;

			}
			index++;
		}
		if (!openDelimiterStack.isEmpty())
			isBalanced = false;

		return isBalanced;
	}

	private static boolean isPaired(char first, char second) {
		return (first == '(' && second == ')' || first == '[' && second == ']' || first == '{' && second == '}');
	}

	public static String convert(String infix) {
		int index = 0;
		int characterCount = infix.length();
		char nextCharacter;
		String postfix = "";
		char topOperator;

		// new empty stack
		LinkedStack<Character> operatorStack = new LinkedStack<Character>();

		char[] x = infix.toCharArray();

		// while parsing through
		while (index < characterCount) {
			nextCharacter = x[index++];
			switch (nextCharacter) {
			case '^':
			case '+':
			case '-':
			case '/':
			case '*':
				operatorStack.push(nextCharacter);
				break;

			case '(':
				operatorStack.push(nextCharacter);
				break;
			case ')':
				topOperator = operatorStack.pop();
				while (topOperator != '(') {
					postfix += Character.toString(topOperator);
					topOperator = operatorStack.pop();
				}
				break;
			default:
				if (nextCharacter == ' ')
					break;
				else if (nextCharacter != '(') {
					String s = Character.toString(nextCharacter);
					postfix += s;
					if ((!operatorStack.isEmpty()) && (operatorStack.peek()) == '^') {
						s = Character.toString(operatorStack.peek());
						postfix += s;
						operatorStack.pop();
					} else if ((!operatorStack.isEmpty())
							&& (((operatorStack.peek()) == '*') || (operatorStack.peek()) == '/')) {
						s = Character.toString(operatorStack.peek());
						postfix += s;
						operatorStack.pop();
					}
					break;
				}
			}

			while (!operatorStack.isEmpty() && index == characterCount) {
				topOperator = operatorStack.pop();
				postfix += topOperator;
			}

		}
		return postfix;
	}
	public String postfixIt(String i) {
		if(!checkBalance(i)) {
			return "Expression is unbalanced. Please fix expression. \n";
		}
		return "Infix: " + i + "\n" + "Postfix: " + convert(i) + "\n"; 
	}
	
}
