package com.test02.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListTest02 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < 11; i++) {
			list.add(i+"");
		}
		System.out.println(list);
		
		Collections.sort(list, new MySortTest()); //MySortTest()라는 새로운 객체가 와서
												  //list안의 값들을 비교해준다.
		System.out.println(list);
	}
}

class MySortTest implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) { //o1 과 o2 를 비교한다.
		// + : 앞의 인자가 더 큰 값이 온다.
		// 0 : 같은 값이 온다
		// - : 뒤의 인자가 더 큰 값이 온다.
		
		
		return -1;
	}
	
}


