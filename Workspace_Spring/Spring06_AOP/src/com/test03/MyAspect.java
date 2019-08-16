package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {

	public void before(JoinPoint join) {
		System.out.println("출석체크");
	}
	
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
}
