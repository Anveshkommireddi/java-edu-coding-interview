package com.edu.java.two.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ScheduleTask {

	public static void main(String[] args) {
		// [[1,7],[8,13],[5,6],[10,14],[6,7]]
		List<List<Integer>> tasksList = Arrays.asList(Arrays.asList(1, 7), Arrays.asList(8, 13), Arrays.asList(5, 6),
				Arrays.asList(10, 14), Arrays.asList(6, 7));
		int result = tasks(tasksList);
		System.out.println(result);
	}

	public static int tasks(List<List<Integer>> tasksList) {
		int result = Integer.MIN_VALUE;
		// sort by start time
		Collections.sort(tasksList, (list1, list2) -> list1.get(0) - list2.get(0));
		// pq sorted with end time
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>((list1, list2) -> list1.get(1) - list2.get(1));
		for (List<Integer> task : tasksList) {
			while (!pq.isEmpty() && pq.peek().get(1) <= task.get(0)) {
				pq.poll();
			}
			pq.offer(task);
			result = Math.max(result, pq.size());
		}
		return result;
	}

}
