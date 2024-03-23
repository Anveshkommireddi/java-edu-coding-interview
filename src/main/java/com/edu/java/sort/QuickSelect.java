package com.edu.java.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickSelect {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuickSelect.class);

	//find kth smallest number
	public static void main(String[] args) {
		int[] arr = { 8, 5, 2, 9, 7, 6, 3 };
		int k = 3;
		int targetIdx = k - 1;
		int res = quickSelect(arr, targetIdx, 0, arr.length - 1);
		LOGGER.info("Array is {}", res);
	}

	private static int quickSelect(int[] arr, int targetIdx, int leftIdx, int rightIdx) {
		while (true) {
			if (leftIdx > rightIdx)
				throw new RuntimeException("RunTime Exception");

			int pivotIdx = leftIdx;
			int lowIdx = leftIdx + 1;
			int highIdx = rightIdx;

			while (lowIdx <= highIdx) {
				if (arr[lowIdx] > arr[pivotIdx] && arr[highIdx] <= arr[pivotIdx]) {
					swap(arr, lowIdx, highIdx);
				}

				if (arr[lowIdx] <= arr[pivotIdx]) {
					lowIdx++;
				}

				if (arr[highIdx] > arr[pivotIdx]) {
					highIdx--;
				}
			}

			swap(arr, pivotIdx, highIdx);

			if (highIdx == targetIdx) {
				return arr[highIdx];
			} else if (highIdx < targetIdx) {
				leftIdx = highIdx + 1;
			} else {
				rightIdx = highIdx - 1;
			}
		}
	}

	private static void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}

}
