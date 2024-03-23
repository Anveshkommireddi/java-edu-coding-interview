package com.edu.java.concurrency.multithreading.barrier;

public class BarrierTest {

	public static void main(String[] args) {
		
		Barrier barrier = new Barrier(3);

		Thread t1 = new Thread(() -> {
			try {
				barrier.execute();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				barrier.execute();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread t3 = new Thread(() -> {
			try {
				barrier.execute();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t1.setName("Thread-1");
		t2.setName("Thread-2");
		t3.setName("Thread-3");

		//t1.start();
		//t2.start();
		//t3.start();
		
		try {
			barrier.runTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
