package com.lotto;

import java.util.Arrays;

public class Lotto {
	// 1~45번까지 숫자 중 6개 추첨
	// 숫자는 중복되지 않는다.

	// 로또 배열 생성
	private int[] lottoMake() {
		int[] arr = new int[6];
		int index = 0;

		while (index < 6) {
			int insert = (int) (Math.random() * 46);

			if (!isSame(arr, insert)) { //if(true) 일때 명령이 실행되므로
				arr[index] = insert;	// isSame이 false가 나온 상태(중복이 아닌상태)일때
				index++;				// ! 로 true를 만들어주고 명령이 실행되도록 함.
			}
		}

		return arr;
	}

	//	로또 배열(arr)안에 내가 만든 랜덤 숫자가 존재하는지 확인.
	//	중복을 제거하는 과정.
	private boolean isSame(int[] arr, int insert) {

		boolean same = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == insert) {
				same = true;
				break;
			} else {
				same = false;
			}
		}
		return same;
	}

	// 배열을 정렬 시켜줌 버블정렬(bubble sort)
	private void sorting(int[] arr) {
		// 배열의 처음부터 끝까지 돌면서
		// 인접한 두 수를 비교하여 swap 한다.

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {

				if (arr[j] < arr[j - 1]) {
					int tmp = arr[j]; //뒷 숫자를 tmp에 저장
					arr[j] = arr[j - 1]; //뒷 숫자를 앞 숫자로 바꿔주는 과정
					arr[j - 1] = tmp; // 저장된 뒷 숫자를 앞 숫자에 넣어줌
					/*
					 * arr[] = {1, 6, 3, 9, 7};
					 * 3<6
					 * tmp = 3;
					 * arr[2] = arr[1];
					 * arr[1] = 3;
					 */
				}
			}
		}
	}

	// 배열 출력
	public void prn() {
		int[] arr = lottoMake();
		
//		sorting(arr);
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%3d", arr[i]);
		}
	}
}
