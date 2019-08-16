package com.hello.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloBiz {

	@Autowired
	private HelloDao dao;
	
	public String getHello() {
		// TODO : 06.dao.getHello();
		return dao.getHello() + ", Spring";
		// TODO : 08.dao에서 return 받은 값 다시 return
	}
	
}
