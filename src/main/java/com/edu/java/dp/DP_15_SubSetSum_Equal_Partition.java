package com.edu.java.dp;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_15_SubSetSum_Equal_Partition {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_15_SubSetSum_Equal_Partition.class);
	
	public static void main(String[] args) {
		int[] arr = {3, 1, 1, 2, 2, 1};
		boolean isPossible = subSetSumEqualPartition(arr);
		LOGGER.info("Is Equal Partition Possible {}", isPossible);
	}
	
	private static boolean subSetSumEqualPartition(int[] arr) {
		int sum = Arrays.stream(arr).sum();
		boolean isPossible = sum % 2 == 0;
		if (isPossible == false) return false;
		int target = sum / 2;
		Boolean[][] mem = new Boolean[arr.length][target + 1];
		//boolean result = isPartitionPossible(arr, arr.length - 1, target, mem);
		boolean result = isPartitionPossibleBottomsUp(arr, target);
		return result;
	}
	
	private static boolean isPartitionPossibleBottomsUp(int[] arr, int target) {
		boolean[][] mem = new boolean[arr.length + 1][target + 1];
		// for first row with no elements mark false
		for (int colIdx = 0; colIdx < mem[0].length; colIdx++) {
			mem[0][colIdx] = false;
		}
		// for first col with 0 sum mark true
		for (int rowIdx = 0; rowIdx < mem.length; rowIdx++) {
			mem[rowIdx][0] = true;
		}
		
		for (int currIdx = 1; currIdx < mem.length; currIdx++) {
			for (int sum = 1; sum < mem[0].length; sum++) {
				boolean dontPick = mem[currIdx - 1][sum];
				boolean pick = false;
				if (sum - arr[currIdx - 1] >= 0) {
					pick = mem[currIdx - 1][sum - arr[currIdx - 1]];
				}
				mem[currIdx][sum] = pick || dontPick;
			}
		}
		
		return mem[arr.length][target];
	}

	private static boolean isPartitionPossible(int[] arr, int currIdx, int target, Boolean[][] mem) {
		if(target < 0 || currIdx < 0) return false;
		if(target == 0) return true;
		if(currIdx == 0) return arr[currIdx] == target;
		if(null != mem[currIdx][target]) return mem[currIdx][target];
		boolean dontPick = isPartitionPossible(arr, currIdx - 1, target, mem);
		boolean pick = false;
		if (target - arr[currIdx] >= 0) {
			pick = isPartitionPossible(arr, currIdx - 1, target - arr[currIdx], mem);
		}
		return mem[currIdx][target] = pick || dontPick;
	}
}
