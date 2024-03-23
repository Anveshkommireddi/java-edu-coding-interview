package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_06_HouseRobber2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_06_HouseRobber2.class);

	public static void main(String[] args) {
		int[] houseVals = { 1, 5, 1, 2, 6 };
		long result = houseRobber(houseVals);
		LOGGER.info("Result is :: {}", result);
	}

	public static long houseRobber(int[] valueInHouse) {
		if (valueInHouse.length == 1) return (long) valueInHouse[0];
		int[] arr1 = copyArrayFromRange(valueInHouse, 0, valueInHouse.length - 2);
		int[] arr2 = copyArrayFromRange(valueInHouse, 1, valueInHouse.length - 1);
		long result1 = houseRobberHelper(arr1);
		long result2 = houseRobberHelper(arr2);
		return Math.max(result1, result2);
	}

	private static long houseRobberHelper(int[] val) {
		Long[] mem = new Long[val.length];
		mem[0] = (long) val[0];
		for (int currIdx = 1; currIdx < val.length; currIdx++) {
			long dontPick = mem[currIdx - 1];
			long pick = (long) val[currIdx];
			pick += currIdx - 2 >= 0 ? mem[currIdx - 2] : 0;
			mem[currIdx] = Math.max(pick, dontPick);
		}
		return mem[mem.length - 1];
	}
	
	//memoized solution
	public static int houseRobberHelperWithMem(int[] val, int currIdx, Integer[] mem) {
		if (currIdx == 0)
			return val[currIdx];
		if (currIdx < 0)
			return 0;
		if (null != mem[currIdx])
			return mem[currIdx];
		int pick = val[currIdx] + houseRobberHelperWithMem(val, currIdx - 2, mem);
		int dontPick = houseRobberHelperWithMem(val, currIdx - 1, mem);
		return mem[currIdx] = Math.max(pick, dontPick);
	}
	
	private static int[] copyArrayFromRange(int[] arr, int from, int to) {
		int[] result = new int[to - from + 1];
		int startIdx = 0;
		for (int idx = from; idx <= to; idx++) {
			result[startIdx++] = arr[idx];
		}
		return result;
	}

}
