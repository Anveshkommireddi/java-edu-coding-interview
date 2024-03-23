package com.edu.java.misc;

public class Employee {
	
	private int empNum;
	
	private String name;
	
	public Employee(int empNum, String name) {
		this.empNum = empNum;
		this.name = name;
	}

	public int getEmpNum() {
		return empNum;
	}

	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [empNum=" + empNum + ", name=" + name + "]";
	}
	
}
