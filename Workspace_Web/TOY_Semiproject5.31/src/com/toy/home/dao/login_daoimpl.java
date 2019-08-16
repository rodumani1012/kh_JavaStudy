package com.toy.home.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.toy.home.db.sql_map_config;
import com.toy.home.dto.login_dto;

public class login_daoimpl extends sql_map_config implements login_dao {

	private String namespace = "mvc.mapper.";

	@Override
	public login_dto login_chk(String user_id, String user_pw) {

		login_dto dto = null;

		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);

		SqlSession session = null;
		session = getSqlSessionFactory().openSession();

		dto = session.selectOne(namespace + "login_chk", map);
		
		return dto;
	}

}
