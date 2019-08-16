package com.test05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("yu")
public class Developer {

	@Autowired
	@Qualifier("yuDept")
	private String dept;
	@Autowired
	@Qualifier("emp_yu")
	private Emp emp;
	
	public Developer() {
	}
	
	public Developer(String dept, Emp emp) {
	}
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return dept + " \t " + emp;
	}
	
	
}
