package com.edu.java.kway.merge;

import java.util.PriorityQueue;

public class KthLargestNumber {

	public static void main(String[] args) {
		int[] arr = { 10000, -10000, 5000, 8000, -9000 };
		int k = 4;
		int result = getKLargestElement(arr, k);
		System.out.println(result);
	}

	private static int getKLargestElement(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((num1, num2) -> num1 - num2);
		for (int i = 0; i < Math.min(arr.length, k); i++) {
			pq.offer(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			int currNum = arr[i];
			if (currNum > pq.peek()) {
				pq.poll();
				pq.offer(currNum);
			}
		}
		return pq.peek();
	}

}
