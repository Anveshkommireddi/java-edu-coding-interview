package com.edu.java.design.patterns.chainofresponsibility;

public class ClaimRequest {

	private String id;

	private int claimAmount;

	public ClaimRequest(String id, int claimAmount) {
		this.id = id;
		this.claimAmount = claimAmount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(int claimAmount) {
		this.claimAmount = claimAmount;
	}

}
