package com.test05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("kang")
public class Engineer {

	@Autowired
	@Qualifier("kangDept")
	private String dept;
	@Autowired
	@Qualifier("emp_kang")
	private Emp emp;
	public Engineer() {
	}
	public Engineer(String dept, Emp emp) {
		super();
		this.dept = dept;
		this.emp = emp;
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
