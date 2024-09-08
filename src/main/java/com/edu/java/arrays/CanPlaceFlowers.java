package com.edu.java.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CanPlaceFlowers {

	private static final Logger LOGGER = LoggerFactory.getLogger(CanPlaceFlowers.class);

	public static void main(String[] args) {
		int[] flowerbed = { 1, 0, 0, 0, 1, 0, 0 };
		int n = 2;
		boolean result = canPlaceFlowers(flowerbed, n);
		LOGGER.info("Result is {}", result);
	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		for (int i = 0; i < flowerbed.length; i++) {
			if (n == 0)
				return true;
			int prev = i > 0 ? flowerbed[i - 1] : 0;
			int curr = flowerbed[i];
			int next = i >= flowerbed.length - 1 ? 0 : flowerbed[i + 1];
			if (curr == 0 && prev == 0 && next == 0) {
				n--;
				flowerbed[i] = 1;
			}
		}
		return n <= 0;
	}

}
