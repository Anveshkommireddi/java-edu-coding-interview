package com.edu.java.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReOrganizeString {
	
	public static void main(String args[]) {
        String[] inputs = {
            "programming",
            "hello",
            "fofjjb",
            "abbacdde",
            "aba",
            "awesome",
            "aaab",
            "aab",
        	"aaabc"
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput string: \"" + inputs[i] + "\"");

            String output = reorganizeString(inputs[i]);
            output = (output.length() == 0) ? "''" : output;

            System.out.println("\tReorganized string: \"" + output + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
	
		private static String reorganizeString(String input) {
			StringBuilder sb = new StringBuilder();
			Map<Character, Integer> charFreqMap = new HashMap<>();
			for (int i = 0; i < input.length(); i++) {
				char currChar = input.charAt(i);
				Integer currVal = charFreqMap.getOrDefault(currChar, 0);
				charFreqMap.put(currChar, currVal + 1);
			}
			
			PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
					(e1, e2) -> e2.getValue() - e1.getValue());
			for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
				pq.offer(entry);
			}
			
			Map.Entry<Character, Integer> prev = null;
			
			while (!pq.isEmpty() || null != prev) {
				
				if (prev != null && pq.isEmpty())
					return "";

				Map.Entry<Character, Integer> entry = pq.poll();
				char currChar = entry.getKey();
				int currVal = entry.getValue();
				sb.append(currChar);
				currVal = currVal - 1;

				if (null != prev) {
					pq.offer(prev);
					prev = null;
				}

				if (currVal > 0) {
					entry.setValue(currVal);
					prev = entry;
				}
			}
			return sb.toString();
		}
	

}
