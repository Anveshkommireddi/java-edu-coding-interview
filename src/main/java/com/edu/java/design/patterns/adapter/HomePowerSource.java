package com.edu.java.design.patterns.adapter;

public class HomePowerSource implements ThreePinSocket {

	@Override
	public void plugIntoThreePinSocket() {
		System.out.println("Device is plugged into a three-pin socket.");
	}

}
