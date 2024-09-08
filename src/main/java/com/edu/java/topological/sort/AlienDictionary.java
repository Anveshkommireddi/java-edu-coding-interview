package com.edu.java.topological.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {

	public static void main(String[] args) {
		//List<String> words = Arrays.asList("xro", "xma", "per", "prt", "oxh", "olv");
		List<String> words = Arrays.asList("ba", "ba", "ba");
		String order = alienOrder(words);
		System.out.println(order);
	}

	public static String alienOrder(List<String> words) {
		StringBuilder sb = new StringBuilder();
		// collect all chars
		Map<Integer, Character> intCharMap = new HashMap<>();
		Map<Character, Integer> charIntMap = new HashMap<>();
		int counter = 0;
		for (String word : words) {
			char[] chars = word.toCharArray();
			for (char charVal : chars) {
				if (!charIntMap.containsKey(charVal)) {
					charIntMap.put(charVal, counter);
					intCharMap.put(counter, charVal);
					counter++;
				}
			}
		}

		int charsSize = charIntMap.keySet().size();
		int[] indegree = new int[charsSize];
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < charsSize; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 1; i < words.size(); i++) {
			String prevWord = words.get(i - 1);
			String currWord = words.get(i);
			if (prevWord.contains(currWord) && prevWord.length() > currWord.length()) {
				return "";
			}
			int prevLength = prevWord.length();
			int currLength = currWord.length();
			for (int idx = 0; idx < Math.min(prevLength, currLength); idx++) {
				char prevChar = prevWord.charAt(idx);
				char currChar = currWord.charAt(idx);
				if (prevChar != currChar) {
					adjList.get(charIntMap.get(prevChar)).add(charIntMap.get(currChar));
					indegree[charIntMap.get(currChar)]++;
					break;
				}
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		List<Integer> topo = new ArrayList<>();
		while (!queue.isEmpty()) {
			int currVertex = queue.poll();
			topo.add(currVertex);
			List<Integer> neighbours = adjList.get(currVertex);
			for (int neighbour : neighbours) {
				indegree[neighbour]--;
				if (indegree[neighbour] == 0) {
					queue.add(neighbour);
				}
			}
		}
		
		if(topo.size() != charsSize) {
			return "";
		}
		
		for(int currVal : topo) {
			sb.append(intCharMap.get(currVal));
		}

		return sb.toString();
	}

}
