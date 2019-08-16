package com.java06_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.java04_array.Person;

public class MTest {
	
	public static void main(String[] args) {
		
		// 1. Person 객체 6명 만들자
		Person p1 = new Person("정서희", 25);
		Person p2 = new Person("최준연", 26);
		Person p3 = new Person("신희수", 24);
		Person p4 = new Person("문희수", 24);
		Person p5 = new Person("정지예", 26);
		Person p6 = new Person("한지수", 27);
		
		// 2. 배열에 Person 객체 넣자.
		Person[] A = new Person[6];
		A[0] = p1;
		A[1] = p2;
		A[2] = p3;
		A[3] = p4;
		A[4] = p5;
		A[5] = p6;
	
		// 3. List에 '2번에서 만든 배열' 전체를 넣자
		List<Person> list = new ArrayList<Person>();
		list.addAll(Arrays.asList(A));
		
		// 4. List 전체 출력
		Iterator<Person> ir = list.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
		
		// 번외. 맵에 넣어서 이름 출력해보기
		Map<Integer, Person> map = new HashMap<Integer, Person>();
		for(int i = 0; i < A.length; i++) {
			map.put(i, A[i]);
		}
		Set<Map.Entry<Integer, Person>> mySet = map.entrySet();
		Iterator<Map.Entry<Integer, Person>> irMap = mySet.iterator();
		
		for(Map.Entry<Integer, Person> entry : mySet) {
			System.out.println(entry.getValue().getName());
		}
	}
}
