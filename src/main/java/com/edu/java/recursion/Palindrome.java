package com.edu.java.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Palindrome {

	private static final Logger LOGGER = LoggerFactory.getLogger(Palindrome.class);

	public static void main(String[] args) {
		String input = "anvna";
		boolean isPalindrome = checkPalindrome(input, 0, input.length() - 1);
		LOGGER.info("{} is {}", input, isPalindrome ? "a palindrome" : "not a palindrome");
	}

	private static boolean checkPalindrome(String input, int start, int end) {
		if (start > end)
			return true;
		boolean isValid = input.charAt(start) == input.charAt(end);
		if (isValid == false)
			return isValid;
		return checkPalindrome(input, start + 1, end - 1);
	}

	public static boolean checkPalindrome(String input) {
		int start = 0;
		int end = input.length() - 1;
		while (start < end) {
			int startChar = input.charAt(start);
			int endChar = input.charAt(end);
			if (startChar != endChar)
				return false;
			start++;
			end--;
		}
		return true;
	}
}
