package com.edu.java.dp;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Algo_Exp_NumbersOfPI {

	private static final Logger LOGGER = LoggerFactory.getLogger(Algo_Exp_NumbersOfPI.class);

	public static void main(String[] args) {
		//String PI = "3141592";
		//String[] numbers = new String[] { "3141", "5", "31", "2", "4159", "9", "42" };
		 String PI = "3141592653589793238462643383279";
			String[] numbers = new String[] { "314159265358979323846", "26433", "8", "3279", "314159265",
					"35897932384626433832", "79" };
		int result = numbersInPi(PI, numbers);
		LOGGER.info("Result is {}", result);
	}

	public static int numbersInPi(String pi, String[] numbers) {
		Set<String> nums = Arrays.asList(numbers).stream().collect(Collectors.toSet());
		int[] mem = new int[pi.length() + 1];
		Arrays.fill(mem, -1);
		int count = numsOfPiHelper(pi, nums, 0);
		//int count = numsOfPiHelperMem(pi, nums, 0, mem);
		return count == 1000000007 ? -1 : count-1;
	}
	
	private static int numsOfPiHelperMem(String pi, Set<String> nums, int startIdx, int[] mem) {
		if(startIdx == pi.length()) return 0;
		if(mem[startIdx] != -1) return mem[startIdx];
		int count = 1000000007;
		for(int idx = startIdx + 1; idx <= pi.length(); idx++) {
			String sub = pi.substring(startIdx, idx);
			if(nums.contains(sub)) {
				count = Math.min(1 + numsOfPiHelperMem(pi, nums, idx, mem), count);
			}
		}
		return mem[startIdx] = count;
	}

	private static int numsOfPiHelper(String pi, Set<String> nums, int startIdx) {
		if (startIdx == pi.length()) return 0;
		int count = 1000000007;
		for (int idx = startIdx + 1; idx <= pi.length(); idx++) {
			String sub = pi.substring(startIdx, idx);
			if (nums.contains(sub)) {
				count = Math.min(1 + numsOfPiHelper(pi, nums, idx), count);
			}
		}
		return count;
	}
}
