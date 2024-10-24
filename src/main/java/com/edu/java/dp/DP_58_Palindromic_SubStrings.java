package com.edu.java.dp;

public class DP_58_Palindromic_SubStrings {

	public static void main(String[] args) {
		String text = "abc";
		int result = countPalindromes(text);
		System.out.println(result);
	}

	private static int countPalindromes(String input) {
		int result = 0;
		for (int idx = 0; idx < input.length(); idx++) {

			// even length
			int even = countPals(input, idx - 1, idx);
			result += even;

			// odd length
			int odd = countPals(input, idx, idx);
			result += odd;
		}
		return result;
	}

	private static int countPals(String input, int left, int right) {
		int result = 0;
		while (left >= 0 && right < input.length()) {
			char leftChar = input.charAt(left);
			char rightChar = input.charAt(right);
			if (leftChar != rightChar) {
				return result;
			}
			result++;
			left--;
			right++;
		}
		return result;
	}

}
