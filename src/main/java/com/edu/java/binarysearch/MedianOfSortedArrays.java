package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MedianOfSortedArrays {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedianOfSortedArrays.class);

	public static void main(String[] args) {
		int[] nums1 = { 2, 3, 5, 8 };
		int[] nums2 = { 10, 12, 14, 16, 18, 20 };
		double median = median(nums1, nums2);
		LOGGER.info("Median of 2 arrays is {}", median);
	}

	private static double median(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int low = 0;
		int high = l1 - 1;
		while(low <= high) {
			int left1 = Integer.MIN_VALUE;
			int left2 = Integer.MIN_VALUE;
			int right1 = Integer.MAX_VALUE;
			int right2 = Integer.MAX_VALUE;
			int mid = (l1 + l2 + 1)/2;
		}
		return 0;
	}

}
