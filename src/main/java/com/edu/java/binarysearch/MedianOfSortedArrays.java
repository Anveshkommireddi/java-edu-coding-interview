package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MedianOfSortedArrays {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedianOfSortedArrays.class);

	public static void main(String[] args) {
		int[] nums1 = { 2, 3, 5, 8 };
		int[] nums2 = { 10, 12, 14, 16, 18, 20 };
		double median = nums1.length > nums2.length ? median(nums2, nums1) : median(nums1, nums2);
		LOGGER.info("Median of 2 arrays is {}", median);
	}

	private static double median(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int low = 0;
		int high = l1;
		int mid = (l1 + l2 + 1) / 2;
		while (low <= high) {

			int left1 = Integer.MIN_VALUE;
			int left2 = Integer.MIN_VALUE;
			int right1 = Integer.MAX_VALUE;
			int right2 = Integer.MAX_VALUE;

			int mid1 = low + (high - low) / 2;
			int mid2 = mid - mid1;

			if (mid1 >= 0 && mid1 < nums1.length)
				right1 = nums1[mid1];
			if (mid2 >= 0 && mid2 < nums2.length)
				right2 = nums2[mid2];
			if (mid1 - 1 >= 0)
				left1 = nums1[mid1 - 1];
			if (mid2 - 1 >= 0)
				left2 = nums2[mid2 - 1];

			if (left1 <= right2 && left2 <= right1) {
				if ((l1 + l2) % 2 == 0) {
					return Math.max(left1, left2);
				} else {
					return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
				}
			} else if (left1 > right2) {
				high = mid1 - 1;
			} else {
				low = mid1 + 1;
			}
		}
		return 0;
	}

}
