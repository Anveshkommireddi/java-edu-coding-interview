package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FloorCeil {

	private static final Logger LOGGER = LoggerFactory.getLogger(FloorCeil.class);

	public static void main(String[] args) {
		int[] nums = { 3, 5, 8, 15, 19 };
		int target = 4;
		int floorIdx = findFloor(nums, target);
		int ceilIdx = findCeil(nums, target);
		LOGGER.info("Floor for the target {} is {}", target, floorIdx);
		LOGGER.info("Ceil for the target {} is {}", target, ceilIdx);
	}

	private static int findCeil(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return mid;
			if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	private static int findFloor(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return mid;
			if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high;
	}

}
