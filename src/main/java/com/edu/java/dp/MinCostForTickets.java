package com.edu.java.dp;

//LC :: 983
public class MinCostForTickets {

	public static void main(String[] args) {
		int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
		int[] costs = { 2, 7, 15 };
		Integer[] mem = new Integer[days.length + 1];
		int minCost = minCost(days, costs, days.length - 1, mem);
		System.out.println(minCost);
	}

	private static int minCost(int[] days, int[] costs, int dayIdx, Integer[] mem) {
		if (dayIdx < 0) return 0;
		if(null != mem[dayIdx]) return mem[dayIdx];
		int result = 1000000;
		for (int costIdx = 0; costIdx < costs.length; costIdx++) {
			int updatedDayIdx = computeDayIdx(costIdx, dayIdx, days);
			int minCost = costs[costIdx] + minCost(days, costs, updatedDayIdx, mem);
			result = Math.min(result, minCost);
		}
		return mem[dayIdx] = result;
	}

	private static int computeDayIdx(int currCostIdx, int currDayIdx, int[] days) {
		if (currCostIdx == 0)
			return currDayIdx - 1;
		int currDay = days[currDayIdx];
		if (currCostIdx == 1) {
			int targetDay = currDay - 7;
			return floorOftargetDay(days, 0, currDayIdx, targetDay);
		}
		if (currCostIdx == 2) {
			int targetDay = currDay - 30;
			return floorOftargetDay(days, 0, currDayIdx, targetDay);
		}
		return -1;
	}

	private static int floorOftargetDay(int[] arr, int low, int high, int target) {
		int result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				high = mid - 1;
			} else if (arr[mid] < target) {
				result = mid;
				low = mid + 1;
			}
		}
		return result;
	}

}
