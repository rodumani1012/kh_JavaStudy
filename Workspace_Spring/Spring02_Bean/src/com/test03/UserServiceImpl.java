package com.test03;

import org.springframework.stereotype.Component;

@Component("myService")
public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
		System.out.println("생성자 호출!");
	}

	@Override
	public void addUser(UserDto dto) {
		System.out.println("addUser 호출!" + dto.getUserName());
	}
	
	
}
