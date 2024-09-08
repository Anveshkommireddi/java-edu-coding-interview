package com.edu.java.solid;

public class OpenClosedPrinciple {

	/**
	 * 2. Open/Closed Principle (OCP) Definition: Software entities (classes,
	 * modules, functions) should be open for extension but closed for modification.
	 * 
	 * Analogy: Consider a library system initially supporting only physical books.
	 * When e-books need to be added, the system should be extended to support
	 * e-books without altering the core code that manages physical books.
	 * 
	 */

	// client code
	public static void main(String[] args) {
		OC_BookManager manager = new OC_BookManager();
		manager.addBook(new OC_PhysicalBook());
		manager.addBook(new OC_Ebook());
	}

}

//Violates OCP: Modifying the class to add new behavior.
class BookManager {
	public void addBook(String bookType) {
		if (bookType.equals("Physical")) {
			// Add physical book
		} else if (bookType.equals("Ebook")) {
			// Add e-book
		}
		// More types may require more modifications here
	}
}

//Adheres to OCP: Adding new behavior by extending the system.
interface OC_Book {
	void add();
}

class OC_PhysicalBook implements OC_Book {
	public void add() {
		System.out.println("Adding a physical book.");
	}
}

class OC_Ebook implements OC_Book {
	public void add() {
		System.out.println("Adding an e-book.");
	}
}

class OC_BookManager {
	public void addBook(OC_Book book) {
		book.add();
	}
}
