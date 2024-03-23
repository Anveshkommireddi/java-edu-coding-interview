package com.edu.java.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

	public static void main(String[] args) {
		String input = "pineapplepenapple";
		Set<String> dictionary = new HashSet<>();
		dictionary.addAll(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
		// output :: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
		List<String> currResult = new ArrayList<>();
		List<String> result = new ArrayList<>();
		wordBreakHelper(input, dictionary, currResult, result);
		System.out.println(result);
	}

	private static void wordBreakHelper(String input, Set<String> dictionary, List<String> currResult, List<String> result) {
		
		if(null == input || input.length() == 0) {
			result.add(String.join(" ", currResult));
			return;
		}
		
		for(int length = 1; length <= input.length(); length++) {
			String newString = input.substring(0, length);
			if(dictionary.contains(newString)) {
				currResult.add(newString);
				String remString = input.substring(length);
				wordBreakHelper(remString, dictionary, currResult, result);
				currResult.remove(currResult.size()-1);
			}
		}
	}
}
