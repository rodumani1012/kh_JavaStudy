package com.pc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.pc.dto.TimeDto;

import common.JDBCTemplate;

public class TimeDao extends JDBCTemplate {
	public int StartTimeUpdate(String id) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(System.currentTimeMillis());
		int hour = date.get(Calendar.HOUR);
		int min = date.get(Calendar.MINUTE);
		
		String sql = " UPDATE KHPC SET HOUR = ? , MIN = ? "
				+ " WHERE ID = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, hour);
			pstm.setInt(2, min);
			pstm.setString(3, id);
			
			res = pstm.executeUpdate();
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}
	
	public TimeDto StartTimeSelect(String id) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		TimeDto res = new TimeDto();
		
		String sql = " SELECT DAY, HOUR, MIN FROM KHPC WHERE ID = ? ";
		
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				res.setDate(rs.getInt(1));
				res.setHour(rs.getInt(2));
				res.setMin(rs.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		return res;
	}
	
	public TimeDto EndTimeUpdate() {
		TimeDto dto = new TimeDto();
		return dto;
	}
	
}
