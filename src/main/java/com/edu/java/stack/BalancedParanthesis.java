package com.edu.java.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedParanthesis {

	private static final List<Character> OPEN_PARANTHESIS_LIST = Arrays.asList('(', '{', '[');

	public static void main(String args[]) {
		System.out.println(isBalanced("{[()]}"));
		System.out.println(isBalanced("[{(}]"));
	}

	private static boolean isBalanced(String input) {
		Stack<Character> paranthesisStack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			Character currChar = input.charAt(i);
			if (OPEN_PARANTHESIS_LIST.contains(currChar)) {
				paranthesisStack.push(currChar);
			} else if ((paranthesisStack.peek() == '(' && currChar == ')')
					|| (paranthesisStack.peek() == '{' && currChar == '}')
					|| (paranthesisStack.peek() == '[' && currChar == ']')) {
				paranthesisStack.pop();
			}
		}
		return paranthesisStack.isEmpty();
	}

}
