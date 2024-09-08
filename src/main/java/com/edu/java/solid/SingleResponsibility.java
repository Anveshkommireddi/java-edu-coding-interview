package com.edu.java.solid;

public class SingleResponsibility {

	/**
	 * Definition: A class should have only one reason to change, meaning it should
	 * have only one job or responsibility.
	 * 
	 * Analogy: Think of a librarian whose job is to manage books. If the librarian
	 * is also responsible for cleaning the library, organizing events, and managing
	 * finances, they would be overwhelmed. Each task should be assigned to a
	 * different specialist.
	 */

}

//Violates SRP: This class has multiple responsibilities.
class SR_Library {
	public void addBook(SR_Book book) {
		/* add book to library */ }

	public void generateReport() {
		/* generate report about library */ }

	public void sendNotifications() {
		/* send notifications to members */ }
}

//Adheres to SRP: Each class has a single responsibility.
class SR_BookManager {
	public void addBook(SR_Book book) {
		/* add book to library */ }
}

class SR_ReportGenerator {
	public void generateReport() {
		/* generate report about library */ }
}

class SR_NotificationService {
	public void sendNotifications() {
		/* send notifications to members */ }
}

class SR_Book {}
