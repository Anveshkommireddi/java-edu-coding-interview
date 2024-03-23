package com.edu.java.concurrency.multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadInterrupt {

	public static final Logger LOGGER = LoggerFactory.getLogger(ThreadInterrupt.class);

	public static void main(String[] args) {

		Thread interruptThread = new Thread(() -> {
			LOGGER.info("interrupted thread execution started... {}", Thread.interrupted());
			try {
				while (!Thread.interrupted()) {
					LOGGER.info("Thread Sleep started...");
					Thread.sleep(5000l);
					LOGGER.info("Thread Sleep ended...");
				}
			} catch (InterruptedException iexp) {
				LOGGER.error("Thread.interrupted() in exception {}", Thread.interrupted());
				LOGGER.error("Thread Interrupted ", iexp);
			}
			LOGGER.info("interrupted thread execution ended... {}", Thread.interrupted());
		});

		interruptThread.start();

		LOGGER.info("Thread Interrupted from main started ... {}", interruptThread.isInterrupted());
		interruptThread.interrupt();
		LOGGER.info("Thread Interrupted from main ended ... {}", interruptThread.isInterrupted());
	}

}
