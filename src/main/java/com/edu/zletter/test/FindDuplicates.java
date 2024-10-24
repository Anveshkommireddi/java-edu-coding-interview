package com.edu.zletter.test;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 6, 4, 4 };
		Set<Integer> duplicates = findDuplicates(arr);
		System.out.println(duplicates);
	}

	private static Set<Integer> findDuplicates(int[] arr) {
		int idx = 0;
		while (idx < arr.length) {
			int currIdx = idx;
			int tgtIdx = arr[idx] - 1;
			if (arr[currIdx] == arr[tgtIdx]) {
				idx++;
			} else {
				swap(arr, currIdx, tgtIdx);
			}
		}
		Set<Integer> result = new HashSet<>();
		for (int cIdx = 0; cIdx < arr.length; cIdx++) {
			if (arr[cIdx] != cIdx + 1) {
				result.add(arr[cIdx]);
			}
		}
		return result;
	}

	private static void swap(int[] arr, int currIdx, int tgtIdx) {
		int temp = arr[currIdx];
		arr[currIdx] = arr[tgtIdx];
		arr[tgtIdx] = temp;
	}

}
