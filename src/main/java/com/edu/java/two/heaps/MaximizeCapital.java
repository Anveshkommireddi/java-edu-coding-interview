package com.edu.java.two.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import com.edu.java.heap.Pair;

public class MaximizeCapital {

	public static void main(String[] args) {
		int k = 1;
		int c = 3;
		int[] capitals = { 0, 2, 3, 4 };
		int[] profits = { 7, 3, 5, 2 };
		int maxCap1 = maximumCapital(c, k, capitals, profits);
		int maxCap2 = maximumCapital2(c, k, capitals, profits);
		System.out.println(maxCap1);
		System.out.println(maxCap2);
	}

	private static int maximumCapital3(int c, int k, int[] capitals, int[] profits) {
		int result = c;
		List<Interval> intervalsList = new ArrayList<>();
		for (int i = 0; i < capitals.length; i++) {
			intervalsList.add(new Interval(capitals[i], profits[i]));
		}
		Collections.sort(intervalsList, (interval1, interval2) -> interval1.capital - interval2.capital);
		PriorityQueue<Interval> pq = new PriorityQueue<>((interval1, interval2) -> interval2.profit - interval1.profit);
		int currCount = 0;
		int idx = 0;
		while (currCount < k) {

			// add projects with initial capital
			while (idx < intervalsList.size() && intervalsList.get(idx).capital <= result) {
				pq.offer(intervalsList.get(idx++));
			}

			if (pq.isEmpty())
				break;

			// claim profits and increase capital
			result += pq.poll().profit;
			currCount++;
		}
		return result;
	}

	public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {
		int currCaptial = k;
		int currK = 0;
		PriorityQueue<int[]> capitalsMinPq = new PriorityQueue<>((c1, c2) -> c1[0] - c2[0]);
		for (int i = 0; i < capitals.length; i++) {
			capitalsMinPq.offer(new int[] { capitals[i], i });
		}
		PriorityQueue<Integer> profitsMaxPq = new PriorityQueue<>((p1, p2) -> p2 - p1);
		while (currK < k) {

			// collect all the capitals less than initial
			while (!capitalsMinPq.isEmpty() && capitalsMinPq.peek()[0] <= currCaptial) {
				profitsMaxPq.offer(capitalsMinPq.poll()[1]);
			}

			if (profitsMaxPq.isEmpty())
				break;

			currCaptial += profitsMaxPq.poll();
			currK++;
		}
		return currCaptial;
	}

	public static int maximumCapital2(int c, int k, int[] capitals, int[] profits) {
		int result = c;
		List<Pair> pairsList = new ArrayList<>();
		for (int i = 0; i < capitals.length; i++) {
			int capital = capitals[i];
			int profit = profits[i];
			Pair pair = new Pair(capital, profit);
			pairsList.add(pair);
		}
		Collections.sort(pairsList, (pair1, pair2) -> pair1.getStart() - pair2.getStart());
		PriorityQueue<Pair> pq = new PriorityQueue<>((pair1, pair2) -> pair2.getEnd() - pair1.getEnd());
		int currCount = 0;
		for (Pair pair : pairsList) {
			while (!pq.isEmpty() && currCount < k && pair.start > result) {
				result += pq.poll().end;
				currCount++;
			}
			if (currCount < k && pair.start <= result) {
				pq.offer(pair);
			}
		}
		while (!pq.isEmpty() && currCount < k) {
			result += pq.poll().end;
			currCount++;
		}

		return currCount >= k ? result : -1;
	}

}

class Interval {

	int capital;
	int profit;

	public Interval(int capital, int profit) {
		this.capital = capital;
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "Interval [capital=" + capital + ", profit=" + profit + "]";
	}

}