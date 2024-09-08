package com.edu.java.inner.classes;

public class OuterClass {

	public static void main(String args[]) {

		// Declaring an instance of the outer class
		OuterClass oc = new OuterClass();
		System.out.println(oc.myName);
		oc.createInnerClassInstance();

		// Declaring instance of innerClass
		OuterClass.StaticInnerClass sic = new OuterClass.StaticInnerClass();
		sic.printName();
	}

	String myName = "outerclass";
	private static String staticName = "outerclass";

	private class InnerClass {

		String myName = "innerClass";

		void printNames() {
			System.out.println(
					"I can access both static & non-static members of my outer class : " + staticName + " " + myName);
		}
	}

	void createInnerClassInstance() {
		// Creating inner class instance
		InnerClass ic = new InnerClass();
		ic.printNames();
	}

	static class StaticInnerClass {

		String myName = "staticInnerClass";

		void printName() {
			System.out.println("I can access static members of my outerclass but not non-static ones: " + staticName);
		}
	}

}
