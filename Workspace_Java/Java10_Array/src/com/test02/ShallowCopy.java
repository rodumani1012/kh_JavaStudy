package com.test02;

import java.util.Arrays;

public class ShallowCopy {
	
	// 얕은 값 복사 : 주소값을 복사한다.
	public static void main(String[] args) {
		int[] original = {10,20,30};
		int[] copy = original;
		
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
		
		System.out.println(original == copy);
		copy[0] = 100;
		System.out.println(original[0]);
		original[1] = 55;
		System.out.println(copy[1]);
		
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
		
		// hashCode : 주소값을 숫자로 표현
		System.out.println(original.hashCode());
		System.out.println(copy.hashCode());
	}
}
