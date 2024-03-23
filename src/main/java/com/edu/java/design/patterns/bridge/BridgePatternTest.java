package com.edu.java.design.patterns.bridge;

public class BridgePatternTest {
	
	public static void main(String[] args) {
		
		TV tv = new TV();
		Radio radio = new Radio();
		
		BasicRemoteControl tvRemote = new BasicRemoteControl(tv);
		BasicRemoteControl radioRemote = new BasicRemoteControl(radio);
		
		tvRemote.powerOn();
		tvRemote.setChannel(3);
		tvRemote.powerOff();
		
		
		radioRemote.powerOn();
		radioRemote.setChannel(91);
		radioRemote.powerOff();
		
	}

}
