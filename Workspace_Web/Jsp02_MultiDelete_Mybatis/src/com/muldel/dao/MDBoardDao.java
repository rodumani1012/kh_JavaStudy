package com.muldel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.muldel.dto.MDBoardDto;

import static common.JDBCTemplate.*;

public class MDBoardDao extends SqlMapConfig {

	String namespace = "muldelmapper.";

	public List<MDBoardDto> selectList() {
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();

		List<MDBoardDto> list = session.selectList(namespace+"selectList");
		
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

			while (rs.next()) {
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
		int res = 0;

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(false);

			res = session.insert(namespace + "insert", dto); // muldel-mapper.xml에서 
			// 만든 mapper가 여러개이면서 mapper마다 insert 문이 있다면 
			// 어떤 mapper에 insert인지 구분지어줄 필요가 있다. 
			// 현재는 mapper가 muldelmapper 밖에 없으므로 namespace를 생략하고 insert만 써도 된다.
			if(res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
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
		int count = 0; // 삭제된 갯수

		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seq);

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			count = session.delete("muldelmapper.muldel", map);

			if (count == seq.length) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}

}
