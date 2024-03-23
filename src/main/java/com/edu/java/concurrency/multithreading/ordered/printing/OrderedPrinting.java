package com.edu.java.concurrency.multithreading.ordered.printing;

public class OrderedPrinting {

	private String text;

	public OrderedPrinting() {
		this.text = "first";
	}

	public synchronized void printFirst() throws InterruptedException {
		while (null != this.text && !this.text.equals("first")) {
			this.wait();
		}
		System.out.println(text);
		this.text = "second";
		this.notifyAll();
	}

	public synchronized void printSecond() throws InterruptedException {
		while (null != this.text && !this.text.equals("second")) {
			this.wait();
		}
		System.out.println(text);
		this.text = "third";
		this.notifyAll();
	}

	public synchronized void printThird() throws InterruptedException {
		while (null != this.text && !this.text.equals("third")) {
			this.wait();
		}
		System.out.println(text);
		this.text = null;
		this.notifyAll();
	}

}
