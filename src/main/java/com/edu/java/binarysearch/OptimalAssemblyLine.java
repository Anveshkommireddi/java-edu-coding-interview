package com.edu.java.binarysearch;

public class OptimalAssemblyLine {

	public static void main(String[] args) {
		int[] stepDurations = { 15, 15, 30, 30, 45 };
		int numOfStations = 3;
		int result = optimalAssemblyLine(stepDurations, numOfStations);
		System.out.println("Result is " + result);
	}

	private static int optimalAssemblyLine(int[] stepDurations, int numOfStations) {
		int start = 0;
		int end = 0;
		for (int stepDuration : stepDurations) {
			start = Math.max(start, stepDuration);
			end += stepDuration;
		}
		int result = Integer.MAX_VALUE;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int count = getCount(stepDurations, numOfStations, mid);
			if (count <= numOfStations) {
				result = Math.min(mid, result);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}

	private static int getCount(int[] stepDurations, int numOfStations, int maxPossibleValue) {
		int count = 1;
		int currValue = 0;
		for (int num : stepDurations) {
			currValue += num;
			if (currValue > maxPossibleValue) {
				count++;
				currValue = num;
			}
		}
		return count;
	}

}
