package com.edu.java.design.patterns.iterator;

import java.util.Iterator;
import java.util.List;

public class ForWardIterator<T> implements Iterator<T> {

	private List<T> list;

	private int idx;

	public ForWardIterator(List<T> list) {
		this.list = list;
		this.idx = 0;
	}

	@Override
	public boolean hasNext() {
		return idx < list.size();
	}

	@Override
	public T next() {
		return list.get(idx++);
	}

}
