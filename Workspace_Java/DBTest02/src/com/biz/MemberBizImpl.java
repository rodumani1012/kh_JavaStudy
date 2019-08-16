package com.biz;

import java.util.List;

import com.dao.MemberDao;
import com.dao.MemberDaoImpl;
import com.dto.MemberDto;

public class MemberBizImpl implements MemberBiz {
//서비스 역할(연산, 바꾸기 등등)
	private MemberDao dao = new MemberDaoImpl();
	
	@Override
	public List<MemberDto> selectList() {
		
//		List<MemberDto> list = dao.selectList();
//		return list;
		// 16~17라인 한줄로
		return dao.selectList();
	}

	@Override
	public MemberDto selectOne(int m_no) {
		
		MemberDto res = dao.selectOne(m_no);
		
		return res;
	}

	@Override
	public int insert(MemberDto dto) {
		
		MemberDto tmp = dto;
		tmp.setM_gender(dto.getM_gender().toUpperCase());
		
		return dao.insert(tmp);
	}

	@Override
	public int update(MemberDto dto) {
		
		MemberDto tmp = dto;
		tmp.setM_gender(dto.getM_gender().toUpperCase());
		
		return dao.update(tmp);
	}

	@Override
	public int delete(int m_no) {
//		int res = dao.delete(m_no);
//		return res;		
		
		return dao.delete(m_no);
	}

}
