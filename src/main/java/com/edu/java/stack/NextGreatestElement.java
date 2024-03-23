package com.edu.java.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestElement {

	public static void main(String[] args) {
		int arr[] = { 4, 6, 3, 2, 8, 1, 11 };
		System.out.println(Arrays.toString(arr));
		int result[] = nextGreatestElement(arr);
		System.out.println(Arrays.toString(result));
	}
	
	private static int[] nextGreatestElement(int[] arr) {
		int[] result = new int[arr.length];
		Arrays.fill(result, -1);
		Stack<Integer> stack = new Stack<>();
		for (int numIdx = arr.length - 1; numIdx >= 0; numIdx--) {
			while (!stack.isEmpty() && arr[numIdx] >= stack.peek()) {
				stack.pop();
			}
			result[numIdx] = !stack.isEmpty() ? stack.peek() : -1;
			stack.push(arr[numIdx]);
		}
		return result;
	}

}
