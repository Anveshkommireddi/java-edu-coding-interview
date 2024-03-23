package com.edu.java.arrays;

import java.util.Arrays;
import java.util.List;

public class UglyNumber {

	private static final List<Integer> numsList = Arrays.asList(2, 3, 5);

	public static void main(String[] args) {
		int num = 10;
		boolean isugly = uglyCheck(num);
		System.out.println(isugly);
	}
	
	private static boolean uglyCheck(int num) {
		for (int pIdx = 0; pIdx < numsList.size(); pIdx++) {
			int pnum = numsList.get(pIdx);
			while (num % pnum == 0) {
				num = num / pnum;
			}
		}
		return num == 1;
	}

	private static boolean uglyCheckRec(int num) {
		if(num == 1) return true;
		boolean isUgly = false;
		for (int i = 0; i < numsList.size(); i++) {
			if (num % numsList.get(i) == 0) {
				isUgly = isUgly || uglyCheckRec(num / numsList.get(i));
			}
		}
		return isUgly;
	}

}
