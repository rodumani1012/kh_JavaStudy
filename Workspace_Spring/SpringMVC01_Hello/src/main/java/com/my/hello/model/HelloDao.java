package com.my.hello.model;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {

	public String getHello() {
		return "Hello";
	}
}
