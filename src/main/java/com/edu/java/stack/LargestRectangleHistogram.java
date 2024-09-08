package com.edu.java.stack;

import java.util.ArrayDeque;
import java.util.Deque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LargestRectangleHistogram {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LargestRectangleHistogram.class);

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 6, 5, 2, 3 };
		int result = maxArea(arr);
		LOGGER.info("Result is {}", result);
	}

	private static int maxArea(int[] arr) {
		Deque<int[]> stack = new ArrayDeque<>();
		int result = Integer.MIN_VALUE;
		for (int idx = 0; idx < arr.length; idx++) {
			// 0 -- idx 1 -- height
			int newIdx = idx;
			while(!stack.isEmpty() && stack.peek()[1] > arr[idx]) {
				int[] pollVal = stack.poll();
				int width = idx - pollVal[0];
				int height = pollVal[1];
				int area = width * height;
				result = Math.max(result, area);
				newIdx = pollVal[0];
			}
			stack.push(new int[] {newIdx, arr[idx]});
		}
		
		while(!stack.isEmpty()) {
			int[] pollVal = stack.poll();
			int width = arr.length - pollVal[0];
			int height = pollVal[1];
			int area = width * height;
			result = Math.max(result, area);
			
		}
		return result;
	}

}
