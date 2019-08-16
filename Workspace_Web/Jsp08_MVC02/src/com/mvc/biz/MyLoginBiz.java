package com.mvc.biz;

import java.util.List;

import com.mvc.dto.MyLoginDto;

public interface MyLoginBiz {

	public MyLoginDto login(String myid, String mypw);
	public MyLoginDto idChk(String myid);
	public int regist(MyLoginDto dto);
	public List<MyLoginDto> selectEnabled();
	public MyLoginDto selectOne(int myno);
	public int updateRole(int myno, String myrole);
	public int delete(int myno);
	public int update(MyLoginDto dto);
}
