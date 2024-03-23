package com.edu.java.arrays;

import java.util.Arrays;

public class MoveNumberToLeftOrRight {

	public static void main(String[] args) {
		int[][] numsList = { { 1, 10, 20, 0, 59, 63, 0, 88, 0 }, { 1, 0, 2, 3, 0 }, { 0 }, { -1, 0, 0, -2, 9 },
				{ 1, 2, 3, 4, 5 }, { 2 } };

		for (int i = 0; i < numsList.length; i++) {
			System.out.println((i + 1) + ". Before list:\t" + Arrays.toString(numsList[i]));
			moveZerosToLeft(numsList[i], 0);
			System.out.println("   After list Left:\t" + Arrays.toString(numsList[i]));
			moveTargetToRight(numsList[i], 0);
			System.out.println("   After list Right:\t" + Arrays.toString(numsList[i]));
			System.out.println(
					"----------------------------------------------------------------------------------------------------\n");
		}
	}

	private static void moveZerosToLeft(int[] arr, int toMove) {
		int readPointer = arr.length - 1;
		int writePointer = arr.length - 1;
		while (readPointer >= 0) {
			if (arr[readPointer] != toMove) {
				arr[writePointer] = arr[readPointer];
				writePointer--;
			}
			readPointer--;
		}

		for (int i = writePointer; i >= 0; i--) {
			arr[i] = toMove;
		}
	}

	private static void moveTargetToRight(int[] arr, int toMove) {
		int readPointer = 0;
		int writePointer = 0;
		while (readPointer < arr.length) {
			if (arr[readPointer] != toMove) {
				arr[writePointer] = arr[readPointer];
				writePointer++;
			}
			readPointer++;
		}

		for (int i = writePointer; i < arr.length; i++) {
			arr[i] = toMove;
		}
	}

}
