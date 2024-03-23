package com.edu.java.design.patterns.observer;

public class PhoneApp implements Observer {

	@Override
	public void update(double temperature) {
		 System.out.println("Phone App: Temperature updated - " + temperature + " degrees Celsius");
	}

}
