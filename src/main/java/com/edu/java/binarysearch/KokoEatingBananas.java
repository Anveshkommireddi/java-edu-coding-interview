package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KokoEatingBananas {

	private static final Logger LOGGER = LoggerFactory.getLogger(KokoEatingBananas.class);

	public static void main(String[] args) {
		int[] piles = { 3, 6, 7, 11 };
		int hours = 8;
		int result = minTimeToEatAllPiles(piles, hours);
		LOGGER.info("Result is {}", result);
	}

	private static int minTimeToEatAllPiles(int[] piles, int hours) {
		int low = 1;
		int high = Integer.MIN_VALUE;
		for (int pile : piles) {
			high = Math.max(pile, high);
		}

		int result = Integer.MAX_VALUE;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (isPossible(piles, mid, hours)) {
				result = Math.min(result, mid);
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}

	private static boolean isPossible(int[] piles, int bananasPerHour, int targetTime) {
		int currTime = 0;
		for (int pile : piles) {
			double val = pile / (bananasPerHour * 1.0);
			currTime += Math.ceil(val);
		}
		return currTime <= targetTime;
	}

}
