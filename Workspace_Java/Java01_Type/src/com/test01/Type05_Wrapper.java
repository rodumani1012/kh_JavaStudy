package com.test01;
/**
 * 참조 타입이 무엇인지 알아보자
 * @author user1
 *
 */
public class Type05_Wrapper {

	public static void main(String[] args) {
		/*
		 *    기본타입		참조타입
		 * 1. byte		->	Byte
		 * 2. short		->	Short
		 * 3. int		->	Integer
		 * 4. long		->	Long
		 * 5. float		->	Float
		 * 6. double	->	Double
		 * 7. char		->	Character
		 * 8. boolean	->	Boolean
		 * 
		 */
		
		System.out.println("byte의 범위 : " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
		System.out.println("short의 범위 : " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		System.out.println("int의 범위 : " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		System.out.println("long의 범위 : " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
		System.out.println("float의 범위 : " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
		System.out.println("double의 범위 : " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
		System.out.println("char의 크기 : " + Character.SIZE); //char는 2byte로 16bit
		
		System.out.println("boolean 참 : " + Boolean.TRUE);
		System.out.println("boolean 참 : " + Boolean.valueOf(true));
		System.out.println("boolean 참 : " + Boolean.valueOf("true"));
		System.out.println("boolean 참 : " + Boolean.valueOf("treee"));
		
		
		
	}

}
