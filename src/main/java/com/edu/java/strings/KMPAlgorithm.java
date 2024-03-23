package com.edu.java.strings;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KMPAlgorithm {

	private static final Logger LOGGER = LoggerFactory.getLogger(KMPAlgorithm.class);

	public static void main(String[] args) {
		String pattern = "aefaedaefaefa";
		String word = "aefaefaefaedaefaedaefaefa";
		int[] kmpPattern = buildPattern(pattern);
		LOGGER.info("KMP array is {}", Arrays.toString(kmpPattern));
		boolean result = patternMatching(word, pattern, kmpPattern);
		LOGGER.info("Pattern {} present in the word {} with result {} ", pattern, word, result);
	}

	private static boolean patternMatching(String word, String pattern, int[] kmpPattern) {
		boolean result = false;
		int p = 0;
		int w = 0;
		int wordLength = word.length();
		int patternLength = pattern.length();
		while (w < wordLength) {
			if (word.charAt(w) == pattern.charAt(p)) {
				if (patternLength - 1 == p) {
					return true;
				}
				w++;
				p++;
			} else if (p > 0) {
				p = kmpPattern[p - 1] + 1;
			} else {
				w++;
			}
		}
		return result;
	}

	private static int[] buildPattern(String pattern) {
		int patternLength = pattern.length();
		int[] kmpPattern = new int[patternLength];
		Arrays.fill(kmpPattern, -1);
		int i = 1;
		int j = 0;
		while (i < patternLength) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				kmpPattern[i] = j;
				i++;
				j++;
			} else if (j > 0) {
				j = kmpPattern[j - 1] + 1;
			} else {
				i++;
			}
		}
		return kmpPattern;
	}

}
