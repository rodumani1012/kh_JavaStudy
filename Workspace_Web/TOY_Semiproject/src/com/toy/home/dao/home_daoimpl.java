package com.toy.home.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.toy.db.sql_map_config;
import com.toy.home.dto.comment_board_dto;
import com.toy.home.dto.normal_board_dto;
import com.toy.project.dto.prj_info_dto;

public class home_daoimpl extends sql_map_config implements home_dao {
	private String namespace = "home.mapper.";

	@Override
	public List<normal_board_dto> selectList(String normal_category,int firstIndex, int recordCountPerPage,String txt_search) {

		SqlSession session = null;

		session = getSqlSessionFactory().openSession();

		Map<String, String> map = new HashMap<String, String>();
		map.put("normal_category", normal_category);
		map.put("firstIndex", String.valueOf(firstIndex) );
		map.put("recordCountPerPage", String.valueOf(recordCountPerPage) );
		map.put("txt_search", txt_search );

		List<normal_board_dto> list = session.selectList("home.mapper.selectList", map);

		return list;

	}

	@Override
	public normal_board_dto selectOne(int normal_num) {
		normal_board_dto dto = new normal_board_dto();

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("normal_num", normal_num);

		SqlSession session = null;

		session = getSqlSessionFactory().openSession();

		dto = session.selectOne(namespace + "selectOne", map);

		return dto;

	}

	@Override
	public int insert(Map<String, String> map) {
		SqlSession session = null;
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "insertSql", map);

			if (res > 0) {
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
	public int update(normal_board_dto dto) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace + "updateSql", dto);

			if (res > 0) {
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
	public int delete(int normal_num) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace + "deleteSql", normal_num);
			if (res > 0) {
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
	public void plusReadCount(int normal_num) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace + "plusReadCount", normal_num);
			if (res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public int comment_insert(Map<String, String> map) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "comment_insert", map);
			if (res > 0) {
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
	public List<comment_board_dto> comment_list(int normal_num) {
		SqlSession session = null;

		session = getSqlSessionFactory().openSession();
		List<comment_board_dto> list = session.selectList(namespace + "comment_list", normal_num);

		return list;

	}

	@Override
	public int comment_comment(Map<String, String> map) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession();
			res = session.insert(namespace + "comment_comment", map);
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
	public int comment_delete(int comment_num) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "comment_delete", comment_num);
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
	public int selectTotalCount(String normal_category,String txt_search) {
		SqlSession session = null;
		int res =0;
		//res = session.selectOne ("home.mapper.selectTotalCount", normal_category);
		Map<String, String> map = new HashMap<String, String>();
		map.put("normal_category", normal_category);
		map.put("txt_search", txt_search);
		
		session = getSqlSessionFactory().openSession();
		//dto = session.selectOne (namespace + "selectTotalCount", map);
		res = session.selectOne (namespace + "selectTotalCount", map);
		return res;
	}

	@Override
	public List<normal_board_dto> small_selectList(String normal_category) {
		
		SqlSession session = null;

		session = getSqlSessionFactory().openSession();

		Map<String, String> map = new HashMap<String, String>();
		map.put("normal_category", normal_category);

		List<normal_board_dto> list = session.selectList("home.mapper.small_selectList", map);

		return list;
	}

	@Override
	public List<prj_info_dto> small_prj_selectList() {
		SqlSession session = null;

		session = getSqlSessionFactory().openSession();

		List<prj_info_dto> list = session.selectList("home.mapper.small_prj_selectList");

		return list;
	}

	@Override
	public int kakaopay(normal_board_dto dto) {
		SqlSession session = null;
		
	
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession();
			res = session.update(namespace + "kakaopay", dto);

			if (res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
		
	}

}