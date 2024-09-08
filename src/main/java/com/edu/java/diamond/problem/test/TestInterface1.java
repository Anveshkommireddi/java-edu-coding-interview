package com.edu.java.diamond.problem.test;

public interface TestInterface1 {

	default void greet() {
		System.out.println("Greet From TestInterface 1");
	}

}
