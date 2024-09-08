package com.edu.java.design.patterns.iterator;

import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {

		MyCollection<String> customList = new MyCollection<>();
		customList.add("one");
		customList.add("two");
		customList.add("three");
		customList.add("four");
		customList.add("five");

		Iterator<String> cfIterator = customList.forwardIterator();
		while (cfIterator.hasNext()) {
			System.out.println(cfIterator.next());
		}
		System.out.println("===============================================");
		Iterator<String> cbIterator = customList.backwardIterator();
		while (cbIterator.hasNext()) {
			System.out.println(cbIterator.next());
		}
	}

}
