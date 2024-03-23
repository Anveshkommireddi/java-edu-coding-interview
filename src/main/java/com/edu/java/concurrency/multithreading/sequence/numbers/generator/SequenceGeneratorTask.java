package com.edu.java.concurrency.multithreading.sequence.numbers.generator;

public class SequenceGeneratorTask implements Runnable {

	NumbersGenerator numbersGenerator;
	int remainder;

	public SequenceGeneratorTask(NumbersGenerator numbersGenerator, int remainder) {
		this.numbersGenerator = numbersGenerator;
		this.remainder = remainder;
	}

	@Override
	public void run() {
		numbersGenerator.printNumbers(remainder);
	}

}
