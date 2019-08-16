package com.toy.project.dao;

import java.util.List;

import com.toy.project.dto.calendar_dto;
import com.toy.project.dto.prj_board_dto;

public interface calendar_dao {

	public List<calendar_dto> selectList(String prj_num, String yyyyMM);
	public List<prj_board_dto> selectList(String prj_num);
	public prj_board_dto board_num(String category);
	public int issue_insert(calendar_dto dto);
	public List<calendar_dto> issue_list(String prj_num, String yyyyMMdd);
}
