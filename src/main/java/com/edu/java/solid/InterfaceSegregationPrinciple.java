package com.edu.java.solid;

/**
 * 4. Interface Segregation Principle (ISP) Definition: Clients should not be
 * forced to depend on interfaces they do not use.
 * 
 * Analogy: Imagine a librarian's interface requiring them to perform various
 * unrelated tasks like issuing books, cleaning the library, and organizing
 * events. Instead, there should be separate interfaces for each task.
 */

public class InterfaceSegregationPrinciple {

}

//Violates ISP: Interface has unrelated methods.
interface IS_LibraryTasks {
	void issueBook();

	void cleanLibrary();

	void organizeEvents();
}

//Adheres to ISP: Separate interfaces for different tasks.
interface IS_BookIssuing {
	void issueBook();
}

interface IS_Cleaning {
	void cleanLibrary();
}

interface IS_EventOrganizing {
	void organizeEvents();
}

class Librarian implements IS_BookIssuing, IS_EventOrganizing {
	public void issueBook() {
		/* issue book */ }

	public void organizeEvents() {
		/* organize events */ }
}
