package com.toy.project.biz;

import java.util.List;

import com.toy.project.dao.calendar_dao;
import com.toy.project.dao.calendar_daoimpl;
import com.toy.project.dto.calendar_dto;
import com.toy.project.dto.prj_board_dto;

public class calendar_bizimpl implements calendar_biz {

	calendar_dao dao = new calendar_daoimpl();
	
	@Override
	public List<calendar_dto> selectList(String prj_num, String yyyyMM) {
		return dao.selectList(prj_num, yyyyMM);
	}

	@Override
	public List<prj_board_dto> selectList(String prj_num) {
		return dao.selectList(prj_num);
	}

	@Override
	public prj_board_dto board_num(String category) {
		return dao.board_num(category);
	}

	@Override
	public int issue_insert(calendar_dto dto) {
		return dao.issue_insert(dto);
	}

	@Override
	public List<calendar_dto> issue_list(String prj_num, String yyyyMMdd) {
		return dao.issue_list(prj_num, yyyyMMdd);
	}

}
