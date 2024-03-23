package com.edu.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fruit {
}

class Banana extends Fruit {
}

class Orange extends Fruit {
}

public class LiskovTest {

	public static void main(String[] args) {

		Banana banana = new Banana();
		Orange orange = new Orange();
		receiveFruit(banana);
		receiveFruit(orange);

		receiveFruitBaskets(new ArrayList<Fruit>());
		receiveFruitBaskets(Arrays.asList(banana));
		receiveFruitBaskets(Arrays.asList(orange));

		List<Banana> bananas1 = new ArrayList<>();
		List<Banana> bananas2 = new ArrayList<>();
		List<Fruit> fruits1 = new ArrayList<>();
		List<Fruit> fruits2 = new ArrayList<>();

		// copyFromTo(fruits1, fruits2);
		// copyFromTo(bananas1, bananas2);

		copyFromTo(bananas1, fruits2);
		copyFromTo(bananas1, bananas2);
		// copyFromTo(fruits1, bananas1);
	}

	// derived extends from base (covariant)
	// generic of derived does not extend from generic of base (not covariant)
	// using polymorphism -- covariance all the subtypes for the fruit can be used
	private static void receiveFruit(Fruit fruit) {
		System.out.println(fruit.getClass().getName());
	}

	private static void receiveFruitBaskets(List<Fruit> fruits) {
		System.out.println("received bunch of fruits");
		fruits.add(new Banana());
		fruits.add(new Orange());
	}

	private static <T> void copyFromTo(List<T> from, List<? super T> to) {
		for (T val : from) {
			to.add(val);
		}
	}

}
