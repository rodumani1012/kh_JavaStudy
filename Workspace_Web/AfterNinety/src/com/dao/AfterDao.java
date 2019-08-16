package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.common.JDBCTemplate;
import com.dto.AfterDto;


public class AfterDao extends JDBCTemplate {

	// 로그인 하는 메소드
	public AfterDto loginCheck(String id, String pw) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		AfterDto dto = new AfterDto();
		String sql = " SELECT * FROM AFTER_USER WHERE ID = ? AND PW = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setRegdate(rs.getDate(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		return dto;
	}
	
	// 90일 체크하는 메소드
	public boolean checkNinety(AfterDto dto) throws SQLException {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int res = 0;
		String sql = " SELECT FLOOR(SYSDATE - ?) FROM AFTER_USER WHERE ID = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setDate(1, dto.getRegdate());
			pstm.setString(2, dto.getId());
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		
		if(res < 90) { // 변경한지 90일 미만
			return false;
		} else { // 변경한지 90일이 지남.
			return true;
		}
	}
}
