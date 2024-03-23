package com.edu.java.sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RepeatedDNA {

	static Map<Character, Integer> charValMap;

	static {
		charValMap = new HashMap<>();
		charValMap.put('A', 1);
		charValMap.put('C', 2);
		charValMap.put('G', 3);
		charValMap.put('T', 4);
	}

	public static void main(String[] args) {
		// String input = "AAAAACCCCCAAAAACCCCCC";
		String input = "GAGTCACAGTAGTTTCA";
		int k = 3;
		Set<String> result = findRepeatedSequences(input, k);
		System.out.println(result);
	}

	public static Set<String> findRepeatedSequences(String s, int k) {
		Set<String> result = new HashSet<>();
		Map<Integer, String> hashValueMap = new HashMap<>();
		char[] chars = s.toCharArray();
		int hashVal = 0;
		for (int i = 0; i < k; i++) {
			int currHash = (int) Math.pow(2, k - i) * charValMap.get(chars[i]);
			hashVal += currHash;
		}
		hashValueMap.put(hashVal, s.substring(0, k));
		for (int i = k; i < s.length(); i++) {
			hashVal = (hashVal - (int) Math.pow(2, k) * charValMap.get(chars[i - k])) * 2
					+ 2 * charValMap.get(chars[i]);
			if (hashValueMap.containsKey(hashVal)) {
				result.add(hashValueMap.get(hashVal));
			} else {
				hashValueMap.put(hashVal, s.substring(i - k + 1, i + 1));
			}
		}
		return result;
	}

}
