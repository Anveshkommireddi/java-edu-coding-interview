package com.edu.java.topk.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6 };
		int k = 2;
		List<Integer> result = topKFrequent(arr, k);
		System.out.println(result);
	}

	public static List<Integer> topKFrequent(int[] arr, int k) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> charFreqMap = new HashMap<>();
		for (int num : arr) {
			charFreqMap.put(num, charFreqMap.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
			if (e1.getValue() == e2.getValue()) {
				return e2.getKey() - e2.getKey();
			}
			return e2.getValue() - e1.getValue();
		});
		for (Entry<Integer, Integer> entry : charFreqMap.entrySet()) {
			pq.offer(entry);
		}
		int count = 0;
		while (!pq.isEmpty() && count < k) {
			result.add(pq.poll().getKey());
			count++;
		}
		return result;
	}

}
