package Lab2Stacks;



public class PostfixEvaluator {

	public PostfixEvaluator() {

	}

	public int EvaluatingPostFix(String postfix) {

		int index = 0;
		int characterCount = postfix.length();
		int nextCharacter;

		// new empty stack
		ArrayStack<Integer> valueStack = new ArrayStack<Integer>();

		char[] x = postfix.toCharArray();

		for (int i = 0; i < characterCount; i++) {
			nextCharacter = x[i];
			valueStack.push((int) nextCharacter);
		}

		// while parsing through
		while (index < characterCount) {
			nextCharacter = x[index++];

			// if scanned character is a digit, push to valueStack
			if (Character.isDigit(nextCharacter))
				valueStack.push((int) (nextCharacter - '0'));
			else {
				int operandOne = valueStack.pop();
				int operandTwo = valueStack.pop();

				switch (nextCharacter) {
				case '+':
					valueStack.push((int) (operandTwo + operandOne));
					break;
				case '-':
					valueStack.push((int) (operandTwo - operandOne));
					break;
				case '*':
					valueStack.push((int) (operandTwo * operandOne));
					break;
				case '/':
					valueStack.push((int) (operandTwo / operandOne));
					break;
				case '^':
					valueStack.push((int) Math.pow(operandTwo, operandOne));
					break;
				default:
					break;
				}

			}

		}
		return valueStack.pop();
	}

}
