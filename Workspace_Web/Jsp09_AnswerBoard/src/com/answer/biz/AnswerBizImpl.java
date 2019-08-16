package com.answer.biz;

import java.util.List;

import com.answer.dao.AnswerDao;
import com.answer.dao.AnswerDaoImpl;
import com.answer.dto.AnswerDto;

public class AnswerBizImpl implements AnswerBiz {

	private AnswerDao dao = new AnswerDaoImpl();
	
	@Override
	public List<AnswerDto> selectList() {
		return dao.selectList();
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		return dao.selectOne(boardno);
	}

	@Override
	public int insertBoard(AnswerDto dto) {
		return dao.insertBoard(dto);
	}

	@Override
	public int updateBoard(AnswerDto dto) {
		return dao.updateBoard(dto);
	}

	@Override
	public int delete(int boardno) {
		return dao.delete(boardno);
	}

	@Override
	public int answerProc(AnswerDto dto) {
		// 부모번호 받아서 -> 부모 그룹 댓글들 순서 +1 -> 새로운 댓글 추가
		
		// select (부모 번호)
		int parentboardno = dto.getBoardno();
		
		// update
		int resUpdate = dao.updateAnswer(parentboardno);
		
		// insert
		int resInsert = dao.insertAnswer(dto);
		
		return (resUpdate + resInsert);
	}

}
