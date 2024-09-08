package com.edu.java8.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountStringChars {

	public static void main(String[] args) {
		String[] lines = { "Java Ruby Struts", "Java Spring", "Spring Python" };
		Map<String, Long> countMap = Arrays.stream(lines).flatMap(line -> Arrays.asList(line.split(" ")).stream())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(countMap);

		Person p1 = new Person("kiran", "Wipro", 22000);
		Person p2 = new Person("charan", "Wipro", 100000);
		Person p3 = new Person("kalki", "Wipro", 88000);
		Person p4 = new Person("robin", "Wipro", 22000);
		List<Person> personsList = Arrays.asList(p4, p1, p2, p3);
		List<Person> sortedPersons = personsList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getName))
				.collect(Collectors.toList());
		System.out.println(sortedPersons);
	}
}

class Person {
	String name;
	int salary;
	String company;

	Person(String name, String company, int salary) {
		this.name = name;
		this.company = company;
		this.salary = salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return this.company;
	}
}