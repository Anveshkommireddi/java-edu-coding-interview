package com.edu.java.misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesInsideEachStringInList {

	public static void main(String[] args) {

		List<String> inputList = Arrays.asList("abcddg", "bcgfhgf", "dtfhgtf");
		List<String> result = inputList.stream()
				.map(input -> Arrays.stream(input.split("")).distinct().collect(Collectors.joining("")))
				.collect(Collectors.toList());
		System.out.println(result);
	}
}
