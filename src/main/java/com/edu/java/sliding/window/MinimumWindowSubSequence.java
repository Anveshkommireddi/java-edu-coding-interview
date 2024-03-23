package com.edu.java.sliding.window;

public class MinimumWindowSubSequence {

	public static void main(String[] args) {
		String str1 = "alpha";
		String str2 = "la";
		String minWindow = minWindow(str1, str2);
		System.out.println(minWindow);
	}

	public static String minWindow(String str1, String str2) {
		int s1Length = str1.length();
		int s2Length = str2.length();
		int start = 0;
		int end = 0;
		int s1Idx = 0;
		int s2Idx = 0;
		int length = Integer.MAX_VALUE;
		String result = "";
		while (s1Idx < s1Length) {
			// track s2 elements
			if (str1.charAt(s1Idx) == str2.charAt(s2Idx)) {

				s2Idx++;
				// if all elements are found backtrack
				if (s2Idx == s2Length) {

					start = s1Idx;
					end = s1Idx;
					s2Idx--;

					while (s2Idx >= 0) {
						if (str1.charAt(start) == str2.charAt(s2Idx)) {
							s2Idx--;
						}
						start--;
					}
					start++;
					// calculate new length
					if (end - start + 1 < length) {
						length = end - start + 1;
						result = str1.substring(start, end + 1);
					}

					s1Idx = start;
					s2Idx = 0;
				}
			}
			s1Idx++;
		}
		return result;
	}

}
