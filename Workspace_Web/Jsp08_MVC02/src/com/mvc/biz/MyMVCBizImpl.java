package com.mvc.biz;

import java.util.List;

import com.mvc.dao.MyMVCDaoImpl;
import com.mvc.dto.MyMVCDto;

public class MyMVCBizImpl implements MyMVCBiz {
	
	private MyMVCDaoImpl dao = new MyMVCDaoImpl();

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

}
