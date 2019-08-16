package com.cal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cal.dto.CalDto;

import common.JDBCTemplate;

public class CalDao extends JDBCTemplate {

	public int insert(CalDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO CALBOARD " + " VALUES(CALBOARDSQ.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getId());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			pstm.setString(4, dto.getMdate());
			System.out.println("03. query 준비");

			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
			if (res > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("05. db 종료");
		}
		return res;
	}

	public List<CalDto> selectList(String id, String yyyyMMdd) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<CalDto> list = new ArrayList<CalDto>();
		String sql = " SELECT * FROM CALBOARD WHERE ID = ? AND SUBSTR(MDATE,1,8) = ? ORDER BY SEQ DESC ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMMdd);
			System.out.println("03. query 준비");

			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			while (rs.next()) {
				CalDto dto = new CalDto();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setMdate(rs.getString(5));
				dto.setRegdate(rs.getDate(6));

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

	public CalDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		CalDto dto = null;
		String sql = " SELECT * FROM CALBOARD WHERE SEQ = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("03. query 준비");
			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			while (rs.next()) {
				dto = new CalDto();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setMdate(rs.getString(5));
				dto.setRegdate(rs.getDate(6));
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

	public int update(CalDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE CALBOARD SET TITLE = ?, CONTENT = ?, REGDATE = SYSDATE WHERE SEQ = ? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("03. query 준비");

			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
				System.out.println("04. query 실행 및 리턴");
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("05. db 종료");
		}
		return res;
	}
	
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " DELETE FROM CALBOARD WHERE SEQ = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("03. query 준비");
			
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
				System.out.println("04. query 실행 및 리턴");
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("05. db 종료");
		}
		return res;
	}
	
	public int muldel(String[] seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		int[] cnt = null;
		String sql = " DELETE FROM CALBOARD WHERE SEQ = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			for(int i = 0; i < seq.length; i++) {
				pstm.setString(1, seq[i]);
				
				pstm.addBatch();
				System.out.println("삭제할 번호 : " + seq[i]);
			}
			System.out.println("03.query 준비");
			// int[] 형태로 [-2, -3, ....]을 리턴. -2는 성공, -3은 실패    
			cnt = pstm.executeBatch(); // 실행!
			System.out.println("04.query 실행 및 리턴");

			// -2는 성공, -3은 실패
			for(int i = 0; i < cnt.length; i++) {
				if(cnt[i] == -2) {
					res++;
				}			
			}	
			if(res == seq.length) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("05.db 종료");
		}
		return res;
	}
	
	// 해당 날짜에 게시글 목록 최대 3개 보여주는 메소드
	public List<CalDto> getCalViewList(String id, String yyyyMM) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<CalDto> list = new ArrayList<CalDto>();
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, MDATE, REGDATE " + 
				" FROM (SELECT (ROW_NUMBER() OVER( " + 
				"	PARTITION BY SUBSTR(MDATE,1,8) ORDER BY MDATE)) RN, " + 
				"	SEQ, ID, TITLE, CONTENT, MDATE, REGDATE " + 
				"	FROM CALBOARD " + 
				"	WHERE ID = ? AND SUBSTR(MDATE,1,6)= ? ) " + 
				" WHERE RN BETWEEN 1 AND 3 ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMM);
			System.out.println("03. query 준비");
			
			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			while(rs.next()) {
				CalDto dto = new CalDto();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setMdate(rs.getString(5));
				dto.setRegdate(rs.getDate(6));
				
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
	
	// 해당 날짜에 일정이 몇개 있는지 보여주는 메소드
	public int getCalViewCount(String id, String yyyyMMdd) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		int cnt = 0;
		String sql = " SELECT COUNT(*) FROM CALBOARD "
				+ " WHERE ID = ? AND SUBSTR(MDATE,1,8) = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMMdd);
			System.out.println("03. query 준비");
			
			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(con, pstm, rs);
			System.out.println("05. db 종료");
		}
		return cnt;
	}
}
