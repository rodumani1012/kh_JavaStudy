package com.toy.home.biz;

import java.util.List;

import java.util.Map;

import com.toy.home.dao.home_dao;
import com.toy.home.dao.home_daoimpl;
import com.toy.home.dto.comment_board_dto;
import com.toy.home.dto.normal_board_dto;
import com.toy.project.dto.prj_info_dto;

public class home_bizimpl implements home_biz {
	home_dao dao = new home_daoimpl();

	@Override
	public List<normal_board_dto> selectList(String normal_category, int firstIndex, int recordCountPerPage,
			String txt_search) {
		return dao.selectList(normal_category, firstIndex, recordCountPerPage, txt_search);
	}

	@Override
	public normal_board_dto selectOne(int normal_num) {
		return dao.selectOne(normal_num);
	}

	@Override
	public int insert(Map<String, String> map) {
		return dao.insert(map);
	}

	@Override
	public int update(normal_board_dto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int normal_num) {
		return dao.delete(normal_num);
	}

	@Override
	public void plusReadCount(int num) {
		dao.plusReadCount(num);
	}

	@Override
	public int comment_insert(Map<String, String> map) {
		return dao.comment_insert(map);

	}

	@Override
	public List<comment_board_dto> comment_list(int normal_num) {
		return dao.comment_list(normal_num);
	}

	@Override
	public int comment_comment(Map<String, String> map) {
		return dao.comment_comment(map);
	}

	@Override
	public int comment_delete(int comment_num) {
		return dao.comment_delete(comment_num);
	}

	@Override
	public int getTotalCount(String normal_category, String txt_search) {
		return dao.selectTotalCount(normal_category, txt_search);
	}

	@Override
	public List<normal_board_dto> small_selectList(String normal_category) {
		return dao.small_selectList(normal_category);
	}

	@Override
	public List<prj_info_dto> small_prj_selectList() {
		return dao.small_prj_selectList();
	}

	@Override
	public int kakaopay(normal_board_dto dto) {
		return dao.kakaopay(dto);
	}
}