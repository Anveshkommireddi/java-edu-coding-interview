package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchInSortedRotatedArray {

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchInSortedRotatedArray.class);

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 , 5, 6, 7, 8, 9, 10};
		int target = 3;
		int peakIdx = findPeak(arr);
		LOGGER.info("Pivot in the array is :: {}", arr[peakIdx]);
		int resIdx = -1;
		if (peakIdx != -1) {
			resIdx = binarySearch(arr, 0, peakIdx, target);
			if (resIdx == -1)
				resIdx = binarySearch(arr, peakIdx + 1, arr.length - 1, target);
		}
		LOGGER.info("Result Idx is :: {}", resIdx);
	}

	private static int binarySearch(int[] arr, int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	private static int findPeak(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		int sortFlagVal = arr[0];
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
				return mid;
			} else if (sortFlagVal < arr[mid]) {
				low = mid + 1;
			} else if (sortFlagVal > arr[mid]) {
				high = mid - 1;
			}
		}
		return -1;
	}

}
