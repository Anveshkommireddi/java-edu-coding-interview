package com.edu.java.merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectIntervals {

	public static void main(String[] args) {
		int[][] intervalLista = { { 1, 4 }, { 5, 6 }, { 7, 9 } };
		int[][] intervalListb = { { 3, 5 }, { 6, 7 }, { 8, 9 } };
		int[][] result = intervalsIntersection(intervalLista, intervalListb);
		for (int[] mergedInterVal : result) {
			System.out.println(Arrays.toString(mergedInterVal));
		}
	}

	public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {
		int aLength = intervalLista.length;
		int bLength = intervalListb.length;
		int aIdx = 0;
		int bIdx = 0;
		List<int[]> resultList = new ArrayList<>();
		while (aIdx < aLength && bIdx < bLength) {

			int aStart = intervalLista[aIdx][0];
			int aEnd = intervalLista[aIdx][1];

			int bStart = intervalListb[bIdx][0];
			int bEnd = intervalListb[bIdx][1];

			if (aStart <= bStart && bStart <= aEnd) {
				resultList.add(new int[] { Math.max(aStart, bStart), Math.min(aEnd, bEnd) });
			} else if (bStart <= aStart && aStart <= bEnd) {
				resultList.add(new int[] { Math.max(aStart, bStart), Math.min(aEnd, bEnd) });
			}
			if (aEnd <= bEnd) {
				aIdx++;
			} else {
				bIdx++;
			}
		}
		int[][] result = new int[resultList.size()][2];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i);
		}
		return result;
	}
}
