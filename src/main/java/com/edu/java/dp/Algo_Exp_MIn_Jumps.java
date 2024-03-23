package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Algo_Exp_MIn_Jumps {

	private static final int MOD = Double.valueOf(Math.pow(10, 9) + 7).intValue();
	private static final Logger LOGGER = LoggerFactory.getLogger(Algo_Exp_MIn_Jumps.class);

	public static void main(String[] args) {
		int[] arr = { 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3 };
		Integer[] mem = new Integer[arr.length];
		int minJumps = minJumps(arr, 0, mem);
		LOGGER.info("Minimum Number of Jumps are {}", minJumps);
	}

	private static int minJumps(int[] arr, int currIdx, Integer[] mem) {
		if (currIdx >= arr.length - 1)
			return 0;
		if (null != mem[currIdx])
			return mem[currIdx];
		int result = MOD;
		int startIdx = currIdx + 1;
		int endIdx = currIdx + arr[currIdx];
		for (int jumpIdx = startIdx; jumpIdx <= endIdx; jumpIdx++) {
			result = Math.min(1 + minJumps(arr, jumpIdx, mem), result);
		}
		return mem[currIdx] = result;
	}

}
