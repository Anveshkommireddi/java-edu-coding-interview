package com.edu.java.arrays;

public class CheckReArrange {

	private static void reArrange(int[] arr) {
		int writePointer = 0;
		int readPointer = 0;
		while (readPointer < arr.length) {
			if (arr[readPointer] < 0) {
				swap(arr, writePointer, readPointer);
				writePointer++;
			}
			readPointer++;
		}
	}

	public static void main(String args[]) {

		int[] arr = { 2, 4, -6, 8, -5, -10 };

		System.out.print("Array before re-arranging: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		reArrange(arr);

		System.out.print("Array after rearranging: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		if (idx1 != idx2 && arr[idx1] != arr[idx2]) {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
	}
}
