package com.pc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pc.dto.PcDto;

import common.JDBCTemplate;

public class PcDao extends JDBCTemplate {

	public List<PcDto> selectlist() {
		Connection con = getConnection();

		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<PcDto> list = new ArrayList<PcDto>();

		String sql = " SELECT * FROM KHPC ORDER BY MYNO DESC";

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("03. query 준비 : " + sql);

			rs = pstm.executeQuery();
			while (rs.next()) {
				PcDto dto = new PcDto();
				dto.setMyno(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setDob(rs.getString(5));
				dto.setTel(rs.getString(6));
				dto.setAddr(rs.getString(7));
				dto.setJd(rs.getDate(8));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}

		return list;
	}

	public PcDto login(String id, String pw) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		PcDto dto = new PcDto();

		String sql = " SELECT * FROM KHPC WHERE ID = ? AND PW = ? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);

			System.out.println("03.query 준비");
			rs = pstm.executeQuery();
			System.out.println("sql = " + sql);
			System.out.println("04. query 실행 및 리턴");

			// 실행이안되요
			while (rs.next()) {
				dto.setMyno(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(String.valueOf(rs.getString(3)));
				dto.setName(rs.getString(4));
				System.out.println("디비: " + dto.getName());

				dto.setDob(rs.getString(5));
				dto.setTel(rs.getString(6));
				dto.setAddr(rs.getString(7));
				dto.setJd(rs.getDate(8));
				// commit(con);
			}
			System.out.println("디비에서 값: " + dto.getName());
		} catch (SQLException e) {
			System.out.println("03.04 단계 에러");
			// rollback(con);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}

		return dto;

	}

	public PcDto idchek(String id) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		PcDto dto = new PcDto();

		String sql = " SELECT * FROM KHPC WHERE ID =? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			System.out.println("03. query 준비");

			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			while (rs.next()) {
				dto.setId(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("03.04 단계 에러");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05.db 종료");
		}

		return dto;

	}

	public int insert(PcDto dto) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " INSERT INTO KHPC " + " VALUES(KHPCSEQ.NEXTVAL,?,?,?,?,?,?,SYSDATE) ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getId());
			pstm.setString(2, dto.getPw());
			pstm.setString(3, dto.getName());
			pstm.setString(4, dto.getDob());
			pstm.setString(5, dto.getTel());
			pstm.setString(6, dto.getAddr());
			System.out.println("03. query 준비");

			res = pstm.executeUpdate();
			System.out.println("04. query 준비 및 리턴");
			commit(con);
		} catch (SQLException e) {
			System.out.println("03.04 단계 에러");
			e.printStackTrace();
			rollback(con);
		} finally {
			close(pstm);
			close(con);
			System.out.println("05. db종료");
		}
		return res;

	}

	public PcDto myselectOne(String myid) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		PcDto dto = null;

		String sql = " SELECT * FROM KHPC WHERE ID =? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			System.out.println("03.query 준비 : " + sql);

			rs = pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			while (rs.next()) {
				dto = new PcDto();
				dto.setMyno(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setDob(rs.getString(5));
				dto.setAddr(rs.getString(6));
				dto.setTel(rs.getString(7));
				dto.setJd(rs.getDate(8));

			}
			commit(con);

		} catch (SQLException e) {
			System.out.println("3,4단계 에러");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05.db 종료");
		}

		return dto;
	}

	public int update(PcDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " UPDATE KHPC SET " + " PW = ?, NAME = ?, DOB = ?, TEL = ?, ADDR = ? " + " WHERE ID = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getPw());
			pstm.setString(2, dto.getName());
			pstm.setString(3, dto.getDob());
			pstm.setString(4, dto.getTel());
			pstm.setString(5, dto.getAddr());
			pstm.setString(6, dto.getId());

			System.out.println("03.query 준비 " + sql);

			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");

			if (res > 0) {
				commit(con);
			}

		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			rollback(con);
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05.db 종료");
		}

		return res;
	}

	public int IdSearchUpdate(String id, String pw) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " UPDATE KHPC SET PW = ? WHERE ID = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, pw);
			pstm.setString(2, id);
			System.out.println("03. query 준비 :" + sql);

			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
			if (res > 0) {
				commit(con);
			}

		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			rollback(con);
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("db 종료");
		}

		return res;
	}

	public List<PcDto> selectByName(String name) {

		Connection con = getConnection();

		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<PcDto> list = new ArrayList<PcDto>();

		String sql = "SELECT * FROM KHPC WHERE NAME = ?";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			System.out.println("03. query 준비 : " + sql);

			rs = pstm.executeQuery();
			while (rs.next()) {
				PcDto dto = new PcDto();
				dto.setMyno(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setDob(rs.getString(5));
				dto.setTel(rs.getString(6));
				dto.setAddr(rs.getString(7));
				dto.setJd(rs.getDate(8));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("3/4단계 실패");
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5.db종료");
		}

		return list;
	}

	public List<PcDto> selectById(String ID) {

		Connection con = getConnection();

		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<PcDto> list = new ArrayList<PcDto>();

		String sql = " SELECT * FROM KHPC WHERE ID = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, ID);
			System.out.println("03. query 준비 : " + sql);

			rs = pstm.executeQuery();
			while (rs.next()) {
				PcDto dto = new PcDto();
				dto.setMyno(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setDob(rs.getString(5));
				dto.setTel(rs.getString(6));
				dto.setAddr(rs.getString(7));
				dto.setJd(rs.getDate(8));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("3/4단계 실패");
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5.db종료");
		}

		return list;

	}

}
