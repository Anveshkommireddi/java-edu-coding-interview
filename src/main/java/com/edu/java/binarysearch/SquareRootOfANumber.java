package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SquareRootOfANumber {

	private static final Logger LOGGER = LoggerFactory.getLogger(SquareRootOfANumber.class);

	public static void main(String[] args) {
		// return floor if square root is not present
		// square root of a number lies between 1 and n/2;
		int x = 2147395599;
		int ans = floorOfASquareRoot(x);
		LOGGER.info("Answer is :: {}", ans);
	}

	private static int floorOfASquareRoot(int x) {
		int low = 1;
		int high = x;
		int ans = 0;
		if (x == 0) return 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (x / mid == mid) return mid;
			if (x / mid < mid) {
				high = mid - 1;
			} else {
				ans = mid;
				low = mid + 1;
			}
		}
		return ans;
	}
}
