package com.edu.zletter.test;

public class User {

	private final String name;

	private final int id;

	private User(Builder builder) {
		this.name = builder.name;
		this.id = builder.id;
	}

	public static Builder builder() {
		return new Builder();
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	static class Builder {

		private String name;
		private int id;

		private Builder() {
		}

		public Builder userName(String name) {
			this.name = name;
			return this;
		}

		public Builder userId(int id) {
			this.id = id;
			return this;
		}

		public User build() {
			return new User(this);
		}

	}
}
