package com.edu.java.arrays;

public class CheckRotateArray {

	public static void main(String args[]) {

		int[] arr = { 3, 6, 1, 8, 4, 2 };

		System.out.print("Array before rotation: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		rotateArray(arr);

		System.out.print("Array after rotation: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void rotateArray(int[] arr) {
		// reverse left part
		reverse(arr, 0, arr.length - 2);
		// reverse right part
		reverse(arr, arr.length - 1, arr.length - 1);
		// reverse whole array
		reverse(arr, 0, arr.length - 1);
	}

	private static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		if (idx1 != idx2 && arr[idx1] != arr[idx2]) {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
	}

}
