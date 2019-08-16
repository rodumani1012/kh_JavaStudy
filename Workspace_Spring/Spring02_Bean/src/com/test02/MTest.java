package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		JobAddress one = (JobAddress) factory.getBean("oneJob");
		System.out.println(one);
		
		// JobAddress.class로 뒤에 써주면 JobAddress로 자동 형변환 시켜준다.
		JobAddress parkJob = factory.getBean("parkJob", JobAddress.class);
		System.out.println(parkJob);
		
		System.out.println(parkJob.getAddr().getName() + "  " + parkJob.getJobName());
		
	}
}
