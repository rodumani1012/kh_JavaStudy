package com.my.dao;

import com.my.dto.ProjectDto;

import common.JDBCTemplate;

import java.sql.*;

public class ProjectDao extends JDBCTemplate {

	// 회원 가입
	public int insert(String msg) {
		Connection con = getconnection();
		PreparedStatement pstm = null;
		int res = 0;

		String[] splitmsg = msg.split(" ");
		String name = splitmsg[1];
		String pw = splitmsg[2];

		String sql = " UPDATE PROJECTBOARD SET PW = ?, MONEY = 500000000 WHERE NAME = ? ";

		try {
			pstm = con.prepareStatement(sql);

			pstm.setString(1, pw);
			pstm.setString(2, name);

			res = pstm.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	// 로그인
	public ProjectDto login(String msg) {
		Connection con = getconnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ProjectDto dto = null;

		String[] splitmsg = msg.split(" ");
		String name = splitmsg[1];
		String pw = splitmsg[2];

		String sql = " SELECT * FROM PROJECTBOARD WHERE NAME = ? AND PW = ? ";

		try {
			pstm = con.prepareStatement(sql);

			pstm.setString(1, name);
			pstm.setString(2, pw);

			rs = pstm.executeQuery();

			while (rs.next()) {
				dto = new ProjectDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}

		return dto;
	}

	//	베팅(블랙잭 전용)
	public void betting(ProjectDto dto, int betting) {
		Connection con = getconnection();
		PreparedStatement pstm = null;

		String sql = " UPDATE PROJECTBOARD SET MONEY = MONEY - ? WHERE NAME = ? ";

		try {
			pstm = con.prepareStatement(sql);

			pstm.setInt(1, betting);
			pstm.setString(2, dto.getName());

			pstm.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 게임 종료시 돈 업데이트(블랙잭전용)
	public void ending(ProjectDto dto, int betting, double result) {
		Connection con = getconnection();
		PreparedStatement pstm = null;

		String sql = " UPDATE PROJECTBOARD SET MONEY = MONEY + (? * ?) WHERE NAME = ? ";

		try {
			pstm = con.prepareStatement(sql);

			pstm.setInt(1, betting);
			pstm.setDouble(2, result);
			pstm.setString(3, dto.getName());

			pstm.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 슬롯게임 엔딩시 돈을 db로 반영
	public void slotending(ProjectDto dto, int money) {
		Connection con = getconnection();
		PreparedStatement pstm = null;

		String sql = " UPDATE PROJECTBOARD SET MONEY = ? WHERE NAME = ? ";

		try {
			pstm = con.prepareStatement(sql);

			pstm.setInt(1, money);
			pstm.setString(2, dto.getName());

			pstm.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}