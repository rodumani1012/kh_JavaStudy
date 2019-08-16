package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

	@Before("execution(public void com.test04.*.*(..))")
	public void before(JoinPoint join) {
		System.out.println("출석체크");
	}
	
	@AfterThrowing(pointcut = "execution(public * *(..))", throwing = "e")
	public void throwing(JoinPoint join) {
		System.out.println("쉬는 날이다.");
	}
	
	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
}
