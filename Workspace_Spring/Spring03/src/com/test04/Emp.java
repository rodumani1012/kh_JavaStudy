package com.test04;


public class Emp {

	private String name;
	private String salary;
	
	public Emp() {
		
	}
	public Emp(String name, String salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String toString() {
		return name + " \t " + salary;
	}
}
