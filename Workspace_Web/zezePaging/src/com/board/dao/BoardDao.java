package com.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.board.db.SqlMapConfig;
import com.board.dto.BoardDto;

public class BoardDao extends SqlMapConfig {

	String namespace = "board.mapper.";
	SqlMapConfig sqlmapconfig = new SqlMapConfig();

	public int getTotalCount() {
		int cnt = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			cnt = session.selectOne(namespace + "getTotalCount");
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	public List<BoardDto> selectList(int begin, int end) {
		SqlSession session = null;
		
		List<BoardDto> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		map.put("begin", begin);
		map.put("end", end);

		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace + "selectList", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}
	
	public int insertData() {
		int res =0;
		SqlSession session = null;
		Map<String,Character> map = new HashMap<>();
		char Data = (char)((int)(Math.random()*26)+65);
		map.put("data",Data);
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"insertData",map);
			if(res>0) {
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

}
