package com.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.MyBoardDto;
import com.template.JDBCTemplate;

public class MyBoardDao extends JDBCTemplate {

	public List<MyBoardDto> selectAll() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM MYBOARD ORDER BY MYNO DESC ";
		
		List<MyBoardDto> res = new ArrayList<MyBoardDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("03.쿼리 준비");
			
			rs = pstm.executeQuery();
			System.out.println("04.쿼리 실행 및 리턴");
			
			while(rs.next()) {
				MyBoardDto dto = new MyBoardDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyname(rs.getString(2));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString(4));
				dto.setMydate(rs.getDate(5));
				
				res.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("03, 04 단계 실패");
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}		
		return res;
	}
	
	public MyBoardDto selectOne(int myno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyBoardDto dto = new MyBoardDto();
		String sql = " SELECT * FROM MYBOARD WHERE MYNO=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("03.쿼리 준비");
			
			rs = pstm.executeQuery();
			System.out.println("04.쿼리 실행 및 리턴");
			
			while(rs.next()) {
				dto.setMyno(rs.getInt("MYNO"));
				dto.setMyname(rs.getString(2));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString(4));					
			}
		} catch (SQLException e) {
			System.out.println("03, 04 단계 실패");
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}		
		return dto;
	}
	
	public int insert(MyBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO MYBOARD VALUES(MYSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("03.쿼리 준비");
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			
			res = pstm.executeUpdate();			
			System.out.println("04.쿼리 실행 및 리턴");

			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			System.out.println("03, 04 단계 실패");
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}		
		return res;
	}
	
	public int update(MyBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE MYBOARD SET MYTITLE = ?, MYCONTENT = ? WHERE MYNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("03.쿼리 준비");
			pstm.setString(1, dto.getMytitle());
			pstm.setString(2, dto.getMycontent());
			pstm.setInt(3, dto.getMyno());
			
			res = pstm.executeUpdate();
			System.out.println("04.쿼리 실행 및 리턴");		

			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			System.out.println("03, 04 단계 실패");
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}		
		return res;
	}
	
	public int delete(MyBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " DELETE FROM MYBOARD WHERE MYNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("03.쿼리 준비");
			pstm.setInt(1, dto.getMyno());
			
			res = pstm.executeUpdate();
			System.out.println("04.쿼리 실행 및 리턴");					
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			System.out.println("03, 04 단계 실패");
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}		
		return res;
	}
}
