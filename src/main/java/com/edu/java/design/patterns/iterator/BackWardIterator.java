package com.edu.java.design.patterns.iterator;

import java.util.Iterator;
import java.util.List;

public class BackWardIterator<T> implements Iterator<T> {

	private List<T> list;

	private int idx;

	public BackWardIterator(List<T> list) {
		this.list = list;
		this.idx = list.size() - 1;
	}

	@Override
	public boolean hasNext() {
		return idx >= 0;
	}

	@Override
	public T next() {
		return list.get(idx--);
	}

}
