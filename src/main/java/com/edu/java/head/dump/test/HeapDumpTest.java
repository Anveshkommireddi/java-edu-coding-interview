package com.edu.java.head.dump.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HeapDumpTest {
	public static void main(String[] args) throws InterruptedException {
		List<String> data = new ArrayList<>();
		int idx = 1;
		while (true) {
			String currVal = "This is string number " + idx++;
			data.add(currVal);
			System.out.println(currVal);
			Thread.sleep(Duration.ofMillis(100l));
		}
	}
}
