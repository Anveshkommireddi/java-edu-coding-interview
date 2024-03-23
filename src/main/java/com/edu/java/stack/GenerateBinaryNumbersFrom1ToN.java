package com.edu.java.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class GenerateBinaryNumbersFrom1ToN {

	public static void main(String args[]) {
		String[] output = findBin(10);
		for (int i = 0; i < output.length; i++)
			System.out.print(output[i] + " ");
	}

	private static String[] findBin(int num) {
		String[] nums = new String[num];
		Queue<String> queue = new ArrayDeque<>(num + 1);
		queue.offer("1");
		for (int i = 0; i < nums.length; i++) {
			String currNum = queue.poll();
			nums[i] = currNum;
			String nextNum1 = currNum + "0";
			String nextNum2 = currNum + "1";
			queue.offer(nextNum1);
			queue.offer(nextNum2);
		}
		return nums;
	}

}
