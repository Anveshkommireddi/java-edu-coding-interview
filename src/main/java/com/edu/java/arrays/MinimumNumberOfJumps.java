package com.edu.java.arrays;

public class MinimumNumberOfJumps {

	public static void main(String... args) {
		//int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int[] arr = { 2, 3, 1, 1, 4 };
		int result = minJumps(arr);
		boolean isReachable = isReachable(arr);
		int results = minJumps(arr, 0);
		System.out.println("Result is " + results);
		//System.out.println("is reachable :: " + isReachable);
		//System.out.println("Result is :: " + result);
	}
	
	private static int minJumps(int[] arr, int idx) {
		if (idx == arr.length - 1)
			return 0;
		if (arr[idx] == 0)
			return Integer.MAX_VALUE;
		int res = Integer.MAX_VALUE;
		for (int i = idx + 1; i <= idx + arr[idx] && i < arr.length; i++) {
			int minres = minJumps(arr, i);
			if (minres != Integer.MAX_VALUE && minres + 1 < res) {
				res = minres + 1;
			}
		}
		return res;
	}

	private static int minJumps(int[] arr) {
		int stepsPossible = arr[0];
		int maxReachable = arr[0];
		int minJumps = 1;

		for (int currIdx = 1; currIdx < arr.length; currIdx++) {
			if (currIdx > maxReachable) return -1;
			stepsPossible--;
			maxReachable = Math.max(maxReachable, currIdx + arr[currIdx]);
			if (stepsPossible == 0) {
				minJumps++;
				stepsPossible = maxReachable - currIdx;
			}
		}
		return minJumps;
	}

	private static boolean isReachable(int[] arr) {
		int maxReachable = 0;
		for (int currIdx = 0; currIdx < arr.length; currIdx++) {
			if (currIdx > maxReachable)
				return false;
			int maxReachableFromCurr = currIdx + arr[currIdx];
			maxReachable = Math.max(maxReachable, maxReachableFromCurr);
		}
		return true;
	}

}
