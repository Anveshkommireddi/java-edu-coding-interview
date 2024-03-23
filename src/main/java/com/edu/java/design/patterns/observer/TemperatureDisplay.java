package com.edu.java.design.patterns.observer;

public class TemperatureDisplay implements Observer {

	@Override
	public void update(double temperature) {
		 System.out.println("Temperature Display: " + temperature + " degrees Celsius");
	}

}
