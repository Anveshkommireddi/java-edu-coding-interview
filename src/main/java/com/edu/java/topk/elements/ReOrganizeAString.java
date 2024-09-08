package com.edu.java.topk.elements;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class ReOrganizeAString {

	public static void main(String[] args) {
		String input = "aaabc";
		// String input = "jjjj";
		String result = reorganizeString(input);
		System.out.println(result);
	}

	public static String reorganizeString(String input) {
		Map<Character, Integer> charFreqMap = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			char currChar = input.charAt(i);
			charFreqMap.put(currChar, charFreqMap.getOrDefault(currChar, 0) + 1);
		}
		PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
		for (Entry<Character, Integer> entry : charFreqMap.entrySet()) {
			pq.offer(entry);
		}
		char prev = '*';
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Entry<Character, Integer> entry = pq.poll();
			Character currChar = entry.getKey();
			int freq = entry.getValue();
			if (currChar != prev) {
				prev = currChar;
				sb.append(currChar);
				if (freq - 1 == 0) {
					charFreqMap.remove(currChar);
				} else {
					entry.setValue(freq - 1);
					pq.add(entry);
				}
			} else {
				if (pq.isEmpty()) {
					return "";
				} else {
					Entry<Character, Integer> entry2 = pq.poll();
					Character currChar2 = entry2.getKey();
					prev = currChar2;
					int freq2 = entry2.getValue();
					sb.append(currChar2);
					if (freq2 - 1 == 0) {
						charFreqMap.remove(currChar2);
					} else {
						entry2.setValue(freq2 - 1);
						pq.add(entry2);
					}
					pq.add(entry);
				}
			}
		}
		return sb.toString();
	}

}
