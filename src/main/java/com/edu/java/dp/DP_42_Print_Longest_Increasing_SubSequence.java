package com.edu.java.dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_42_Print_Longest_Increasing_SubSequence {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_42_Print_Longest_Increasing_SubSequence.class);

	public static void main(String[] args) {
		int[] arr = { 5, 4, 11, 1, 16, 8 };
		printLIS(arr);
	}

	private static void printLIS(int[] arr) {
		int[] maxLenArr = new int[arr.length];
		Arrays.fill(maxLenArr, 1);
		int[] parent = new int[arr.length];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		int maxlengthIdx = -1;
		int maxi = Integer.MIN_VALUE;
		for (int currIdx = 1; currIdx < arr.length; currIdx++) {
			for (int prevIdx = 0; prevIdx < currIdx; prevIdx++) {
				if (arr[currIdx] > arr[prevIdx] && 1 + maxLenArr[prevIdx] > maxLenArr[currIdx]) {
					maxLenArr[currIdx] = 1 + maxLenArr[prevIdx];
					parent[currIdx] = prevIdx;
				}
			}
			if (maxLenArr[currIdx] > maxi) {
				maxi = maxLenArr[currIdx];
				maxlengthIdx = currIdx;
			}
		}
		LOGGER.info("Input Array     {}", arr);
		LOGGER.info("parent array    {}", parent);
		LOGGER.info("maxLength Array {}", maxLenArr);

		Deque<Integer> stack = new ArrayDeque<>();
		int currIdx = maxlengthIdx;
		stack.push(arr[currIdx]);
		while (parent[currIdx] != currIdx) {
			currIdx = parent[currIdx];
			stack.push(arr[currIdx]);
		}
		LOGGER.info("stack {}", stack);
	}
}
