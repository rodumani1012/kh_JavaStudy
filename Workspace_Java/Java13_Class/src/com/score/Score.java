package com.score;

public class Score {
	// 100~90 A, 89~80 B, 79~70 C, 69~60 D, 59~50 E, 나머지 F
	private String name;
	private int kor, eng, math;

	public Score() {

	}

	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return kor + eng + math;
	}

	public double getAvg() {
		return (double) getSum() / 3;
	}

	public String getGrade() {
		String tmp = "";

		switch ((int) getAvg() / 10) {
		case 10:
		case 9:
			tmp = "A";
			break;
		case 8:
			tmp = "B";
			break;
		case 7:
			tmp = "C";
			break;
		case 6:
			tmp = "D";
			break;
		case 5:
			tmp = "E";
			break;
		default:
			tmp = "F";
			break;
		}
		return tmp;
	}

	@Override
	public String toString() {
		return "이름 : " + name + " 국어 : " + kor + " 영어 : " + eng + " 수학 : " + math + 
				"\n총점 : " + getSum() + " 평균 : " + getAvg() + " 등급 : " + getGrade();
	}

}
