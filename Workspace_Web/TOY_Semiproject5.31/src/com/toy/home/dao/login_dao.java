package com.toy.home.dao;

import com.toy.home.dto.login_dto;

public interface login_dao {
	
	public login_dto login_chk(String id, String pw);

}
