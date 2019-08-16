package com.java05_class;

public class MTest {
	
	public static void main(String[] args) {
		Animal jumbo = new Elephant("점보", 5);
		System.out.println(jumbo);
		jumbo.bark();
		
		System.out.println();
		
		Animal animal = new Animal("코끼리", "도토", 5);
		System.out.println(animal);
		animal.bark();
	}
}
