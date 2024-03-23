package com.edu.java.design.patterns.template;

public class BeverageApp {

	public static void main(String[] args) {
		
		Beverage coffee = new Coffee();
		coffee.prepareBeverage();

		Beverage tea = new Tea();
		tea.prepareBeverage();
	}
}
