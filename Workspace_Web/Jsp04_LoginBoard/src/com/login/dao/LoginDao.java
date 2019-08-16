package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.dto.LoginDto;

import common.JDBCTemplate;

public class LoginDao extends JDBCTemplate{

	/*
	 * 관리자 기능
	   1.회원 전체 정보 보기(탈퇴한 회원 포함)
	   2.가입된 회원 정보 보기(myenabled='Y')
	   3.회원 등급 조정
	 */
	
	/*
	 * 유저 기능
	   1.로그인
	   2.회원가입 -> 아이디 중복체크 insert
	   3.내 정보 보기 selectOne
	   4.내 정보 수정 update
	   5.회원 탈퇴 (UPDATE MYMEMBER SET MYENABLED = 'N' WHERE MYNO = ?)
	 */
	
	public LoginDto login(String myid, String mypw) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		LoginDto dto = new LoginDto();
		String sql = " SELECT * FROM MYMEMBER WHERE MYID = ? AND MYPW = ? AND MYENABLED = 'Y' ";
				// MYENABLED = 'Y' 로하면 탈퇴한 회원은 로그인 할 수 없다.
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			pstm.setString(2, mypw);
			System.out.println("03.query준비 : " + sql);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));
			}
		} catch (SQLException e) {
			System.out.println("03,04단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
			System.out.println("05.db 종료");
		}		
		return dto;
	}
	
	public LoginDto idChk(String myid) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		LoginDto dto = new LoginDto();
		String sql = " SELECT MYID FROM MYMEMBER WHERE MYID = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto.setMyid(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}		
		return dto;
	}
	
	public int regist(LoginDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO MYMEMBER VALUES(MYMEMBERSEQ.NEXTVAL, ?,?,?,?,?,?,'Y','USER') ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyid());
			pstm.setString(2, dto.getMypw());
			pstm.setString(3, dto.getMyname());
			pstm.setString(4, dto.getMyaddr());
			pstm.setString(5, dto.getMyphone());
			pstm.setString(6, dto.getMyemail());
			
			res =  pstm.executeUpdate();
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}		
		return res;
	}
	
	public List<LoginDto> selectEnabled() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<LoginDto> list = new ArrayList<LoginDto>();
		String sql = " SELECT MYNO,MYID,MYPW,MYNAME,MYADDR,MYPHONE,MYEMAIL,MYENABLED,MYROLE " +
					" FROM MYMEMBER WHERE MYENABLED = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, "Y");
			System.out.println("03.query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				LoginDto dto = new LoginDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("03,04 단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
			System.out.println("05.db 종료");
		}
		
		return list;
	}
	
	public LoginDto selectOne(int myno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM MYMEMBER WHERE MYNO = ? ";
		LoginDto dto = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto = new LoginDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return dto;
	}
	
	public int updateRole(int myno, String myrole) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE MYMEMBER SET MYROLE = ? WHERE MYNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myrole);
			pstm.setInt(2, myno);
			System.out.println("03.query 준비 : " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			System.out.println("03,04 단계 에러");
			rollback(con);
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}
		return res;
	}
	
	public int delete(int myno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE MYMEMBER SET MYENABLED='N' WHERE MYNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("03.query 준비 : " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			System.out.println("03,04단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("05.db 종료");
		}
		
		return res;
	}
	
	public int update(LoginDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE MYMEMBER SET MYPW=?, MYNAME=?, MYADDR =?, MYPHONE=?, MYEMAIL=? "
					+ " WHERE MYNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMypw());
			pstm.setString(2, dto.getMyname());
			pstm.setString(3, dto.getMyaddr());
			pstm.setString(4, dto.getMyphone());
			pstm.setString(5, dto.getMyemail());
			pstm.setInt(6, dto.getMyno());
			
			res = pstm.executeUpdate();
			
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}
		return res;
	}
}
