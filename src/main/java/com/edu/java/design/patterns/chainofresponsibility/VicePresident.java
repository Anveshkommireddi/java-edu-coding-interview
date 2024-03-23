package com.edu.java.design.patterns.chainofresponsibility;

public class VicePresident implements Approver {

	@Override
	public void approveRequest(ClaimRequest claimRequest) {
		System.out.println(
				"claimRequest is approved by vice president for the amount " + claimRequest.getClaimAmount() + ".");
	}

}
