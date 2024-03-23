package com.edu.java.design.patterns.facade;

public class Projector {
	
	public void on() {
        System.out.println("Projector is on");
    }

    public void setInput(DVDPlayer dvdPlayer) {
        System.out.println("Setting input to DVD Player");
    }

    public void off() {
        System.out.println("Projector is off");
    }

}
