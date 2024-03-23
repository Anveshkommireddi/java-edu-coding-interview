package com.edu.java.design.patterns.strategy;

public class StrategyPatternMainTest {

	public static void main(String[] args) {

		// Create a shopping cart
		ShoppingCart cart = new ShoppingCart();

		// Set the payment strategy
		cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012", "12/25", "123"));
		cart.checkout(100.0); // Pay using Credit Card

		// Change payment strategy dynamically
		cart.setPaymentStrategy(new PayPalPayment("example@example.com", "password"));
		cart.checkout(50.0); // Pay using PayPal

		// Change payment strategy dynamically again
		cart.setPaymentStrategy(new GooglePayPayment("9876543210", "123456"));
		cart.checkout(75.0); // Pay using Google Pay
	}

}
