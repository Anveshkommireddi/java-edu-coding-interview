package com.edu.java.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArrays {

	public static void main(String[] args) {
		List<List<Integer>> arrays = new ArrayList<>();
		arrays.add(Arrays.asList(1, 5, 9, 21));
		arrays.add(Arrays.asList(-1, 0));
		arrays.add(Arrays.asList(-124, 81, 121));
		arrays.add(Arrays.asList(3, 6, 12, 20, 150));
		List<Integer> result = mergeSortedArrays(arrays);
		System.out.println(result);
	}

	public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Item> pq = new PriorityQueue<>((p1, p2) -> p1.value - p2.value);
		for (int i = 0; i < arrays.size(); i++) {
			List<Integer> currList = arrays.get(i);
			Item pair = new Item(currList.get(0), i, 0);
			pq.offer(pair);
		}

		while (!pq.isEmpty()) {
			Item minPair = pq.poll();
			int minValue = minPair.value;
			int minValueIdx = minPair.valIdx;
			int minValArrIdx = minPair.arrayIdx;
			result.add(minValue);
			int nextValueIdx = minValueIdx + 1;
			List<Integer> currList = arrays.get(minValArrIdx);
			if (nextValueIdx < currList.size()) {
				Item newPair = new Item(currList.get(nextValueIdx), minValArrIdx, nextValueIdx);
				pq.offer(newPair);
			}
		}
		return result;
	}
}
