package com.singleton;

public class MTest {

	public static void main(String[] args) {
//		Singleton s = new Singleton(); //private이므로 new 할 수 없다. 에러 발생.
		
		Singleton s= Singleton.getInstance(); //new Singleton();해서 주소값을 넣어줌으로써 null이 아니게 됨.
		System.out.println(s);				  // return singleton; 
		System.out.println(s.hashCode());
		
		Singleton st = Singleton.getInstance(); //exist!! 
		System.out.println(st);					// return singleton; 이므로 주소값이 s와 같아짐.
		System.out.println(st.hashCode());
		
		System.out.println(s == st); // 싱글톤이기 때문에 s, st 서로 주소값이 같음.
		
		Hello h = new Hello();  
		System.out.println(h);
		Hello h2 = new Hello();
		System.out.println(h2);
		System.out.println(h == h2); //h, h2 서로 주소값이 다름.
	}
}
