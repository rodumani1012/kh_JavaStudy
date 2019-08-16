package com.bike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.bike.dto.BikeDto;

import common.JDBCTemplate;

public class BikeDao extends JDBCTemplate {

	public int insert(List<BikeDto> dtos) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO BIKE_DB VALUES(?, ?, ?, ?, ?, ?, ?) ";

		int[] cnt = null;

		try {
			pstm = con.prepareStatement(sql);

			for (int i = 0; i < dtos.size(); i++) {
				BikeDto dto = dtos.get(i);

				pstm.setString(1, dto.getAddr_gu());
				pstm.setInt(2, dto.getContent_id());
				pstm.setString(3, dto.getContent_nm());
				pstm.setString(4, dto.getNew_addr());
				pstm.setInt(5, dto.getCradle_count());
				pstm.setDouble(6, dto.getLongitude());
				pstm.setDouble(7, dto.getLatitude());

				pstm.addBatch(); // 적재!!
			}
			System.out.println("03.query 준비");

			cnt = pstm.executeBatch(); // 결과는 -2 또는 -3
			System.out.println("04.query 실행 및 리턴");

			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] == -2) { // -2는 성공, -3은 실패
					res++;
				}
			}
			if (res == dtos.size()) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("03/04 실행 오류");
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("05.db 종료");
		}
		return res;
	}
	
	public int delete() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = " DELETE FROM BIKE_DB WHERE CONTENT_ID = ? ";
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
//			pstm.setInt(1, );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
	}
}
