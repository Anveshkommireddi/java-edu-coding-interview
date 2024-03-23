package com.edu.java.arrays;

public class RemoveEvenNumbersInPlace {

	public static void main(String[] args) {
		int[] arr = { 32, 37, 10, 40, 11, 5 };
		moveEvenToEnd(arr);
		System.out.println(arr);
	}

	private static void moveEvenToEnd(int[] arr) {
		int lp = 0;
		for (int rp = 0; rp < arr.length; rp++) {
			if (arr[rp] % 2 != 0) {
				swap(arr, lp, rp);
				lp++;
			}
		}
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
