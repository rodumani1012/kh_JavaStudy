package com.pc.biz;

import java.util.List;

import com.pc.dao.PcDao;
import com.pc.dto.PcDto;

public class PcBiz {
	private PcDao dao = new PcDao();

	public List<PcDto> selectlist() {

		return dao.selectlist();
	}

	public PcDto login(String id, String pw) {
		return dao.login(id, pw); // dto
	}

	public PcDto idchek(String id) {
		return dao.idchek(id);
	}

	public int insert(PcDto dto) {
		return dao.insert(dto);

	}

	public PcDto myselectOne(String myid) {

		return dao.myselectOne(myid);

	}

	public int update(PcDto dto) {

		return dao.update(dto);

	}

	public List<PcDto> selectById(String inputId) {
		// TODO Auto-generated method stub
		return dao.selectById(inputId);
	}

	public List<PcDto> selectByName(String inputname) {
		// TODO Auto-generated method stub
		return dao.selectByName(inputname);
	}

}
