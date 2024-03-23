package com.edu.java.sort;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergeSort {

	static Map<Integer, Integer> leftGreaterElementsCountMap = new HashMap<>();
	static Map<Integer, Integer> rightGreaterElementsCountMap = new HashMap<>();

	private static final Logger LOGGER = LoggerFactory.getLogger(MergeSort.class);

	public static void main(String[] args) {
		int[] arr = { 3, 2, 4, 1, 6 };
		LOGGER.info("Array is {}", arr);
		mergeSort(arr, 0, arr.length - 1);
		LOGGER.info("leftGreaterElementsCountMap is {}", leftGreaterElementsCountMap);
		LOGGER.info("rightGreaterElementsCountMap is {}", rightGreaterElementsCountMap);
		LOGGER.info("Sorted Array is {}", arr);
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if (low >= high) return;
		int mid = low + (high - low) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int[] leftArr = copyElementsFrom(arr, low, mid);
		int[] rightArr = copyElementsFrom(arr, mid + 1, high);
		int leftIdx = 0;
		int rightIdx = 0;
		int arrIdx = low;
		while (leftIdx < leftArr.length && rightIdx < rightArr.length) {
			if (leftArr[leftIdx] <= rightArr[rightIdx]) {
				rightGreaterElementsCountMap.put(leftArr[leftIdx],
						rightGreaterElementsCountMap.getOrDefault(leftArr[leftIdx], 0) + rightArr.length - rightIdx);
				arr[arrIdx++] = leftArr[leftIdx++];
			} else {
				leftGreaterElementsCountMap.put(rightArr[rightIdx],
						leftGreaterElementsCountMap.getOrDefault(rightArr[rightIdx], 0) + leftArr.length - leftIdx);
				arr[arrIdx++] = rightArr[rightIdx++];
			}
		}

		while (leftIdx < leftArr.length) {
			arr[arrIdx++] = leftArr[leftIdx++];
		}

		while (rightIdx < rightArr.length) {
			arr[arrIdx++] = rightArr[rightIdx++];
		}

	}

	private static int[] copyElementsFrom(int[] arr, int low, int high) {
		int resIdx = 0;
		int[] res = new int[high - low + 1];
		for (int idx = low; idx <= high; idx++)
			res[resIdx++] = arr[idx];
		return res;
	}

}
