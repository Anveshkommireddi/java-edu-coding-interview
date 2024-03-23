package com.edu.java.concurrency.multithreading.foobar;

public class FooBar {

	private int maxVal;

	private String text;

	public FooBar(int maxVal) {
		this.maxVal = maxVal;
		this.text = "foo";
	}

	public synchronized void printFoo() throws InterruptedException {
		for (int i = 0; i < maxVal; i++) {
			while (!this.text.equals("foo")) {
				this.wait();
			}
			System.out.print(text);
			this.text = "bar";
			this.notifyAll();
		}
	}

	public synchronized void printBar() throws InterruptedException {
		for (int i = 0; i < maxVal; i++) {
			while (!this.text.equals("bar")) {
				this.wait();
			}
			System.out.println(text);
			this.text = "foo";
			this.notifyAll();
		}
	}

}
