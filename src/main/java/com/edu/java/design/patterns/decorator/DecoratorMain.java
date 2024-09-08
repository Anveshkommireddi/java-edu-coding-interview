package com.edu.java.design.patterns.decorator;

public class DecoratorMain {

	public static void main(String[] args) {

		// Create a plain pizza
		Pizza pizza = new PlainPizza();
		System.out.println("Plain Pizza - Description: " + pizza.getDescription());
		System.out.println("Plain Pizza - Cost: $" + pizza.getCost());

		// Decorate the plain pizza with cheese
		pizza = new CheeseDecorator(pizza);
		System.out.println("Cheese Pizza - Description: " + pizza.getDescription());
		System.out.println("Cheese Pizza - Cost: $" + pizza.getCost());

		// Decorate the cheese pizza with mushrooms
		pizza = new MushroomDecorator(pizza);
		System.out.println("Cheese Mushroom Pizza - Description: " + pizza.getDescription());
		System.out.println("Cheese Mushroom Pizza - Cost: $" + pizza.getCost());
	}
}
