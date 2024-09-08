package com.edu.java.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class JavaTest {

	/**
	 * 
	 * Walmart has 100+ stores and each store has multiple associate
	 *
	 * 
	 * 
	 * In a store, an associate can work for multiple departments. Here are shifts
	 * of a associate in various departments:
	 * 
	 * In hardware department: From 8 to 10
	 * 
	 * In customer support department: From 10 to 12
	 * 
	 * In Diary department: From 14 to 21
	 *
	 * 
	 * 
	 * Given the above split of shifts, provide an method to return the different
	 * shifts of a colleague for the day after merging contiguous shifts.
	 * 
	 * Output: shift timings in this case are 8 to 12 and 14 to 21.
	 * 
	 * 8 - 10 10 - 12 11 - 13 14 - 21 //input 14-21, 8-10, 10-12 // (8-10), (10-12),
	 * (14-21) // sort start times // pq //(end time) // 8-10 // 10-12
	 */

	public static void main(String[] args) {
		List<Shift> shiftsList = Arrays.asList(new Shift(8, 10), new Shift(10, 12), new Shift(14, 21));
		// sorting shifts based on start time
		Collections.sort(shiftsList, (shift1, shift2) -> shift1.startTime - shift2.startTime);
		// collecting shifts by highest end time
		PriorityQueue<Shift> shiftQueue = new PriorityQueue<>((shift1, shift2) -> shift1.endTime - shift2.endTime);
		for (Shift currShift : shiftsList) {
			if (shiftQueue.isEmpty()) {
				shiftQueue.add(currShift);
			} else {
				Shift prevShift = shiftQueue.peek();
				if (currShift.startTime <= prevShift.endTime && currShift.endTime > prevShift.endTime) {
					prevShift.endTime = currShift.endTime;
				} else {
					shiftQueue.add(currShift);
				}
			}
		}
		List<Shift> mergedShifts = new ArrayList<>();
		while (!shiftQueue.isEmpty()) {
			mergedShifts.add(shiftQueue.poll());
		}
		System.out.println(mergedShifts);
	}
}
class Shift {
	int startTime;
	int endTime;
	public Shift(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String toString() {
		return "Shift startTime : " + startTime + " endTime : " + endTime;
	}
}
