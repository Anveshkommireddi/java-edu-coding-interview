package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_53_Palindromic_Partitions_II {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_53_Palindromic_Partitions_II.class);

	public static void main(String[] args) {
		String input = "bababcbadcede";
		int count = minPalPartitions(input, 0);
		LOGGER.info("COUNT OF Palindromic Partions {}", count);
	}

	private static int minPalPartitions(String input, int startIdx) {
		if(startIdx == input.length()) return 0;
		int count = 100000007;
		for (int idx = startIdx + 1; idx <= input.length(); idx++) {
			String sub = input.substring(startIdx, idx);
			//initial code :: if (isPalindrome(input, 0, sub.length() - 1)) {
			if (isPalindrome(input, startIdx, idx-startIdx-1)) {
				int tempCount = 1 + minPalPartitions(input, idx);
				count = Math.min(count, tempCount);
			}
		}
		return count;
	}

	private static boolean isPalindrome(String input, int left, int right) {
		while (left < right) {
			if (input.charAt(left) != input.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

}
