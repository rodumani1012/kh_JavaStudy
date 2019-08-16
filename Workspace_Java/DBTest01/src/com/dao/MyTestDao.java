package com.dao;

import static common.template.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.MyTestDto;

// DAO : Data Access Object
   // db와 연결하는 역할.
public class MyTestDao {
	
	private Connection con;
	
	public MyTestDao(Connection con) {
		this.con = con;
	}
	
	public List<MyTestDto> selectList() {
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MyTestDto> res = new ArrayList<MyTestDto>();
		String sql = " SELECT * FROM MYTEST " + " ORDER BY MNO ";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MyTestDto temp = new MyTestDto();
				temp.setMno(rs.getInt(1));
				temp.setMname(rs.getString(2));
				temp.setNickName(rs.getString(3));
				
				res.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return res;
	}
	
	public MyTestDto selectOne(int mno) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyTestDto res = new MyTestDto();
		
		String sql = " SELECT MNO, MNAME, NICKNAME FROM MYTEST WHERE MNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, mno);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				
				res.setMno(rs.getInt(1));
				res.setMname(rs.getString("MNAME"));
				res.setNickName(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public int insert(MyTestDto dto) {
		PreparedStatement pstm = null;
		int n = 0;		
		
		String sql = " INSERT INTO MYTEST " + "VALUES(?, ?, ?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getMno());
			pstm.setString(2, dto.getMname());
			pstm.setString(3, dto.getNickName());
			
			n = pstm.executeUpdate();			

			if (n >0) {
				System.out.println("insert 성공");
			} else {
				System.out.println("insert 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return n;
	}
	
	public int update(MyTestDto dto) {
		// Statement 버전
		Statement stmt = null;
		int res = 0;
		
		String sql = " UPDATE MYTEST SET MNO = " + dto.getMno() 
				+ ", NICKNAME = '" + dto.getNickName() + "'"
				+ " WHERE MNAME = '" + dto.getMname() + "'";
		
		try {
			stmt = con.createStatement();
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//PreparedStatement 버전
//		PreparedStatement pstm = null;
//		int res = 0;
//		
//		String sql = " UPDATE MYTEST SET MNO = ?, NICKNAME = ? WHERE MNAME = ? ";
//		try {
//			pstm = con.prepareStatement(sql);
//			pstm.setInt(1, dto.getMno());
//			pstm.setString(2, dto.getNickName());
//			pstm.setString(3, dto.getMname());
//			
//			res = pstm.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		return res;
	}
	
	public int delete(int mno) {
		PreparedStatement pstm = null;
		int n = 0;
		
		String sql = " DELETE FROM MYTEST WHERE MNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, mno);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return n;
	}
}
