package com.test01.vector;

import java.util.Vector;

public class VectorTest02 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		v.add("홍길동");
		v.add("한진희");
		v.add("정햇나라");
		v.add("최준연");
		v.add("강호동");
		v.add("정민호");
		v.add("조세호");
		
		System.out.println(v);
		printVector(v);
		
		System.out.println("=============");
		
		testVector(v);
		
		
	}
	public static void testVector(Vector<String> v) {
		// 1. "홍길동"의 인덱스를 찾아서
		// 해당 인덱스의 값을 "홍길순"으로 변경하자.
		v.set(v.indexOf("홍길동"), "홍길순");
//		System.out.println(v);
		printVector(v);
				
		// 2. ~동으로 끝나는 값을 찾아서
		// 만일 있다면, 해당 값의 "동"을 "순"으로 바꾸자.
		for(int i = 0; i<v.size(); i++) {
			if(v.get(i).endsWith("동")) {//v.get(i).endsWith("동") 는 true/false 로 나옴
				v.set(v.indexOf(v.get(i)), v.get(i).replace("동", "순"));
//				v.set(i, v.get(i).replace("동", "순"));
			}
		}
		printVector(v);
		
		// 3. 마지막 글자가 "호" 인 값을 찾아서
		// 만일 있다면, 삭제하자.
		for(int i = 0; i<v.size(); i++) {
			if(v.get(i).endsWith("호")) {
				v.remove(i);
			}
		}
		printVector(v);
	}
	
	// 대괄호랑 , 없애고 출력하는 메소드
	public static void printVector(Vector<String> v) {

//		for(int i = 0; i< v.size(); i++) {
//			System.out.print(v.get(i) + " ");
//		}
		// 향상된 for문
		for(String s : v) {
			System.out.printf("%s ", s);
		}
		System.out.println();
	}
}
