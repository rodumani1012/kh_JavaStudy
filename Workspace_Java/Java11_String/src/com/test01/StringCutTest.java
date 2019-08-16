package com.test01;

import java.util.StringTokenizer;

public class StringCutTest {
	
	public static void main(String[] args) {
		
		String str = "The String class represents character strings.";
		
		// subString -> java.lang.String
		System.out.println(str.substring(4,10));
		
		// split -> java.lang.String
		String[] tmp = str.split(" ");
		for (int i=0; i< tmp.length; i++) {
			System.out.println(tmp[i+2]);
		}
		
		// StringTokenizer -> java.util
		StringTokenizer st= new StringTokenizer(str, " ");
		
		while(st.hasMoreElements()) { //정규표현식에 따라 뒤에 더 있는지 확인함.
			System.out.println(st.nextToken()); //있으면 행동함.
		}
	}
}
