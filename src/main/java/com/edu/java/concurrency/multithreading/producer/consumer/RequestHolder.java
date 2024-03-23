package com.edu.java.concurrency.multithreading.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;

public class RequestHolder {
	
	Queue<Integer> queue;
	int queuSize;
	int maxsize;

	public RequestHolder(int queueSize, int maxSize) {
		queue = new LinkedList<>();
		this.queuSize = queueSize;
		this.maxsize = maxSize;
	}

}
