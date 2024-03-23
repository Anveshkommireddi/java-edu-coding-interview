package com.edu.java.arrays;

public class CheckMinimum {

	public static void main(String args[]) {

		int[] arr = { 9, 2, 3, 6 };

		System.out.print("Array : ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		int min = findMinimum(arr);
		System.out.println("Minimum in the Array: " + min);

	}

	private static int findMinimum(int[] arr) {
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			result = Math.min(arr[i], result);
		}
		return result;
	}

}
