package com.generic;

public class Emp<T> {

	// <T> : type	
	private T empno;
	private String ename;
	
	public Emp() {
		
	}
	
	public Emp(T empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}
	
	public T getEmpno() {
		return empno;
	}
	public void setEmpno(T empno) {
		this.empno = empno;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	
}
