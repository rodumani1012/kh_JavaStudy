package com.test02;

public class MTest {

	public static void main(String[] args) {
		/*
		 * Cat c = new Cat(); c.bark();
		 * 
		 * Dog d = new Dog(); d.bark();
		 */
		
		Animal some = new Dog();
		some.bark();
		
		some = new Cat();
		some.bark();
		
		if (some instanceof Dog) { //some이 dog의 instance 인가? 를 확인함
			System.out.println("멍멍이");
		}  else if (some instanceof Cat) {
			System.out.println("야옹이");
		}	
		
		Super s = new A();
		B b = (B)s; //ClassCaseException 발생.
	
	}
}
/*
 다형성
 1. 부모의 타입으로 자식 객체를 생성
 Parent p = new Child();
 
 2. 부모의 이름으로 자식 대입
 Child c = new Child();
 Parent p = c;
 
 3. 부모의 메소드를 가지고 자식의 메소드 호출
 
 ※ 같은 부모를 가진 자식 클래스들은 
 컴파일 시에는 형 변환이 가능하지만 (손으로 그냥 쳤을때 문법상 오류가 없지만.)
 런타임시 시에는 ClassCastException을 발생. (실행했을땐 오류가 발생) 
 
 
 */
