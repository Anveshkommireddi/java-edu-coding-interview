package com.edu.java.backtracking;

import java.util.HashSet;
import java.util.Set;

public class MaxUniqueStringSplit {

	public static void main(String[] args) {
		String input = "wwwzfvedwfvhsww";
		int result = maxUniqueSplit(input);
		System.out.println(result);
	}

	public static int maxUniqueSplit(String s) {
		Set<String> hash = new HashSet<>();
		Integer[] mem = new Integer[s.length() + 1];
		int resultMem = helperMem(s, 1, hash, mem);
		return resultMem;
	}

	private static int helper(String input, int idx, Set<String> hash) {
		if (idx > input.length())
			return 0;
		int split = 0;
		String temp = input.substring(0, idx);
		if (!hash.contains(temp)) {
			hash.add(temp);
			String newString = input.substring(idx);
			split += 1 + helper(newString, 1, hash);
			hash.remove(temp);
		} 
		int noSplit = helper(input, idx + 1, hash);
		return Math.max(split, noSplit);
	}

	private static int helperMem(String input, int idx, Set<String> hash, Integer[] mem) {
		if (idx > input.length())
			return 0;
		if (null != mem[idx])
			return mem[idx];
		int split = 0;
		String temp = input.substring(0, idx);
		if (!hash.contains(temp)) {
			hash.add(temp);
			String newString = input.substring(idx);
			split += 1 + helperMem(newString, 1, new HashSet<>(), mem);
			hash.remove(temp);
		} 
		int noSplit = helperMem(input, idx + 1, hash, mem);
		return mem[idx] = Math.max(split, noSplit);
	}

}
