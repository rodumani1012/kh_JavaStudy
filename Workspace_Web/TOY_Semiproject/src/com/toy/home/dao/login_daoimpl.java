package com.toy.home.dao;

import java.util.HashMap;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.toy.db.sql_map_config;
import com.toy.home.dto.user_info_dto;

public class login_daoimpl extends sql_map_config implements login_dao {

	private String namespace = "home.mapper.";

	@Override
	public user_info_dto login_chk(String user_id, String user_pw) {

		user_info_dto dto = null;

		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);

		SqlSession session = null;
		session = getSqlSessionFactory().openSession();

		dto = session.selectOne(namespace + "login_chk", map);

		return dto;
	}

	@Override
	public int insert(user_info_dto dto) {
		int res = 0;

		SqlSession session = null;

		session = super.getSqlSessionFactory().openSession();

		res = session.insert(namespace + "signup", dto);

		session.commit();
		session.close();

		return res;
	}

	@Override
	public user_info_dto id_check(String id) {
		user_info_dto dto = null;

		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", id);

		System.out.println("아이디 유효성 검사중");

		SqlSession session = null;

		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace + "id_chk", map);

		return dto;
	}

	@Override
	public user_info_dto nick_check(String nickname) {
		user_info_dto dto = null;

		Map<String, String> map = new HashMap<String, String>();
		map.put("user_nickname", nickname);

		System.out.println("닉네임 유효성 검사중");

		SqlSession session = null;

		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace + "nick_chk", map);

		return dto;
	}

	@Override
	public user_info_dto login_chk_sns(String id) {
		SqlSession session = null;

		user_info_dto dto = new user_info_dto();
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", id);

		session = getSqlSessionFactory().openSession();

		dto = session.selectOne(namespace + "login_chk_sns", map);

		return dto;
	}

	@Override
	public boolean regist_chk(String id) {
		boolean temp = false;

		user_info_dto dto = new user_info_dto();

		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", id);

		SqlSession session = null;

		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace + "regist_chk", map);

		if (dto == null) { // db에 sns id가 없다면
			temp = true;
		} else {
			temp = false;
		}

		return temp;
	}

	@Override
	public int regist_sns(user_info_dto dto) {
		int res = 0;

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(false);

			res = session.insert(namespace + "regist_sns", dto);

			if (res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	@Override
	public int update_user_info(user_info_dto dto) {
		int res = 0;

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(false);

			res = session.update(namespace + "update_user_info", dto);

			if (res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update_user_pw(user_info_dto dto) {
		int res = 0;

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(false);

			res = session.update(namespace + "update_user_pw", dto);

			if (res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int member_withdraw(user_info_dto dto) {
		int res = 0;

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(false);

			res = session.delete(namespace + "member_withdraw", dto);

			if (res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public user_info_dto find_id(String name, String nickname) {
		System.out.println("이메일 가져오기");
		System.out.println(name +" "+nickname);
		user_info_dto dto = new user_info_dto();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_name", name);
		map.put("user_nickname", nickname);
		
		System.out.println(map);
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace+"bring_byname",map);
		
		System.out.println(dto);
			
		return dto;
	}

	@Override
	public user_info_dto find_pw(String name, String id) {
		System.out.println("이메일 가져오기");
		System.out.println(name +" "+id);
		user_info_dto dto = new user_info_dto();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_name", name);
		map.put("user_id", id);
		
		System.out.println(map);
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace+"bring_byid",map);
		
		System.out.println(dto);
			
		return dto;
	}
	
	@Override
	public int change_pw(String password, String id) {
		int res = 1;

		SqlSession session = null;

		try {
			session = super.getSqlSessionFactory().openSession();

			Map<String, String> map = new HashMap<String, String>();
			map.put("user_password", password);
			map.put("user_id", id);

			res = session.insert(namespace + "change_pw", map);

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return res;
	}

}