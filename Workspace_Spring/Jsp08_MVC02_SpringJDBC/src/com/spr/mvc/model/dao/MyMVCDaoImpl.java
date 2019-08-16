package com.spr.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spr.mvc.model.dto.MyMVCDto;

@Repository
public class MyMVCDaoImpl implements MyMVCDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<MyMVCDto> selectList() {
		List<MyMVCDto> list = jdbcTemplate.query(selectListSql,
				new RowMapper<MyMVCDto>() {//객체 생성해서 바로 넣는 방식
					@Override
					public MyMVCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
						MyMVCDto dto = new MyMVCDto();
						dto.setSeq(rs.getInt(1));
						dto.setWriter(rs.getString(2));
						dto.setTitle(rs.getString(3));
						dto.setContent(rs.getString(4));
						dto.setRegdate(rs.getDate(5));
						
						return dto;
						// 생성된 dto를 list로 반환해준다.
					} 
		});
		
		return list;
	}

	@Override
	public MyMVCDto selectOne(int seq) {
		MyMVCDto dto = jdbcTemplate.queryForObject(selectOneSql, 
				 new Object[] {seq}, new MyMapper());
		return dto;
	}

	@Override
	public int insert(MyMVCDto dto) {
//		int res = jdbcTemplate.update("INSERT INTO MYMVCBOARD VALUES(MYMVCBOARDSEQ.NEXTVAL, ?, ?, ?,SYSDATE)",
//				dto.getWriter(), dto.getTitle(), dto.getWriter());
		int res = 0;
		try {
			res = jdbcTemplate.update(insertSql, new Object[] {dto.getWriter(), dto.getTitle(), dto.getContent()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			return res;
		}
		return res;
	}

	@Override
	public int update(MyMVCDto dto) {
		
		int res = 0;
		try {
			res = jdbcTemplate.update(updateSql, new Object[] {dto.getTitle(), dto.getContent(), dto.getSeq()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			return res;
		}
		return res;
	}

	@Override
	public int delete(int seq) {
		
		int res = jdbcTemplate.update(deleteSql, seq);
		return res;
	}

	// inner class
	public static final class MyMapper implements RowMapper<MyMVCDto> {

		@Override
		public MyMVCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			MyMVCDto dto = new MyMVCDto();
			dto.setSeq(rs.getInt(1));
			dto.setWriter(rs.getString(2));
			dto.setTitle(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setRegdate(rs.getDate(5));
			
			return dto;
		}
		
	}

	@Override
	public int muldel(int[] seq) {
		int res = 0;

		List<Object[]> list = new ArrayList<Object[]>();
  
		for (int i : seq) {
		   list.add(new Object[] { i });
		}
		
		int count[] = jdbcTemplate.batchUpdate(deleteSql, list);
  
		for(int i : count) {
		   if(i == -2) {
			  res++;
		   }
		}
		return res;
	}
	
}
