package com.edu.java.design.patterns.adapter;

public class IronBox implements TwoPinSocket {

	@Override
	public void plugIntoTwoPinSocket() {
		System.out.println("Iron Box is plugged into a two-pin socket.");
	}

}
