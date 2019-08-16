package com.test04;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.person.Person;

public class MapTest03 {

	public static void main(String[] args) {
		// 1. Person 객체 4개 만들자. (나, 짝궁 2명, 홍길동(나이는100))
		Person choi = new Person("최준연", 26);
		Person song = new Person("송치윤", 50);
		Person jeong = new Person("정민호", 35);
		Person hong = new Person("홍길동", 100);

		// 2. generic : <Integer, Person>
		// type : Map, 객체 : Hashmap
		// 변수명 : personMap을 만들자.
		Map<Integer, Person> personMap = new HashMap<Integer, Person>();

		// 3. k=v 형식으로 값을 넣자.
		// 1=나, 2=짝궁1, 3=짝궁2, 4=홍길동
		personMap.put(1, choi);
		personMap.put(2, song);
		personMap.put(3, jeong);
		personMap.put(4, hong);

		prn(personMap);
		// 4. 나이가 100인 사람을 찾아서
		// 나이를 150으로 바꾸자
		Set<Map.Entry<Integer, Person>> set = personMap.entrySet();
		for (Map.Entry<Integer, Person> entry : set) {
			if (entry.getValue().age == 100) {
				entry.getValue().age = 150;
			}
		}
		
		// 5. 전체를 출력하자.
		prn(personMap);

	}

	public static void prn(Map<Integer, Person> map) {

		Set<Entry<Integer, Person>> set = map.entrySet(); //Map.Entry<Integer, Person> 나 Entry<Integer, Person>나 상관없음
		for (Map.Entry<Integer, Person> entry : set) {
			System.out.println(entry.getKey() + " : " +
					entry.getValue().name + ", " +
					entry.getValue().age);
		}
	}
}
