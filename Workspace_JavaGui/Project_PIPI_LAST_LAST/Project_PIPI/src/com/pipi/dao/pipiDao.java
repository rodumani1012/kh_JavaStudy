package com.pipi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pipi.dto.pipiDto;

import common.JDBCTemplate;

public class pipiDao extends JDBCTemplate {
   
   
   //가입
   public static int insert(String myid, String mypw) {
      Connection con = getConnection();
      PreparedStatement pstm = null;
      int res =0;
      
      String sql = "INSERT INTO PIPIBOARD VALUES(PIPISEQ.NEXTVAL,?,?,100,100,100,100,0,'D','N','Y' )";
      
      try {
         pstm = con.prepareStatement(sql);
         pstm.setString(1, myid);
         pstm.setString(2, mypw);
         System.out.println("03 query 준비");
         
         res = pstm.executeUpdate();
         System.out.println("04 query 실행 및 리턴");
         
         if(res>0) {
            commit(con);
         }
         
      } catch (SQLException e) {
         System.out.println("0304단계 오류");
         e.printStackTrace();
      }finally {
         close(pstm);
         close(con);
      }
      
      return res;
      
   }
   
   //로그인
   public static pipiDto login(String id, String pw) {
      Connection con = getConnection();
      PreparedStatement pstm = null;
      ResultSet rs = null;
      pipiDto dto = null;
      
      String sql = "SELECT * FROM PIPIBOARD WHERE MYID=? AND MYPW=? AND MYENABLED='Y' ";
      
      try {
         pstm = con.prepareStatement(sql);
         pstm.setString(1, id);
         pstm.setString(2, pw);
         System.out.println("03 query 준비");
         
         rs = pstm.executeQuery();
         System.out.println("04 query 실행및 리턴");
         while(rs.next()) {
            dto = new pipiDto();
            dto.setMyno(rs.getInt(1));
            dto.setMyid(rs.getString(2));
            dto.setMypw(rs.getString(3));
            dto.setMyheart(rs.getInt(4));
            dto.setMyfull(rs.getInt(5));
            dto.setMystamina(rs.getInt(6));
            dto.setMyclean(rs.getInt(7));
            dto.setMydate(rs.getInt(8));
            dto.setMyallday(rs.getString(9));
            dto.setMydisease(rs.getString(10));
            dto.setMyenabled(rs.getString(11));
         }
         
      } catch (SQLException e) {
         System.out.println("0304단계 에러");
         e.printStackTrace();
      }finally {
         close(rs);
         close(pstm);
         close(con);
      }
      return dto;
   }
   
   
   //id체크    
   public static pipiDto idchk(String id) {
      Connection con = getConnection();
      PreparedStatement pstm = null;
      ResultSet rs = null;
      pipiDto dto = null;
      
      String sql ="SELECT * FROM PIPIBOARD WHERE MYID=?";
      
      try {
         pstm = con.prepareStatement(sql);
         pstm.setString(1, id);
         System.out.println("03 query 준비");
         
         rs = pstm.executeQuery();
         System.out.println("04 query 실행 리턴");
         while(rs.next()) {
            dto = new pipiDto();
            dto.setMyid(rs.getString(1));
         }
         
      
         
      } catch (SQLException e) {
         System.out.println("0304 단계 에러");
         e.printStackTrace();
      }finally {
         close(rs);
         close(pstm);
         close(con);
      }
      
      return dto;
   }
   
   //save(update)
   
   public static pipiDto update(pipiDto dto) {
      Connection con = getConnection();
      PreparedStatement pstm = null;
      int res = 0;
      
      String sql = " UPDATE PIPIBOARD SET MYHEART=?, MYFULL=?, MYSTAMINA=?, MYCLEAN=?, "
                  + " MYDATE=?, MYALLDAY=?, MYDISEASE=?, MYENABLED=?, WHERE MYID=? ";
      
      try {
         pstm = con.prepareStatement(sql);
         System.out.println("03 query 준비");
         pstm.setInt(1, dto.getMyheart());
         pstm.setInt(2, dto.getMyfull());
         pstm.setInt(3, dto.getMystamina());
         pstm.setInt(4, dto.getMyclean());
         pstm.setInt(5, dto.getMydate());
         pstm.setString(6, dto.getMyallday());
         pstm.setString(7, dto.getMydisease());
         pstm.setString(8, dto.getMyenabled());
         pstm.setString(9, dto.getMyid());
         
         res = pstm.executeUpdate();
         System.out.println("04 query 실행 및 리턴");
         
         if(res>0) {
            commit(con);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstm);
         close(con);
      }
      return dto;   
   }

