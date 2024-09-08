package com.edu.java.sliding.window;

public class SubStringVowelsInOrder {

	public static void main(String[] args) {
		String word = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
		int result = longestBeautifulSubstring(word);
		System.out.println(result);
	}

	public static int longestBeautifulSubstring(String word) {
		char[] letters = word.toCharArray();
		int result = Integer.MIN_VALUE;
		int count = 1;
		int length = 1;
		for (int idx = 1; idx < letters.length; idx++) {
			if (letters[idx - 1] == letters[idx]) {
				length += 1;
			} else if (letters[idx - 1] < letters[idx]) {
				length += 1;
				count += 1;
			} else {
				length = 1;
				count = 1;
			}
			if (count == 5) {
				result = Math.max(result, length);
			}
		}
		return result;
	}

}
