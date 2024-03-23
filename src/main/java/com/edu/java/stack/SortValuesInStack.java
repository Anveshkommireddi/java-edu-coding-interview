package com.edu.java.stack;

import java.util.Stack;

public class SortValuesInStack {

	public static void main(String args[]) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(2);
		stack.push(97);
		stack.push(4);
		stack.push(42);
		stack.push(12);
		stack.push(60);
		stack.push(23);
		sortStack(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	private static void sortStack(Stack<Integer> stack) {

		Stack<Integer> tempStack = new Stack<>();

		while (!stack.isEmpty()) {
			int currVal = stack.pop();
			if (tempStack.isEmpty() || currVal >= tempStack.peek()) {
				tempStack.push(currVal);
			} else {
				while (!tempStack.isEmpty() && currVal < tempStack.peek()) {
					stack.push(tempStack.pop());
				}
				tempStack.push(currVal);
			}
		}

		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}

	}

}
