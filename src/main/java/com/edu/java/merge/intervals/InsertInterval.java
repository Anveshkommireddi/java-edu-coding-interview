package com.edu.java.merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// inputs are sorted by start time
		int[][] existingIntervals = { { 1, 3 }, { 4, 5 }, { 7, 8 }, { 9, 12 }, { 13, 14 } };
		int[] newInterval = { 6, 10 };
		int[][] result = insertInterval(existingIntervals, newInterval);
		for (int[] mergedInterVal : result) {
			System.out.println(Arrays.toString(mergedInterVal));
		}
	}

	private static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
		boolean isInserted = false;
		List<int[]> intervals = new ArrayList<>();
		for (int[] interval : existingIntervals) {
			int currStart = interval[0];
			int currEnd = interval[1];
			if (isInserted) {
				int[] prev = intervals.get(intervals.size() - 1);
				if (currStart <= prev[1]) {
					prev[0] = Math.min(prev[0], currStart);
					prev[1] = Math.max(prev[1], currEnd);
				} else {
					intervals.add(interval);
				}
			} else {
				if (newInterval[0] <= currEnd) {
					interval[0] = Math.min(currStart, newInterval[0]);
					interval[1] = Math.max(currEnd, newInterval[1]);
					isInserted = true;
				}
				intervals.add(interval);
			}
		}
		return null;
	}

//	public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
//
//		List<int[]> result = new ArrayList<>();
//		boolean isInserted = false;
//		for (int[] interval : existingIntervals) {
//			int currStart = interval[0];
//			int currEnd = interval[1];
//			if (isInserted) {
//				int[] prev = result.get(result.size() - 1);
//				if (currStart <= prev[1]) {
//					prev[0] = Math.min(prev[0], currStart);
//					prev[1] = Math.max(prev[1], currEnd);
//				} else {
//					result.add(interval);
//				}
//			} else {
//				if (newInterval[0] <= currEnd) {
//					interval[0] = Math.min(currStart, newInterval[0]);
//					interval[1] = Math.max(currEnd, newInterval[1]);
//					isInserted = true;
//					result.add(interval);
//				} else {
//					result.add(interval);
//				}
//			}
//
//		}
//		
//		if(!isInserted) {
//			result.add(newInterval);
//		}
//
//		int[][] resultIntervalsList = new int[result.size()][2];
//		for (int i = 0; i < result.size(); i++) {
//			resultIntervalsList[i] = result.get(i);
//		}
//		return resultIntervalsList;
//	}
}
