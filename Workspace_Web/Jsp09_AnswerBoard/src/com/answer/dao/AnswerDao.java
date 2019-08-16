package com.answer.dao;

import java.util.List;

import com.answer.dto.AnswerDto;

public interface AnswerDao {

	String SELECT_LIST_SQL = " SELECT BOARDNO,GROUPNO,GROUPSQ,TITLETAB,TITLE,CONTENT,WRITER,REGDATE FROM ANSWERBOARD "
			+ " ORDER BY GROUPNO DESC, GROUPSQ ";
	String SELECT_ONE_SQL = " SELECT BOARDNO,GROUPNO,GROUPSQ,TITLETAB,TITLE,CONTENT,WRITER,REGDATE FROM ANSWERBOARD "
			+ " WHERE BOARDNO = ? ";
	String INSERT_BOARD_SQL = " INSERT INTO ANSWERBOARD "
			+ " VALUES(BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0, ?, ?, ?, SYSDATE) ";
	String UPDATE_BOARD_SQL = " UPDATE ANSWERBOARD SET TITLE = ?, CONTENT = ? "
			+ " WHERE BOARDNO = ? ";
	String DELETE_BOARD_SQL = " DELETE FROM ANSWERBOARD WHERE BOARDNO = ? ";
	
	//게시글 답변 쿼리문
	String UPDATE_ANSWER_SQL = " UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1 " + 
			" WHERE GROUPNO=(SELECT GROUPNO FROM ANSWERBOARD " + 
			"				WHERE BOARDNO = ?) " + 
			" AND GROUPSQ > (SELECT GROUPSQ FROM ANSWERBOARD " + 
			"				WHERE BOARDNO = ?) ";
	String INSERT_ANSWER_SQL = " INSERT INTO ANSWERBOARD " + 
			" VALUES(BOARDNOSEQ.NEXTVAL, " + 
			"	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=?), " + 
			"	(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=?)+1, " + 
			"	(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO=?)+1, " + 
			"	?,?,?,SYSDATE " + 
			" ) ";
	
	public List<AnswerDto> selectList();
	public AnswerDto selectOne(int boardno);
	public int insertBoard(AnswerDto dto);
	public int updateBoard(AnswerDto dto);
	public int delete(int boardno);
	
	//게시글 답변 메소드
	public int updateAnswer(int boardno);
	public int insertAnswer(AnswerDto dto);
}
