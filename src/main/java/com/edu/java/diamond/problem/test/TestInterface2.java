package com.edu.java.diamond.problem.test;

public interface TestInterface2 {

	default void greet() {
		System.out.println("Greet From TestInterface 2");
	}

}
