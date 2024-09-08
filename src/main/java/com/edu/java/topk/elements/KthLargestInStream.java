package com.edu.java.topk.elements;

import java.util.PriorityQueue;

public class KthLargestInStream {

	private PriorityQueue<Integer> minHeap;

	private int k;

	public KthLargestInStream(int k, int[] nums) {
		this.k = k;
		this.minHeap = new PriorityQueue<>((num1, num2) -> num1 - num2);
		addElementsToHeap(nums);
	}

	private void addElementsToHeap(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			minHeap.add(nums[i]);
			while (minHeap.size() > k) {
				minHeap.poll();
			}
		}
	}

	// adds element in the topKHeap
	public int add(int val) {
		minHeap.add(val);
		while (minHeap.size() > k) {
			minHeap.poll();
		}
		return minHeap.isEmpty() ? -1 : minHeap.peek();
	}

}
