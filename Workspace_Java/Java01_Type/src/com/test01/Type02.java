package com.test01;

public class Type02 {

//		정수형 리터럴 : byte(1=8bit), short(2byte), 기본타입 int(4byte), long(8byte)
		public static void main(String[] args) {
			// type 변수 = 값;
			byte b01 = (byte) 1;
			System.out.println(b01);
			byte b02 = (byte) 3;
			System.out.println(b02);
			
			// 정수형 기본 연산 : int
//			byte bSum = b01 + b02; int 연산값을 byte에 넣으면 에러 발생
			byte bSum = (byte) (b01 + b02);
			System.out.println(bSum);
			
			System.out.println("-----------------");
			
			short s01 = 12345;
			short s02 = (short) 54321;
			
			System.out.println(s01 + "" + s02);
			short sSum = (short) (s01 + s02);
			System.out.println(sSum);
			
			System.out.println("----------------");
			
			int i = 10;
			int j = 20;
			int sum = i + j;
			
			System.out.println("1차 : " + sum);
			i = 30;
			System.out.println("2차 : " + sum); // 이미 계산 끝나서 i값을 바꿔도 변함 없음.
			
			sum = i + j;
			System.out.println("3차 : " + sum);

			System.out.println("----------------");
			
			long l01 = 10000000000l; //long 타입 캐스트는 뒤에 l
			long l02 = 20000000000l;
			long lSum = l01 + l02; //int 보다 long이 단위가 커서 캐스트 없이 연산이 그냥 됨.
			System.out.println(lSum);
			
			System.out.println("================");
			System.out.println(10);
			//2,8,16진수 각각 0b, 00, 0x를 앞에 붙이면 된다.
			//2진수(0b)
			System.out.println(0b10);
			//8진수(00)
			System.out.println(0010);
			//16진수(0x)
			System.out.println(0x10);
		}
}
