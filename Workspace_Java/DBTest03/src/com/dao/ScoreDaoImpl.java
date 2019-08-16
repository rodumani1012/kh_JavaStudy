package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.ScoreDto;

import common.template.JDBCTemplate;

public class ScoreDaoImpl extends JDBCTemplate implements ScoreDao {
	
	
	@Override
	public List<ScoreDto> selectList() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<ScoreDto> res = new ArrayList<ScoreDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_ALL_SQL);
			rs = pstm.executeQuery();
			while(rs.next()) {
				ScoreDto dto = new ScoreDto();
				dto.setS_no(rs.getInt(1));
				dto.setS_name(rs.getString(2));
				dto.setS_kor(rs.getInt(3));
				dto.setS_eng(rs.getInt(4));
				dto.setS_math(rs.getInt(5));
				dto.setS_sum(rs.getInt(6));
				dto.setS_avg(rs.getDouble(7));
				dto.setS_grade(rs.getString(8));

				res.add(dto);
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
	public ScoreDto selectOne(int m_no) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ScoreDto res = new ScoreDto();
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, m_no);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				res.setS_no(rs.getInt(1));
				res.setS_name(rs.getString(2));
				res.setS_kor(rs.getInt(3));
				res.setS_eng(rs.getInt(4));
				res.setS_math(rs.getInt(5));
				res.setS_sum(rs.getInt(6));
				res.setS_avg(rs.getDouble(7));
				res.setS_grade(rs.getString(8));
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
	public int insert(ScoreDto dto) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getS_name());
			pstm.setInt(2, dto.getS_kor());
			pstm.setInt(3, dto.getS_eng());
			pstm.setInt(4, dto.getS_math());
			pstm.setInt(5, dto.getS_sum());
			pstm.setDouble(6, dto.getS_avg());
			pstm.setString(7, dto.getS_grade());
			
			// 쿼리 실행
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
	public int update(ScoreDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setString(1, dto.getS_name());
			pstm.setInt(2, dto.getS_kor());
			pstm.setInt(3, dto.getS_eng());
			pstm.setInt(4, dto.getS_math());
			pstm.setInt(5, dto.getS_no());
			
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

	@Override
	public ScoreDto first(int s_no) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;		
		
		ScoreDto res = new ScoreDto();		
		
		try {
			pstm = con.prepareStatement(SELECT_FIRST_SQL);
			pstm.setInt(1, s_no);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				res.setS_no(rs.getInt(1));
				res.setS_name(rs.getString(2));
				res.setS_kor(rs.getInt(3));
				res.setS_eng(rs.getInt(4));
				res.setS_math(rs.getInt(5));
				res.setS_sum(rs.getInt(6));
				res.setS_avg(rs.getDouble(7));
				res.setS_grade(rs.getString(8));
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
	public ScoreDto second(int s_no) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;		
		
		ScoreDto res = new ScoreDto();		
		
		try {
			pstm = con.prepareStatement(SELECT_SECOND_SQL);
			pstm.setInt(1, s_no);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				res.setS_no(rs.getInt(1));
				res.setS_name(rs.getString(2));
				res.setS_kor(rs.getInt(3));
				res.setS_eng(rs.getInt(4));
				res.setS_math(rs.getInt(5));
				res.setS_sum(rs.getInt(6));
				res.setS_avg(rs.getDouble(7));
				res.setS_grade(rs.getString(8));
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
	public ScoreDto third(int s_no) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;		
		
		ScoreDto res = new ScoreDto();		
		
		try {
			pstm = con.prepareStatement(SELECT_THIRD_SQL);
			pstm.setInt(1, s_no);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				res.setS_no(rs.getInt(1));
				res.setS_name(rs.getString(2));
				res.setS_kor(rs.getInt(3));
				res.setS_eng(rs.getInt(4));
				res.setS_math(rs.getInt(5));
				res.setS_sum(rs.getInt(6));
				res.setS_avg(rs.getDouble(7));
				res.setS_grade(rs.getString(8));
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

}
