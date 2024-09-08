package com.edu.java.kway.merge;

public class Pair {
	
	private int sum;
	
	private int list1Idx;
	
	private int list2Idx;
	
	public Pair(int sum, int list1Idx, int list2Idx) {
		this.sum = sum;
		this.list1Idx = list1Idx;
		this.list2Idx = list2Idx;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getList1Idx() {
		return list1Idx;
	}

	public void setList1Idx(int list1Idx) {
		this.list1Idx = list1Idx;
	}

	public int getList2Idx() {
		return list2Idx;
	}

	public void setList2Idx(int list2Idx) {
		this.list2Idx = list2Idx;
	}

}
