package com.edu.java.generics;

import java.util.ArrayList;
import java.util.List;

class Animal {
	void makeSound() {
		System.out.println("Animal sound");
	}
}

class Dog extends Animal {
	@Override
	void makeSound() {
		System.out.println("Bark");
	}
}

class Cat extends Animal {
	@Override
	void makeSound() {
		System.out.println("Meow");
	}
}

class AnimalShelter {
	// Method to add Dogs to a list of animals or any superclass of Dog
	public void addDogs(List<? super Dog> animals) {
		animals.add(new Dog()); // Safe to add Dog
		animals.add(new Dog()); // Safe to add Dog
	}

	// Method to add Cats to a list of animals or any superclass of Cat, Dog
	public void addCats(List<? super Animal> animals) {
		animals.add(new Cat()); // Safe to add Cat
		animals.add(new Dog()); // Safe to add Dog
	}

}

public class ConsumerSuper {

	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<>();
		AnimalShelter shelter = new AnimalShelter();

		// Adding dogs to the list of animals
		shelter.addDogs(animals); // List<Animal> is accepted because Animal is a superclass of Dog
		// Adding cats to the list of animals
		shelter.addCats(animals); // List<Animal> is accepted because Animal is a superclass of Cat

		for (Animal animal : animals) {
			animal.makeSound(); // Outputs: "Bark" for each dog and "Meow" for each cat
		}
	}
}
