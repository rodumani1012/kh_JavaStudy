package com.aaa;

public class AAA {
	
	private int abc;
	
	// 생성자(default constructor)
	public AAA() {
		// super();
		System.out.println("AAA 생성");
	}
	// 생성자(파라미터가 있는 생성자)
	public AAA(int abc) {
		this.abc = abc;
		System.out.println("AAA 생성(abc 받아서 생성)");
	}

	//getter & setter
	public int getAbc() { //abc값을 가져올 때 get 사용
		return abc;
	}
	
	public void setAbc(int abc) { //abc에 값을 집어넣고 싶을때 set 사용
		this.abc = abc;
	}
	
	
	public void prn() {
		System.out.println("AAA의 prn 메소드");
	}
	
	
}
/*
 <생성자>
 1. 클래스 이름과 동일하되, 리턴타입 없고, 객체 생성시 접근 제한자는 public이다.
 
 class MyTest{
 	public MyTest() {
 	}
 }
 
 2. 생성자는 객체 생성을 하는 new 연산자와 함께 사용되며 생성시 단 한번만 자동 호출 된다.
 
 MyTest t01 = new MyTest();
 
 3. 생성자는 메소드처럼 호출할 수 없다.
 
 t01.MyTest();   (X)
 
 4. 생성자는 overload 할 수 있다.
 class MyTest{
 	int a;
 	int b;
 	public MyTest() {}				// default constructor(기본생성자)
 	public MyTest(int a) {}
 	pbblic MyTest(int a, int b) {}
 }
 
 5. 생성자를 명시하지 않으면 기본 생성자가 자동으로 제공되어 멤버변수(field)를 초기화 하고,
 	명시된 생성자만 선언하게 되면 명시 생성자만 호출이 가능하고 기본 생성자는 제공되지 않는다.
 	
 class AA {
 }				// new AA();  라고 쓸 수 있다.
 
 class BB {
 	public BB() {}
 }				// new BB(); 라고 쓸 수 있다.
 
 class CC {
 	public CC(int c) {} //명시된 생성자
 }				// new CC();  불가능  -> new CC(10);  가능
  
  
 6. 생성자는 상속되지 않는다.
 
 7. 생성자는 내부호출 할 수 있다. 키워드는 this()
 
 8. 생성자의 목적은 객체 생성 및 멤버변수 초기화 이다.
  
  
 */
