package com.edu.java.misc;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CustomPriorityQueueProblem {

	public static void main(String[] args) {
		List<Integer> tasks = Arrays.asList(6, 6, 6, 6, 3, 3, 1, 1);
		// List<Integer> tasks = Arrays.asList(6, 6, 6, 6, 3, 3, 1, 2, 1, 2, 2, 2);
		Map<Integer, Integer> countMap = new LinkedHashMap<>();
		for (Integer task : tasks) {
			int currVal = countMap.getOrDefault(task, 0);
			countMap.put(task, currVal + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
			return e2.getKey() - e1.getKey() == 0 ? e2.getValue() - e1.getValue() : e2.getKey() - e1.getKey();
		});

		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			pq.add(entry);
		}

		while (!pq.isEmpty() && pq.peek().getValue() >= 2) {
			Map.Entry<Integer, Integer> numCountEntry = pq.poll();
			int currVal = numCountEntry.getKey();
			int currValCount = numCountEntry.getValue();
			if (currValCount == 2) {
				countMap.remove(currVal);
			} else if (currValCount > 2) {
				currValCount -= 2;
				countMap.put(currVal, currValCount);
			}
			int newVal = currVal / 2;
			int existingValCount = countMap.getOrDefault(newVal, 0);
			countMap.put(newVal, existingValCount + 1);
		}
		
		System.out.println(countMap);
	}

}
