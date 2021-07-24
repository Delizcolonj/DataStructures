package project2;

import java.util.EmptyStackException;

public class PostfixToInfix<T> {

	public static String convert(String postfix) {

		int length = postfix.length();
		char nextCharacter;
		LinkedStack<String> valueStack = new LinkedStack<>();
		String operand1, operand2;
		String infix = "";

		for (int i = 0; i < length; i++) {
			nextCharacter = postfix.charAt(i);
			if (Character.isWhitespace(nextCharacter)) {
				continue;
			} else if (Character.isLetterOrDigit(nextCharacter)) {
				valueStack.push("" + nextCharacter);
			} else {
				if (valueStack.isEmpty()) {
					throw new EmptyStackException();
				}

				operand1 = valueStack.pop();
				if (valueStack.isEmpty()) {
					throw new IllegalArgumentException();
				}

				operand2 = valueStack.pop();

				infix = "(" + operand2 + nextCharacter + operand1 + ")";
				valueStack.push(infix);
			}
		}

		infix = valueStack.pop();

		if (!valueStack.isEmpty()) {
			throw new IllegalStateException();
		}

		infix = removeParentheses(infix);
		return infix;
	}

	public static String removeParentheses(String infix) {
		String infix_without_parentheses = "";
		if (infix.charAt(0) == '(' && infix.charAt(infix.length() - 1) == ')') {
			infix_without_parentheses = infix.substring(1, infix.length() - 1);
		}
		return infix_without_parentheses;
	}
}

