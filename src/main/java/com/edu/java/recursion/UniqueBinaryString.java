package com.edu.java.recursion;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniqueBinaryString {

	private static final Logger LOGGER = LoggerFactory.getLogger(UniqueBinaryString.class);

	//find first missing binary number
	public static void main(String[] args) {

		String[] input = { "000", "010", "001", "011", "100", "110", "111" };
		int length = 3;
		int startIdx = 0;
		String currRes = "";
		Set<String> inputHashSet = Arrays.stream(input).distinct().collect(Collectors.toSet());
		String firstDifferentPermutation = findFirstMissingPermuation(inputHashSet, length, startIdx, currRes);
		LOGGER.info("First Identified Non Repeating Permutation is :: {}", firstDifferentPermutation);

	}

	private static String findFirstMissingPermuation(Set<String> inputHashSet, int length, int currIdx,
			String currRes) {

		if (length == currRes.length()) {
			if (!inputHashSet.contains(currRes))
				return currRes;
			return null;
		}

		if (currIdx >= length)
			return null;

		String zeroPermutaion = findFirstMissingPermuation(inputHashSet, length, currIdx + 1, currRes + "0");
		if (null != zeroPermutaion)
			return zeroPermutaion;

		return findFirstMissingPermuation(inputHashSet, length, currIdx + 1, currRes + "1");
	}

}
