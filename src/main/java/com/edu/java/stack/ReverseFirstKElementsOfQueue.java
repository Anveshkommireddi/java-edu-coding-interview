package com.edu.java.stack;

import java.util.Stack;

public class ReverseFirstKElementsOfQueue {

	public static void main(String args[]) {

		Queue<Integer> queue = new Queue<Integer>(10);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);

		reverseK(queue, 5);

		System.out.print("Queue: ");
		while (!queue.isEmpty()) {
			System.out.print(queue.dequeue() + " ");
		}
	}

	private static void reverseK(Queue<Integer> queue, int k) {

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < k; i++) {
			stack.push(queue.dequeue());
		}

		while (!stack.isEmpty()) {
			queue.enqueue(stack.pop());
		}

		for (int i = 0; i < queue.getCurrSize() - k; i++) {
			queue.enqueue(queue.dequeue());
		}
	}

}
