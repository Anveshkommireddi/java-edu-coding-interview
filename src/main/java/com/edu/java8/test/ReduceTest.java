package com.edu.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceTest {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int val = numbers.stream().reduce(0, (carry, num) -> carry + num);
		System.out.println(val);
		List<Integer> sortedNums = numbers.stream().sorted((num1, num2) -> num1 - num2).collect(Collectors.toList());
		System.out.println(sortedNums);
		int num = 13;
		int rem = num % 8;
		System.out.println(rem);
	}

}
