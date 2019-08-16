package com.test03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.score.Score;

public class SetTest02 {

	public static void main(String[] args) {
		// 1. Score 객체 3개 만들자
		Score choi = new Score("최준연", 90, 78, 40);
		Score hong = new Score("홍길동", 76, 98, 60);
		Score jang = new Score("장길산", 45, 69, 82);

		// 2. Score 객체를 관리하는 Set을 만들자.
		// type은 Set, 실제 객체(값)은 HashSet,
		// 변수 이름은 scoreSet
		Set<Score> scoreSet = new HashSet<Score>();

		// 3. 위에서 만든 scoreSet에다 1번에서 만든
		// Score 객체 3개를 넣자.
		scoreSet.add(choi);
		scoreSet.add(hong);
		scoreSet.add(jang);

		// 4. scoreSet에서 이름으로 '나'를 찾아,
		// 국어점수를 100점으로 변경 후 전체 출력하자.
//		prn(scoreSet);
		transElement(scoreSet, "최준연", 100);

	}

	private static void transElement(Set<Score> scoreSet, String name, int kor) {
		// iterator를 사용하자.
		// 강사님 기본버전
//		for(Score s : scoreSet) {
//			if(s.getName().equals(name)) {
//				s.setKor(kor);
//			}
//		}
//		prn(scoreSet);
		
		// 강사님 Obj[] 버전
//		Object[] objArr = scoreSet.toArray();
//		for(Object o : objArr) {
//			if(((Score)o).getName().equals(name)) {
//				((Score) o).setKor(kor);
//			}
//		}
//		prn(scoreSet);
		
		// 강사님 iterator
		Iterator<Score> ir = scoreSet.iterator();
		while (ir.hasNext()) {
//			if(ir.next().getName().equals(name)) {
//				ir.next().setKor(kor);
//			}			
//			System.out.println(ir.next()); //java.util.NoSuchElementException 오류 발생.
										   //다음이 없는데 다음걸 반환하려 하니까 오류발생.
			Score tmp = ir.next();
			if(tmp.getName().equals(name)) {
				tmp.setKor(kor);
			}
			System.out.println(tmp);
		}
//		prn(scoreSet);
	}
		// 내꺼
//		Iterator<Score> ir = scoreSet.iterator();
//		while (ir.hasNext()) {
//			Object[] objArr = scoreSet.toArray();
//			for (Object o : objArr) {
//				if (((Score) o).getName().equals(name)) {
//					((Score) o).setKor(kor);
//				}
//			}
//			ir.next();
//		}
//		System.out.println(scoreSet);
//	}

	public static void prn(Set<Score> set) {
		// collection 안의 값을 가져오는(조회하는) 방법

		// 1.
//		for(Score s : set) {
//			System.out.println(s);
//		}

		// 2.
//		Object[] objArr = set.toArray();
//		// 2-1.
//		for (int i = 0; i < objArr.length; i++) {
//			System.out.println(objArr[i]);
//		}
//		// 2-2.
//		for (Object o : objArr) {
//			System.out.println(o);
//		}
		// 2번으로 만든 이름출력
//		for (int i = 0; i < objArr.length; i++) {
//			System.out.println(((Score) objArr[i]).getName());
//		}
//		//2번으로 만든 이름출력
//		for (Object o : objArr) {
//			System.out.println(((Score) o).getName());
//		}

		// 3.
		// Iterator : 컬렉션 저장 요소를 읽어오는 표준화 된 방법
		Iterator<Score> ir = set.iterator();
		while (ir.hasNext()) { // hasNext 를 통해 다음값이 있는지 없는지 확인.
			System.out.println(ir.next()); // 있으면 출력하고 다음값으로 넘어감
		}
	}
}
