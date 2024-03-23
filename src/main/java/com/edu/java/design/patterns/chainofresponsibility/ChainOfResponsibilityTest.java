package com.edu.java.design.patterns.chainofresponsibility;

public class ChainOfResponsibilityTest {

	public static void main(String[] args) {
		
		Admin admin = new Admin();
		Manager manager = new Manager();
		VicePresident vicePresident = new VicePresident();
		admin.setNext(manager);
		manager.setNext(vicePresident);

		ClaimRequest claim1 = new ClaimRequest("claim1", 500);
		admin.approveRequest(claim1);

		ClaimRequest claim2 = new ClaimRequest("claim2", 1500);
		admin.approveRequest(claim2);

		ClaimRequest claim3 = new ClaimRequest("claim3", 50000);
		admin.approveRequest(claim3);
	}
}
