package com.edu.java.kway.merge;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumber {

	public static void main(String[] args) {
		List<List<Integer>> lists = Arrays.asList(Arrays.asList(2, 6, 8), Arrays.asList(3, 6, 10),
				Arrays.asList(5, 8, 11));
		int k = 5;
		int result = kSmallestNumber(lists, k);
		System.out.println(result);
	}

	public static int kSmallestNumber(List<List<Integer>> lists, int k) {

		PriorityQueue<Holder> minHeap = new PriorityQueue<>((h1, h2) -> h1.getVal() - h2.getVal());

		for (int listIdx = 0; listIdx < lists.size(); listIdx++) {
			List<Integer> list = lists.get(listIdx);
			if (list.size() == 0)
				continue;
			Holder holder = new Holder(list.get(0), listIdx, 0);
			minHeap.add(holder);
		}

		int count = 0;
		int res = 0;
		while (count < k && !minHeap.isEmpty()) {
			Holder holder = minHeap.poll();
			count++;
			res = holder.getVal();
			if (count == k) {
				return holder.getVal();
			}
			List<Integer> lst = lists.get(holder.getListIdx());
			int nextValIdx = holder.getValIdx() + 1;
			if (nextValIdx < lst.size()) {
				minHeap.add(new Holder(lst.get(nextValIdx), holder.getListIdx(), nextValIdx));
			}
		}

		return res;
	}

}
