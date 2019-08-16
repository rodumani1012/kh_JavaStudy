package com.test04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //bean 객체로 생성해준다. developer로 객체가 생성됨.
public class Developer {

	@Autowired
	@Qualifier("yuDept")
	private String dept;
	@Autowired //값을 자동으로 넣어준다
	@Qualifier("yuEmp") //이름을 찾아서
	private Emp emp;
	
	public Developer() {
		
	}
	
	public Developer(String dept, Emp emp) {
		this.dept = dept;
		this.emp = emp;
	}

	@Override
	public String toString() {
		return emp + " \t " + dept;
	}

}
