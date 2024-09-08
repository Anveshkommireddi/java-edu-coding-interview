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
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> hashWordsInfo = new HashMap<>();
		for (String word : strs) {
			int[] freq = new int[26];
			for (int i = 0; i < word.length(); i++) {
				char currChar = word.charAt(i);
				int currIdx = currChar - 'a';
				freq[currIdx]++;
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 26; i++) {
				sb.append("#");
				sb.append(freq[i]);
			}
			String hash = sb.toString();
			List<String> anagrams = hashWordsInfo.getOrDefault(hash, new ArrayList<>());
			anagrams.add(word);
			hashWordsInfo.put(hash, anagrams);
		}
		result.addAll(hashWordsInfo.values());
		return result;
	}

	private static List<List<String>> groupAnagramsOld(String[] input) {
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
