package com.edu.java.solid;

public class LiskovSubstituionPrinciple {

	/**
	 * 3. Liskov Substitution Principle (LSP) Definition: Objects of a superclass
	 * should be replaceable with objects of a subclass without affecting the
	 * correctness of the program.
	 * 
	 * Analogy: In a library system where a LibraryMember can borrow books, both
	 * StudentMember and ProfessorMember should be able to borrow books. If the
	 * system works for LibraryMember, it should work for StudentMember and
	 * ProfessorMember without issues.
	 * 
	 */

	public static void main(String[] args) {
		LS_Bird sparrow = new LS_Sparrow();
		LS_Bird penguin = new LS_Penguin();
		sparrow.move(); // Output: Sparrow is flying
		penguin.move(); // Output: Penguin is swimming
	}

}

//Violates LSP: Subclass behavior is inconsistent with the base class.
class WLS_Bird {
	public void fly() {
		System.out.println("Bird is flying");
	}
}

class WLS_Penguin extends WLS_Bird {
	@Override
	public void fly() {
		throw new UnsupportedOperationException("Penguins can't fly");
	}
}

//Adheres to LSP: Using inheritance in a way that doesn't break the base class behavior.
abstract class LS_Bird {
	public abstract void move();
}

class LS_Sparrow extends LS_Bird {
	@Override
	public void move() {
		System.out.println("Sparrow is flying");
	}
}

class LS_Penguin extends LS_Bird {
	@Override
	public void move() {
		System.out.println("Penguin is swimming");
	}
}
