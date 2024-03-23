package com.edu.java.merge.intervals;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MergeIntervals {

	public static void main(String[] args) {
		// inputs are sorted by start time
		int[][] intervals = { { 3, 7 }, { 6, 8 }, { 10, 12 }, { 11, 15 } };
		int[][] result = mergeIntervals(intervals);
		for (int[] mergedInterVal : result) {
			System.out.println(Arrays.toString(mergedInterVal));
		}
	}

	public static int[][] mergeIntervals(int[][] intervals) {
		Deque<Interval> intervalsList = new ArrayDeque<>();
		for (int[] interval : intervals) {
			if (intervalsList.isEmpty() || intervalsList.getLast().getEnd() < interval[0]) {
				intervalsList.addLast(new Interval(interval[0], interval[1]));
			} else {
				Interval peekInterval = intervalsList.removeLast();
				peekInterval.setEnd(Math.max(interval[1], peekInterval.getEnd()));
				intervalsList.addLast(peekInterval);
			}
		}
		int[][] result = new int[intervalsList.size()][2];
		int idx = 0;
		while (!intervalsList.isEmpty()) {
			Interval peek = intervalsList.removeFirst();
			result[idx++] = new int[] { peek.getStart(), peek.getEnd() };
		}
		return result;
	}

}

class Interval {

	private int start;

	private int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}
	
}