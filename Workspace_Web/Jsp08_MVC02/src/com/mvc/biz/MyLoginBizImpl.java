package com.mvc.biz;

import java.util.List;

import com.mvc.dao.MyLoginDaoImpl;
import com.mvc.dto.MyLoginDto;

public class MyLoginBizImpl implements MyLoginBiz {

	private MyLoginDaoImpl dao = new MyLoginDaoImpl();  
	
	@Override
	public MyLoginDto login(String myid, String mypw) {
		return dao.login(myid, mypw);
	}

	@Override
	public MyLoginDto idChk(String myid) {
		return dao.idChk(myid);
	}

	@Override
	public int regist(MyLoginDto dto) {
		return dao.regist(dto);
	}

	@Override
	public List<MyLoginDto> selectEnabled() {
		return dao.selectEnabled();
	}

	@Override
	public MyLoginDto selectOne(int myno) {
		return dao.selectOne(myno);
	}

	@Override
	public int updateRole(int myno, String myrole) {
		return dao.updateRole(myno, myrole);
	}

	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}

	@Override
	public int update(MyLoginDto dto) {
		return dao.update(dto);
	}
}
