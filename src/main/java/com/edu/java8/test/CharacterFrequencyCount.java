package com.edu.java8.test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequencyCount {

	public static void main(String[] args) {
		String word = "Concept of the Day";
//		String[] letters = word.split("");
//		Map<String, Integer> countMap = new HashMap<>();
//		Arrays.stream(letters).filter(letter -> !letter.equals(" "))
//				.forEach(letter -> countMap.put(letter, countMap.getOrDefault(letter, 0) + 1));
		// System.out.println(countMap);
		Map<Character, Long> java8Map = word.chars().mapToObj(num -> (char) num)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(java8Map);
	}

}
