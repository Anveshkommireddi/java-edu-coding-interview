package com.edu.java.arrays;

import java.util.Arrays;

public class ReArrangeNumsAlternativelyBySign {

	public static void main(String[] args) {
		int[] arr = { 3, 1, -2, -5, 2, -4 };
		Arrays.asList(arr).stream().forEach(num -> System.out.print(num + " "));
		System.out.println();
		int[] res = reArrangeBySign(arr);
		Arrays.asList(res).stream().forEach(num -> System.out.print(num + " "));
	}

	private static int[] reArrangeBySign(int[] arr) {
		int pIdx = 0;
		int nIdx = 1;
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int idx = 0;
			if (arr[i] > 0) {
				idx = pIdx;
				pIdx += 2;
			} else {
				idx = nIdx;
				nIdx += 2;
			}
			res[idx] = arr[i];
		}
		return res;
	}

}
