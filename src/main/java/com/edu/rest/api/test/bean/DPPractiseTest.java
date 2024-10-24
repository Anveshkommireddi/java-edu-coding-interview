package com.edu.rest.api.test.bean;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DPPractiseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(DPPractiseTest.class);

	public static void main(String[] args) {
		// String PI = "3141592";
		// String[] numbers = new String[] { "3141", "5", "31", "2", "4159", "9", "42"
		// };
		String PI = "3141592653589793238462643383279";
		String[] numbers = new String[] { "314159265358979323846", "26433", "8", "3279", "314159265",
				"35897932384626433832", "79" };
		int result = minPiNumbers(PI, numbers);
		LOGGER.info("Result is {}", result);
	}

	private static int minPiNumbers(String pi, String[] numbers) {
		Set<String> numsSet = Arrays.stream(numbers).collect(Collectors.toSet());
		Integer[] mem = new Integer[pi.length() + 1];
		return minHelper(pi, numsSet, 0, mem);
	}

	private static int minHelper(String pi, Set<String> numsSet, int startIdx, Integer[] mem) {
		if (startIdx == pi.length()) return 0;
		if(null != mem[startIdx]) return mem[startIdx];
		int result = 1000000007;
		for (int endIdx = startIdx + 1; endIdx <= pi.length(); endIdx++) {
			String piString = pi.substring(startIdx, endIdx);
			if (numsSet.contains(piString)) {
				result = Math.min(1 + minHelper(pi, numsSet, endIdx, mem), result);
			}
		}
		return mem[startIdx] = result;
	}

}
