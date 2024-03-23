package com.edu.java.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithSumK {

	public static void main(String[] args) {
		int[] arr = { 10, 2, -2, -20, 10 };
		int sum = -10;
		int count = countSubArraysWithSumK(arr, sum);
		System.out.println(count);
	}

	private static int countSubArraysWithSumK(int[] arr, int targetSum) {
		Map<Integer, Integer> countMap = new HashMap<>();
		countMap.put(0, 1);
		int count = 0;
		int currSum = 0;
		for (int num : arr) {
			currSum += num;
			int checkSum = currSum - targetSum;
			if (countMap.containsKey(checkSum)) {
				count += countMap.get(checkSum);
			}
			countMap.put(currSum, countMap.getOrDefault(currSum, 0) + 1);
		}
		return count;
	}
}
