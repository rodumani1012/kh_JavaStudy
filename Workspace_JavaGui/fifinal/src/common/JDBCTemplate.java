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
         System.out.println("01.계정 연결");
      } catch (ClassNotFoundException e) {
         System.out.println("01.계정 연결 실패");
         e.printStackTrace();
      }
      
      try {
         con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
         System.out.println("02.driver 연결");
         
      } catch (SQLException e) {
         System.out.println("02.driver 연결 실패");
         e.printStackTrace();
      }
      
      return con;
   }
   
   public static void close(Connection con) {
      try {
         if(con != null) {
            con.close();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public static void close(Statement stmt) {
      
      try {
         if(stmt != null) {
            stmt.close();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   }
   public static void close(ResultSet rs) {
      
      try {
         if(rs!=null) {
            rs.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   public static void close(ResultSet rs, Statement stmt, Connection con) {
      close(rs);
      close(stmt);
      close(con);
   }
   public static void close(Statement stmt, Connection con) {
      close(stmt);
      close(con);
   }
   
   public static void commit(Connection con) {
      try {
         if(con != null) {
            con.commit();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public static void rollback(Connection con) {
      
      try {
         if(con != null) {
            con.rollback();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}







