package com.edu.java.stack;

@SuppressWarnings("unchecked")
public class Queue<V> {

	private int maxSize;
	private int front;
	private int back;
	private int currSize;
	private V[] arr;

	public Queue(int maxSize) {
		this.maxSize = maxSize;
		this.arr = (V[]) new Object[maxSize];
		this.front = 0;
		this.back = -1;
		this.currSize = 0;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public int getCurrSize() {
		return currSize;
	}

	public boolean isEmpty() {
		return currSize == 0;
	}

	public boolean isFull() {
		return currSize == maxSize;
	}

	public V top() {
		if (isEmpty())
			return null;
		return arr[front];
	}

	public void enqueue(V value) {
		if (isFull()) {
			System.err.println("Queue is Full");
			return;
		}
		back = (back + 1) % maxSize; // to keep index in range
		arr[back] = value;
		currSize++;
	}

	public V dequeue() {
		if (isEmpty()) {
			System.err.println("Queue is Empty");
			return null;
		}
		V val = arr[front];
		front = (front + 1) % maxSize; // to keep index in range
		currSize--;
		return val;
	}

}
