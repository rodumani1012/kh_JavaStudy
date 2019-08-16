package com.answer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.answer.dto.AnswerDto;

import common.JDBCTemplate;

public class AnswerDaoImpl extends JDBCTemplate implements AnswerDao {

	@Override
	public List<AnswerDto> selectList() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<AnswerDto> list = new ArrayList<AnswerDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			System.out.println("03. 쿼리 준비" + SELECT_LIST_SQL);
			rs = pstm.executeQuery();
			System.out.println("04. 쿼리 실행 및 리턴");
			while(rs.next()) {
				AnswerDto dto = new AnswerDto();
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupsq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setDelflag(rs.getString(5));
				dto.setWriter(rs.getString(6));
				dto.setTitle(rs.getString(7));
				dto.setContent(rs.getString(8));
				dto.setRegdate(rs.getDate(9));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
			System.out.println("05. db 종료");
		}
		return list;
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		AnswerDto dto = new AnswerDto();
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, boardno);
			System.out.println("03. 쿼리 준비" + SELECT_ONE_SQL);
			
			rs = pstm.executeQuery();
			System.out.println("04. 쿼리 실행 및 리턴");
			while(rs.next()) {
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupsq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setDelflag(rs.getString(5));
				dto.setWriter(rs.getString(6));
				dto.setTitle(rs.getString(7));
				dto.setContent(rs.getString(8));
				dto.setRegdate(rs.getDate(9));
			}
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
			System.out.println("05. db 종료");
		}
		return dto;
	}

	@Override
	public boolean insertBoard(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		boolean temp = false;
		
		try {
			pstm = con.prepareStatement(INSERT_BOARD_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("03. 쿼리 준비" + INSERT_BOARD_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("04. 쿼리 실행 및 리턴");
			if (res > 0) {
				temp = true;
				commit(con);
			} else {
				temp = false;
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("05. db 종료");
		}
		return temp;
	}

	@Override
	public boolean updateBoard(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		boolean temp = false;
		
		try {
			pstm = con.prepareStatement(UPDATE_BOARD_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getBoardno());
			System.out.println("03. 쿼리 준비" + UPDATE_BOARD_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("04. 쿼리 실행 및 리턴");
			if (res > 0) {
				commit(con);
				temp = true;
			} else {
				rollback(con);
				temp = false;
			}
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("05. db 종료");
		}
		
		return temp;
	}

	@Override
	public boolean delete(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		boolean temp = false;
		
		try {
			pstm = con.prepareStatement(DELETE_BOARD_SQL);
			pstm.setInt(1, boardno);
			System.out.println("03. 쿼리 준비" + DELETE_BOARD_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("04. 쿼리 실행 및 리턴");
			if(res > 0) {
				temp = true;
				commit(con);
			} else {
				temp = false;
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("05. db 종료");
		}
		return temp;
	}

	@Override
	public boolean updateAnswer(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		boolean temp = false;
		
		try {
			pstm = con.prepareStatement(UPDATE_ANSWER_SQL);
			pstm.setInt(1, boardno);
			pstm.setInt(2, boardno);
			System.out.println("03. 쿼리 준비" + UPDATE_ANSWER_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("04. 쿼리 실행 및 리턴");
			if(res > 0) {
				temp = true;
				commit(con);
			} else {
				temp = false;
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("05. db 종료");
		}
		return temp;
	}

	@Override
	public boolean insertAnswer(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		boolean temp = false;
		
		try {
			pstm = con.prepareStatement(INSERT_ANSWER_SQL);
			pstm.setInt(1, dto.getBoardno());
			pstm.setInt(2, dto.getBoardno());
			pstm.setInt(3, dto.getBoardno());
			pstm.setString(4, dto.getWriter());
			pstm.setString(5, dto.getTitle());
			pstm.setString(6, dto.getContent());
			System.out.println("03. 쿼리 준비" + INSERT_ANSWER_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("04. 쿼리 실행 및 리턴");
			if(res > 0) {
				temp = true;
				commit(con);
			} else {
				temp = false;
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("05. db 종료");
		}
		return temp;
	}

}
