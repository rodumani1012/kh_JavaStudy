package com.test06;

public class BeanFactory {

	Object getBean(String beanName) {
		
		if (beanName.equals("Samsong")) {
			return new SamsongTv();
		} else if (beanName.equals("Ig")) {
			return new IgTv();
		}
		
		return null;
	}
}
