package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest01 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. driver 연결(properties에서 Java Build Path 에서 ojdbc6.jar 파일 꼭 추가한 상태에서!)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		// New Oracle에서 properties -> Driver properties -> Connection Url 복사해서 붙여넣기
		String id = "kh"; //계정 아이디에 따라 바꾸면 됨
		String pw = "kh"; //계정 비밀번호에 따라 바꾸면 됨
		
		Connection con = DriverManager.getConnection(url, id, pw);
		
		// 3. query 준비
		Statement stmt = con.createStatement();
		String sql = "SELECT * FROM EMP";
		
		// 4. 결과 리턴
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt("SAL"));
			//숫자 또는 특정 컬럼의 이름으로 호출할 수 있다.
			// 숫자로 호출할 때 해당 컬럼이 숫자타입이면 getInt, 문자는 getString, 날짜는 getDate
		} 
		
		// 5. DB 종료
		rs.close();
		stmt.close();
		con.close();   //가장 먼저 실행한것 부터 닫아주기.
	}
}
