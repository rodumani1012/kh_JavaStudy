package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// beans.xml 의 값을 가져오는 방식 3가지
		
		// 1. 기존 방식(구식이라 안씀)
		// Resource res = new FileSystemResource("src/com/test03/beans.xml");
		
		// 2.
		// Resource res = new ClassPathResource("com/test03/beans.xml");
		// BeanFactory factory = new XmlBeanFactory(res);
		
		// 3. 
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		MessageBean bean01 = (MessageBean) factory.getBean("bean01");
		bean01.sayHello("Spring");
		
		MessageBean bean02 = (MessageBean) factory.getBean("bean02");
		bean02.sayHello("스프링");
	}
}

/*
	1. ApplicationContext (ClassPathXmlApplicationContext)
	
	BeanFactory <- ApplicationContext <- ClassPathXmlApplicationContext
	
	ApplicationContext : 스프링 컨테이너의 인스턴스
	ClassPathXmlApplicationContext : Xml 형식의 독립형 어플리케이션
		지정된 classpath에서 ~~.xml을 읽어서 생성
		
	2. contents, context, container 의 차이점
	contents : 내용, 기능
	context : 기능 구현을 위한 정보(설명)
	container : contents와 context를 담고있는 객체
*/
