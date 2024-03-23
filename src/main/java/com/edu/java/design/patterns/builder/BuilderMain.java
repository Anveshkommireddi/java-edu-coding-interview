package com.edu.java.design.patterns.builder;

public class BuilderMain {

	public static void main(String[] args) {
		User user = User.builder().firstName("Naga Anvesh").lastName("Kommireddi").age(28)
				.email("nagaanvesh.kommireddi@gmail.com").phoneNumber("9666682391").build();
		System.out.println(user.getFirstName()); // John
		System.out.println(user.getLastName()); // Doe
		System.out.println(user.getAge()); // 30
		System.out.println(user.getEmail()); // john.doe@example.com
		System.out.println(user.getPhoneNumber()); // 1234567890
	}

}
