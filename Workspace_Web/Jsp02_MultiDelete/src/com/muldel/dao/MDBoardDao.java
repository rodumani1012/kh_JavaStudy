package com.muldel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muldel.dto.MDBoardDto;

import common.JDBCTemplate;

public class MDBoardDao extends JDBCTemplate {
	
	public List<MDBoardDto> selectList() {
		Connection con = getConnection();
		System.out.println("01.계정 및 드라이버 연결");
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		String sql = " SELECT * FROM MDBOARD ORDER BY SEQ DESC";
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("02.쿼리 준비");
			rs = pstm.executeQuery();
			System.out.println("03.쿼리 실행 및 리턴");
			
			while(rs.next()) {
				MDBoardDto dto = new MDBoardDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegedate(rs.getDate(5));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("04.db 종료");
		}		
		return list;
	}
	
	public MDBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM MDBOARD WHERE SEQ = ? ";
		MDBoardDto dto = new MDBoardDto();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegedate(rs.getDate(5));
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
	
	public int insert(MDBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO MDBOARD VALUES(MDBOARDSEQ.NEXTVAL,?,?,?,SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
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
	
	public int update(MDBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE MDBOARD SET TITLE = ?, CONTENT = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			
			res = pstm.executeUpdate();
			
			if(res > 0) {
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
	
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " DELETE FROM MDBOARD WHERE SEQ = ? ";
	
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
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
	
	public int multiDelete(String[] seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " DELETE FROM MDBOARD WHERE SEQ = ? ";
		
		// 결과값 받을 배열
		int[] cnt = null;
		
		try {
			pstm = con.prepareStatement(sql);
			
			for(int i = 0; i < seq.length; i++) {
				pstm.setString(1, seq[i]);
				
				// 메모리에 적재 후,
				// executeBatch() 메소드가 호출될 때
				// 한꺼번에 실행!!
				pstm.addBatch(); // 적재!
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
			close(pstm);
			close(con);
			System.out.println("05.db 종료");
		}
		return res;
	}
	
}
