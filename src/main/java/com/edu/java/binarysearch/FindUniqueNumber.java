package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//give a sorted array with 2 numbers and only one number once. find the index of the single number
public class FindUniqueNumber {

	private static final Logger LOGGER = LoggerFactory.getLogger(FindUniqueNumber.class);

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 3, 4, 4, 5, 5 };
		int[] arr1 = { 1, 1, 2, 2, 3, 4, 4, 5, 5 };
		int[] arr2 = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6 };
		int[] arr3 = { 1, 2, 2, 3, 3, 4, 4, 5, 5 };
		int[] arr4 = { 1, 1, 2, 2, 3, 3, 4, 4, 5 };
		int resultIdx = findUniqueNum(arr3);
		LOGGER.info("Result Idx is {}", resultIdx);
	}

	private static int findUniqueNum(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || arr[mid] != arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] != arr[mid + 1]))
				return mid;
			if (mid > 0 && arr[mid] == arr[mid - 1]) {
				int leftLength = mid - 1;
				if (leftLength % 2 != 0) {
					high = mid - 1 - 1;
				} else {
					low = mid + 1;
				}
			} else if (arr[mid] == arr[mid + 1]) {
				int leftLength = mid;
				if (leftLength % 2 != 0) {
					high = mid - 1;
				} else {
					low = mid + 1 + 1;
				}
			}
		}
		return -1;
	}

}
