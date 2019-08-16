package my.group;

//import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;

public class RPS {

	public static void main(String[] args) throws IOException {
		
		System.out.println("---------------------");
		System.out.println("가위.바위.보 게임 Ver2.0");
		System.out.println("---------------------");
		System.out.println("게임 시작.");
		System.out.println("---------------------");
		System.out.println("1.가위   2.바위   3.보 /// 선택");
		System.out.println("---------------------");
			

		Scanner sc = new Scanner(System.in);
		int game = sc.nextInt();  // 입력...
		
		switch(game){
			case 1 : 
				System.out.println("사용자 가위");
				break;
			case 2 : 
				System.out.println("사용자 바위");
				break;
			case 3 : 
				System.out.println("사용자 보");
				break;
			default:
				System.out.println("실행불가");
		}
		
		int temp=2;
		
		while(temp<=5){
			
			for(int i=1; i<=1; i++){
				
			temp = (int)(Math.random()*4);
						
				if(game == 1){
					if(temp == 1){
						System.out.println("컴퓨터 가위");
						System.out.println("비겼습니다");
					}
					else if(temp == 2){
						System.out.println("컴퓨터 바위");
						System.out.println("졌습니다");
					}	
					else{
						System.out.println("컴퓨터 보");
						System.out.println("이겼습니다");
					}
				}
			
				if(game == 2){
					if(temp == 1){
						System.out.println("컴퓨터 가위");
						System.out.println("이겼습니다");
					}	
					else if(temp == 2){
						System.out.println("컴퓨터 바위");
						System.out.println("비겼습니다");
					}
					else{
						System.out.println("컴퓨터 보");
						System.out.println("졌습니다.");
					}
				}	
			
				if(game == 3){
					if(temp == 1){
						System.out.println("컴퓨터 가위");
						System.out.println("졌습니다");
					}	
					else if(temp == 2){
						System.out.println("컴퓨터 바위");
						System.out.println("이겼습니다");
					}
					else{
						System.out.println("컴퓨터 보");
						System.out.println("비겼습니다");
					}
				}	
					System.out.println("재시작하시겠습니까? y / n");	
			} 	// for문 중괄호
					Scanner a = new Scanner(System.in);  
					String next = " ";  
					next = a.next();    
					if(next.equals("y")) {   
						System.out.println("처음 입력한 값으로 랜덤재시작됩니다");
					}
					else if(next.equals("n")) {
						System.out.println("프로그램을 종료합니다");
						break;
				}
			}   // while문 중괄호
		}   // main메소드 중괄호
	}   // 클래스...

