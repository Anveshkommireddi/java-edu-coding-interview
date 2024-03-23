package com.edu.java.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandOfStraights {

	private static final Logger LOGGER = LoggerFactory.getLogger(HandOfStraights.class);

	public static void main(String[] args) {
		int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
		int groupSize = 3;
		boolean result = isPossible(hand, groupSize);
		LOGGER.info("Result is {}", result);
	}

	private static boolean isPossible(int[] hand, int groupSize) {
		if (hand.length == 0 || hand.length % groupSize != 0)
			return false;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Map<Integer, Integer> numFreqMap = new HashMap<>();
		for (int num : hand) {
			numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
		}
		numFreqMap.entrySet().stream().forEach(entry -> pq.offer(entry.getKey()));
		while (!pq.isEmpty()) {
			int minVal = pq.peek();
			for (int i = 0; i < groupSize; i++) {
				int currVal = minVal + i;
				if (!numFreqMap.containsKey(currVal)) {
					return false;
				}
				if (numFreqMap.get(currVal) == 1) {
					numFreqMap.remove(currVal);
					pq.remove(currVal);
				} else {
					numFreqMap.put(currVal, numFreqMap.getOrDefault(currVal, 0) - 1);
				}
			}
		}
		return pq.isEmpty() && numFreqMap.isEmpty() ? true : false ;
	}
}
