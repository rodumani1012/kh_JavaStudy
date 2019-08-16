package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MyMVCDto;

import common.JDBCTemplate;

public class MyMVCDaoImpl extends JDBCTemplate implements MyMVCDao {
	
	@Override
	public List<MyMVCDto> selectList() {
		Connection con = getConnection();
		System.out.println("01,02 계정 및 드라이버 연결");
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MyMVCDto> list = new ArrayList<MyMVCDto>();
		
		try {
			pstm = con.prepareStatement(selectListSql);
			System.out.println("03.query 준비 : " + selectListSql);
			rs = pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			while(rs.next()) {
				MyMVCDto dto = new MyMVCDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		return list;
	}

	@Override
	public MyMVCDto selectOne(int seq) {
		Connection con = getConnection();
		System.out.println("01,02 계정 및 드라이버 연결");
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyMVCDto dto = new MyMVCDto();
		
		try {
			pstm = con.prepareStatement(selectOneSql);
			pstm.setInt(1, seq);
			System.out.println("03.query 준비 : " + selectOneSql);
			rs = pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		return dto;
	}

	@Override
	public int insert(MyMVCDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(insertSql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			res = pstm.executeUpdate();
			if(res > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}
		return res;
	}

	@Override
	public int update(MyMVCDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(updateSql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			
			res = pstm.executeUpdate();
			if(res > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}
		return res;
	}

	@Override
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(deleteSql);
			pstm.setInt(1, seq);
			
			res = pstm.executeUpdate();
			if(res > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}
		return res;
	}

}
