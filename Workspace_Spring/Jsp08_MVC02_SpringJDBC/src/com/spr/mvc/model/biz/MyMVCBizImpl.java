package com.spr.mvc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.mvc.model.dao.MyMVCDao;
import com.spr.mvc.model.dto.MyMVCDto;

@Service
public class MyMVCBizImpl implements MyMVCBiz {
	
	@Autowired
	private MyMVCDao dao;

	@Override
	public List<MyMVCDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MyMVCDto selectOne(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public int insert(MyMVCDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MyMVCDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		return dao.delete(seq);
	}

	@Override
	public int muldel(int[] seq) {
		return dao.muldel(seq);
	}

}
