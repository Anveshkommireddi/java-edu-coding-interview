package com.edu.java.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> queue1 = new ArrayDeque<Integer>();
	Queue<Integer> queue2 = new ArrayDeque<Integer>();

	// Push(7), Pop(), Push(9), Push(10), Pop(), IsEmpty()

	public void pushFast(Integer value) {
		queue1.offer(value);
	}

	public Integer popSlow() {
		if (isEmpty()) {
			System.err.println("Stack is Empty");
			return -1;
		}

		while (queue1.size() > 1) {
			queue2.offer(queue1.poll());
		}
		int value = queue1.poll();
		swapQueues();
		return value;
	};

	private void swapQueues() {
		Queue<Integer> queue3 = queue1;
		queue1 = queue2;
		queue2 = queue3;
	}

	public boolean isEmpty() {
		return queue1.isEmpty() && queue2.isEmpty();
	};

}
