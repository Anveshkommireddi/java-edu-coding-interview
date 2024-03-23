package com.edu.java.concurrency.multithreading.producer.consumer;

public class ProducerConsumerExample {

	public static void main(String[] args) {

		RequestHolder requestHolder = new RequestHolder(1, 10);

		Thread t1 = new Thread(new Producer(requestHolder));
		Thread t2 = new Thread(new Consumer(requestHolder));

		t1.start();
		t2.start();

		// System.out.println("Completed");
	}

}
