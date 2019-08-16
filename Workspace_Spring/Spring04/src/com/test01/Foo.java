package com.test01;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Foo {

	Bar bar;
	
	public Foo() {
		System.out.println("no args 생성자");
	}
	
	public Foo(Date date) {
		System.out.println("생성자(date) : " + date);
	}
	
	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("setBar(bar) 호출!");
	}
	
	public void setDate(Date d) {
		System.out.println("setDate(d) 호출!");
	}
	
	public void setNumber(int num) {
		System.out.println("setNumber(" + num + ") 호출");
	}
	
	public void setStudent(String[] item) {
		System.out.println("setStudent() 호출!");
		for(String name : item) {
			System.out.println("학생 : " + name);
		}
	}
	
	public void setInfo(List<String> item) {
		System.out.println("setInfo() 호출!");
		for(String res : item) {
			System.out.println(res);
		}
	}
	
	public void setEvent(Set<String> item) {
		System.out.println("setEvent() 호출!");
		for(String res : item) {
			System.out.println(res);
		}
	}
	
	public void setSeason(Map<String, String> item) {
		System.out.println("setSeason() 호출!");
		Set<String> keys = item.keySet();
		for(String key : keys) {
			System.out.println(key + "의 계절 : " + item.get(key));
		}
	}
	
	public void setScore(List<Score> list) {
		System.out.println("setScore() 호출!!");
		
		for (Score res : list) {
			System.out.println(res);
		}
	}
}
