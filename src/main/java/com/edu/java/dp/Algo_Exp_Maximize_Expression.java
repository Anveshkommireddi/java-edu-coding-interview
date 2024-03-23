package com.edu.java.dp;

public class Algo_Exp_Maximize_Expression {

	public static void main(String[] args) {
		int[] arr = { 3, 6, 1, -3, 2, 7 };
		// arr[a] - arr[b] + arr[c] - arr[d]
		int result = maximizeExpr(arr, 0, 4, true, 0);
	}

	private static int maximizeExpr(int[] arr, int idx, int k, boolean isEven, int currSum) {
		if(k == 1) {
			int mul = isEven ? 1 : -1;
			//int maxVal = currSum < 0 ? getM
		}
		int result = Integer.MIN_VALUE;
		return result;
	}

}
