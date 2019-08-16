package com.spr.mvc.model.biz;

import java.util.List;

import com.spr.mvc.model.dto.MyMVCDto;

public interface MyMVCBiz {

	public List<MyMVCDto> selectList();
	public MyMVCDto selectOne(int seq);
	public int insert(MyMVCDto dto);
	public int update(MyMVCDto dto);
	public int delete(int seq);
	public int muldel(int[] seq);
	
}
