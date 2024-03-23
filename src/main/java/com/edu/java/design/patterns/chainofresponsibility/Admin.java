package com.edu.java.design.patterns.chainofresponsibility;

public class Admin implements Approver {

	private Approver next;

	@Override
	public void approveRequest(ClaimRequest claimRequest) {
		if (claimRequest.getClaimAmount() <= 1000) {
			System.out
					.println("claimRequest is approved by admin for the amount " + claimRequest.getClaimAmount() + ".");
			return;
		}

		next.approveRequest(claimRequest);
	}

	public void setNext(Approver next) {
		this.next = next;
	}

}
