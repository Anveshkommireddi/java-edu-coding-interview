package com.edu.java8.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighestNumber {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 0, 2); // .mapToLong(Long::valueOf)
		Integer val = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).findAny().orElse(-1);
		System.out.println(val);
	}

}
