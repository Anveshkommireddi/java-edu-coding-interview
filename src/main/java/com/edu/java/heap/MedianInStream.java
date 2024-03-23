package com.edu.java.heap;

import java.util.PriorityQueue;

public class MedianInStream {

	PriorityQueue<Integer> maxHeap = null;
	PriorityQueue<Integer> minHeap = null;

	public MedianInStream() {
		maxHeap = new PriorityQueue<>((a, b) -> b - a);
		minHeap = new PriorityQueue<>((a, b) -> a - b);
	}

	public static void main(String[] args) {
		// Driver code
		int[] nums = { 35, 22, 30, 25, 1 };
		MedianInStream medianOfAges = null;
		for (int i = 0; i < nums.length; i++) {
			System.out.print(i + 1);
			System.out.print(".\tData stream: [");
			medianOfAges = new MedianInStream();
			for (int j = 0; j <= i; j++) {
				System.out.print(nums[j]);
				if (j != i)
					System.out.print(", ");
				medianOfAges.insertNum(nums[j]);
			}
			System.out.println("]");
			System.out.println("\t\tThe median for the given numbers is: " + medianOfAges.findMedian());
			System.out.println(PrintHyphens.repeat("-", 100));
		}

	}

	private void insertNum(int currNum) {
		if (maxHeap.isEmpty() || maxHeap.peek() <= currNum) {
			maxHeap.add(currNum);
		} else {
			minHeap.add(currNum);
		}

		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		} else if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	private double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			// we have even number of elements, take the average of middle two elements
			return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
		}
		// because max-heap will have one more element than the min-heap
		return maxHeap.peek();
	}
}
