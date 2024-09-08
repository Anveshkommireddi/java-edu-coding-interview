package com.edu.java.concurrency.multithreading;

public class DeadLockExample {

	private static final Object lock1 = new Object();

	private static final Object lock2 = new Object();

	public static void method1() {
		synchronized (lock1) {
			System.out.println("Method1: Holding lock1...");
			method2();
			System.out.println("Method1: Completed...");
		}
	}

	public static void method2() {
		synchronized (lock2) {
			System.out.println("Method2: Holding lock2...");
			method1();
			System.out.println("Method2: Completed...");
		}
	}

	public static void main(String[] args) {
		Thread thread1 = new Thread(DeadLockExample::method1);
		Thread thread2 = new Thread(DeadLockExample::method2);

		thread1.start();
		thread2.start();
	}

}
