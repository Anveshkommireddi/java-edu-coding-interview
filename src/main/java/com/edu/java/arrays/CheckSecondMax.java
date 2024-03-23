package com.edu.java.arrays;

public class CheckSecondMax {

	public static void main(String args[]) {

		int[] arr = { -2, -33, -10, -456 };

		System.out.println("Array: " + arrayToString(arr));

		int secMax = findSecondMaximum(arr);

		System.out.println("Second maximum: " + secMax);

	}
	
	public static String arrayToString(int[] arr) {
		if (arr.length > 0) {
			StringBuilder result = new StringBuilder("");
			for (int i = 0; i < arr.length; i++) {
				result.append(arr[i]).append(" ");
			}
			return result.toString();
		} else {
			return "Empty Array!";
		}
	}

	private static int findSecondMaximum(int[] arr) {
		int firstMax = Integer.MIN_VALUE;
		int secondMax = firstMax;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > firstMax) {
				secondMax = firstMax;
				firstMax = arr[i];
			} else if (arr[i] > secondMax && arr[i] != firstMax) {
				secondMax = arr[i];
			}
		}
		return secondMax;
	}

}
