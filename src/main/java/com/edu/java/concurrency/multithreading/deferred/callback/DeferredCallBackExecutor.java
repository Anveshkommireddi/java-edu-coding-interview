package com.edu.java.concurrency.multithreading.deferred.callback;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeferredCallBackExecutor {

	PriorityQueue<CallBack> q = new PriorityQueue<>((o1, o2) -> (int) (o1.executeAt - o2.executeAt));

	ReentrantLock lock = new ReentrantLock();

	Condition newCallbackArrived = lock.newCondition();

	private static final Logger LOGGER = LoggerFactory.getLogger(DeferredCallBackExecutor.class);

	private long findSleepDuration() {
		long currentTime = System.currentTimeMillis();
		return q.peek().executeAt - currentTime;
	}

	public void start() throws InterruptedException {

		long sleepFor = 0;

		while (true) {

			lock.lock();

			while (q.isEmpty()) {
				newCallbackArrived.await();
			}

			while (!q.isEmpty()) {
				sleepFor = findSleepDuration();

				if (sleepFor <= 0)
					break;
				CallBack cb = q.peek();
				LOGGER.info("+++++++ CB Before await {}  with sleep time {} seconds.", cb.message, sleepFor / 1000);
				boolean isElapsed = newCallbackArrived.await(sleepFor, TimeUnit.MILLISECONDS);
				LOGGER.info("isElapsed {}", isElapsed);
				LOGGER.info("------ CB after await {}  with sleep time {} seconds.", cb.message, sleepFor / 1000);
			}

			CallBack cb = q.poll();
			LOGGER.info("Executed at {}  required at  {} : message: {}", System.currentTimeMillis() / 1000,
					cb.executeAt / 1000, cb.message);
			lock.unlock();
		}
	}

	public void registerCallback(CallBack callBack) {
		lock.lock();
		q.add(callBack);
		newCallbackArrived.signal();
		lock.unlock();
	}

}
