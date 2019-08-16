package com.answer.dao;

import java.util.List;

import com.answer.dto.AnswerDto;

public interface AnswerDao {

	String SELECT_LIST_SQL = " SELECT * FROM ANSWERNEWBOARD ORDER BY GROUPNO DESC, GROUPSQ ";
	String SELECT_ONE_SQL = " SELECT * FROM ANSWERNEWBOARD WHERE BOARDNO = ? ";
	String INSERT_BOARD_SQL = " INSERT INTO ANSWERNEWBOARD VALUES(BOARDNOSQ.NEXTVAL, "
			+ " GROUPNOSQ.NEXTVAL, 1, 0, 'N', ?, ?, ?, SYSDATE) ";
	String UPDATE_BOARD_SQL = " UPDATE ANSWERNEWBOARD SET TITLE = ?, CONTENT = ? WHERE BOARDNO = ? ";
	String DELETE_BOARD_SQL = " UPDATE ANSWERNEWBOARD SET DELFLAG = 'Y' WHERE BOARDNO = ? ";
	
	String UPDATE_ANSWER_SQL = " UPDATE ANSWERNEWBOARD SET GROUPSQ = GROUPSQ + 1 "
			+ " WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERNEWBOARD "
			+ "  				WHERE BOARDNO = ?) "
			+ " AND GROUPSQ > (SELECT GROUPSQ FROM ANSWERNEWBOARD "
			+ " 				WHERE BOARDNO = ?) ";
	String INSERT_ANSWER_SQL = " INSERT INTO ANSWERNEWBOARD VALUES(BOARDNOSQ.NEXTVAL, "
			+ " (SELECT GROUPNO FROM ANSWERNEWBOARD WHERE BOARDNO = ?), "
			+ " (SELECT GROUPSQ FROM ANSWERNEWBOARD WHERE BOARDNO = ?)+1, "
			+ " (SELECT TITLETAB FROM ANSWERNEWBOARD WHERE BOARDNO = ?)+1, "
			+ " 'N', ?, ?, ?, SYSDATE) ";
	
	public List<AnswerDto> selectList();
	public AnswerDto selectOne(int boardno);
	public boolean insertBoard(AnswerDto dto);
	public boolean updateBoard(AnswerDto dto);
	public boolean delete(int boardno);
	
	public boolean updateAnswer(int boardno);
	public boolean insertAnswer(AnswerDto dto);
	
}
