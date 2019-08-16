package com.compare;

public class Score implements Comparable<Object> {

	private String name;
	private int kor;
	private int eng;
	private int math;

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
		default:
			tmp = "F";
			break;
		}

		return tmp;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\t 국어 : " + kor + " \t 영어 : " + eng + " \t 수학 : " + math + " \n\t 총점 : " + getSum()
				+ " \t 평균" + String.format("%.2f", getAvg()) + " \t 등급 : " + getGrade();
	}

	@Override
	public int compareTo(Object o) {
		Score other = (Score) o;
		// 나(this)와 other(Score)를 비교하자.

		// + : 앞의 인자가 더 큰 값
		// 0 : 같은 값
		// - : 뒤의 인자가 더 큰 값

		// 오름차순 정렬
		if (this.getKor() > other.getKor()) {
			return 1; // +
		} else if (this.getKor() < other.getKor()) {
			return -1; // -
		} else if (this.getKor() == other.getKor()) {
			if (this.getAvg() > other.getAvg()) {
				return 1; // 0
			} else if (this.getAvg() < other.getAvg()) {
				return -1;
			} else {
				return 0;
			}

		}

		return 0;
	}
}