   /*public static int growselect(int Myno) {
      Connection con = getConnection();
      PreparedStatement pstm = null;
      ResultSet rs = null;
      int mydate = 0;
   
      String sql = " SELECT MYDATE FROM PIPIBOARD WHERE MYNO = ? ";
      try {
         pstm = con.prepareStatement(sql);
      //   System.out.println("03 query 준비");
         pstm.setInt(1, Myno);
      
         rs = pstm.executeQuery();
      //   System.out.println("04 query 실행및 리턴");
         while(rs.next()) {
            
            mydate = rs.getInt(1);
         }
      
      } catch (SQLException e) {
         System.out.println("0304단계 에러");
         e.printStackTrace();
      }finally {
         close(rs);
         close(pstm);
         close(con);
      }
      return mydate;
   }*/

   //public static int updateMydate(int Myno) {
   public static int updateMydate(pipiDto dto) {
      Connection con = getConnection();
      PreparedStatement pstm = null;
      int res = 0;
      
      //String sql = " UPDATE PIPIBOARD SET MYDATE = MYDATE + 1 WHERE  myno =? ";
      String sql = " UPDATE PIPIBOARD SET MYDATE = ? , MYALLDAY=? WHERE  myno =? "; // 낮, 밤으로 변경하면서 재변경 20190507
      
      try {
         pstm = con.prepareStatement(sql);
         pstm.setInt(1, dto.getMydate());
         pstm.setString(2, dto.getMyallday());
         pstm.setInt(3, dto.getMyno());
         
         res = pstm.executeUpdate();
         
         if(res>0) {
            commit(con);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstm);
         close(con);
      }
      return res;   
   }
   
   //myno 별 select data    
      public static pipiDto selectData(int Myno) {
         Connection con = getConnection();
         PreparedStatement pstm = null;
         ResultSet rs = null;
         pipiDto dto = null;
         
         String sql ="SELECT * FROM PIPIBOARD WHERE MYNO=?";
         
         try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Myno);
            
            rs = pstm.executeQuery();
            while(rs.next()) {
               dto = new pipiDto();
               dto.setMyno(rs.getInt(1));
               dto.setMyid(rs.getString(2));
               dto.setMypw(rs.getString(3));
               dto.setMyheart(rs.getInt(4));
               dto.setMyfull(rs.getInt(5));
               dto.setMystamina(rs.getInt(6));
               dto.setMyclean(rs.getInt(7));
               dto.setMydate(rs.getInt(8));
               dto.setMyallday(rs.getString(9));
               dto.setMydisease(rs.getString(10));
               dto.setMyenabled(rs.getString(11));
            }
            
         
            
         } catch (SQLException e) {
            System.out.println("0304 단계 에러");
            e.printStackTrace();
         }finally {
            close(rs);
            close(pstm);
            close(con);
         }
         
         return dto;
      }
      
      
      public static int updateStatus(pipiDto dto) {
         Connection con = getConnection();
         PreparedStatement pstm = null;
         int res = 0;
         
         String sql = " UPDATE PIPIBOARD SET MYHEART=?, MYFULL=?, MYSTAMINA=? , MYCLEAN=? WHERE MYNO=? ";
         
         try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, dto.getMyheart());
            pstm.setInt(2, dto.getMyfull());
            pstm.setInt(3, dto.getMystamina());
            pstm.setInt(4, dto.getMyclean());
            pstm.setInt(5, dto.getMyno());
            
            res = pstm.executeUpdate();
            
            if(res>0) {
               commit(con);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         }finally {
            close(pstm);
            close(con);
         }
         return res;   
      }
      
         //약먹기
         public static int updatemedicine(int myno) {
         Connection con = getConnection();
         PreparedStatement pstm = null;
         int res = 0;
            
         String sql = " UPDATE PIPIBOARD SET MYDISEASE='N' WHERE MYNO=? ";
         
         try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, myno);
            
            res = pstm.executeUpdate();
            
            if(res>0) {
               commit(con);
            }
            
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }finally {
            close(pstm);
            close(con);
         }
            return res;
         }
         

      
   }
      
      
   