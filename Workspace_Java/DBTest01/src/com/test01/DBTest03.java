package com.test01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import common.template.JDBCTemplate;

public class DBTest03 extends JDBCTemplate {
	
	public static void main(String[] args) throws SQLException {

		//db랑 연결하기 위한 객체
		Connection con = null;
		Statement stmt = null;
		int res;
		
		// insert 하기 위해
		int mno = 0;
		String mname = null;
		String nickName = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("번호 입력 : ");
		mno = sc.nextInt();
		System.out.println("이름 입력 : ");
		mname = sc.next();
		System.out.println("별명 입력: ");
		nickName = sc.next();
		
		// 1. 2.
		con = getConnection();
		
		// 3. query 준비
		stmt = con.createStatement();
		String sql = "INSERT INTO MYTEST VALUES(" + mno + ", '" + mname + "', '" + nickName + "')";
		// 36번 라인과 같은 뜻 =>  INSERT INTO MYTEST VALUES (mno, 'mname', 'nickName');
		System.out.println("03. query 준비");
		
		// 4. 
		res = stmt.executeUpdate(sql);
		if(res >0) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}
		System.out.println("04. query 실행 및 리턴");
		
		// 5.
		close(stmt);
		close(con);
		System.out.println("05. db 종료");
	}
}
