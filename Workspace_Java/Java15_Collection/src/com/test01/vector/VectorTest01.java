package com.test01.vector;

import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		
		//Vector<E>		E : element
		//		<K>		K : Key
		//		<V>		V : Value
		//		<T>		T : Type
		
		// Vector()
		// Vector(initialCapacity) : iCa만큼의 용량으로 만든다.
		// Vector(iCa, capaInc) : iCa만큼의 용량으로 만들고 capaInce 만큼 용량이 증가한다.
		Vector<Integer> v = new Vector<Integer>(10,5); //10칸짜리 용량, 5칸의 용량 증가량
		System.out.println(v.size() + " : " + v.capacity()); // 0 : 10
												// 아직 아무것도 안들어 있어서 사이즈는 0, 수용량은 10
		for(int i = 0; i < 10; i++) {
			v.add(i);
		}
		
		System.out.println(v.size() + " : " + v.capacity());
		System.out.println(v);  // 0~9까지 10개 들어있는 상황.
		
		v.add(10);
		System.out.println(v.size() + " : " + v.capacity());
		System.out.println(v);  // 기존 10칸에서 10이 들어가자 5칸이 늘어나게 됨.
		
		
		
	}
}
