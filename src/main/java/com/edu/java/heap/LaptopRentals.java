package com.edu.java.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LaptopRentals {

	public static void main(String[] args) {
		int[][] times = new int[][] { { 0, 2 }, { 1, 4 }, { 4, 6 }, { 0, 4 }, { 7, 8 }, { 9, 11 }, { 3, 10 } };
		//int[][] times = new int[][] { { 0, 4 }, { 2, 3 }, { 2, 3 }, { 2, 3 } };
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		for (int[] time : times) {
			input.add(new ArrayList<>(Arrays.asList(time[0], time[1])));
		}
		int result = laptopRentals(input);
		System.out.println("Result is " + result);
	}

	public static int laptopRentals(List<List<Integer>> times) {
		List<Pair> inputList = new ArrayList<>();
		for (List<Integer> time : times) {
			inputList.add(new Pair(time.get(0), time.get(1)));
		}
		List<Pair> sortedInputList = inputList.stream().sorted((p1, p2) -> p1.start - p2.start)
				.collect(Collectors.toList());
		int result = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.end - p2.end);
		for (Pair time : sortedInputList) {
			int currStart = time.start;
			while (!pq.isEmpty() && currStart >= pq.peek().end) {
				pq.poll();
			}
			pq.offer(time);
			result = Math.max(pq.size(), result);
		}
		return result;
	}
}
