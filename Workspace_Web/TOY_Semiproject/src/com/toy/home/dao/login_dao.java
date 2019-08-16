package com.toy.home.dao;

import com.toy.home.dto.user_info_dto;

public interface login_dao {
	
	public user_info_dto login_chk(String id, String pw);

	public int insert(user_info_dto dto);
	
	public user_info_dto id_check(String id);
	
	public user_info_dto nick_check(String nickname);
	
	public user_info_dto login_chk_sns(String id);
	
	public boolean regist_chk(String id);
	
	public int regist_sns(user_info_dto dto);
	
	public int update_user_info(user_info_dto dto);
	
	public int update_user_pw(user_info_dto dto);
	
	public int member_withdraw(user_info_dto dto);
	
	public user_info_dto find_id(String name, String nickname);
	
	public user_info_dto find_pw(String name, String id);
	
	public int change_pw(String password, String id);
	
}
