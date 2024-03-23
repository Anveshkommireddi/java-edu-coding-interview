package com.edu.java.hashing;

import java.util.HashSet;
import java.util.Set;

public class FindSubArrayWithSumK {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 20, 3, 10, 5 };
		int sum = 33;
		boolean isExist = checkIfSubArrayExistWithSumK(arr, sum);
		System.out.println(isExist);
	}

	private static boolean checkIfSubArrayExistWithSumK(int[] arr, int sum) {
		int currSum = 0;
		Set<Integer> numsSet = new HashSet<>();
		numsSet.add(0);
		for (int num : arr) {
			currSum += num;
			int checkSum = currSum - sum;
			if (numsSet.contains(checkSum)) {
				return true;
			}
			numsSet.add(currSum);
		}
		return false;
	}

}
