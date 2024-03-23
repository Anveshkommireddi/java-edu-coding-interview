package com.edu.java.heap;

import java.util.PriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// LC :: 1046
public class LastStoneWeight {

	private static final Logger LOGGER = LoggerFactory.getLogger(LastStoneWeight.class);

	public static void main(String[] args) {
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		int result = lastStoneWeight(stones);
		LOGGER.info("Result is {}", result);
	}

	private static int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		for (int stone : stones) {
			maxHeap.offer(stone);
		}

		while (!maxHeap.isEmpty() && maxHeap.size() > 1) {
			int firstMax = maxHeap.poll();
			int secondMax = maxHeap.poll();
			int absValue = Math.abs(firstMax - secondMax);
			if (absValue > 0) {
				maxHeap.offer(absValue);
			}
		}
		return maxHeap.size() == 1 ? maxHeap.peek() : 0;
	}

}
