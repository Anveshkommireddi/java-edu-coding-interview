package com.edu.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsMainTest {

	public static void main(String[] args) {

		List<Integer> nums1 = new ArrayList<>(Arrays.asList(1, 2, 3));
		List<Integer> nums2 = new ArrayList<>(Arrays.asList(2, 4, 5));

		System.out.println(nums1);
		System.out.println(nums2);

		copy(nums1, nums2);

		copyAllBut(nums1, nums2, 2);

		System.out.println(nums1);
		System.out.println(nums2);
	}

	// Generic function
	private static <T> void copy(List<T> from, List<T> to) {
		for (T val : from) {
			to.add(val);
		}
	}

	// Constraints on methods using generics
	private static <T extends Comparable<T>> void copyAllBut(List<T> from, List<T> to, T exclude) {
		for (T val : from) {
			if (val.compareTo(exclude) != 0) {
				to.add(val);
			}
		}
	}
}
