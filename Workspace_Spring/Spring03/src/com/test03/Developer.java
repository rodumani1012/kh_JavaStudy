package com.test03;

public class Developer extends Emp {
	
	private String dept;
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public Developer() {
		
	}
	
	public Developer(String name, int salary) {
		super(name, salary);
	}
	
	@Override
	public String toString() {
		return super.toString() + " \t " + dept;
	}
}
