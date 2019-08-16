package com.test01;

/**
 * javadoc test<br/>
 * Hello, World 를 출력하는 class<br/>
 * <br/>
 * javadoc 만드는 방법<br/>
 * project 우클릭 - export - javadoc - %JAVA_HOME%\bin\javadoc.exe <br/>
 * VM옵션에 (-locale ko_KR -encoding UTF-8 -charset UTF-8 -docencoding UTF-8)
 * 
 * @author user1
 *
 */
public class Type01 {
/**
 * main method. 프로그램의 주 진입점
 * @param args 기본 파라미터
 */
		public static void main(String[] args) {
			/*
			 * 주석
			 * =설명
			 * compile 시 주석 제거됨
			 */
			// 한줄 주석
			System.out.println("Hello, World!");
			
		}
}
