package com.edu.java.dp;

import java.util.Arrays;

public class DP_18_Count_SubSets_With_S1_Greater_than_S2 {

	public static final int MOD = Double.valueOf(Math.pow(10, 9) + 7).intValue(); // 1000000007

	public static void main(String[] args) {
		int[] arr = { 1, 0, 8, 5, 1, 4 };
		Arrays.sort(arr);
		reverserArray(arr, 0, arr.length-1);
		int difference = 17;
		int size = arr.length;
		int count = countPartitions(size, difference, arr);
		System.out.println(count);
	}

	private static void reverserArray(int[] arr, int i, int j) {
		while(i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

	public static int countPartitions(int n, int d, int[] arr) {
		int totalSum = 0;
		for (int i = 0; i < arr.length; i++) {
			totalSum += arr[i];
		}
		int target = totalSum + d;
		if (target % 2 != 0)
			return 0;
		target = (totalSum + d) / 2;
		Integer[][] mem = new Integer[arr.length][target + 1];
		int count = countSub(arr, arr.length - 1, target, mem);
		return count;
	}

	private static int countSub(int[] arr, int idx, int target, Integer[][] mem) {

		if (target == 0)
			return 1;
		if (idx == 0 && arr[idx] == target)
			return 1;

		if (idx <= 0 || target < 0)
			return 0;

		if (null != mem[idx][target])
			return mem[idx][target];

		int dontPickCount = countSub(arr, idx - 1, target, mem);
		int pickCount = 0;
		if (arr[idx] <= target) {
			pickCount = countSub(arr, idx - 1, target - arr[idx], mem);
		}
		return mem[idx][target] = (pickCount + dontPickCount) % MOD;
	}

}
