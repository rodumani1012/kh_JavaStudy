package com.test06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	// pointcut으로 사용할 empty method
	// myClass라는 이름으로 별칭을 줘서 before와 after에 사용함.
//	@Pointcut("execution(public * *(..))")
//	public void myClass() {}
	
//	@Before("myClass()")
//	public void before(JoinPoint join) {
//		System.out.println("출석체크");
//	}
	
//	@After("myClass()")
//	public void after(JoinPoint join) {
//		System.out.println("집에 간다.");
//	}
	
	// @Before : 타겟이 연결되기 전(before)에 연결해주세요.
	@Before("execution(public void Man.classWork(..))")
	public void before(JoinPoint join) {
		System.out.println("출석체크");
	}

	@After("execution(public void Woman.*())")
	public void after(JoinPoint join) {
		System.out.println("집에 간다");
	}
	
}
