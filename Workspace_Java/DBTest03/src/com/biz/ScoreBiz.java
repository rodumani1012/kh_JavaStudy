package com.biz;

import java.util.List;

import com.dto.ScoreDto;

public interface ScoreBiz {
	
	public List<ScoreDto> selectList();
	public ScoreDto selectOne(int s_no);
	public int insert(ScoreDto dto);
	public int update(ScoreDto dto);
	public int delete(int s_no);
	public ScoreDto first(int s_no);
	public ScoreDto second(int s_no);
	public ScoreDto third(int s_no);
}
