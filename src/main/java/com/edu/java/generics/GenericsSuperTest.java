package com.edu.java.generics;

import java.util.UUID;

public class GenericsSuperTest {

	public static void main(String[] args) {
		
		System.out.println(UUID.randomUUID().toString());

		Thread innerThread = new Thread(new Runnable() {

			public void run() {

				for (int i = 0; i < 100; i++) {
					System.out.println("I am a new thread !");
				}
			}
		});

		innerThread.start();
		System.out.println("Main thread exiting");
	}
}
