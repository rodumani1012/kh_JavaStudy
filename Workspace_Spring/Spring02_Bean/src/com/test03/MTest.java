package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		// 생성자는 new 연산자와 같이 사용되어 클래스로부터 객체를 생성할 때 호출되어 
		// 객체의 초기화를 담당한다.
//		IOC컨테이너. 경로에 있는 xml파일을 읽어서 IOC컨테이너를 만들자
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		UserDto dto = (UserDto) factory.getBean("myDto");
		System.out.println(dto.getPer());
		System.out.println(dto.getMyDate());
		System.out.println(dto.getUserName());
		
		UserService service = factory.getBean("myService", UserService.class);
		service.addUser(dto);
	}
}
