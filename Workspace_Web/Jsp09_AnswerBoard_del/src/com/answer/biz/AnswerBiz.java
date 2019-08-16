package com.answer.biz;

import java.util.List;

import com.answer.dto.AnswerDto;

public interface AnswerBiz {

	public List<AnswerDto> selectList();
	public AnswerDto selectOne(int boardno);
	public boolean insertBoard(AnswerDto dto);
	public boolean updateBoard(AnswerDto dto);
	public boolean delete(int boardno);
	
//	public boolean updateAnswer(int boardno);
//	public boolean insertAnswer(AnswerDto dto);
	public boolean answerProc(AnswerDto dto);
}
