package com.edu.lc.test;

public class HappyNumberTest {

	public static void main(String[] args) {
		int num = 4;
		boolean isHappy = checkHappiness(num);
		System.out.println(num + " is Happy ? " + isHappy);
	}

	private static boolean checkHappiness(int num) {
		int sp = num;
		int fp = num;
		do {
			sp = calculate(sp);
			fp = calculate(calculate(fp));
			System.out.println("SP is :: " + sp + " FP is :: " + fp);
		} while (sp != fp);
		return sp == 1;
	}

	private static int calculate(int num) {
		int res = 0;
		while (num > 0) {
			int rem = num % 10;
			num = num / 10;
			res += (rem * rem);
		}
		return res;
	}

}
