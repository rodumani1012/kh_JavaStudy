package com.test01;

public class Score {

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private String grade;
	
	public Score() {
		
	}
	
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		getSum();
		getAvg();
		getGrade();
	}


	public Score(String name, int kor, int eng, int math, int sum, double avg, String grade) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = sum;
		this.avg = avg;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return kor + eng + math;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return getSum()/3.0;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getGrade() {
		switch ((int)getAvg()/10) {
		case 10:
		case 9:
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

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + "\t 국어 : " + kor + "\t 영어 : " + eng + "\t 수학 : " + math + 
				"\n\t 총점 : " + getSum() + "\t 평균 : "
				+ getAvg() + "\t 등급 : " + getGrade();
	}
	
}
