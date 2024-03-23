package com.edu.java.design.patterns.template;

public class Tea extends Beverage {

	@Override
	public void brew() {
		System.out.println("Steeping the tea");
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding lemon");
	}

}
