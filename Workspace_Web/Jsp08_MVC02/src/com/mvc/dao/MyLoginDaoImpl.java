package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MyLoginDto;

import common.JDBCTemplate;

public class MyLoginDaoImpl extends JDBCTemplate implements MyLoginDao {
	/*
	 * 관리자 기능 1.회원 전체 정보 보기(탈퇴한 회원 포함) 2.가입된 회원 정보 보기(myenabled='Y') 3.회원 등급 조정
	 */

	/*
	 * 유저 기능 1.로그인 2.회원가입 -> 아이디 중복체크 insert 3.내 정보 보기 selectOne 4.내 정보 수정 update
	 * 5.회원 탈퇴 (UPDATE MYMEMBER SET MYENABLED = 'N' WHERE MYNO = ?)
	 */

	@Override
	public MyLoginDto login(String myid, String mypw) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyLoginDto dto = new MyLoginDto();
		String sql = " SELECT * FROM MYMEMBER WHERE MYID = ? AND MYPW = ? AND MYENABLED = 'Y' ";
		// MYENABLED = 'Y' 로하면 탈퇴한 회원은 로그인 할 수 없다.
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			pstm.setString(2, mypw);
			System.out.println("03.query준비 : " + sql);

			rs = pstm.executeQuery();

			while (rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setAddr(rs.getString(5));
				dto.setPhone(rs.getString(6));
				dto.setEmail(rs.getString(7));
				dto.setEnabled(rs.getString(8));
				dto.setRole(rs.getString(9));
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

	@Override
	public MyLoginDto idChk(String myid) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyLoginDto dto = new MyLoginDto();
		String sql = " SELECT MYID FROM MYMEMBER WHERE MYID = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);

			rs = pstm.executeQuery();

			while (rs.next()) {
				dto.setId(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
		}
		return dto;
	}

	@Override
	public int regist(MyLoginDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO MYMEMBER VALUES(MYMEMBERSEQ.NEXTVAL, ?,?,?,?,?,?,'Y','USER') ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getId());
			pstm.setString(2, dto.getPw());
			pstm.setString(3, dto.getName());
			pstm.setString(4, dto.getAddr());
			pstm.setString(5, dto.getPhone());
			pstm.setString(6, dto.getEmail());

			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}
		return res;
	}

	@Override
	public List<MyLoginDto> selectEnabled() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MyLoginDto> list = new ArrayList<MyLoginDto>();
		String sql = " SELECT MYNO,MYID,MYPW,MYNAME,MYADDR,MYPHONE,MYEMAIL,MYENABLED,MYROLE "
				+ " FROM MYMEMBER WHERE MYENABLED = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, "Y");
			System.out.println("03.query 준비 : " + sql);

			rs = pstm.executeQuery();

			while (rs.next()) {
				MyLoginDto dto = new MyLoginDto();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setAddr(rs.getString(5));
				dto.setPhone(rs.getString(6));
				dto.setEmail(rs.getString(7));
				dto.setEnabled(rs.getString(8));
				dto.setRole(rs.getString(9));

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

	@Override
	public MyLoginDto selectOne(int myno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM MYMEMBER WHERE MYNO = ? ";
		MyLoginDto dto = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);

			rs = pstm.executeQuery();

			while (rs.next()) {
				dto = new MyLoginDto();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setAddr(rs.getString(5));
				dto.setPhone(rs.getString(6));
				dto.setEmail(rs.getString(7));
				dto.setEnabled(rs.getString(8));
				dto.setRole(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
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

	@Override
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

	@Override
	public int update(MyLoginDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE MYMEMBER SET MYPW=?, MYNAME=?, MYADDR =?, MYPHONE=?, MYEMAIL=? "
					+ " WHERE MYNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getPw());
			pstm.setString(2, dto.getName());
			pstm.setString(3, dto.getAddr());
			pstm.setString(4, dto.getPhone());
			pstm.setString(5, dto.getEmail());
			pstm.setInt(6, dto.getSeq());
			
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
