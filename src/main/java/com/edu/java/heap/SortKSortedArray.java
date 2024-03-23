package com.edu.java.heap;

import java.util.PriorityQueue;

public class SortKSortedArray {

	public static void main(String[] args) {
		int[] arr = { -4, -3, -1, 1, 2, 3 };
		int k = 2;
		int[] result = sortKSortedArray(arr, k);
		System.out.println(result);
	}

	public static int[] sortKSortedArray(int[] arr, int k) {
		int[] result = new int[arr.length];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < Math.min(arr.length, k + 1); i++) {
			pq.offer(arr[i]);
		}
		int resIdx = 0;
		for (int i = k + 1; i < arr.length; i++) {
			Integer minNum = pq.poll();
			result[resIdx++] = minNum;
			pq.offer(arr[i]);
		}

		while (!pq.isEmpty()) {
			Integer minNum = pq.poll();
			result[resIdx++] = minNum;
		}
		return result;
	}

}
