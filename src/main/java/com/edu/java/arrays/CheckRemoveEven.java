package com.edu.java.arrays;

import java.util.Arrays;

public class CheckRemoveEven {

	private static int[] removeEven(int[] arr) {
		int oddElementsSize = (int) Arrays.stream(arr).filter(num -> num % 2 != 0).count();
		int[] result = new int[oddElementsSize];
		int resIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				result[resIdx] = arr[i];
				resIdx++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int size = 10;
		int[] arr = new int[size]; // declaration and instantiation

		System.out.print("Before removing Even Numbers: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i; // assigning values
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		int[] newArr = removeEven(arr); // calling removeEven

		System.out.print("After removing Even Numbers: ");
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " "); // prinitng array
		}
	}

}
