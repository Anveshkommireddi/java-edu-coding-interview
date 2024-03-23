package com.edu.java.strings;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {

	// find all anagrams of p that are present in s
	public static void main(String[] args) {
		String s = "abab";
		String p = "ab";
		List<Integer> result = getIndexesOfAnagrams(s, p);
		System.out.println(result);
	}

	private static List<Integer> getIndexesOfAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (p.length() > s.length())
			return result;
		int[] hash = new int[26];
		int[] windowHash = new int[26];
		for (int i = 0; i < p.length(); i++) {
			int stgtIdx = s.charAt(i) - 'a';
			int ptgtIdx = p.charAt(i) - 'a';
			hash[ptgtIdx]++;
			windowHash[stgtIdx]++;
		}
		for (int i = p.length(); i <= s.length(); i++) {
			if (matches(hash, windowHash)) {
				result.add(i - p.length());
			}
			if (i == s.length())
				break;
			int sremoveIdx = s.charAt(i - p.length()) - 'a';
			int stgtIdx = s.charAt(i) - 'a';
			windowHash[sremoveIdx]--;
			windowHash[stgtIdx]++;
		}
		return result;
	}

	private static boolean matches(int[] hash, int[] windowHash) {
		for (int i = 0; i < 26; i++) {
			if (hash[i] != windowHash[i])
				return false;
		}
		return true;
	}

}
