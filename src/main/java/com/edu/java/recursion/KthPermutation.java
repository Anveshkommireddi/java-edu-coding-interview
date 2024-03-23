package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KthPermutation {

	private static final Logger LOGGER = LoggerFactory.getLogger(KthPermutation.class);

	// LeetCode 60
	public static void main(String[] args) {
		int n = 4;
		int kthPermutation = 24;
		List<Integer> nums = new ArrayList<>();
		int fact = 1;
		for (int i = 1; i < n; i++) {
			fact *= i;
			nums.add(i);
		}
		nums.add(n);
		String result = getKthPermutation(nums, fact, kthPermutation - 1);
		LOGGER.info("Kth Permutation is {}", result);
	}

	private static String getKthPermutation(List<Integer> nums, int fact, int kthPermutation) {
		String response = "";
		while (true) {
			int numIdx = kthPermutation / fact;
			response = response + nums.get(numIdx);
			nums.remove(numIdx);
			if (nums.size() == 0) break;
			kthPermutation = kthPermutation % fact;
			fact = fact / nums.size();
		}
		return response;
	}

}
