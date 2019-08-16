package another.group;

import java.util.Scanner;

public class Bomb {
	
	
	
	public static void main(String[] args) {
		boolean b1 = true;
		Scanner s1 = new Scanner(System.in);
		
		while (b1) {
			System.out.println("========== 폭탄 게임 ==========");
			System.out.println("정수(좌표)를 입력하세요 : ");
			int loc1 = s1.nextInt();
			Bomb field1 = new Bomb();
			field1.field(loc1);
			
		}
		
		s1.close();
		System.out.println("Scanner closed");

	}
	
	public int field(int i) {
//		while (condition) {
//			
//		}
		
		return 0;
	}

}
