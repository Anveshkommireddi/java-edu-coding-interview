package com.edu.java.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {

	public static void main(String[] args) {
		String str1 = "AAAAAAAAAAA";
		String str2 = "A";
		String result = minWindow(str1, str2);
		System.out.println(result);
	}

	public static String minWindow(String s1, String s2) {
		Map<Character, Integer> s2CharFreqMap = new HashMap<>();
		for (int i = 0; i < s2.length(); i++) {
			int currVal = s2CharFreqMap.getOrDefault(s2.charAt(i), 0);
			s2CharFreqMap.put(s2.charAt(i), currVal + 1);
		}

		Map<Character, Integer> s1CharFreqMap = new HashMap<>();
		String result = "";
		int length = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		while (end < s1.length()) {
			if(start > end) {
				end = start;
				continue;
			}
			int currVal = s1CharFreqMap.getOrDefault(s1.charAt(end), 0);
			s1CharFreqMap.put(s1.charAt(end), currVal + 1);
			boolean isValid = validateMap(s1CharFreqMap, s2CharFreqMap);
			if (isValid) {
				if (end - start + 1 < length) {
					result = s1.substring(start, end + 1);
					length = end - start + 1;
				}
				s1CharFreqMap.put(s1.charAt(start), s1CharFreqMap.get(s1.charAt(start)) - 1);
				s1CharFreqMap.put(s1.charAt(end), currVal);
				start++;
				end--;
			}
			end++;
		}

		return result;
	}

	private static boolean validateMap(Map<Character, Integer> s1CharFreqMap, Map<Character, Integer> s2CharFreqMap) {
		for(Map.Entry<Character, Integer> entry : s2CharFreqMap.entrySet()) {
			Character s2Key = entry.getKey();
			Integer s2Val = entry.getValue();
			Integer s1Val = s1CharFreqMap.getOrDefault(s2Key, 0);
			if(s1Val < s2Val) return false;
		}
		return true;
	}

}
