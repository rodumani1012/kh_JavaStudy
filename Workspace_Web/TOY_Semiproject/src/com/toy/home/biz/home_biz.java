package com.toy.home.biz;

import java.util.List;
import java.util.Map;

import com.toy.home.dto.comment_board_dto;
import com.toy.home.dto.normal_board_dto;
import com.toy.project.dto.prj_info_dto;

public interface home_biz {

	public List<normal_board_dto> selectList(String normal_category, int firstIndex, int recordCountPerPage,
			String txt_search);

	public normal_board_dto selectOne(int normal_num);

	public int insert(Map<String, String> map);

	public int update(normal_board_dto dto);

	public int delete(int normal_num);

	public void plusReadCount(int num);

	public int comment_insert(Map<String, String> map);

	public List<comment_board_dto> comment_list(int normal_num);

	public int comment_comment(Map<String, String> map);

	public int comment_delete(int comment_num);

	public int getTotalCount(String normal_category, String txt_search);
	
	public List<normal_board_dto> small_selectList(String normal_category);
	
	public List<prj_info_dto> small_prj_selectList();
	
	public int kakaopay(normal_board_dto dto);

}