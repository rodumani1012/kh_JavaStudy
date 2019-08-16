package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import common.template.JDBCTemplate;

public class DBTest06_update extends JDBCTemplate{
	
	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstm = null;
		int res;
		
		String mname = "";
		int mno = 0;
		String nickName = "";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("변경해줄 이름은?");
		mname = sc.next();
		System.out.println("바꿀 번호 입력 : ");
		mno = sc.nextInt();
		System.out.println("바꿀 별명 입력 : ");
		nickName = sc.next();
		
		// 1. 2.
		con = getConnection();
		
		// 3. query
		String sql = " UPDATE MYTEST SET MNO = ?, NICKNAME = ? WHERE MNAME = ? ";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, mno);
		pstm.setString(2, nickName);
		pstm.setString(3, mname);
		System.out.println("03. query 준비");
		
		// 4. 
		res = pstm.executeUpdate();
		System.out.println("04. query 실행 및 리턴");
		if (res >0) {
			System.out.println("변경 성공");
		} else {
			System.out.println("변경 실패");
		}
		
		// 5.
		close(pstm);
		close(con);
		System.out.println("05. db 종료");
		
	}
}
