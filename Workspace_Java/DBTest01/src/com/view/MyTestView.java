package com.view;

import java.sql.Connection;
import java.util.Scanner;

import com.dao.MyTestDao;
import com.dto.MyTestDto;

import common.template.JDBCTemplate;

public class MyTestView extends JDBCTemplate{

	static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		StringBuffer sb = new StringBuffer();
		int select = 0;
		
		sb.append("1.전체출력\n")
		  .append("2.추    가\n")
		  .append("3.수    정\n")
		  .append("4.삭    제\n")
		  .append("5.선택출력\n")
		  .append("6.종    료\n");
	
		System.out.println(sb);
		System.out.println("번호 선택 : ");
		select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		int no = 0;
		
		int mno = 0;
		String mname = "";
		String nickName = "";
		
		Connection con = getConnection();
		MyTestDao dao = new MyTestDao(con);
		MyTestDto dto = new MyTestDto(mno, mname, nickName);
		
		do {
			no = getMenu();
			
			switch (no) {
			case 1:
				//전체출력
				System.out.println("**************");
				System.out.println("전 체 출 력");
				for(MyTestDto dto1 : dao.selectList()) {
					System.out.println(dto1);
				}
				System.out.println("**************");
				break;
			case 2:
				// 추가
				System.out.println("새 번호 입력 : ");
				mno = sc.nextInt();
				System.out.println("새 이름 입력 : ");
				mname = sc.next();
				System.out.println("새 별명 입력 : ");
				nickName = sc.next();
				dao.insert(dto);
				break;
			case 3:
				// 수정
				System.out.println("변경해줄 이름은?");
				mname = sc.next();
				System.out.println("바꿀 번호 입력 : ");
				mno = sc.nextInt();
				System.out.println("바꿀 별명 입력 : ");
				nickName = sc.next();
				dto = new MyTestDto(mno, mname, nickName);
				dao.update(dto);
				
				int updateOne = dao.update(dto);
				if(updateOne > 0) {
					System.out.println("수정 되었습니다.");
				} else {
					System.out.println("수정에 실패하였습니다.");
				}
				break;
			case 4:
				// 삭제
				System.out.println("삭제할 컬럼번호 : ");
				mno = sc.nextInt();
				dao.delete(mno);
				break;
			case 5:
				// 선택 출력
				System.out.println("출력할 번호 입력 : ");
				mno = sc.nextInt();
				MyTestDto selectOne = dao.selectOne(mno);
				System.out.println("**************");
				System.out.println(selectOne);
				System.out.println("**************");
				break;
			case 6:
				// 종료
				System.out.println("종료");
				close(con);
				sc.close();
				break;
			}
			
		} while (no != 6);
		
		
		
	}
}
