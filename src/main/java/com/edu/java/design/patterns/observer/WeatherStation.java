package com.edu.java.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

	private double temperature;

	public List<Observer> observers;

	public WeatherStation() {
		observers = new ArrayList<>();
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void unregisterObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature);
		}
	}

}
