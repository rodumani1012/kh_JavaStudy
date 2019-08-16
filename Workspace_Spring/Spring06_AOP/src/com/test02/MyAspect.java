package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

	//공통 관심사항 만들기.
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object returnVal = null;
		
		System.out.println("출석 체크");
		
		try {
			returnVal = invocation.proceed();
		} catch (Exception e) {
			System.out.println("쉬는 날이다.");
		}
		
		System.out.println("집에 간다.");
		
		return returnVal;
	}

}
