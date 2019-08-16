package com.view;

import java.util.List;
import java.util.Scanner;

import com.biz.ScoreBiz;
import com.biz.ScoreBizImpl;
import com.dto.ScoreDto;

public class ScoreView {
	static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		int select = 0;
		
		StringBuffer sb = new StringBuffer();
		sb.append("******************\n");
		sb.append("1.전체출력\n");
		sb.append("2.선택출력\n");
		sb.append("3.추    가\n");
		sb.append("4.수    정\n");
		sb.append("5.삭    제\n");
		sb.append("******************\n");
		sb.append("6.1등 출력\n");
		sb.append("7.2등 출력\n");
		sb.append("8.3등 출력\n");		
		sb.append("9.종    료\n");
		System.out.println(sb);
		
		System.out.println("input select : ");
		select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		int select = 0;		
		
		ScoreBiz biz = new ScoreBizImpl();
		
		while(select != 9) {
			
			select = getMenu();
			
			switch (select) {
			case 1:
				// 전체선택
				System.out.println("*****************");
				
				List<ScoreDto> list = biz.selectList();	
				for(ScoreDto dto : list) {
					System.out.println(dto);
				}
				
				System.out.println("*****************");
				break;
			case 2:
				// 선택출력
				System.out.println("번호 선택 : ");
				int selectOne = sc.nextInt();
				ScoreDto selectDto = biz.selectOne(selectOne);
				System.out.println(selectDto);
				break;
			case 3:
				// 추가
				System.out.println("추가할 데이터를 입력");
				System.out.println("이름 : ");
				String insertName = sc.next();
				System.out.println("국어점수 : ");
				int insertKor = sc.nextInt();
				System.out.println("영어점수 : ");
				int insertEng = sc.nextInt();
				System.out.println("수학점수 : ");
				int insertMath = sc.nextInt();

//				ScoreDto insertDto = new ScoreDto(0, insertName, insertKor, 
//						insertEng, insertMath, 0, 0, "");
				ScoreDto insertDto = new ScoreDto();
				insertDto.setS_name(insertName);
				insertDto.setS_kor(insertKor);
				insertDto.setS_eng(insertEng);
				insertDto.setS_math(insertMath);

				int insertRes = biz.insert(insertDto);
				if (insertRes > 0) {
					System.out.println("추가 성공");
				} else {
					System.out.println("추가 실패");
				}
				break;
			case 4:
				// 수정
				System.out.println("수정할 번호 : ");
				int updateNo = sc.nextInt();
				System.out.println("수정할 이름 : ");
				String updateName = sc.next();
				System.out.println("수정할 국어 점수 : ");
				int updateKor = sc.nextInt();
				System.out.println("수정할 영어 점수 : ");
				int updateEng = sc.nextInt();
				System.out.println("수정할 수학 점수 : ");
				int updateMath = sc.nextInt();
				
				ScoreDto updateDto = new ScoreDto(updateNo, updateName, 
						updateKor, updateEng, updateMath,0,0,"");
				int updateRes = biz.update(updateDto);
				if (updateRes > 0) {
					System.out.println("업데이트 성공");
				} else {
					System.out.println("업데이트 실패");
				}
						
				break;
			case 5:
				// 삭제
				System.out.println("삭제할 번호 : ");
				int deleteNo = sc.nextInt();
				
				int deleteRes = biz.delete(deleteNo);
				if (deleteRes > 0) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 6:
				// 1등 출력
				System.out.println("1등을 출력합니다.");
				int inputNo1 = 1;
				ScoreDto selRes1 = biz.first(inputNo1);
				System.out.println(selRes1);
				break;
			case 7:
				// 2등 출력
				System.out.println("2등을 출력합니다.");
				int inputNo2 = 2;
				ScoreDto selRes2 = biz.second(inputNo2);
				System.out.println(selRes2);
				break;
			case 8:
				// 3등 출력
				System.out.println("3등을 출력합니다.");
				int inputNo3 = 3;
				ScoreDto selRes3 = biz.third(inputNo3);
				System.out.println(selRes3);
				break;
			case 9:
				// 종료
				System.out.println("종료되었습니다.");
				sc.close();
				break;
			}
		}
	}
}
