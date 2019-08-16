package com.mvc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mvc.db.SqlMapConfig;
import com.mvc.dto.MyMVCDto;

public class MyMVCDaoImpl extends SqlMapConfig implements MyMVCDao {

	private String namespace = "mvc.mapper.";

	@Override
	public List<MyMVCDto> selectList() {
		// JDBCTemplate 에서 getConnection과 같은 역할
		String resource = "com/mvc/db/mvc-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<MyMVCDto> list = null;
		SqlSession session = null;
		try {
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			session = sqlSessionFactory.openSession();

			list = session.selectList("mvc.mapper.selectList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public MyMVCDto selectOne(int seq) {

		MyMVCDto dto = new MyMVCDto();

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("seq", seq);
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace + "selectOne", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return dto;
	}

	@Override
	public int insert(MyMVCDto dto) {
		int res = 0;
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "insert",dto);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int update(MyMVCDto dto) {
		int res = 0;
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace + "update", dto);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int delete(int seq) {
		int res = 0;
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace + "deleteOne", seq);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

}
