package com.edu.java.design.patterns.adapter;

public class SocketAdapter implements TwoPinSocket {

	private ThreePinSocket threePinSocket;

	public SocketAdapter(ThreePinSocket threePinSocket) {
		this.threePinSocket = threePinSocket;
	}

	@Override
	public void plugIntoTwoPinSocket() {
		threePinSocket.plugIntoThreePinSocket();
		System.out.println("Adapter is converting to a two-pin socket.");
	}

}
