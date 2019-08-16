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
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();

		List<MyMVCDto> list = session.selectList("mvc.mapper.selectList"); // 해당 맵퍼의 이름.메소드

		return list;
	}

	@Override
	public MyMVCDto selectOne(int seq) {

		MyMVCDto dto = new MyMVCDto();

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("seq", seq);
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace + "selectOne", map);

		return dto;
	}

	@Override
	public int insert(MyMVCDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MyMVCDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
