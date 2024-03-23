package com.edu.java.concurrency.multithreading.producer.consumer;

import java.util.Queue;

public class Producer implements Runnable {

	RequestHolder requestHolder;

	public Producer(RequestHolder requestHolder) {
		this.requestHolder = requestHolder;
	}

	@Override
	public void run() {
		int maxSize = requestHolder.maxsize;
		int queuSize = requestHolder.queuSize;
		Queue<Integer> queue = requestHolder.queue;
		for (int i = 1; i <= maxSize; i++) {
			synchronized (requestHolder) {
				try {
					while (queue.size() == queuSize) {
						// System.out.println("Producer Waiting Started " + i);
						requestHolder.wait();
						// System.out.println("Producer Waiting Completed" + i);
					}
					Thread.sleep(1000l);
					queue.add(i);
					System.out.println("Produced " + i);
					requestHolder.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
