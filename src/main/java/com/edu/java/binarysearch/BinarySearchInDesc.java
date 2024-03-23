package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinarySearchInDesc {

	private static final Logger LOGGER = LoggerFactory.getLogger(BinarySearchInDesc.class);

	public static void main(String[] args) {
		int[] arr = { 8, 7, 6, 5, 4, 3, 2, 1 };
		int target = 7;
		int resIdx = reverseBinarySearch(arr, target);
		LOGGER.info("Index of the Target is :: {}", resIdx);
	}

	private static int reverseBinarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

}
