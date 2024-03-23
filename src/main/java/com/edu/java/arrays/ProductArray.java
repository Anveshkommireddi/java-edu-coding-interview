package com.edu.java.arrays;

public class ProductArray {

	private static int[] findProduct(int[] arr) {
		int[] res = new int[arr.length];
		// store cumulative product from right side
		int temp = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			res[i] = temp;
			temp *= arr[i];
		}
		temp = 1;
		// store cumulative product from left side
		for (int i = 0; i < arr.length; i++) {
			res[i] *= temp;
			temp *= arr[i];
		}
		return res;
	}

	public static void main(String args[]) {

		int[] arr = { -1, 2, -3, 4, -5 };

		System.out.println("Array before product: " + arrayToString(arr));

		int[] prodArray = findProduct(arr);

		System.out.println("Array after product: " + arrayToString(prodArray));
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
}
