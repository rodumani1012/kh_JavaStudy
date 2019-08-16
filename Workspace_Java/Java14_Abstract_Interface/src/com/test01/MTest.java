package com.test01;

public class MTest {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		cat.bark();
		dog.bark();
		
		Animal some = cat;
		some.bark();
		
		cat.eat("생선");
		dog.eat("뼈다귀");
		
	}
}
