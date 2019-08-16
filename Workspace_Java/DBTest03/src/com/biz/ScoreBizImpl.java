package com.biz;

import java.util.List;

import com.dao.ScoreDao;
import com.dao.ScoreDaoImpl;
import com.dto.ScoreDto;

public class ScoreBizImpl implements ScoreBiz {

	private ScoreDao dao = new ScoreDaoImpl(); 
	
	@Override
	public List<ScoreDto> selectList() {
		
		return dao.selectList();
	}

	@Override
	public ScoreDto selectOne(int s_no) {
		
		return dao.selectOne(s_no);
	}

	@Override
	public int insert(ScoreDto dto) {
		int sum = getSum(dto.getS_kor(), dto.getS_eng(), dto.getS_math());
		double avg = getAvg(sum);
		String grade = getGrade(avg);
		
		dto.setS_sum(sum);
		dto.setS_avg(avg);
		dto.setS_grade(grade);
		
		return dao.insert(dto);
	}

	@Override
	public int update(ScoreDto dto) {
		int sum = getSum(dto.getS_kor(), dto.getS_eng(), dto.getS_math());
		double avg = getAvg(sum);
		String grade = getGrade(avg);
		
		dto.setS_sum(sum);
		dto.setS_avg(avg);
		dto.setS_grade(grade);
		
		return dao.update(dto);
	}

	@Override
	public int delete(int s_no) {
		
		return dao.delete(s_no);
	}

	@Override
	public ScoreDto first(int s_no) {
		
		return dao.first(s_no);
	}

	@Override
	public ScoreDto second(int s_no) {
		
		return dao.second(s_no);
	}

	@Override
	public ScoreDto third(int s_no) {
		
		return dao.third(s_no);
	}
	
	private int getSum(int kor, int eng, int math) {
		return kor+eng+math;
	}
	
	private double getAvg(int sum) {
		return (double) sum/3;
	}
	
	private String getGrade(double avg) {
		
		switch ((int)avg/10) {
		case 10: case 9:
			return "A";		
		case 8:
			return "B";		
		case 7:
			return "C";	
		case 6:
			return "D";	
		default:
			return "F";	
		}
	}
}
