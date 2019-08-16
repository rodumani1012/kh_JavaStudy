package com.ant;

public class AntQuiz {
	// 개미수열
	//	1, 11, 12, 1121, 122111, 112213,......

	// 얘가 뭔지, 얘가 몇개인지, 
	// 같으면 cnt ++, 다르면 걔는 몇개인지
	//	public static void ant(String ant) {
	//		
	//		
	//		int cnt = 0;
	//		int loopTime = 5;
	//		
	//		char[] c = ant.toCharArray();
	//		for(int i=0; i<ant.length(); i++) {
	//			if(c[i]==c[i+1]) {
	//				cnt++;
	//			} else {
	//				
	//			}
	//		}
	//	}
	//	
	//	public static void main(String[] args) {
	//		ant("1121");
	//	}
	public static void main(String[] args) {
		String startnum = "89";
		String nextnum = "";
		String nownum = "";
		int outputline = 5;
		int no = 1;

		System.out.println(startnum);

		for (int i = 0; i < outputline; i++) {
			nextnum = "";
			nownum = "";
			/*
			 * startnum길이만큼 루프를 돌리고,nownum과 nownum의 다음자리수와 같으면 while문을 실행 다음번호를 nextnum에 담은후
			 * 출력!!!
			 */
			for (int j = 0; j < startnum.length(); j++) {
				nownum = startnum.substring(j, j + 1);
				if (j + 1 < startnum.length() && nownum.equals(startnum.substring(j + 1, j + 2))) {
					while (j + 1 < startnum.length() && nownum.equals(startnum.substring(j + 1, j + 2))) {
						j++;
						no++;
					}
					nextnum = nextnum + nownum + no;
				} else {
					nextnum = nextnum + nownum + "1";
				}
				no = 1;
			}
			startnum = nextnum;
			System.out.println(nextnum);
		}
	}
}
