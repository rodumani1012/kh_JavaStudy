package com.dao;

import java.sql.SQLException;

import com.dto.AfterDto;

public class MTest {

	public static void main(String[] args) throws SQLException {
		AfterDao dao = new AfterDao();
		
		AfterDto dto = new AfterDto();
		dto.setId("wnsdus");
		dto.setPw("123");
		
		dto = dao.loginCheck(dto.getId(), dto.getPw());
		dao.checkNinety(dto);
	}
}
