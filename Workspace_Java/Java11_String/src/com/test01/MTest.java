package com.test01;

import java.util.Arrays;

public class MTest {
	// field(전역 변수)
	// static이 붙으면 class 변수
	// static이 안붙으면 instance 변수
	static String str = "The String class represents character strings.";
	
	public static void main(String[] args) {
		
		String s = "hello";
		s = s + 1 + 2; //s의 "hello"가 바뀌지 않고 string pool 영역에 저장되어있고
					   //"hello12"라는 새로운 값이 메모리에 생성된다.
		
		System.out.println(s); //String은 변하지 않는다.(immutable)
		
		s = 1+2+s;
		System.out.println(s);
			
		prn01();
		prn02();
		prn03();
		prn04();
		prn05();
		prn06();
		prn07();
		prn08();
		prn09();
		prn10();		
		
	}

	//		1. str의 길이를 출력하자
	private static void prn01() {
		System.out.println("1번 : " + str.length());
	}
	
	//		2. str 전체를 대문자로 바꿔서 출력.
	private static void prn02() {
		System.out.println("2번 : " + str.toUpperCase());
	}	
	
	//		3. str 전체를 소문자로 바꿔서 출력
	private static void prn03() {
		System.out.println("3번 : " + str.toLowerCase());
	}
	
	//		4. str에서 첫 번째 c의 인덱스 위치를 출력.
	private static void prn04() {
		System.out.println("4번 : " + str.indexOf('c'));
//		System.out.println("4번 : " + str.indexOf('c',12)); // 12번 index 이후에 나오는 c의 위치
	}
		
	//		5. class 를 java로 바꿔서 출력.
	private static void prn05() {
		System.out.println("5번 : " + str.replace("class", "java"));
	}
	
	//		6. character를 찾아서 대문자로 변환 후, str 전체를 출력.
	private static void prn06() {	
		String a = str.substring(28, 37).toUpperCase();
		System.out.println("6번 : " + str.replace("character", a));
	}
	
	// 강사
	private static void prntea06() {
		String target = "character";
		int start = str.indexOf(target);
		int end = target.length() + start;
		String upper = str.substring(start, end).toUpperCase();
		System.out.println(str.replace(target, upper));
	}
	
	//		7. str을 char[]로 바꿔서 출력하되, c 만 출력.
	//			그리고, c의 갯수도 출력.	
	private static void prn07() {
		char[] arr = str.toCharArray();
//		System.out.println(Arrays.toString(arr)); //배열에 잘 들어갔는지 확인
		int cnt = 0;
		System.out.print("7번 : ");
		for(int i =0; i<arr.length; i++) {
			if(Character.toLowerCase(arr[i]) == 'c') {
				System.out.print(arr[i]);
				cnt++;
			} else {
				System.out.print(" ");
			}
		}
		System.out.println("\n\tc의 갯수 : " + cnt);
	}
	
	//		8. str을 char[]로 바꿔서 출력하되, 대문자만 출력.
	//			그리고 대문자의 갯수도 출력.
	private static void prn08() {
		char[] arr = str.toCharArray();
		int cnt = 0;
		System.out.print("8번 : ");		
		for(int i=0; i<arr.length; i++) {
			if(Character.isUpperCase(arr[i])) {
				System.out.print(arr[i]);
				cnt++;
			} else {
				System.out.print(" ");
			}
		}
		System.out.println("\n\t대문자의 갯수 : " + cnt);
	}
	// 강사
	private static void prntea08() {
		char[] arr = str.toCharArray();
		int cnt = 0;
		for (int i = 0; i<arr.length; i++) {
			if(arr[i]=='c' || arr[i]=='C') {
				System.out.printf("%c", arr[i]);
				cnt++;
			}
		}
	}
	
	//		9. str에 있는 모든 공백을 제거 후 출력.
	private static void prn09() {		
//		System.out.println(str.trim()); //맨 앞, 뒤의 공백을 제거
		System.out.println("9번 : " + str.replace(" ", "")); //문자 그대로 인식.
		System.out.println("9번 : " + str.replaceAll(" ", "")); //정규표현식으로 인식
	}
	
	//		10. 전체를 역순으로 출력.
	private static void prn10() {
		char[] arr = str.toCharArray();
		System.out.print("10번 : ");
		for(int i=45; i>-1; i--) {
			System.out.print(arr[i]);
		}
	}
	//강사
	private static void prntea10() {
		int arrIndex = 0;
		char[] ch = new char[str.length()];
		
		for(int i = str.length()-1; i>=0; i--) { // -1은 ch에 46번 인덱스가 없으므로.
			ch[i] =str.charAt(arrIndex); //45번지부터 거꾸로 하나씩 집어넣음
			arrIndex++;
		}
		System.out.println(ch); //거꾸로 넣어진 ch를 출력.
	}
}
