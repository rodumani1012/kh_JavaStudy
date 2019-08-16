package com.login.biz;

import java.util.List;

import com.login.dao.LoginDao;
import com.login.dto.LoginDto;

public class LoginBiz {

	private LoginDao dao = new LoginDao();
	
	public LoginDto login(String myid, String mypw) {
		return dao.login(myid, mypw);
	}
	
	public LoginDto idChk(String myid) {
		return dao.idChk(myid);
	}
	
	public int regist(LoginDto dto) {
		return dao.regist(dto);
	}
	
	public List<LoginDto> selectEnabled() {
		return dao.selectEnabled();
	}
	
	public LoginDto selectOne(int myno) {
		return dao.selectOne(myno);
	}
	
	public int updateRole(int myno, String myrole) {
		return dao.updateRole(myno, myrole);
	}
	
	public int delete(int myno) {
		return dao.delete(myno);
	}
	
	public int update(LoginDto dto) {
		return dao.update(dto);
	}
}
