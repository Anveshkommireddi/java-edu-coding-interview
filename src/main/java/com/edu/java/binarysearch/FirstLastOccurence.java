package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstLastOccurence {

	private static final Logger LOGGER = LoggerFactory.getLogger(FirstLastOccurence.class);

	public static void main(String[] args) {

		int[] input = { 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 11 };
		
		int target = 22;

		int[] result = rangeOfaNumber(input, target);

		LOGGER.info("Range is :: {} from {}", result[0], result[1]);
	}

	private static int[] rangeOfaNumber(int[] input, int target) {
		int lowIdx = floorOfTarget(input, target);
		int highIdx = ceilOfTarget(input, target);
		return new int[] { lowIdx, highIdx };
	}

	private static int floorOfTarget(int[] arr, int target) {
		int high = arr.length - 1;
		int low = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < target) {
				low = mid + 1;
			} else if (arr[mid] >= target) {
				high = mid - 1;
			}
		}
		return low < arr.length && arr[low] == target ? low : -1;
	}

	private static int ceilOfTarget(int[] arr, int target) {
		int high = arr.length - 1;
		int low = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] <= target) {
				low = mid + 1;
			} else if (arr[mid] > target) {
				high = mid - 1;
			}
		}
		return high > 0 && arr[high] == target ? high : -1;
	}

}
