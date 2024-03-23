package com.edu.java.design.patterns.observer;

public interface Subject {
	
	void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers();

}
