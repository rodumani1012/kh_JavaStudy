package com.test03;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
	
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		set.add("1");
		set.add("3");
		set.add("2");
		set.add("5");
//		set.add(null);
		// null 이라는 값으로 들어는 가지만
		// 외부에서 접근하게 되면
		// NullPointerException(NPE)을 발생시킨다.
		set.add("6");
		set.add("4");
		set.add("7");
		set.add("1"); //중복을 허용하지 않는다.
		
		System.out.println(set); //set은 순서가 없다.
		setDelete(set, "4");
		
		System.out.println(set);
		
		setFind(set, "5");
	}
	
	public static void setDelete(Set<String> s, String del) {
		
		for(String d : s) {
			if(d.equals(del)) {
				System.out.println("삭제!");
				s.remove(del);
				break; //break 명령이 없으면 오류발생. 수정, 삭제가 안되는 foreach문의 특성 때문에.
			}
		}
	}
	
	public static void setFind(Set<String> s, String find) {
		
		for(String f : s) {
			if(f.equals(find)) {
				System.out.println(find + "찾았다!");
			}
		}
	}
}
