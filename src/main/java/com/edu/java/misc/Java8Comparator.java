package com.edu.java.misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Comparator {

	public static void main(String[] args) {
		Employee emp1 = new Employee(1, "anvesh");
		Employee emp2 = new Employee(2, "karan");
		Employee emp3 = new Employee(3, "pankaj");
		Employee emp4 = new Employee(4, "anvesh");
		List<Employee> empList = Arrays.asList(emp1, emp2, emp3, emp4);
		List<Employee> sortedEmpList = empList.stream()
				.sorted(Comparator.comparing(Employee::getName, (ce1, ce2) -> ce1.compareTo(ce2))
						.thenComparing(Employee::getEmpNum, (ce1, ce2) -> ce1 - ce2))
				.collect(Collectors.toList());
		System.out.println(sortedEmpList);

		Map<Integer, String> map = new HashMap<>();
		map.put(30, "Anvesh Doe");
		map.put(25, "Anvesh Doe");
		map.put(40, "Bill Smith");

		// Sort the map entries by values, then by keys.
		map.entrySet().stream()
				.sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
				.sorted((entry1, entry2) -> entry1.getKey() - entry2.getKey())
				.collect(Collectors.toMap(entry -> entry.getKey(), 
										  entry -> entry.getValue(),
										  (oldKey, newKey) -> oldKey, () -> new LinkedHashMap<>()))
				.forEach((key, value) -> System.out.println(key + "=" + value));
		

	}

}
