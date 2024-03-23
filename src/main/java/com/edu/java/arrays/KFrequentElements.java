package com.edu.java.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KFrequentElements {

	private static final Logger LOGGER = LoggerFactory.getLogger(KFrequentElements.class);

	public static void main(String[] args) {
		int[] arr = { 6, 1, 1, 1, 2, 2,3 };
		int k = 2;
		int[] res = kFrequentElements(arr, k);
		LOGGER.info("Result is {}", Arrays.toString(res));
	}

	private static int[] kFrequentElements(int[] nums, int k) {
		int[] res = new int[k];
		Map<Integer, Integer> numFreqMap = new HashMap<>();
		for (int num : nums) {
			int val = numFreqMap.getOrDefault(num, 0);
			numFreqMap.put(num, val + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k,
				(entry1, entry2) -> entry2.getValue().equals(entry1.getValue()) ? entry2.getKey() - entry1.getKey()
						: entry2.getValue() - entry1.getValue());

		for (Map.Entry<Integer, Integer> entry : numFreqMap.entrySet()) {
			pq.offer(entry);
		}

		int idx = 0;
		while (!pq.isEmpty() && idx < k) {
			Map.Entry<Integer, Integer> entry = pq.remove();
			int val = entry.getKey();
			System.out.println(val);
			res[idx] = val;
			idx++;
		}
		return res;
	}
	
}
