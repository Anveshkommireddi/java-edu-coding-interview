package com.edu.java.binarysearch;

public class MinimizeMaxDifference {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 101, 107, 201, 206 };
		int k = 3;
		Integer[][] mem = new Integer[arr.length + 1][k + 1];
		int result = minMaxDiff(arr, 0, k, mem);
		System.out.println(result);
	}

	private static int minMaxDiff(int[] arr, int startIdx, int k, Integer[][] mem) {

		if (k == 1) {
			return getMinMaxDiff(arr, startIdx, arr.length - 1);
		}

		if (null != mem[startIdx][k])
			return mem[startIdx][k];

		int res = Integer.MAX_VALUE;
		for (int idx = startIdx; idx < arr.length - k; idx++) {
			int minTemp = getMinMaxDiff(arr, startIdx, idx);
			int partitonTemp = minMaxDiff(arr, idx + 1, k - 1, mem);
			int min = Math.max(partitonTemp, minTemp);
			res = Math.min(res, min);
		}
		return mem[startIdx][k] = res;
	}

	private static int getMinMaxDiff(int[] arr, int startIdx, int endIdx) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int idx = startIdx; idx <= endIdx; idx++) {
			min = Math.min(arr[idx], min);
			max = Math.max(arr[idx], max);
		}
		return Math.abs(max - min);
	}

}
