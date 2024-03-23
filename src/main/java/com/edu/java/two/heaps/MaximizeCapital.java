package com.edu.java.two.heaps;

import java.util.PriorityQueue;

public class MaximizeCapital {

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

}
