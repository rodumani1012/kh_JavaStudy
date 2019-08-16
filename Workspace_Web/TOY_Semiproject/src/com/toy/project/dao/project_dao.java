package com.toy.project.dao;

import java.util.List;
import java.util.Map;

import com.toy.home.dto.user_info_dto;
import com.toy.project.dto.prj_info_dto;
import com.toy.project.dto.prj_issue_dto;

public interface project_dao {
	
public int prj_new(String prj_name, int user_num, String prj_loc, String user_nickname);

	public List<prj_info_dto> prj_list(int user_num);

	public List<prj_info_dto> prj_board(int prj_num);

	public int prj_issue_insert(prj_issue_dto dto);

	public int issue_new(Map<String, String> map);

	public List<prj_issue_dto> prj_issue_list(int prj_num);

	public user_info_dto nick_check(String nickname);

	public user_info_dto bring_email(String nickname);

	public user_info_dto bring_nick(int user_num);

	public user_info_dto bring_num(String nickname);

	public prj_info_dto bring_prj(String prj_name, int user_num);

	public int insert_user(int prj_num, int invite_num);

	public int board_new(Map<String, String> map);

	public int board_move(Map<String, Integer> map);

	public prj_info_dto prj_selectOne(int prj_num);
	
	public int prj_update(prj_info_dto dto);
	
	public int prj_delete(int prj_num);
	
	public Map<String, String> issue_one(int issue_num);

	public int issue_update(Map<String, String> map);

	public int issue_del(int issue_num);
}
