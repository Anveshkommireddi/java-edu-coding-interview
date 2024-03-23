package com.edu.java.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        String input = "25525511135";
        Set<String> result = new HashSet<>();
        //generateValidIpAddresses(input, 0, 0, "", result);
        List<String> curr = new ArrayList<>();
        generateIP(input, 0, curr, result);
        result.stream().forEach(System.out::println);
    }

    private static void generateValidIpAddresses(String input, Integer currIdx, Integer partition, String curr, Set<String> result) {

        if (partition == 4 || currIdx >= input.length()) {
            if (currIdx == input.length() && partition == 4) {
                result.add(curr.substring(0, curr.length() - 1));
            }
            return;
        }

        generateValidIpAddresses(input, currIdx + 1, partition + 1, curr + input.substring(currIdx, currIdx + 1) + ".", result);

        if (currIdx + 2 <= input.length() && isValidNumber(input, currIdx, currIdx + 2)) {
            generateValidIpAddresses(input, currIdx + 2, partition + 1, curr + input.substring(currIdx, currIdx + 2) + ".", result);
        }

        if (currIdx + 3 <= input.length() && isValidNumber(input, currIdx, currIdx + 3)) {
            generateValidIpAddresses(input, currIdx + 3, partition + 1, curr + input.substring(currIdx, currIdx + 3) + ".", result);
        }
    }

    private static void generateIP(String input, Integer currIdx, List<String> curr, Set<String> result) {

        if (curr.size() >= 4 || currIdx >= input.length()) {
            if (curr.size() == 4 && currIdx == input.length()) {
                String res = String.join(".", curr);
                result.add(res);
            }
            return;
        }

        for (int index = currIdx; index < input.length(); index++) {

            if (currIdx + 1 <= input.length() && isValidNumber(input, currIdx, currIdx + 1)) {
                curr.add(input.substring(currIdx, currIdx + 1));
                generateIP(input, currIdx + 1, curr, result);
                curr.remove(curr.size() - 1);
            }

            if (currIdx + 2 <= input.length() && isValidNumber(input, currIdx, currIdx + 2)) {
                curr.add(input.substring(currIdx, currIdx + 2));
                generateIP(input, currIdx + 2, curr, result);
                curr.remove(curr.size() - 1);
            }

            if (currIdx + 3 <= input.length() && isValidNumber(input, currIdx, currIdx + 3)) {
                curr.add(input.substring(currIdx, currIdx + 3));
                generateIP(input, currIdx + 3, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
	private static void newImpl(String input, int currIdx, List<String> currRes, Set<String> result) {
		if(currRes.size() == 4 || currIdx >= input.length()) {
			 if (currRes.size() == 4 && currIdx == input.length()) {
	                String res = String.join(".", currRes);
	                result.add(res);
	            }
	            return;
		}
		
		for (int idx = currIdx + 1; idx <= currIdx + 3; idx++) {
			if(idx <= input.length() && isValidNumber(input, currIdx, idx)) {
				String temp = input.substring(currIdx, idx);
				currRes.add(temp);
				newImpl(input, idx, currRes, result);
				currRes.remove(currRes.size()-1);
			}
		}
	}

    private static boolean isValidNumber(String input, Integer start, int end) {
        if (input.charAt(start) == '0')
            return false;
        String ipAddress = input.substring(start, end);
        return Integer.parseInt(ipAddress) <= 255;
    }
}
