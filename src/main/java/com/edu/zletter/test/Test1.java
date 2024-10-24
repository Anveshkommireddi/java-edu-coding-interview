package com.edu.zletter.test;

public class Test1 {
	
	public static void main(String[] args) {
		User user = User.builder().userName("anvesh").userId(123).build();
		System.out.println(user.getName());
		System.out.println(user.getId());
	}

}
