package com.baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {

	private int[] inputArr;
	private int size;
	
	public User() {
		this(3);
	}
	
	public User(int size) {
		this.size = size;
		inputArr = new int[size];
	}
	
	public int[] input() {
		System.out.println("1~9 사이의 숫자 " + size + " 자릿수를 입력해 주세요 (각 숫자는 공백으로 구분)");
		
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				String[] input = sc.nextLine().split(" ");
				for(int i = 0 ; i < size ; i++) {
					if(input[i].length() > 1) {
						throw new ArrayIndexOutOfBoundsException();
					}
					inputArr[i] = Integer.parseInt(input[i]);
				}
				break;
			
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다. 숫자만 다시 입력해 주세요.");
			} catch (NumberFormatException e) {
				System.out.println("잘못 입력하셨습니다. 숫자만 다시 입력해 주세요.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("잘못 입력하셨습니다. 1 ~ 9 사이의 숫자만 공백으로 구분하여 입력해 주세요.");
			} catch(Exception e) {
				System.out.println("잘못 입력하셨습니다. 숫자만 다시 입력해 주세요.");
			}
		}
		
		return inputArr;
	}
	
}
