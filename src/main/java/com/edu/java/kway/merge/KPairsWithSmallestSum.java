package com.edu.java.kway.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSum {

	public static void main(String[] args) {
		int[] list1 = { 1, 2, 300 };
		int[] list2 = { 1, 11, 20, 35, 300 };
		int k = 5;
		List<List<Integer>> result = kSmallestPairs(list1, list2, k);
		System.out.println(result);
	}

	public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {
		List<List<Integer>> result = new ArrayList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>((pair1, pair2) -> pair1.getSum() - pair2.getSum());
		for (int list1Idx = 0; list1Idx < Math.min(list1.length, target); list1Idx++) {
			int sum = list1[list1Idx] + list2[0];
			Pair pair = new Pair(sum, list1Idx, 0);
			pq.offer(pair);
		}
		int count = 0;
		while (count < target && !pq.isEmpty()) {
			Pair currPair = pq.poll();
			int newList2Idx = currPair.getList2Idx() + 1;
			count++;
			List<Integer> vals = Arrays.asList(list1[currPair.getList1Idx()], list2[currPair.getList2Idx()]);
			result.add(vals);
			if (newList2Idx < list2.length) {
				Pair newPair = new Pair(list1[currPair.getList1Idx()] + list2[newList2Idx], currPair.getList1Idx(),
						newList2Idx);
				pq.offer(newPair);
			}
		}
		return result;
	}

}
