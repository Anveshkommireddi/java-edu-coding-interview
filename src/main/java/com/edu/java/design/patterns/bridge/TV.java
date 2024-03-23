package com.edu.java.design.patterns.bridge;

public class TV  implements Device {
	
	private int channel;

	@Override
	public void turnOn() {
		System.out.println("TV is switched on...");
	}

	@Override
	public void turnOff() {
		System.out.println("TV is switched off...");
	}

	@Override
	public void setChannel(int channel) {
		this.channel = channel;
		System.out.println("TV is switched to channel " + channel);
	}

}
