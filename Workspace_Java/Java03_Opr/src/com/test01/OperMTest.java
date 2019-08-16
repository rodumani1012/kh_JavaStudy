package com.test01;

public class OperMTest {
	
	// 변수 앞에 final 붙으면 상수
	public static final int TEN = 10;
	
	public static void main(String[] args) {
		System.out.println(op01(10, 3));
		System.out.println(op02());
		op03(10, 3);
		System.out.println();
		op04();
		op05();
		op06();
		op07();
	}
	
	// 1. 사칙연산
	public static String op01(int a, int b) {
		System.out.printf("%d + %d = %d  \n", a,b,a+b);
		System.out.printf("%d - %d = %d  \n", a,b,a-b);
		System.out.printf("%d * %d = %d  \n", a,b,a*b);
		System.out.printf("%d / %d = 몫 : %d 나머지 : %d \n", a,b,a/b,a%b);
				
		return "사칙연산 끝 \n";
	}
	
	// 2. 대입연산
	public static String op02() {
		int res = 0;
		System.out.println("그냥 res : " + res);
//		res = res + TEN;
		res += TEN; //28번째 라인 줄임말
		res -= TEN;
		System.out.println("TEN 연산 후 : " + res);
		
		return "==================";
	}
	
	// 3. 증감연산자(++, --)
	public static void op03(int a, int b) {
		// 변수의 앞, 뒤에 증가/감소 연산자를 붙이게 되면 변수가 가진 값을 1씩 증가/감소 시킨다.
		// 전위 연산자 : 연산자가 변수 앞에. 연산 먼저하고 나중에 값을 리턴 ex) ++i
		// 후위 연산자 : 연산자가 변수 뒤에. 값을 리턴하고 나중에 연산 ex) i++
		
		System.out.println(a);					  // a = 10
		System.out.println("후위 연산 : " + a++); // a = 11 (출력은 10)
		System.out.println("전위 연산 : " + ++a); // a = 12 (출력은 12)
		
		a = TEN;
		int sum = a++ + ++a + ++a + b++; // (): 실제값, 10(11) + 12(12) + 13(13) + 3(4)
		System.out.println(sum);
	}
	
	// 4. 논리연산자 (&, |, &&, ||) -> true, false
	public static void op04() {

		System.out.println("1. ===============");
		System.out.println(true & true); //참
		System.out.println(true & false); //거짓
		System.out.println(false & true); // 거짓
		System.out.println(false & false); //거짓
		System.out.println("2. ===============");
		System.out.println(true && true); //참
		System.out.println(true && false); //거짓
		System.out.println(false && true); // 거짓    //앞은 이미 거짓으로 판별되었고 뒤까지 할 필요 없어서 데드코드가 됨.
		System.out.println(false && false); //거짓
		System.out.println("3. ===============");
		System.out.println(true | true); //참
		System.out.println(true | false); //참
		System.out.println(false | true); // 참
		System.out.println(false | false); //거짓
		System.out.println("4. ===============");
		System.out.println(true || true); //참
		System.out.println(true || false); //참
		System.out.println(false || true); // 참
		System.out.println(false || false); //거짓
		System.out.println("==================");
		
		int a = TEN;
		int b = 3;		
		System.out.println((a>b) && (b>a));
		
	}
	
	// 5. 비교 연산자(>, <, >=, <=, ==, !=)
	public static void op05() {
		System.out.println("========= op05 ===========");
		System.out.println(true == true);
		System.out.println(true != true);
	}
	
	// 6. 삼항연산자
	//  (조건) ? 참 : 거짓
	public static boolean op06() {
		System.out.println("========= op06 ===========");
		int a = TEN;
		int b = 3;
		
		int res = (a>b) ? a+b : a-b;
		System.out.println(res);
		
		boolean test = (a>b) ? true : false;
		System.out.println(test);
		return test;

	}

	// 7. 비트연산자(&, |, ^, ~, <<, >>  : 0, 1 비트를 가지고 연산함.)
	public static void op07() {
		System.out.println("========= op07 ===========");
		int a = 10;
//		0000 0000 0000 0000 0000 0000 0000 1010
		int b = 2;
//		0000 0000 0000 0000 0000 0000 0000 0010
		
		System.out.println(a & b); // &이므로 0,0 일때 0   1,1 일때 1
//		  0000 0000 0000 0000 0000 0000 0000 1010
//		& 0000 0000 0000 0000 0000 0000 0000 0010
//		------------------------------------------
//		  0000 0000 0000 0000 0000 0000 0000 0010
		
		System.out.println(a | b); // |이므로 0,0 일때 0   0,1/1,0/1,1 일때 1
//		  0000 0000 0000 0000 0000 0000 0000 1010
//		| 0000 0000 0000 0000 0000 0000 0000 0010
//		------------------------------------------
//		  0000 0000 0000 0000 0000 0000 0000 1010
		
		System.out.println(~a); // ~은 not을 의미함. 반대
//		  0000 0000 0000 0000 0000 0000 0000 1010
//		~ 1111 1111 1111 1111 1111 1111 1111 0101
		
		int c = 10;
//		  0000 0000 0000 0000 0000 0000 0000 1010
		System.out.println(c>>2);
//		  00 0000 0000 0000 0000 0000 0000 0010 / 10
		System.out.println(Integer.toBinaryString(c>>2));  
		
		
		
	}
}
