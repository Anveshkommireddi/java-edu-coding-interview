package com.edu.lc.test;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidPalindrome2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidPalindrome2.class);

	public static void main(String[] args) {
		int[] bill = { 5, 10, 5, 5, 10, 20 };
		boolean result = lemonadeChange(bill);
		LOGGER.info("asteroid Collision is {}", result);
	}

	public static boolean lemonadeChange(int[] bills) {
		Map<Integer, Integer> changeInfo = new HashMap<>();
		changeInfo.put(5, 0);
		changeInfo.put(10, 0);
		changeInfo.put(20, 0);

		for (int bill : bills) {
			int change = bill - 5;
			boolean isChangePossible = isChangePossible(changeInfo, change);
			if (isChangePossible == false)
				return false;
			changeInfo.put(bill, changeInfo.get(bill) + 1);
		}
		return true;
	}

	private static boolean isChangePossible(Map<Integer, Integer> changeInfo, int change) {
		boolean result = false;
		if (change == 5 && changeInfo.get(5) >= 1) {
			changeInfo.put(5, changeInfo.get(5) - 1);
			result = true;
		} else if (change == 15 && changeInfo.get(10) >= 1 && changeInfo.get(5) >= 1) {
			changeInfo.put(10, changeInfo.get(10) - 1);
			changeInfo.put(5, changeInfo.get(5) - 1);
			result = true;
		} else if (change == 15 && changeInfo.get(5) >= 3) {
			changeInfo.put(5, changeInfo.get(5) - 3);
			result = true;
		} else if(change == 0) {
			result = true;
		}
		return result;
	}

}
