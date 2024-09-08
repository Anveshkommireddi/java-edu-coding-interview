package com.edu.java.concurrency.multithreading.pc;

import java.util.LinkedList;
import java.util.Queue;

public class ProdCons {

	int size;

	Queue<Integer> queue;

	public ProdCons(int size) {
		this.size = size;
		queue = new LinkedList<>();
	}

	public synchronized void produce(int val) throws InterruptedException {
		while (queue.size() == size) {
			wait();
		}
		queue.add(val);
		System.out.println(Thread.currentThread().getName() + " Produced Value is :: " + val);
		notifyAll();
	}

	public synchronized void consume() throws InterruptedException {
		while (queue.isEmpty()) {
			wait();
		}
		Integer polledValue = queue.poll();
		System.out.println(Thread.currentThread().getName() + " Consumed Value is :: " + polledValue);
		notifyAll();
	}

}
