package com.toy.home.biz;

import com.toy.home.dao.login_dao;
import com.toy.home.dao.login_daoimpl;
import com.toy.home.dto.login_dto;

public class login_bizimpl implements login_biz{
	
	login_dao dao = new login_daoimpl();

	@Override
	public login_dto login_chk(String user_id, String user_pw) {
		return dao.login_chk(user_id, user_pw);
	}
	
}
