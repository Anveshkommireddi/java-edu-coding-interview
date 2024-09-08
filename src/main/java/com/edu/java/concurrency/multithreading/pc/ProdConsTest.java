package com.edu.java.concurrency.multithreading.pc;

public class ProdConsTest {

	public static void main(String[] args) {

		int size = 10;
		ProdCons prodCons = new ProdCons(size);

		Thread producerThread = new Thread(() -> {
			for (int val = 1; val <= size; val++) {
				try {
					prodCons.produce(val);
					Thread.sleep(1000l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "++Producer++");

		Thread consumerThread = new Thread(() -> {
			for (int val = 1; val <= size; val++) {
				try {
					prodCons.consume();
					Thread.sleep(1000l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "--Consumer--");

		producerThread.start();
		consumerThread.start();
	}

}
