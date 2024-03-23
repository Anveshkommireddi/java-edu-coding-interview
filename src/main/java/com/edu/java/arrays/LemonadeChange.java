package com.edu.java.arrays;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LemonadeChange {

	private static final Logger LOGGER = LoggerFactory.getLogger(LemonadeChange.class);

	public static void main(String[] args) {
		int[] arr = { 5, 5, 5, 20, 5, 10, 10, 5 };
		boolean result = lemonadeChange(arr);
		LOGGER.info("Result is {}", result);
	}

	private static boolean lemonadeChange(int bills[]) {
		Map<Integer, Integer> changeMap = new HashMap<>();
		changeMap.put(5, 0);
		changeMap.put(10, 0);
		changeMap.put(20, 0);
		boolean result = true;
		for (int bill : bills) {
			int changeToGive = bill - 5;
			changeMap.put(bill, changeMap.get(bill) + 1);
			int numOf20s = changeToGive / 20;
			if (numOf20s > 0 && changeMap.get(20) >= numOf20s) {
				changeMap.put(20, changeMap.get(20) - numOf20s);
				changeToGive = changeToGive % 20;
			}

			int numOf10s = changeToGive / 10;
			if (numOf10s > 0 && changeMap.get(10) >= numOf10s) {
				changeMap.put(10, changeMap.get(10) - numOf10s);
				changeToGive = changeToGive % 10;
			}

			int numOf5s = changeToGive / 5;
			if (numOf5s > 0 && changeMap.get(5) >= numOf5s) {
				changeMap.put(5, changeMap.get(5) - numOf5s);
				changeToGive = changeToGive % 5;
			}

			if (changeToGive != 0)
				return false;
		}
		return result;
	}

}
