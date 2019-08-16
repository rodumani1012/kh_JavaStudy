package com.test02;

public class MTest {

	public static void main(String[] args) {
		
		// 1. 바나나 10개 넣어서 출력하자.
		// new class() : instance = 객체
		FruitBasket f1 = new FruitBasket();
		f1.basketSetting("바나나", 10);		
		
		f1.basketSize = 40; //static인 basketSize를 nonstatic인 f1이 불러와서 변경시키자 밑에 사과의 basketSize에 영향을 준다.
		f1.fruitName = "복숭아";
		//non-static에서 static을 부를 수 있지만 전체에 영향을 줄 수 있어 조심해야한다.
		System.out.println(f1.basketSize);
		System.out.println(f1.fruitName);
		System.out.println(f1.fruitCount);

		/*
		 * 또는 
		 * FruitBasket banana = new FruitBasket();
		 * banana.basketSetting("바나나", 10);
		 */
		
		
		// 2. 사과 21개 넣어서 출력하자.
		f1.basketSetting("사과", 21);
		/*
		 * 또는 
		 * FruitBasket apple = new FruitBasket();
		 * apple.basketSetting("사과", 21);
		 */
		System.out.println(f1.basketSize);
		System.out.println(f1.fruitName);
		System.out.println(f1.fruitCount);
		
	}
}
