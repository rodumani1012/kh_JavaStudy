package com.test01;

import static common.template.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest02 {

	public static void main(String[] args) throws SQLException {
		
		// 1번 2번 연결해보기
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		stmt = con.createStatement();
		String sql = "SELECT * FROM DEPT";
		System.out.println("03. query 준비");
		
		rs = stmt.executeQuery(sql);
		System.out.println("04. query 실행 및 결과 리턴");
		while(rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString("LOC"));
		}
		
		close(rs);
		close(stmt);
		close(con);
		System.out.println("05. db 종료");
	}
}
