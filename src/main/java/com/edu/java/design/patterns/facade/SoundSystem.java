package com.edu.java.design.patterns.facade;

public class SoundSystem {

	private int volume;

	public SoundSystem() {
		this.volume = 10;
	}

	public int getVolume() {
		return volume;
	}

	public void on() {
		System.out.println("Sound System is on");
	}

	public void setVolume(int volume) {
		this.volume = volume;
		System.out.println("Setting volume to: " + volume);
	}

	public void off() {
		System.out.println("Sound System is off");
	}

}
