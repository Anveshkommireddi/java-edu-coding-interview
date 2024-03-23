package com.edu.java.design.patterns.builder;

public class User {

	private final String firstName;
	private final String lastName;
	private final int age;
	private final String email;
	private final String phoneNumber;

	private User(Builder userBuilder) {
		this.firstName = userBuilder.firstName;
		this.lastName = userBuilder.lastName;
		this.age = userBuilder.age;
		this.email = userBuilder.email;
		this.phoneNumber = userBuilder.phoneNumber;
	}

	public static Builder builder() {
		return new Builder();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	static class Builder {

		private String firstName;
		private String lastName;
		private int age;
		private String email;
		private String phoneNumber;

		private Builder() {
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public User build() {
			return new User(this);
		}

	}

}
