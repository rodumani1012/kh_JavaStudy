package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import common.template.JDBCTemplate;

public class DBTest04_insert extends JDBCTemplate{
	
	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstm = null;
		int res;
		
		int mno = 0;
		String mname = "";
		String nickName = "";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("번호 입력 : ");
		mno = sc.nextInt();
		System.out.println("이름 입력 : ");
		mname = sc.next();
		System.out.println("별명 입력 : ");
		nickName = sc.next();
		
		// 1. 2.
		con = getConnection();
		
		// 3.query
		String sql = " INSERT INTO MYTEST " + " VALUES(?,?,?) "; //데이터가 들어갈 곳을 ? 로 해놓음.
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, mno);
		pstm.setString(2, mname); // mname에 ' '을 붙이지 않는다.
		pstm.setString(3, nickName);
		
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
