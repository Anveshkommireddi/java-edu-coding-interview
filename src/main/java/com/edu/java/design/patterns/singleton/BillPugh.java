package com.edu.java.design.patterns.singleton;

public class BillPugh {

	private BillPugh() {
	}

	public static BillPugh getInstance() {
		return BillPughHelper.SINGLETON;
	}

	private static class BillPughHelper {
		private static final BillPugh SINGLETON = new BillPugh();
	}

}
