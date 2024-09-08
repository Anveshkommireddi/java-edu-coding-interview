package com.edu.java.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContainerWithMostWater {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContainerWithMostWater.class);

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int result = maxWater(height);
		LOGGER.info("Result is {}", result);
	}

	private static int maxWater(int[] arr) {
		int sp = 0;
		int ep = arr.length - 1;
		int result = Integer.MIN_VALUE;
		while (sp < ep) {
			int left = arr[sp];
			int right = arr[ep];
			int area = Math.min(left, right) * (ep - sp);
			result = Math.max(result, area);
			if (left <= right) {
				sp++;
			} else {
				ep--;
			}
		}
		return result;
	}

	private static int maxWaterTest2(int[] arr) {
		int result = Integer.MIN_VALUE;
		int l = 0;
		int r = arr.length - 1;
		while (l < r) {
			int width = r - l;
			int height = Math.min(arr[l], arr[r]);
			int area = width * height;
			result = Math.max(area, result);
			if (arr[l] < arr[r]) {
				l++;
			} else {
				r--;
			}
		}
		return result;
	}

}
