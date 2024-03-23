package com.edu.java.design.patterns.observer;

public class ObserverMain {

	public static void main(String[] args) {
		
		WeatherStation weatherStation = new WeatherStation();

		// Create observers
		Observer temperatureDisplay = new TemperatureDisplay();
		Observer phoneApp = new PhoneApp();

		// Register observers with the subject
		weatherStation.registerObserver(temperatureDisplay);
		weatherStation.registerObserver(phoneApp);

		// Set temperature and notify observers
		weatherStation.setTemperature(25.5);
		weatherStation.setTemperature(30.0);

		// Unregister an observer
		weatherStation.unregisterObserver(temperatureDisplay);

		// Set temperature again and notify remaining observers
		weatherStation.setTemperature(27.8);
	}

}
