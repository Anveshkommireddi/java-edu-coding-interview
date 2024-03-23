package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PeakElement {

	private static final Logger LOGGER = LoggerFactory.getLogger(PeakElement.class);

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2, 4, 4, 5, 2, 3 };
		int peakIdx = findOnePeakElement(arr);
		LOGGER.info("Peak Element :: {}", peakIdx);
	}

	private static int findOnePeakElement(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
				return mid;
			} else if (mid > 0 && arr[mid - 1] > arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
