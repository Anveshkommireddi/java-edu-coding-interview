package com.edu.java.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxInASlidingWindow {

	public static void main(String[] args) {
		int[] targetList = { 3, 2, 1, 2 };
		int[][] numsList = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				{ 10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67 }, { 4, 5, 6, 1, 2, 3 },
				{ 9, 5, 3, 1, 6, 3 } };
		for (int i = 0; i < targetList.length; i++) {
			System.out.println((i + 1) + ". Original list:\t" + Arrays.toString(numsList[i]));
			System.out.println("   Window size:\t\t" + targetList[i]);
			ArrayDeque<Integer> ouput = findMaxSlidingWindow(numsList[i], targetList[i]);
			System.out.println("   Max:\t\t\t" + ouput);
			System.out.println(
					"-----------------------------------------------------------------------------------------------------\n");
		}
	}

	// arr --> 1, 3, 2, 4, 5, 6, 7, 8, 9, 10  windowLength --> 3
	private static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowLength) {
		ArrayDeque<Integer> result = new ArrayDeque<>();
		if (null == arr || arr.length == 0)
			return result;
		if (arr.length < windowLength) {
			windowLength = arr.length;
		}

		Deque<Integer> list = new ArrayDeque<>();
		//prepare dequeue for first window
		for (int i = 0; i < windowLength; i++) {
			// remove smaller values than current values to maintain decreasing order in Dequeue
			while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
				list.removeLast();
			}
			list.addLast(i);
		}

		for (int i = windowLength; i < arr.length; i++) {
			// add peak from previous window to result
			result.addLast(arr[list.peekFirst()]);
			// remove older window indexes
			while (!list.isEmpty() && list.peekFirst() <= i - windowLength) {
				list.removeFirst();
			}
			// remove smaller values than current values to maintain decreasing order in Dequeue
			while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
				list.removeLast();
			}
			list.addLast(i);
		}
		//add peak from last window to the result
		result.addLast(arr[list.peekFirst()]);
		return result;
	}

}
