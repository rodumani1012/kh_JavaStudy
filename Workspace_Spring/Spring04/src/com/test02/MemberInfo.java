package com.test02;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class MemberInfo implements MessageSourceAware {

	private MessageSource message;
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("컨테이너가 메세지 설정을 수행중...");
		this.message = messageSource;
	}
	
	// applicationContext에서 전달되어 setMessageSource()에서 처리된 것을 
	// 보기위해 만든 메소드
	public void display(Locale locale) {
		String name = message.getMessage("member.name", null, locale);
		String birthplace = message.getMessage("member.birthplace", null, locale);
		String hobby = message.getMessage("member.hobby", null, locale);
		String age = message.getMessage("member.age", new Object[] {"13"}, locale);
		
		System.out.println(locale);
		System.out.println(name);
		System.out.println(birthplace);
		System.out.println(hobby);
		System.out.println(age);
	}

}
