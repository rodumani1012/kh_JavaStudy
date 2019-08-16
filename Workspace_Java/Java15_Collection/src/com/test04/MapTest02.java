package com.test04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.score.Score;

public class MapTest02 {

	public static void main(String[] args) {
		
		Score hong = new Score("홍길동",100,55,88);
		Score lee = new Score("이순신", 48, 100, 44);
		Score kim = new Score("김선달", 0,99,100);
		
		Map<Integer, Score> scoreMap = new HashMap<Integer, Score>();
	
		scoreMap.put(1, hong);
		scoreMap.put(2, lee);
		scoreMap.put(3, kim);
		scoreMap.put(4, hong);
		scoreMap.put(4, lee); //key는 중복이 안됨, value는 중복이 되고 덮어쓰기 되어짐
		
		printMap(scoreMap);
		// 이름과 평균만 출력.
		
		printNameAvg(scoreMap);
	}

	private static void printMap(Map<Integer, Score> map) {
		
		Set<Map.Entry<Integer, Score>> mySet = map.entrySet();
		
		for(Map.Entry<Integer, Score> s : mySet) {
			System.out.println(s);
//			System.out.println(s.getValue());
		}		
	}	
	
	private static void printNameAvg(Map<Integer, Score> map) {
		
		Set<Map.Entry<Integer, Score>> mySet = map.entrySet();
		
		for(Map.Entry<Integer, Score> s : mySet) {
			System.out.printf("이름 : %s  평균 : %.2f \n", s.getValue().getName(), s.getValue().getAvg());
		}
	}
}
