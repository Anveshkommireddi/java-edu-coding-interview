package com.edu.java.solid;

public class DependencyInversionPricniple {

	/**
	 * 5. Dependency Inversion Principle (DIP) Definition: High-level modules should
	 * not depend on low-level modules. Both should depend on abstractions (e.g.,
	 * interfaces). Abstractions should not depend on details. Details (concrete
	 * implementations) should depend on abstractions.
	 * 
	 * Analogy: A librarian depends on an abstract "Notification Service" to send
	 * notifications rather than a specific "Email Service" or "SMS Service." This
	 * way, the implementation of the notification service can change without
	 * affecting the librarian's code.
	 * 
	 */

	public static void main(String[] args) {
		DI_NotificationService emailService = new DS_EmailService();
		DI_NotificationService smsService = new DS_SMSService();

		DI_Librarian librarian = new DI_Librarian(emailService);
		librarian.notifyMembers(); // Using email service

		librarian = new DI_Librarian(smsService);
		librarian.notifyMembers(); // Using SMS service
	}

}

//Violates DIP: High-level module depends on low-level module.
class WDI_EmailService {
	public void sendEmail() {
		/* send email */ }
}

class DS_Librarian {
	private WDI_EmailService emailService = new WDI_EmailService();

	public void notifyMembers() {
		emailService.sendEmail();
	}
}

//Adheres to DIP: High-level module depends on an abstraction.
interface DI_NotificationService {
	void notifyUsers();
}

class DS_EmailService implements DI_NotificationService {
	public void notifyUsers() {
		/* send email */ }
}

class DS_SMSService implements DI_NotificationService {
	public void notifyUsers() {
		/* send SMS */ }
}

class DI_Librarian {
	private DI_NotificationService notificationService;

	public DI_Librarian(DI_NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public void notifyMembers() {
		notificationService.notify();
	}
}
