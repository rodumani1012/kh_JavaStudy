package com.test05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

	// pointcut으로 사용할 empty method
	// myClass라는 이름으로 별칭을 줘서 before와 after에 사용함.
	@Pointcut("execution(public * *(..))")
	public void myClass() {
		
	}
	
	@Before("myClass()")
	public void before(JoinPoint join) {
		System.out.println("출석체크");
	}
	
	@After("myClass()")
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
}
