package com.test04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest01 {
	
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		for(int i = 111; i<116; i++) {
			map.put(i, i+"val");
		}
		
		System.out.println(map);
		System.out.println(map.get(113));
		
		printMap(map);
		
	}
	
	private static void printMap(Map<Integer, String> map) {
		
		Set<Map.Entry<Integer, String>> mySet = map.entrySet();
		/*
		 * Map<K, V> : Key와 Value를 묶어서 관리
		 * Map.Entry<K, V> : Key 따로, Value 따로 관리
		 * Set<Map.Entry<K, V>> : Entry<K, V>를 Set으로 관리하겠다.
		 */
		for(Map.Entry<Integer, String> entry : mySet) {
			System.out.println(entry.getKey()+ " : " + entry.getValue());
		}
	}
}
