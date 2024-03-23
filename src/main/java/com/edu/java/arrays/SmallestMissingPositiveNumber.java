package com.edu.java.arrays;

public class SmallestMissingPositiveNumber {

	public static void main(String[] args) {
		int N = 5;
		// int[] arr = { 0, -10, 1, 3, -20 };
		int[] arr = { 1, 2, 3, 4, 5 };
		int result = missingNumber(arr, N);
		System.out.println(result);
	}

	private static int missingNumber(int arr[], int size) {
		int idx = 0;
		while (idx < size) {
			int currIdx = idx;
			int targetIdx = arr[idx] - 1;
			if (arr[currIdx] > 0 && arr[currIdx] <= arr.length && arr[currIdx] != arr[targetIdx]) {
				swap(arr, currIdx, targetIdx);
			} else {
				idx++;
			}
		}

		for (int i = 0; i < size; i++) {
			if (arr[i] != i + 1)
				return i + 1;
		}
		return size + 1;
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		if (idx1 != idx2 && arr[idx1] != arr[idx2]) {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
	}

}
