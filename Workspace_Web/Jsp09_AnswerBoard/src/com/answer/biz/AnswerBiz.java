package com.answer.biz;

import java.util.List;

import com.answer.dto.AnswerDto;

public interface AnswerBiz {
	
	public List<AnswerDto> selectList();
	public AnswerDto selectOne(int boardno);
	public int insertBoard(AnswerDto dto);
	public int updateBoard(AnswerDto dto);
	public int delete(int boardno);
	
	//게시글 답변 메소드
//	public int updateAnswer(int boardno);
//	public int insertAnswer(AnswerDto dto);
	// 16~17을 하나로 묶는 것이 biz의 역할.
	public int answerProc(AnswerDto dto);
//	public int answerProc(AnswerDto dto, int parentBoardNo); 부모게시글 번호도 알면 보기 더 편해질 수 있음
}
