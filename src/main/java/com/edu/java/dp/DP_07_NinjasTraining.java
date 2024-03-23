package com.edu.java.dp;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_07_NinjasTraining {

	private static final Logger Logger = LoggerFactory.getLogger(DP_07_NinjasTraining.class);

	public static void main(String[] args) {
		int[][] points = { { 10, 40, 70 }, 
				           { 20, 50, 80 }, 
				           { 30, 60, 90 } };
		int noOfDays = 3;
		int maxPoints = ninjaTraining(noOfDays, points);
		Logger.info("Max Points in {} no of days is {}", noOfDays, maxPoints);
	}

	private static int ninjaTraining(int noOfDays, int[][] points) {
		// int valWithOutMem = ninjaTraining(points, noOfDays - 1, noOfDays);
		int[][] mem = new int[noOfDays][4];
		for (int i = 0; i < mem.length; i++) {
			Arrays.fill(mem[i], -1);
		}
		return ninjaTrainingMem(points, noOfDays - 1, noOfDays, mem);
	}

	private static int ninjaTrainingMem(int[][] points, int currDay, int prevTask, int[][] mem) {
		if (currDay == 0) {
			// calculate max points for the day 0 by looping all the tasks
			int currMax = Integer.MIN_VALUE;
			for (int task = 0; task < points[0].length; task++) {
				if (task != prevTask) {
					currMax = Math.max(currMax, points[currDay][task]);
				}
			}
			return currMax;
		}

		if (mem[currDay][prevTask] != -1)
			return mem[currDay][prevTask];

		int currMax = Integer.MIN_VALUE;
		//loop on all the tasks in current day
		for (int task = 0; task < 3; task++) {
			//check the condition to not pick the same task done in the previous task
			if (task != prevTask) {
				int val = points[currDay][task] + ninjaTrainingMem(points, currDay - 1, task, mem);
				currMax = Math.max(currMax, val);
			}
		}
		return mem[currDay][prevTask] = currMax;
	}

	private static int ninjaTraining(int[][] points) {
		int[][] mem = new int[points.length][3];
		return -1;
	}
}