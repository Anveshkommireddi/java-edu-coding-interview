package com.edu.java.design.patterns.decorator;

public class CheeseDecorator extends PizzaDecorator {

	public CheeseDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", Cheese";
	}

	@Override
	public double getCost() {
		return pizza.getCost() + 1.5;
	}

}
