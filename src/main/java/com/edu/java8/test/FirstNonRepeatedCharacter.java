package com.edu.java8.test;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		String sentence = "concept of the day";
		sentence.chars().mapToObj(val -> (char) val)
				.filter(val -> val != ' ')
				.collect(Collectors.groupingBy(val -> val, LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue() == 1)
				.map(Entry::getKey)
				.findFirst()
				.orElse(null);
				
	}

}
