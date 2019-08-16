package com.test02.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("홍길동");
		list.add("이순신");
		list.add("김선달");
		list.add("강호동");
		list.add("유재석");
		list.add("신동엽");
		list.add("조세호");

		System.out.println(list);

		printList(list);

		System.out.println("============================");

		// 1. 홍길동 -> 김길동으로 바꾸자
		list.set(list.indexOf("홍길동"), "김길동");
		printList(list);

		// 2. ~동 으로 끝나는 객체를 찾아서
		// 만일 있으면 ~순으로 바꾸자
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).endsWith("동")) {
				list.set(i, list.get(i).replace("동", "순"));
			}
		}
		printList(list);

		// 3. ~호 인 객체를 찾아서
		// 만일 있으면 삭제하자.
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).endsWith("호")) {
				list.remove(i);
			}
		}
		printList(list);

	}

	private static void printList(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

}
