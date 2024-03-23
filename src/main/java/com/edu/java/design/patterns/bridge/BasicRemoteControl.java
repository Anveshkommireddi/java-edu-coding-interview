package com.edu.java.design.patterns.bridge;

public class BasicRemoteControl implements RemoteControl {

	private Device device;

	public BasicRemoteControl(Device device) {
		this.device = device;
	}

	@Override
	public void powerOn() {
		device.turnOn();
	}

	@Override
	public void powerOff() {
		device.turnOff();
	}

	@Override
	public void setChannel(int channel) {
		device.setChannel(channel);
	}

}
