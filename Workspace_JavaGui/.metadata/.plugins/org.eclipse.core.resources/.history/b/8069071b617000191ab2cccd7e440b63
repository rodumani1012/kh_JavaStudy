package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("01.드라이브 연결");
		} catch (ClassNotFoundException e) {
			System.out.println("01.드라이브 연결 실패");
			e.printStackTrace();
		}

		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "kh";
			String pw = "kh";

			con = DriverManager.getConnection(url, id, pw);
			con.setAutoCommit(false);
			System.out.println("02.계정 연결");
		} catch (SQLException e) {
			System.out.println("02.계정 연결 실패");
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			if (con != null) { // if를 쓰면 오류찾기 어려울 수 있다.
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null) { // if를 쓰면 오류찾기 어려울 수 있다.
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) { // if를 쓰면 오류찾기 어려울 수 있다.
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try {
			if (con != null) {
				con.commit();	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try {
			if (con != null) {
				con.rollback();	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
