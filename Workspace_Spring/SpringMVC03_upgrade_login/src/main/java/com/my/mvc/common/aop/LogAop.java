package com.my.mvc.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAop {
	
	// JoinPoint 파라미터는 꼭 필요한 것이 아님. 타겟에 대해 무언가를 할때 넣어주면 됨.
	public void before(JoinPoint join) {
		// syso는 자원을 많이 잡아먹기 때문에 덜 잡아먹는
		// Logger를 사용한다.
		
		// 타겟 앞에 찍기.
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("----------logger start----------");
		Object args[] = join.getArgs(); //타겟의 아규먼트를 가져옴.
		// args[] = {};
		System.out.println(Arrays.toString(args));
		
		if(args != null) {
			// selectOne, selectList, ...
			logger.info("Method : \t" + join.getSignature().getName());
			
			// 아큐먼트가 몇개 있는지 찍어보는 것
			// id, password, name, email, ...
			for(int i = 0; i < args.length; i++) {
				logger.info(i + "번째 : \t" + args[i]);
			}
		}
		/*
		 * join.getTarget() : 대상 객체를 리턴해줌.
		 *     .getArgs() : 대상 파라미터(아규먼트) 리턴
		 *     .getSignature() : 대상 메소드 정보를 리턴
		 */
	}
	

	public void after(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("----------logger end----------");
	}
	
	public void afterThrowing(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("ERROR : \t " + join.getArgs());
		logger.info("ERROR : \t " + join.toString());
	}
}
