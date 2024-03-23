package com.edu.java.binarysearch;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BooksAllocationTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BooksAllocationTest.class);

	public static void main(String[] args) {
		List<Integer> books = Arrays.asList(25, 46, 28, 49, 24);
		int result = findPages(books, books.size(), 4);
		LOGGER.info("Result is {}", result);
	}

	public static int findPages(List<Integer> arr, int n, int m) {
		int low = Integer.MIN_VALUE;
		int high = 0;
		for (Integer val : arr) {
			low = Math.max(low, val);
			high += val;
		}
		int ans = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isPossible(arr, m, mid)) {
				low = mid + 1;
			} else {
				ans = Math.min(ans, mid);
				high = mid - 1;
			}
		}
		return ans;
	}

	private static boolean isPossible(List<Integer> books, int minStudents, int maxPages) {
		int currStudents = 1;
		int currPages = 0;
		for (int i = 0; i < books.size(); i++) {
			currPages += books.get(i);
			if (currPages > maxPages) {
				currStudents++;
				currPages = books.get(i);
			}
		}
		return currStudents > minStudents;
	}

}
