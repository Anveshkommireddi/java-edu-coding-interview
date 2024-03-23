package com.edu.java.design.patterns.strategy;

public class GooglePayPayment implements PaymentStrategy {

	private String phoneNumber;
	private String otp;

	public GooglePayPayment(String phoneNumber, String otp) {
		this.phoneNumber = phoneNumber;
		this.otp = otp;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid $" + amount + " using Google Pay");
	}
}
