package com.edu.java.design.patterns.flyweight;

//Concrete Flyweight class representing a shared resource
public class ConcreteFlyWeight implements FlyWeight {

	private final String intrinsicState;

	public ConcreteFlyWeight(String intrinsicState) {
		this.intrinsicState = intrinsicState;
	}

	@Override
	public void operation(String extrinsicState) {
		System.out.println("Intrinsic State is :: " + intrinsicState);
		System.out.println("Extrinsic State is :: " + extrinsicState);
	}

}
