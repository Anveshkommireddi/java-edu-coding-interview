package com.edu.java.design.patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyCollection<T> {

	private List<T> list;

	public MyCollection() {
		this.list = new ArrayList<>();
	}

	public void add(T val) {
		list.add(val);
	}
	
	public Iterator<T> forwardIterator() {
		return new ForWardIterator<>(list);
	}
	
	public Iterator<T> backwardIterator() {
		return new BackWardIterator<>(list);
	}

}
