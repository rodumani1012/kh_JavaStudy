package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.MemberDto;

import common.template.JDBCTemplate;

public class MemberDaoImpl extends JDBCTemplate implements MemberDao {

	@Override
	public List<MemberDto> selectList() {
		// 1. 2.
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<MemberDto> res = new ArrayList<MemberDto>();
		try {
			// 3. query 작성
			pstm = con.prepareStatement(SELECT_ALL_SQL);

			// 4. query 실행
			rs = pstm.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setM_no(rs.getInt(1));
				dto.setM_name(rs.getString(2));
				dto.setM_age(rs.getInt(3));
				dto.setM_gender(rs.getString(4));
				dto.setM_location(rs.getString(5));
				dto.setM_job(rs.getString(6));
				dto.setM_tel(rs.getString(7));
				dto.setM_email(rs.getString(8));

				res.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. close
			close(rs);
			close(pstm);
			close(con);
		}

		return res;
	}

	@Override
	public MemberDto selectOne(int m_no) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MemberDto res = new MemberDto();

		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, m_no);

			rs = pstm.executeQuery();
			while (rs.next()) {
				res.setM_no(rs.getInt("M_NO"));
				res.setM_name(rs.getString(2));
				res.setM_age(rs.getInt(3));
				res.setM_gender(rs.getString(4));
				res.setM_location(rs.getString(5));
				res.setM_job(rs.getString(6));
				res.setM_tel(rs.getString(7));
				res.setM_email(rs.getString(8));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}

		return res;
	}

	@Override
	public int insert(MemberDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(INSERT_SQL);
			// M_no는 시퀀스로 해놔서 안하는 거임.
			pstm.setString(1, dto.getM_name());
			pstm.setInt(2, dto.getM_age());
			pstm.setString(3, dto.getM_gender());
			pstm.setString(4, dto.getM_location());
			pstm.setString(5, dto.getM_job());
			pstm.setString(6, dto.getM_tel());
			pstm.setString(7, dto.getM_email());

			res = pstm.executeUpdate();

			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}

		return res;
	}

	@Override
	public int update(MemberDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setString(1, dto.getM_name());
			pstm.setInt(2, dto.getM_age());
			pstm.setString(3, dto.getM_gender());
			pstm.setString(4, dto.getM_location());
			pstm.setString(5, dto.getM_job());
			pstm.setString(6, dto.getM_tel());
			pstm.setString(7, dto.getM_email());
			pstm.setInt(8, dto.getM_no());

			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}

		return res;
	}

	@Override
	public int delete(int m_no) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setInt(1, m_no);

			res = pstm.executeUpdate();

			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}

		return res;
	}

}
