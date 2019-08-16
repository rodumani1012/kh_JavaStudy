package com.hello.mvc.model;

import org.springframework.stereotype.Repository;

@Repository // exception을 DataAccessException으로 변환해줌
public class HelloDao {

	public String getHello() {
		// TODO : 07.dao에서 return
		return "Hello"; //db에서 값을 가져왔다고 가정.
	}
}
