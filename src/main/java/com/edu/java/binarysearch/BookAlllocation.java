package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookAlllocation {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookAlllocation.class);

	public static void main(String[] args) {
		int[] pages = { 7, 2, 5, 10, 8 };
		int noOfPersons = 2;
		int result = minimizeMaxPages(pages, noOfPersons);
		LOGGER.info("Minimum Max Window Sum with M {} subArrays is :: {}", noOfPersons, result);
	}

	private static int minimizeMaxPages(int[] pages, int noOfPersons) {
		int minPages = Integer.MIN_VALUE;
		int maxPages = 0;
		int result = Integer.MAX_VALUE;
		for (Integer page : pages) {
			maxPages += page;
			minPages = Math.max(minPages, page);
		}
		while (minPages <= maxPages) {
			int mid = minPages + (maxPages - minPages) / 2;
			int noOfStudentsWithMid = countNumberOfStudentsWithMid(pages, mid);
			if (noOfStudentsWithMid > noOfPersons) {
				minPages = mid + 1;
			} else {
				result = Math.min(result, mid);
				maxPages = mid - 1;
			}
		}
		return result;
	}

	private static int countNumberOfStudentsWithMid(int[] pages, int mid) {
		int result = 1;
		int currSum = 0;
		for (int i = 0; i < pages.length; i++) {
			currSum += pages[i];
			if (currSum > mid) {
				result++;
				currSum = pages[i];
			}
		}
		return result;
	}

}
