package com.edu.java.heap;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Heapify {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Heapify.class);

	public static void main(String[] args) {
		int[] arr = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
		printArray(arr);
		buildMaxHeap(arr);
		printArray(arr);
		int[] arr1 = { 4, 10, 3, 5, 1 };
		buildMinHeap(arr1);
		printArray(arr1);
	}

	private static void buildMaxHeap(int[] arr) {
		int n = arr.length;
		for (int currIdx = (n / 2) - 1; currIdx >= 0; currIdx--) {
			maxHeapify(arr, currIdx);
		}
	}

	private static void buildMinHeap(int[] arr) {
		int n = arr.length;
		for (int currIdx = (n / 2) - 1; currIdx >= 0; currIdx--) {
			minHeapify(arr, currIdx);
		}
	}

	private static void minHeapify(int[] arr, int currIdx) {

		int smallIdx = currIdx;
		int leftIdx = 2 * currIdx + 1;
		int rightIdx = 2 * currIdx + 2;

		if (leftIdx < arr.length && arr[leftIdx] < arr[smallIdx]) {
			smallIdx = leftIdx;
		}

		if (rightIdx < arr.length && arr[rightIdx] < arr[smallIdx]) {
			smallIdx = rightIdx;
		}

		if (smallIdx != currIdx) {
			swap(arr, currIdx, smallIdx);
			minHeapify(arr, smallIdx);
		}
	}

	private static void maxHeapify(int[] arr, int currIdx) {

		int largeIdx = currIdx;
		int leftIdx = 2 * currIdx + 1;
		int rightIdx = 2 * currIdx + 2;

		if (leftIdx < arr.length && arr[leftIdx] > arr[largeIdx]) {
			largeIdx = leftIdx;
		}

		if (rightIdx < arr.length && arr[rightIdx] > arr[largeIdx]) {
			largeIdx = rightIdx;
		}

		if (currIdx != largeIdx) {
			swap(arr, currIdx, largeIdx);
			maxHeapify(arr, largeIdx);
		}
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	private static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
		System.out.println("\n=========================");
	}

}
