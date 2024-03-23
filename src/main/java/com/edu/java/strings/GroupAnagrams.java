package com.edu.java.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupAnagrams {

	private static final Logger LOGGER = LoggerFactory.getLogger(GroupAnagrams.class);

	public static void main(String[] args) {
		String[] strs = { "eatt", "ttea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = groupAnagrams(strs);
		LOGGER.info("Result is :: {}", result);
	}

	private static List<List<String>> groupAnagrams(String[] input) {
		Map<String, List<String>> hashAnagramsMap = new HashMap<>();
		for (String word : input) {
			char[] hash = new char[26];
			char[] wordArray = word.toCharArray();
			for (int i = 0; i < wordArray.length; i++) {
				int targetIdx = wordArray[i] - 'a';
				hash[targetIdx] = (char) (hash[targetIdx] + 1);
			}
			String hashedString = new String(hash);
			List<String> anagramsLst = hashAnagramsMap.getOrDefault(hashedString, new ArrayList<>());
			anagramsLst.add(word);
			hashAnagramsMap.put(hashedString, anagramsLst);
		}
		List<List<String>> res = new ArrayList<>();
		res.addAll(hashAnagramsMap.values());
		return res;
	}
}
