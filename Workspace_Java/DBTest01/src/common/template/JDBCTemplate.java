package common.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	// 1. driver 2. 계정 합치기
	public static Connection getConnection() {

		// 1. driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("01. driver 연결");
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] 01. driver 연결 실패");
			e.printStackTrace();
		}

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// New Oracle에서 properties -> Driver properties -> Connection Url 복사해서 붙여넣기
		String id = "kh";
		String pw = "kh";

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("02. 계정 연결");
		} catch (SQLException e) {
			System.out.println("[Error] 02. 계정 연결 실패");
			e.printStackTrace();
		}

		return con;
	}

	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null) { //if문을 try catch문 안에 넣어도 상관 없음
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
}
