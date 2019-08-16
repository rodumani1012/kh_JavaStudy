package com.toy.project.biz;

import java.util.List;
import java.util.Map;

import com.toy.home.dto.user_info_dto;
import com.toy.project.dao.project_dao;
import com.toy.project.dao.project_daoimpl;
import com.toy.project.dto.prj_info_dto;
import com.toy.project.dto.prj_issue_dto;

public class project_bizimpl implements project_biz {

	project_dao dao = new project_daoimpl();

	@Override
	public int prj_new(String prj_name, int user_num, String prj_loc, String user_nickname) {
		return dao.prj_new(prj_name, user_num, prj_loc, user_nickname);
	}

	@Override
	public List<prj_info_dto> prj_list(int user_num) {
		return dao.prj_list(user_num);
	}

	@Override
	public List<prj_info_dto> prj_board(int prj_num) {
		return dao.prj_board(prj_num);
	}

	@Override
	public user_info_dto nick_check(String nickname) {
		return dao.nick_check(nickname);
	}

	@Override
	public user_info_dto bring_email(String nickname) {
		return dao.bring_email(nickname);
	}

	@Override
	public user_info_dto bring_nick(int user_num) {
		return dao.bring_nick(user_num);
	}

	@Override
	public user_info_dto bring_num(String nickname) {
		return dao.bring_num(nickname);
	}

	@Override
	public prj_info_dto bring_prj(String prj_name, int user_num) {
		return dao.bring_prj(prj_name, user_num);
	}

	@Override
	public int insert_user(int prj_num, int invite_num) {
		return dao.insert_user(prj_num, invite_num);
	}

	@Override
	public int board_new(Map<String, String> map) {
		return dao.board_new(map);
	}

	@Override
	public int board_move(Map<String, Integer> map) {
		return dao.board_move(map);
	}

	@Override
	public int prj_issue_insert(prj_issue_dto dto) {
		return dao.prj_issue_insert(dto);
	}

	@Override
	public int issue_new(Map<String, String> map) {
		return dao.issue_new(map);
	}

	@Override
	public List<prj_issue_dto> prj_issue_list(int prj_num) {
		return dao.prj_issue_list(prj_num);
	}

	@Override
	public prj_info_dto prj_selectOne(int prj_num) {
		return dao.prj_selectOne(prj_num);
	}

	@Override
	public int prj_update(prj_info_dto dto) {
		return dao.prj_update(dto);
	}

	@Override
	public int prj_delete(int prj_num) {
		return dao.prj_delete(prj_num);
	}

	@Override
	public Map<String, String> issue_one(int issue_num) {
		return dao.issue_one(issue_num);
	}

	@Override
	public int issue_update(Map<String, String> map) {
		return dao.issue_update(map);
	}

	@Override
	public int issue_del(int issue_num) {
		return dao.issue_del(issue_num);
	}
}
