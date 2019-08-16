package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import common.template.JDBCTemplate;

public class DBTest05_delete extends JDBCTemplate{

	public static void main(String[] args) throws SQLException {
		/*
		 *  삭제할 이름은 ?
		 *  홍길동
		 *  삭제되었습니다.
		 */
		
		Connection con = null;
		PreparedStatement pstm = null;
		int res;
		
		String mname = "";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 이름은 : ");
		mname = sc.next();
		
		// 1. 2.
		con = getConnection();
		
		// 3.query
		String sql = " DELETE FROM MYTEST WHERE MNAME = ? "; //데이터가 들어갈 곳을 ? 로 해놓음.
		pstm = con.prepareStatement(sql);
		pstm.setString(1, mname);		
		System.out.println("03. query 준비");
		
		// 4. 
		res = pstm.executeUpdate();
		System.out.println("04. query 실행 및 리턴");
		if (res >0) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}
		
		// 5.
		close(pstm);
		close(con);
		System.out.println("05. db 종료");
	}
}
