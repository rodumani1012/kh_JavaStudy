package com.test02;

public class FruitBasket {
	
	// field(전역 변수)
	// static이 붙은 basketSize는 class 변수
	 static int basketSize = 30;
	// static이 안붙은 fruitCount, fruitName은 instance 변수
	 int fruitCount = 10;
	 String fruitName;
	
	public void basketSetting(String name, int fruit) {
		// 1. 파라미터로 넘어온 과일 이름을
		// 	  fruitName 변수에 대입하자
		fruitName = name;
		
		
		// 2. 파라미터로 넘어온 과일 갯수(int fruit)를
		//	  fruitCount 변수에 더하자
		fruitCount += fruit;
		basketPrn();
	}
	
	private void basketPrn() {
		
		System.out.println("바구니 안의 과일 : " + fruitName);
		
		// 3. 삼항연산자를 사용하여 조건(basketSize 변수의 값이 fruitCount 변수의 값보다
		//		크거나 같은 경우 "fruitName 의 갯수는 fruitCount 입니다."
		//		아닐 경우 "바구니가 넘쳤습니다." 를 출력하자.
		
		//res는 지역변수
		String res = (basketSize >= fruitCount)? fruitName + "의 갯수는 " + fruitCount + " 입니다." : "바구니가 넘쳤습니다.";
		System.out.println(res);
	}
}
