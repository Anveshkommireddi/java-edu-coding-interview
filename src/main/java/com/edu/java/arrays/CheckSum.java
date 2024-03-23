package com.edu.java.arrays;

import java.util.Arrays;

public class CheckSum {
	public static void main(String[] args) {
		int n = 9;
		int[] arr1 = { 1, 2, 3, 4, 5 };
		if (arr1.length > 0) {
			int[] arr2 = findSum(arr1, n);
			int num1 = arr2[0];
			int num2 = arr2[1];

			if ((num1 + num2) != n)
				System.out.println("Not Found");
			else {
				System.out.println("Number 1 = " + num1);
				System.out.println("Number 2 = " + num2);
				System.out.println("Sum = " + (n));

			}
		} else {
			System.out.println("Input Array is Empty!");
		}
	}

	private static int[] findSum(int[] arr, int n) {
		int[] res = new int[2];
		Arrays.sort(arr);
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int sum = arr[low] + arr[high];
			if (sum < n) {
				low++;
			} else if (sum > n) {
				high--;
			} else {
				return new int[] { arr[low], arr[high] };
			}
		}
		return res;
	}
}
