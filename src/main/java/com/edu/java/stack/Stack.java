package com.edu.java.stack;

@SuppressWarnings("unchecked")
public class Stack<V> {

	private int maxSize;
	private int top;
	private V[] arr;

	public Stack(int size) {
		this.maxSize = size;
		this.top = -1; // Initially when the stack is empty
		this.arr = (V[]) new Object[size];
	}

	public int getMaxSize() {
		return this.maxSize;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public V top() {
		if (isEmpty())
			return null;
		return arr[top];
	}

	public void push(V value) {
		if (isFull()) {
			System.err.println("Stack is Full");
			return;
		}

		arr[++top] = value;
	}

	public V pop() {
		if (isEmpty()) {
			System.err.println("Stack is Empty");
			return null;
		}
		return arr[--top];
	}

}
