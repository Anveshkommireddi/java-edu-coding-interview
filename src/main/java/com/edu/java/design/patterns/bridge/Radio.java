package com.edu.java.design.patterns.bridge;

public class Radio implements Device {
	
	private int channel;

	@Override
	public void turnOn() {
		System.out.println("Radio is switched on...");
	}

	@Override
	public void turnOff() {
		System.out.println("Radio is switched off...");
		
	}

	@Override
	public void setChannel(int channel) {
		this.channel = channel;
		System.out.println("Radio is switched to channel " + channel);
	}

}
