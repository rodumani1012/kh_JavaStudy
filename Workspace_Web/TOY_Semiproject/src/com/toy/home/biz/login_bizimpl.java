package com.toy.home.biz;

import com.toy.home.dao.login_dao;
import com.toy.home.dao.login_daoimpl;
import com.toy.home.dto.user_info_dto;

public class login_bizimpl implements login_biz{
	
	login_dao dao = new login_daoimpl();

	@Override
	public user_info_dto login_chk(String user_id, String user_pw) {
		return dao.login_chk(user_id, user_pw);
	}

	@Override
	public int insert(user_info_dto dto) {
		
		return dao.insert(dto);
	}

	@Override
	public user_info_dto id_check(String id) {
		return dao.id_check(id);
	}

	@Override
	public user_info_dto nick_check(String nickname) {
		return dao.nick_check(nickname);
	}

	@Override
	public user_info_dto login_chk_sns(String id) {
		return dao.login_chk_sns(id);
	}

	@Override
	public boolean regist_chk(String id) {
		return dao.regist_chk(id);
	}

	@Override
	public int update_user_info(user_info_dto dto) {
		return dao.update_user_info(dto);
	}

	@Override
	public int update_user_pw(user_info_dto dto) {
		return dao.update_user_pw(dto);
	}

	@Override
	public int member_withdraw(user_info_dto dto) {
		return dao.member_withdraw(dto);
	}

	@Override
	public int regist_sns(user_info_dto dto) {
		return dao.regist_sns(dto);
	}

	@Override
	public user_info_dto find_id(String name, String nickname) {
		return dao.find_id(name, nickname);
	}

	@Override
	public user_info_dto find_pw(String name, String id) {
		return dao.find_pw(name,id);
	}

	@Override
	public int change_pw(String password, String id) {
		return dao.change_pw(password, id);
	}
	
}
