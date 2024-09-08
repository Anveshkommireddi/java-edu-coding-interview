package com.edu.java.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class FindMaxKnapsackProfit {

	public static void main(String[] args) {
//		String input = "catsanddog";
//		List<String> words = Arrays.asList("cat", "and", "cats", "sand", "dog");
//		String input = "aaaaaaa";
//		List<String> words = Arrays.asList("aaaa", "aaa");
//		boolean isPresent = wordBreak(input, words);
//		System.out.println(isPresent);
//		List<String> result = wordBreak2(input, words);
		// System.out.println(result);
//		int[] money = {2, 10, 14, 8, 1};
//		int result = houseRobber(money);
//		System.out.println(result);
//		int[] nums = { 2, 3, -2, 4 };
//		int maxP = maxProduct(nums);
//		System.out.println(maxP);
		List<String> words = Arrays.asList("hog", "dot", "pot", "pop", "mop", "map", "cap", "cat");
		String src = "dog";
		String dest = "cat";
		int result = wordLadder(src, dest, words);
		System.out.println(result);
	}

	public static int maxProduct(int[] nums) {
		int cmax = nums[0];
		int cmin = nums[0];
		int fmax = Integer.MIN_VALUE;
		for (int idx = 1; idx < nums.length; idx++) {
			int num = nums[idx];
			if (num == 0) {
				cmax = 1;
				cmin = 1;
				continue;
			}
			int copyCmax = cmax;
			cmax = Math.max(num, Math.max(num * cmax, num * cmin));
			cmin = Math.min(num, Math.min(num * copyCmax, num * cmin));
			fmax = Math.max(fmax, Math.max(cmax, cmin));
		}
		return fmax;
	}

	public static int houseRobber(int[] money) {
		Integer[] mem1 = new Integer[money.length];
		Integer[] mem2 = new Integer[money.length];
		return Math.max(houseRobberHelper(money, 0, money.length - 2, mem1),
				houseRobberHelper(money, 1, money.length - 1, mem2));
	}

	private static int houseRobberHelper(int[] money, int idx, int maxIdx, Integer[] mem) {
		if (idx > maxIdx)
			return 0;
		if (null != mem[idx]) {
			return mem[idx];
		}
		int dontPick = houseRobberHelper(money, idx + 1, maxIdx, mem);
		int pick = money[idx] + houseRobberHelper(money, idx + 2, maxIdx, mem);
		return mem[idx] = Math.max(pick, dontPick);
	}

	private static List<String> wordBreak2(String input, List<String> words) {
		List<String> result = new ArrayList<>();
		List<String> currSet = new ArrayList<>();
		wordBreak2Helper(input, words, 0, currSet, result);
		return result;
	}

	private static void wordBreak2Helper(String input, List<String> words, int startIdx, List<String> currSet,
			List<String> result) {
		if (startIdx >= input.length()) {
			result.add(String.join(" ", currSet));
			return;
		}
		for (int endIdx = startIdx + 1; endIdx <= input.length(); endIdx++) {
			String subString = input.substring(startIdx, endIdx);
			if (words.contains(subString)) {
				currSet.add(subString);
				wordBreak2Helper(input, words, endIdx, currSet, result);
				currSet.remove(currSet.size() - 1);
			}
		}
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		Boolean[] mem = new Boolean[s.length() + 1];
		return wbHelper(s, 0, wordDict, mem);
	}

	private static boolean wbHelper(String input, int startIdx, List<String> wordDict, Boolean[] mem) {
		if (startIdx >= input.length()) {
			return true;
		}
		if (null != mem[startIdx]) {
			return mem[startIdx];
		}
		for (int idx = startIdx + 1; idx <= input.length(); idx++) {
			String subString = input.substring(startIdx, idx);
			if (wordDict.contains(subString) && wbHelper(input, idx, wordDict, mem)) {
				return mem[startIdx] = true;
			}
		}
		return mem[startIdx] = false;
	}
	
	public static int wordLadder(String src, String dest, List<String> words) {
		Set<String> wordsSet = new HashSet<>(words);
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(src, 0));
		int result = Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			Node currNode = queue.poll();
			result = Math.max(result, currNode.level);
			collectWordsWithSingleCharDiff(wordsSet, currNode, queue);
		}
		return result;
	}

	private static void collectWordsWithSingleCharDiff(Set<String> wordsSet, Node currNode, Queue<Node> queue) {
		String currWord = currNode.word;
		int currLevel = currNode.level;
		Set<String> newWords = new HashSet<>();
		for (String word : wordsSet) {
			if (singleCharDiff(word, currWord)) {
				newWords.add(word);
			}
		}
		wordsSet.removeAll(newWords);
		for (String newWord : newWords) {
			Node newNode = new Node(newWord, currLevel + 1);
			queue.add(newNode);
		}
	}

	private static boolean singleCharDiff(String word, String currWord) {
		Map<Character, Integer> currWordMap = new TreeMap<>();
		for (int i = 0; i < currWord.length(); i++) {
			char currChar = currWord.charAt(i);
			currWordMap.put(currChar, currWordMap.getOrDefault(currChar, 0) + 1);
		}
		Map<Character, Integer> wordMap = new TreeMap<>();
		for (int i = 0; i < word.length(); i++) {
			char currChar = word.charAt(i);
			wordMap.put(currChar, wordMap.getOrDefault(currChar, 0) + 1);
		}
		int diffCount = 0;
		for (Map.Entry<Character, Integer> entry : currWordMap.entrySet()) {
			Character currChar = entry.getKey();
			Integer currWordMapValue = entry.getValue();
			Integer wordMapValue = wordMap.getOrDefault(currChar, 0);
			diffCount += Math.abs(wordMapValue - currWordMapValue);
			if (diffCount > 1) {
				return false;
			}
		}
		return true;
	}
}

class Node {
	
	String word;
	
	int level;
	
	public Node(String word, int level) {
		this.word = word;
		this.level = level;
	}
}
