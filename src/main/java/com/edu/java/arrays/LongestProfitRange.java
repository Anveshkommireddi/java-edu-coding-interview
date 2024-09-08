package com.edu.java.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestProfitRange {

	public static void main(String[] args) {
		int[] arr = {-1, 9, 0, 8, -5, 6, -24};
		List<Integer> result = maxProfitRange(arr);
		System.out.println(result);
		List<String> test = new ArrayList<>();
		test.add("Apple");
		test.add("Avacado");
		test.add("Banana");
		Map<Character, Long> countNumber = test.stream()
				.collect(Collectors.groupingBy(fruit -> fruit.charAt(0), Collectors.counting()));
		System.out.println(countNumber);
		
	}

	private static List<Integer> maxProfitRange(int[] arr) {
		List<Integer> result = new ArrayList<>();
		int start = 0;
		int end = 0;
		int cMax = arr[0];
		int tMax = arr[0];
		result.add(start);
		result.add(end);
		for (int idx = 1; idx < arr.length; idx++) {
			if (arr[idx] + cMax > arr[idx]) {
				cMax = arr[idx] + cMax;
			} else {
				cMax = arr[idx];
				start = idx;
			}
			if (cMax >= tMax) {
				tMax = cMax;
			} else {
				end = idx - 1;
				result.set(0, start);
				result.set(1, end);
			}
		}
		return result;
	}

}
