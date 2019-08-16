package com.test01;

public class Weather {

	public void prn(int a) {
		String res = ((a>=3) && (a<6))?"봄":
						((a>=6) && (a<9))?"여름":
							((a>=9) && (a<12))?"가을":
								((a==12) || (a<3))?"겨울":
									"잘못 입력 하셨습니다.";
		
		System.out.println(res);
	}
}
