package com.edu.java.arrays;

import java.util.Arrays;

public class LeastCommonNumber {

	public static void main(String[] args) {
		int[] v1 = new int[] { 6, 7, 10, 25, 30, 63, 64 };
		int[] v2 = new int[] { 0, 4, 5, 6, 7, 8, 50 };
		int[] v3 = new int[] { 1, 6, 10, 14 };
		System.out.println("Array 1: " + Arrays.toString(v1));
		System.out.println("Array 2: " + Arrays.toString(v2));
		System.out.println("Array 3: " + Arrays.toString(v3));

		Integer result = findLeastCommonNumber(v1, v2, v3);
		System.out.println("Least Common Number: " + result);
	}

	private static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
		int a1Pointer = 0;
		int a2Pointer = 0;
		int a3Pointer = 0;
		while (a1Pointer < arr1.length && a2Pointer < arr2.length && a3Pointer < arr3.length) {

			if (arr1[a1Pointer] == arr2[a2Pointer] && arr2[a2Pointer] == arr3[a3Pointer]) {
				return arr1[a1Pointer];
			}

			if (arr1[a1Pointer] <= arr2[a2Pointer] && arr1[a1Pointer] <= arr3[a3Pointer]) {
				a1Pointer++;
			} else if (arr2[a2Pointer] <= arr1[a1Pointer] && arr2[a2Pointer] <= arr3[a3Pointer]) {
				a2Pointer++;
			} else if (arr3[a3Pointer] <= arr1[a1Pointer] && arr3[a3Pointer] <= arr2[a2Pointer]) {
				a3Pointer++;
			}
		}
		return -1;
	}
}
