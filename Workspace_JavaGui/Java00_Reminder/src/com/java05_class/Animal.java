package com.java05_class;

public class Animal {
	
	// member : field + method
	// field : 속성
	 
	// method : 기능
	
	// constructor : 객체 생성, field 초기화
	
	// field
	private String kind;
	private String name;
	private int age;
	
	// constructor
	public Animal(String kind, String name, int age) {
		this.kind = kind;
		this.name = name;
		this.age = age;
	}
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// getter & setter 를 사용하는 이유 : 
		// 기능 추가하려고. (ex. 유효성 검사)
		// 내가 원하는 값만 필드에 입력할 수 있다.
	// 접근 제어(getter : 읽기 전용 / getter&setter : 읽기 쓰기)
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void bark() {
		System.out.println("울음소리 : ");
	}

	@Override
	public String toString() {
		return "(" + kind + ")" + name + "[" + age + "살]";
	}
	
	
}
