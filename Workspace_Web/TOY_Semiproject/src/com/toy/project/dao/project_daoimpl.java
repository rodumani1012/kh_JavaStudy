package com.toy.project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.toy.db.sql_map_config;
import com.toy.home.dto.user_info_dto;
import com.toy.project.dto.prj_info_dto;
import com.toy.project.dto.prj_issue_dto;

public class project_daoimpl extends sql_map_config implements project_dao {

	String namespace = "project.mapper.";
	
	@Override
	public int prj_new(String prj_name, int user_num, String prj_loc, String user_nickname) {

		int res = 1;

		SqlSession session = null;

		try {
			session = super.getSqlSessionFactory().openSession();

			Map<String, String> map = new HashMap<String, String>();
			map.put("prj_name", prj_name);
			map.put("prj_loc", prj_loc);
			map.put("user_nickname", user_nickname);

			res *= session.insert(namespace + "project_new", map);
			res *= session.insert(namespace + "project_new_in_user", user_num);
			res *= session.insert(namespace + "project_new_board1");
			res *= session.insert(namespace + "project_new_board2");
			res *= session.insert(namespace + "project_new_board3");

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return res;
	}

	@Override
	public List<prj_info_dto> prj_list(int user_num) {

		SqlSession session = null;

		session = super.getSqlSessionFactory().openSession();

		List<prj_info_dto> list = session.selectList(namespace + "project_list", user_num);

		return list;
	}

	@Override
	public List<prj_info_dto> prj_board(int prj_num) {
		
		SqlSession session = null;
		session = super.getSqlSessionFactory().openSession();
		
		List<prj_info_dto> list = session.selectList(namespace+"project_board",prj_num);
		
		return list;
	}
	
	@Override
	public user_info_dto nick_check(String nickname) {
		user_info_dto dto = new user_info_dto();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_nickname", nickname);
		
		System.out.println("닉네임 검사중");
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace+"nick_chk",map);
		
		System.out.println("map:"+map);
			
		return dto;
	}

	@Override
	public user_info_dto bring_email(String nickname) {
		System.out.println("이메일 가져오기");
		user_info_dto dto = new user_info_dto();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_nickname", nickname);
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace+"bring_bynick",map);
		
		System.out.println(dto);
			
		return dto;
	}

	@Override
	public user_info_dto bring_nick(int user_num) {
		System.out.println("닉네임 가져오기");
		System.out.println(user_num);
		user_info_dto dto = new user_info_dto();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("user_num", user_num);
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace+"bring_bynum",map);
		
		System.out.println(map);
		System.out.println(dto);
			
		return dto;
	}


	@Override
	public int prj_issue_insert(prj_issue_dto dto) {
		SqlSession session = null;
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession();
			res = session.insert(namespace + "project_issue_insert", dto);
			if (res>0) {
				session.commit();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int issue_new(Map<String, String> map) {
		int res = 0;
		SqlSession session = null;
		try {
			session = super.getSqlSessionFactory().openSession();
			res = session.insert(namespace + "issue_new", map);
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return res;

	}

	@Override
	public List<prj_issue_dto> prj_issue_list(int prj_num) {
		SqlSession session = null;
		session = super.getSqlSessionFactory().openSession();

		List<prj_issue_dto> list = session.selectList(namespace + "issue_list", prj_num);

		return list;
	}
	

	@Override
	public user_info_dto bring_num(String nickname) {
		System.out.println("회원번호 가져오기");
		user_info_dto dto = new user_info_dto();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_nickname", nickname);
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace+"bring_bynick",map);
		
		System.out.println(dto);
		
		return dto;
	}
	
	@Override
	public prj_info_dto bring_prj(String prj_name, int user_num) {
		System.out.println("프로젝트 번호 가져오기");
		System.out.println(prj_name);
		System.out.println(user_num);
		prj_info_dto dto = new prj_info_dto();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prj_name", prj_name);
		map.put("user_num", user_num);
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace+"bring_prj",map);
		
		System.out.println(map);
		System.out.println(dto);
			
		return dto;
	}
	
	@Override
	public int insert_user(int prj_num, int invite_num) {

		int res = 0;

		SqlSession session = null;

		try {
			session = super.getSqlSessionFactory().openSession();

			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("user_num", invite_num);
			map.put("prj_num", prj_num);

			res = session.insert(namespace + "insert_user", map);

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return res;
	}

	@Override
	public int board_new(Map<String, String> map) {

		int res = 0;
		SqlSession session = null;
		try {
			session = super.getSqlSessionFactory().openSession();
			res = session.insert(namespace + "board_new", map);
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return res;
	}

	@Override
	public int board_move(Map<String, Integer> map) {

		int res = 0;
		SqlSession session = null;

		try {
			session = super.getSqlSessionFactory().openSession();
			res *= session.update(namespace + "board_move_after", map);
			res *= session.update(namespace + "board_move_before", map);
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return res;
	}

	@Override
	public prj_info_dto prj_selectOne(int prj_num) {
		prj_info_dto dto = new prj_info_dto();

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("prj_num", prj_num);

		SqlSession session = null;

		session = getSqlSessionFactory().openSession();

		dto = session.selectOne(namespace + "project_show", map);

		return dto;
		
	}

	@Override
	public int prj_update(prj_info_dto dto) {
		SqlSession session = null;
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession();
			res = session.update(namespace + "project_update", dto);
			
			if(res>0) {
				session.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int prj_delete(int prj_num) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.delete(namespace + "project_delete", prj_num);
			if(res>0) {
				session.commit();
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	@Override
	public Map<String, String> issue_one(int issue_num) {
		
		SqlSession session = null;
		
		session = super.getSqlSessionFactory().openSession();
		Map<String, String> map = session.selectOne(namespace+"issue_one", issue_num);
		
		return map;
	}

	@Override
	public int issue_update(Map<String, String> map) {
		
		int res = 0;
		
		SqlSession session = null;
		try {
			session = super.getSqlSessionFactory().openSession();
			res = session.insert(namespace+"issue_"+map.get("column"), map);
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		
		return res;
	}

	@Override
	public int issue_del(int issue_num) {
		
		int res = 0;
		
		SqlSession session = null;
		
		try {
			session = super.getSqlSessionFactory().openSession();
			res = session.delete(namespace+"issue_del", issue_num);
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
