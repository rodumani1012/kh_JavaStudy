package com.test02;

import java.util.Arrays;

public class DeepCopy {
	
	// 깊은 값 복사 : 값 자체를 복사해서 새로운 배열 생성(주소값이 다름)
	public static void main(String[] args) {
		// 1. 인덱스를 통해 값을 가져와서 복사
		int[] original = {10,20,30,40};
		int[] copy = new int[original.length];
		
		for(int i = 0; i<original.length; i++) {
			copy[i] = original[i];
		}
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
		System.out.println(original==copy);
		
		copy[0] = 100;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
		
		// 2. original 에게 복사 요청 (clone() 사용)
		int[] cloneArr = original.clone();
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(cloneArr));
		System.out.println(original==cloneArr);
		
		cloneArr[0] = 200;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(cloneArr));
		
		// 3. system을 사용해서 복사
		// System.arrayCopy(원본 배열 객체, 원본 시작 위치, 
		//					복사 배열 객체,	복사 시작 위치, 복사 갯수);		
		int[] systemArray = new int[5];
		Arrays.fill(systemArray, 100);
		System.out.println(Arrays.toString(systemArray));
		
		System.arraycopy(original, 0, systemArray, 1, 2); //10 20 30 40 을 갖고있는 original 배열의 0번째부터 2개를
		System.out.println(Arrays.toString(systemArray));//100 100 100 100 100 을 갖고있는 systemArray 배열의 1번째부터 넣음
														 //∴ 100 10 20 100 100 이 된다.
		System.out.println("-------------");
		System.out.println(original.hashCode());
		System.out.println(copy.hashCode());
		System.out.println(cloneArr.hashCode());
		System.out.println(systemArray.hashCode());
		
	}
}
