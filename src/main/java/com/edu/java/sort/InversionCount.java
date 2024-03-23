package com.edu.java.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InversionCount {

	private static final Logger LOGGER = LoggerFactory.getLogger(InversionCount.class);

	public static void main(String[] args) {
		int[] arr = { 3, 2, 4, 1, 6 };
		int invCount = mergeSort(arr, 0, arr.length - 1);
		LOGGER.info("Inversion Count is {}", invCount);
	}

	private static int mergeSort(int[] arr, int low, int high) {
		int totalInversions = 0;
		if (low >= high) return totalInversions;
		int mid = low + (high - low) / 2;
		totalInversions += mergeSort(arr, low, mid);
		totalInversions += mergeSort(arr, mid + 1, high);
		totalInversions += merge(arr, low, mid, high);
		return totalInversions;
	}

	private static int merge(int[] arr, int low, int mid, int high) {
		int invCount = 0;
		int[] leftArr = copyElementsFrom(arr, low, mid);
		int[] rightArr = copyElementsFrom(arr, mid + 1, high);
		int leftIdx = 0;
		int rightIdx = 0;
		int arrIdx = low;
		while (leftIdx < leftArr.length && rightIdx < rightArr.length) {
			if (leftArr[leftIdx] <= rightArr[rightIdx]) {
				arr[arrIdx++] = leftArr[leftIdx++];
			} else {
				invCount += leftArr.length - leftIdx;
				arr[arrIdx++] = rightArr[rightIdx++];
			}
		}

		while (leftIdx < leftArr.length) {
			arr[arrIdx++] = leftArr[leftIdx++];
		}

		while (rightIdx < rightArr.length) {
			arr[arrIdx++] = rightArr[rightIdx++];
		}
		return invCount;
	}

	private static int[] copyElementsFrom(int[] arr, int low, int high) {
		int resIdx = 0;
		int[] res = new int[high - low + 1];
		for (int idx = low; idx <= high; idx++)
			res[resIdx++] = arr[idx];
		return res;
	}

}
