package com.edu.java.arrays;

public class CheckMergeArray {

	private static int[] mergeArrays(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		int resIdx = 0;
		int firstIdx = 0;
		int secondIdx = 0;
		while (firstIdx < arr1.length && secondIdx < arr2.length) {
			if (arr1[firstIdx] <= arr2[secondIdx]) {
				result[resIdx] = arr1[firstIdx];
				firstIdx++;
			} else {
				result[resIdx] = arr2[secondIdx];
				secondIdx++;
			}
			resIdx++;
		}

		while (firstIdx < arr1.length) {
			result[resIdx] = arr1[firstIdx];
			firstIdx++;
			resIdx++;
		}

		while (secondIdx < arr2.length) {
			result[resIdx] = arr2[secondIdx];
			secondIdx++;
			resIdx++;
		}
		return result;
	}

	public static void main(String args[]) {

		int[] arr1 = { 1, 12, 14, 17, 23 }; // creating a sorted array called arr1
		int[] arr2 = { 11, 19, 27 }; // creating a sorted array called arr2

		int[] resultantArray = mergeArrays(arr1, arr2); // calling mergeArrays

		System.out.print("Arrays after merging: ");
		for (int i = 0; i < arr1.length + arr2.length; i++) {
			System.out.print(resultantArray[i] + " ");
		}
	}
}
