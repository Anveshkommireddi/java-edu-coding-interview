package com.edu.java.stack;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	// Enqueue(3), Dequeue(), Dequeue(), Enqueue(1), Enqueue(7), Dequeue()
	public void enqueueFast(Integer value) {
		stack1.push(value);
	}

	public Integer dequeueSlow() {
		if (isEmpty()) {
			System.err.println("No Elements to Dequeue");
			return -1;
		}

		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	private boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	public void enqueueSlow(Integer value) {
		// push every element from stack1 to stack2
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		// push the element to stack1
		stack1.push(value);
		// pop all the elements from stack2 to stack1
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}

	public Integer dequeueFast() {
		if (stack1.isEmpty()) {
			System.err.println("No Elements to Dequeue");
			return -1;
		}
		return stack1.pop();
	}

}
