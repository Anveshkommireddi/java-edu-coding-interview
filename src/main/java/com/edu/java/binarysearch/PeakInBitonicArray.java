package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PeakInBitonicArray {

	private static final Logger LOGGER = LoggerFactory.getLogger(PeakInBitonicArray.class);

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int peakIdx = findPeakInBitonicArray(arr);
		LOGGER.info("Peak in the Bitonic Array is {}", peakIdx);
	}

	private static int findPeakInBitonicArray(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
				return mid;
			} else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
				low = mid + 1;
			} else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				high = mid - 1;
			}
		}
		return -1;
	}

}
