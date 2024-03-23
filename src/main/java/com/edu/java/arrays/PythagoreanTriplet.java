package com.edu.java.arrays;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PythagoreanTriplet {

	private static final Logger LOGGER = LoggerFactory.getLogger(PythagoreanTriplet.class);

	public static void main(String[] args) {
		int[] arr = { 3, 8, 5 };
		boolean isPythagorean = isPythagorean(arr);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		LOGGER.info("Pythagorean found is {}", isPythagorean);
	}

	private static boolean isPythagorean(int[] arr) {
		int[] freq = prepareFrequencyArray(arr);
		Set<Integer> squaresSet = prepareSquaresSet(freq);
		return checkSquaresSum(freq, squaresSet);
	}

	private static boolean checkSquaresSum(int[] freq, Set<Integer> squaresSet) {
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				int aSquare = i * i;
				for (int j = i + 1; j < freq.length; j++) {
					if (freq[j] > 0) {
						int bSquare = j * j;
						int cSquare = aSquare + bSquare;
						if (squaresSet.contains(cSquare)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private static Set<Integer> prepareSquaresSet(int[] freq) {
		Set<Integer> squaresSet = new HashSet<>();
		for (int i = 0; i < freq.length; i++) {
			int num = freq[i];
			if (num > 0) {
				squaresSet.add(i * i);
			}
		}
		return squaresSet;
	}

	private static int[] prepareFrequencyArray(int[] arr) {
		int[] freq = new int[1001];
		for (int num : arr) {
			freq[num]++;
		}
		return freq;
	}

}
