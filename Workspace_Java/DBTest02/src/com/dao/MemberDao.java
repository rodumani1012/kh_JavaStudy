package com.dao;

import java.util.List;

import com.dto.MemberDto;

public interface MemberDao {

	String SELECT_ALL_SQL = " SELECT * FROM TB_MEMBER ORDER BY M_NO "; //인터페이스에서 만든 변수는 
																		//상수화 됨
	static final String SELECT_ONE_SQL = " SELECT * FROM TB_MEMBER WHERE M_NO = ? "; //자동으로 상수화되므로
														//static final을 안붙여도 된다.
	String INSERT_SQL = " INSERT INTO TB_MEMBER VALUES(MEMBERSQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?) ";
	String UPDATE_SQL = " UPDATE TB_MEMBER "
			+ " SET M_NAME = ?, M_AGE = ? "
			+ ", M_GENDER = ?, M_LOCATION = ? "
			+ ", M_JOB = ?, M_TEL = ?, M_EMAIL = ? "
			+ "WHERE M_NO = ? ";
	String DELETE_SQL = " DELETE FROM TB_MEMBER WHERE M_NO = ? ";

	public List<MemberDto> selectList();
	public MemberDto selectOne(int m_no);
	public int insert(MemberDto dto);
	public int update(MemberDto dto);
	public int delete(int m_no);
	
	
}
