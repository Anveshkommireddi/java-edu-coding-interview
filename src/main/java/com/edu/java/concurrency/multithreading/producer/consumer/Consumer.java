package com.edu.java.concurrency.multithreading.producer.consumer;

import java.util.Queue;

public class Consumer implements Runnable {

	RequestHolder requestHolder;

	public Consumer(RequestHolder requestHolder) {
		this.requestHolder = requestHolder;
	}

	@Override
	public void run() {
		int maxSize = requestHolder.maxsize;
		Queue<Integer> queue = requestHolder.queue;
		for (int i = 1; i <= maxSize; i++) {
			synchronized (requestHolder) {
				try {
					while (queue.isEmpty()) {
						// System.out.println("Consumer Waiting Started ");
						requestHolder.wait();
						// System.out.println("Consumer Waiting Completed ");
					}
					Thread.sleep(1000l);
					int val = queue.remove();
					System.out.println("Consumed " + val);
					requestHolder.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
