package com.edu.java.design.patterns.flyweight;

public class FlyWeightMainTest {

	public static void main(String[] args) {
		FlyWeight flyweight1 = FlyweightFactory.getFlyweight("key1");
		FlyWeight flyweight2 = FlyweightFactory.getFlyweight("key2");
		FlyWeight flyweight3 = FlyweightFactory.getFlyweight("key1");

        flyweight1.operation("Extrinsic State 1");
        flyweight2.operation("Extrinsic State 2");
        flyweight3.operation("Extrinsic State 3");
	}
}
