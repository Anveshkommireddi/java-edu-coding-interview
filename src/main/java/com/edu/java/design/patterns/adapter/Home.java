package com.edu.java.design.patterns.adapter;

public class Home {
	
	public static void main(String[] args) {
		
        IronBox ironBox = new IronBox();
        HomePowerSource powerSource = new HomePowerSource();
        SocketAdapter adapter = new SocketAdapter(powerSource);

        ironBox.plugIntoTwoPinSocket(); // Directly plugged into two-pin socket
        adapter.plugIntoTwoPinSocket();      // Plugged into three-pin socket via adapter
    }

}
