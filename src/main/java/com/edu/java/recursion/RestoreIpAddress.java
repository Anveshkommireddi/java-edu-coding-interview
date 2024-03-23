package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestoreIpAddress {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestoreIpAddress.class);

	public static void main(String[] args) {
		String input = "25525511135";
		Set<String> result = new HashSet<>();
		List<String> curr = new ArrayList<>();
		generateIP(input, 0, curr, result);
		result.parallelStream().forEach(LOGGER::info);
	}

	private static void generateIP(String input, int startIdx, List<String> currSet, Set<String> result) {

		if (currSet.size() == 4 && startIdx == input.length()) {
			String ipAddress = String.join(".", currSet);
			result.add(ipAddress);
			return;
		}

		if (currSet.size() == 4 && startIdx != input.length())
			return;

		if (startIdx >= input.length() || currSet.size() > 4)
			return;
		
		if (startIdx + 1 <= input.length()) {
			String tempResult = input.substring(startIdx, startIdx + 1);
			currSet.add(tempResult);
			generateIP(input, startIdx + 1, currSet, result);
			currSet.remove(currSet.size() - 1);
		}

		if (startIdx + 2 <= input.length() && isValidNumber(input, startIdx, startIdx + 2)) {
			String tempResult = input.substring(startIdx, startIdx + 2);
			currSet.add(tempResult);
			generateIP(input, startIdx + 2, currSet, result);
			currSet.remove(currSet.size() - 1);
		}

		if (startIdx + 3 <= input.length() && isValidNumber(input, startIdx, startIdx + 3)) {
			String tempResult = input.substring(startIdx, startIdx + 3);
			currSet.add(tempResult);
			generateIP(input, startIdx + 3, currSet, result);
			currSet.remove(currSet.size() - 1);
		}

	}

	private static boolean isValidNumber(String input, Integer start, int end) {
		if (input.charAt(start) == '0')
			return false;
		String ipAddress = input.substring(start, end);
		return Integer.parseInt(ipAddress) <= 255;
	}

}
