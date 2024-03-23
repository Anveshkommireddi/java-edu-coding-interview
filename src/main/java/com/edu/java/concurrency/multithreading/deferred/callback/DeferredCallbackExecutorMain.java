package com.edu.java.concurrency.multithreading.deferred.callback;

public class DeferredCallbackExecutorMain {

	public static void main(String... args) throws InterruptedException {

		final DeferredCallBackExecutor deferredCallbackExecutor = new DeferredCallBackExecutor();

		Thread service = new Thread(() -> {
			try {
				deferredCallbackExecutor.start();
			} catch (InterruptedException ie) {
			    Thread.currentThread().interrupt();
			}
		});

		service.start();

		Thread lateThread = new Thread(() -> {
			CallBack cb = new CallBack(8, "Hello this is the callback submitted first");
			deferredCallbackExecutor.registerCallback(cb);
		});
		lateThread.start();

		Thread.sleep(3000);

		Thread earlyThread = new Thread(() -> {
			CallBack cb = new CallBack(1, "Hello this is callback sumbitted second");
			deferredCallbackExecutor.registerCallback(cb);
		});
		earlyThread.start();

		lateThread.join();
		earlyThread.join();
	}

}
