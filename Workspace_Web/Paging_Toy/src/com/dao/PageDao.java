package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.db.sql_map_config;
import com.dto.PagingDto;

public class PageDao extends sql_map_config{
	private String namespace = "page.mapper.";
	
	public List<PagingDto> selectList(String category,int firstIndex, int recordCountPerPage,String txt_search) {

		SqlSession session = null;

		session = getSqlSessionFactory().openSession();

		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("firstIndex", String.valueOf(firstIndex) );
		map.put("recordCountPerPage", String.valueOf(recordCountPerPage) );
		map.put("txt_search", txt_search );

		List<PagingDto> list = session.selectList(namespace + "selectList", map);

		return list;

	}
	
	public int selectTotalCount(String category,String txt_search) {
		SqlSession session = null;
		
		int res =0;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("txt_search", txt_search);
		
		session = getSqlSessionFactory().openSession();
		res = session.selectOne (namespace + "selectTotalCount", map);
		
		return res;
	}
	
	public int insert(String category) {
		
		int res = 0;
		
		SqlSession session = null;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		
		try {
			session = super.getSqlSessionFactory().openSession();
			res = session.insert(namespace+"insert", map);
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return res;
		
	}
	
	public int delete(String category) {
		
		int res = 0;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		
		SqlSession session = null;
		
		try {
			session = super.getSqlSessionFactory().openSession();
			res = session.insert(namespace+"delete", map);
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
