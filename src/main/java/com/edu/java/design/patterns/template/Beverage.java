package com.edu.java.design.patterns.template;

public abstract class Beverage {

	public final void prepareBeverage() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	private void boilWater() {
		System.out.println("Boil Water");
	}

	public abstract void brew();

	private void pourInCup() {
		System.out.println("Pour in Cup");
	}

	public abstract void addCondiments();

}
