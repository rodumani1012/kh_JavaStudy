package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MVCBoardDto;

import common.JDBCTemplate;

public class MVCBoardDao extends JDBCTemplate{

	public List<MVCBoardDto> selectList(){
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();
		
		String sql = " SELECT SEQ,WRITER,TITLE,CONTENT,REGDATE FROM MVCBOARD ORDER BY SEQ DESC ";
		try {
			pstm=con.prepareStatement(sql);
			System.out.println("03. query준비 끝");
			rs=pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			while(rs.next()) {
				MVCBoardDto dto = new MVCBoardDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
				list.add(dto);		
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("03/04 단계 에러");
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05.db종료");
		}
		
		return list;
	}
	public MVCBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MVCBoardDto dto = new MVCBoardDto();
		
		String sql =" SELECT * FROM MVCBOARD WHERE SEQ=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			
			rs=pstm.executeQuery();
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		return dto;
	}
	public int insert(MVCBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res=0;
		
		String sql=" INSERT INTO MVCBOARD VALUES(MVCBOARDSEQ.NEXTVAL,?,?,?,SYSDATE) ";
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			res=pstm.executeUpdate();
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
	public int update(MVCBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql=" UPDATE MVCBOARD SET TITLE=?,CONTENT=? WHERE SEQ=? ";
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			
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
	public int multiDelete(String[] seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		int[] cnt = null;
		String sql=" DELETE FROM MVCBOARD WHERE SEQ=? ";
		try {
			pstm=con.prepareStatement(sql);
			
			for(int i=0;i<seq.length;i++) {
				pstm.setString(1, seq[i]);
				
				pstm.addBatch();//executeBatch() 를 실행할때 쌓여있는 쿼리가 한번에 실행된다.
			}
			cnt=pstm.executeBatch();
			for(int i=0;i<cnt.length;i++) {
				if(cnt[i]==-2) {
					res++;
				}
			}
			if(res == seq.length) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " DELETE FROM MVCBOARD WHERE SEQ=? ";
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, seq);
			
			res=pstm.executeUpdate();
			if(res > 0) {
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
	
	public int countboard() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int res=0;
		String sql=" SELECT COUNT(*) FROM MVCBOARD ";
		
		try {
			pstm=con.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
		}
		return res;
	}
}
