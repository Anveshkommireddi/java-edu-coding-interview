package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_03_FrogJumpWithKDistance {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_03_FrogJumpWithKDistance.class);

	public static void main(String[] args) {
		int[] energy = { 10, 20, 30, 10 };
		int k = 2;
		Integer[] mem = new Integer[energy.length];
		int minEnergy = minEnergyFrogJumpWithKJumpsMem(energy, energy.length - 1, k, mem);
		LOGGER.info("MINIMUM ENERGY CONSUMED TO REACH END IS ::: {}", minEnergy);
	}

	private static int minEnergyFrogJumpWithKJumps(int[] energy, int currIdx, int k) {
		if (currIdx <= 0) return 0;
		int minVal = Integer.MAX_VALUE;
		for (int jump = 1; jump <= k; jump++) {
			if (currIdx >= jump) {
				int currVal = minEnergyFrogJumpWithKJumps(energy, currIdx - jump, k) + Math.abs(energy[currIdx] - energy[currIdx - jump]);
				minVal = Math.min(minVal, currVal);
			}
		}
		return minVal;
	}
	
	private static int minEnergyFrogJumpWithKJumpsMem(int[] energy, int currStepIdx, int maxSteps, Integer[] mem) {
		if (currStepIdx <= 0)
			return 0;
		if (mem[currStepIdx] != null)
			return mem[currStepIdx];
		int minVal = Integer.MAX_VALUE;
		for (int step = 1; step <= maxSteps; step++) {
			if (currStepIdx >= step) {
				int currVal = minEnergyFrogJumpWithKJumpsMem(energy, currStepIdx - step, maxSteps, mem)
						+ Math.abs(energy[currStepIdx] - energy[currStepIdx - step]);
				minVal = Math.min(minVal, currVal);
			}
		}
		return mem[currStepIdx] = minVal;
	}

}
