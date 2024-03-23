package com.edu.java.dp;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_02_FrogJump {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_02_FrogJump.class);

	public static void main(String[] args) {
		int[] energy = { 10, 20, 30, 10 };
		int[] mem = new int[energy.length];
		Arrays.fill(mem, -1);
		int minEnergy = minEnergyFrogJump(energy, energy.length - 1, mem);
		LOGGER.info("MINIMUM ENERGY CONSUMED TO REACH END IS ::: {}", minEnergy);
		int newMinEnergy = frogJumpOpt(energy);
		LOGGER.info("New MINIMUM ENERGY CONSUMED TO REACH END IS ::: {}", newMinEnergy);
	}

	private static int minEnergyFrogJump(int[] energy, int currIdx, int[] mem) {
		if (currIdx <= 0) return 0;
		if (mem[currIdx] != -1) return mem[currIdx];
		int minEnergyByOneStep = minEnergyFrogJump(energy, currIdx - 1, mem) + Math.abs(energy[currIdx] - energy[currIdx - 1]);
		int minEnergyBytwoStep = Integer.MAX_VALUE;
		if (currIdx - 2 >= 0) {
			minEnergyBytwoStep = minEnergyFrogJump(energy, currIdx - 2, mem) + Math.abs(energy[currIdx] - energy[currIdx - 2]);
		}
		return mem[currIdx] = Math.min(minEnergyByOneStep, minEnergyBytwoStep);
	}
	
	private static int frogJumpOpt(int[] energy) {
		int[] result = new int[energy.length];
		result[0] = 0;
		result[1] = Math.abs(energy[1] - energy[0]);
		for (int i = 2; i < result.length; i++) {
			int minEnergyByOneStep = result[i - 1] + Math.abs(energy[i] - energy[i - 1]);
			int minEnergyBytwoStep = result[i - 2] + Math.abs(energy[i] - energy[i - 2]);
			result[i] = Math.min(minEnergyByOneStep, minEnergyBytwoStep);
		}
		return result[result.length - 1];
	}

}
