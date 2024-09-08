package com.edu.java.diamond.problem.test;

public class TestClass implements TestInterface1, TestInterface2 {

	@Override
	public void greet() {
		TestInterface1.super.greet();
	}

	public void print(Object obj) {
		System.out.println("Print Using Object :: " + obj);
	}

	public void print(String obj) {
		System.out.println("Print Using String :: " + obj);
	}

}
