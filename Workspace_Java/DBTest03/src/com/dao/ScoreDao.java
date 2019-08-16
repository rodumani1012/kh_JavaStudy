package com.dao;

import java.util.List;

import com.dto.ScoreDto;

public interface ScoreDao {

	String SELECT_ALL_SQL = " SELECT * FROM TB_SCORE ";
	String SELECT_ONE_SQL = " SELECT * FROM TB_SCORE WHERE S_NO = ? ";
	String INSERT_SQL = " INSERT INTO TB_SCORE VALUES(SCORESQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?) ";
	String UPDATE_SQL = " UPDATE TB_SCORE SET S_NAME = ?, S_KOR = ?, S_ENG = ?, S_MATH = ? "
			+ "WHERE S_NO = ? ";
	String DELETE_SQL = " DELETE FROM TB_SCORE WHERE S_NO = ? ";
	String SELECT_FIRST_SQL = " SELECT * FROM(SELECT A.*, ROWNUM AS R "
			+ " FROM(SELECT * FROM TB_SCORE ORDER BY S_SUM DESC) A) B "
			+ " WHERE B.R = ? ";
	String SELECT_SECOND_SQL = " SELECT * FROM(SELECT A.*, ROWNUM AS R "
			+ " FROM(SELECT * FROM TB_SCORE ORDER BY S_SUM DESC) A) B "
			+ " WHERE B.R = ? ";
	String SELECT_THIRD_SQL = " SELECT * FROM(SELECT A.*, ROWNUM AS R "
			+ " FROM(SELECT * FROM TB_SCORE ORDER BY S_SUM DESC) A) B "
			+ " WHERE B.R = ? ";
	
	public List<ScoreDto> selectList();
	public ScoreDto selectOne(int m_no);
	public int insert(ScoreDto dto);
	public int update(ScoreDto dto);
	public int delete(int m_no);
	public ScoreDto first(int s_no);
	public ScoreDto second(int s_no);
	public ScoreDto third(int s_no);
}
