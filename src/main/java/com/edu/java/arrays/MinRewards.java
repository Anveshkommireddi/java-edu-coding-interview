package com.edu.java.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinRewards {

	private static final Logger LOGGER = LoggerFactory.getLogger(MinRewards.class);

	public static void main(String[] args) {
		int[] scores = new int[] { 8, 4, 2, 1, 3, 6, 7, 9, 5 };
		int minRewards = minRewards(scores);
		LOGGER.info("Min Rewards are {}", minRewards);
	}

	private static int minRewards(int[] scores) {
		return 0;
	}

}
