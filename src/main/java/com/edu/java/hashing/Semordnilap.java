package com.edu.java.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Semordnilap {

	// palindromes -- reverse -- semordnilap
	public static void main(String[] args) {
		String[] words = { "dog", "desserts", "god", "stressed" };
		List<List<String>> result = semordnilap(words);
		System.out.println(result);
	}

	private static List<List<String>> semordnilap(String[] words) {
		List<List<String>> result = new ArrayList<>();
		// collect words in a set to identify at constant time
		Set<String> wordsStore = new HashSet<>();
		for (String word : words) {
			wordsStore.add(word);
		}

		for (String word : words) {
			String reverseWord = new StringBuilder(word).reverse().toString();
			if (!word.equals(reverseWord) && wordsStore.contains(reverseWord)) {
				List<String> semordnilapPair = new ArrayList<>();
				semordnilapPair.add(word);
				semordnilapPair.add(reverseWord);
				result.add(semordnilapPair);

				wordsStore.remove(word);
				wordsStore.remove(reverseWord);
			}
		}
		return result;
	}

}
