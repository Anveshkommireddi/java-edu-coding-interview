package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinDaysForMBouquets {

	private static final Logger LOGGER = LoggerFactory.getLogger(MinDaysForMBouquets.class);

	public static void main(String[] args) {
		int numOfBouquets = 2;
		int numOfFlowersPerBouquet = 3;
		int[] bloomingFlowers = { 7, 7, 7, 7, 13, 11, 12, 7 };
		int result = minDaysForMBouquets(bloomingFlowers, numOfBouquets, numOfFlowersPerBouquet);
		LOGGER.info("Result is {}", result);
	}

	private static int minDaysForMBouquets(int[] bloomingFlowers, int numOfBouquets, int numOfFlowersPerBouquet) {
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		for (int flower : bloomingFlowers) {
			low = Math.min(low, flower);
			high = Math.max(high, flower);
		}

		int result = Integer.MAX_VALUE;
		while (low < high) {
			int midDays = low + (high - low) / 2;
			if (isPossible(bloomingFlowers, numOfBouquets, numOfFlowersPerBouquet, midDays)) {
				result = Math.min(result, midDays);
				high = midDays - 1;
			} else {
				low = midDays + 1;
			}
		}
		return result;
	}

	private static boolean isPossible(int[] bloomingFlowers, int numOfBouquets, int numOfFlowersPerBouquet,
			int midDays) {
		int currFlowers = 0;
		int currBouquets = 0;
		for (int flower : bloomingFlowers) {
			if (flower <= midDays) {
				currFlowers++;
			} else {
				currFlowers = 0;
			}
			if (currFlowers == 3) {
				currBouquets++;
				currFlowers = 0;
			}
		}
		return currBouquets >= numOfBouquets;
	}

}
