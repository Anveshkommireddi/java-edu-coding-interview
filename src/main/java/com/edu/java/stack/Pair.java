package com.edu.java.stack;

public class Pair<U, T> {

	private U first;

	private T last;

	public Pair() {
	}

	public Pair(U u, T t) {
		this.first = u;
		this.last = t;
	}

	public U getFirst() {
		return first;
	}

	public T getLast() {
		return last;
	}
	
	@Override
	public String toString() {
		return "Pair [first=" + first + ", last=" + last + "]";
	}

}
