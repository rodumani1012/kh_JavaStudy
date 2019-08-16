package com.test04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Engineer {

	@Autowired
	@Qualifier("kangDept")
	private String dept;
	@Autowired
	@Qualifier("kangEmp")
	private Emp emp;
	
	public Engineer() {
		
	}
	
	public Engineer(String dept, Emp emp) {
		this.dept = dept;
		this.emp = emp;
	}

	@Override
	public String toString() {
		return emp + " \t " + dept;
	}
}
