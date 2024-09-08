package com.edu.java.kway.merge;

public class Holder {

	private int val;

	private int listIdx;

	private int valIdx;

	public Holder(int val, int listIdx, int valIdx) {
		this.val = val;
		this.listIdx = listIdx;
		this.valIdx = valIdx;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getListIdx() {
		return listIdx;
	}

	public void setListIdx(int listIdx) {
		this.listIdx = listIdx;
	}

	public int getValIdx() {
		return valIdx;
	}

	public void setValIdx(int valIdx) {
		this.valIdx = valIdx;
	}

}
