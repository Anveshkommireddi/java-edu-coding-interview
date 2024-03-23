package com.edu.java.design.patterns.strategy;

public class CreditCardPayment implements PaymentStrategy {

	private String cardNumber;
	private String expiryDate;
	private String cvv;

	public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid $" + amount + " using Credit Card");
	}

}
