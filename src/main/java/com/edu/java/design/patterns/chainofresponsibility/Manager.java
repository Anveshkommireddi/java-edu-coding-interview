package com.edu.java.design.patterns.chainofresponsibility;

public class Manager implements Approver {

	private Approver next;

	@Override
	public void approveRequest(ClaimRequest claimRequest) {

		if (claimRequest.getClaimAmount() <= 5000) {
			System.out.println(
					"claimRequest is approved by manager for the amount " + claimRequest.getClaimAmount() + ".");
			return;
		}

		next.approveRequest(claimRequest);
	}

	public void setNext(Approver next) {
		this.next = next;
	}

}
