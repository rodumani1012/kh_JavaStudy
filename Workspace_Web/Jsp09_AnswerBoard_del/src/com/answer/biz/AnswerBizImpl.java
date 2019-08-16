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
	public boolean insertBoard(AnswerDto dto) {
		return dao.insertBoard(dto);
	}

	@Override
	public boolean updateBoard(AnswerDto dto) {
		return dao.updateBoard(dto);
	}

	@Override
	public boolean delete(int boardno) {
		return dao.delete(boardno);
	}

	@Override
	public boolean answerProc(AnswerDto dto) {
		
		int parentboardno = dto.getBoardno();
		
		boolean update_res = dao.updateAnswer(parentboardno);
		boolean insert_res = dao.insertAnswer(dto);
		
		boolean temp = false;
		if(update_res==true || insert_res==true) { //마지막글은 update해도 증가할 값이 없으므로 false가 리턴된다.
			temp = true;			//그래서 &&로 묶으면 if조건에서 temp가 false로 반환되고 댓글은 작성이 되는 오류가 발생하므로
		} else {				// ||로 바꿔줘야 한다.
			temp = false;
		}
		return temp;
	}

}
