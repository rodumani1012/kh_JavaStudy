package com.view;

import java.util.List;
import java.util.Scanner;

import com.biz.MemberBiz;
import com.biz.MemberBizImpl;
import com.dto.MemberDto;

public class MemberView {
// 호출 순서 : View -> Biz -> Dao,dto -> Biz -> View
	static Scanner sc = new Scanner(System.in);

	public static int getMenu() {

		StringBuffer sb = new StringBuffer();
		int select = 0;

		sb.append("******************\n");
		sb.append("1.전체출력\n");
		sb.append("2.선택출력\n");
		sb.append("3.추    가\n");
		sb.append("4.수    정\n");
		sb.append("5.삭    제\n");
		sb.append("6.종    료\n");
		System.out.println(sb);

		System.out.println("input select :");
		select = sc.nextInt();

		return select;
	}

	public static void main(String[] args) {
		int select = 0;
		MemberBiz biz = new MemberBizImpl();

		while (select != 6) {
			select = getMenu();

			switch (select) {
			case 1:
				// 전체출력
				System.out.println("********************");

				List<MemberDto> list = biz.selectList();
				for (MemberDto dto : list) {
					System.out.println(dto);
				}

				System.out.println("********************");
				break;
			case 2:
				// 선택출력
				System.out.println("번호 선택 : ");
				int selectOne = sc.nextInt();
				MemberDto selectDto = biz.selectOne(selectOne);
				System.out.println(selectDto);
				break;
			case 3:
				// 추가
				System.out.println("추가할 데이터를 입력");
				System.out.println("이름 : ");
				String inputName = sc.next();
				System.out.println("나이 : ");
				int inputAge = sc.nextInt();
				System.out.println("성별 (M/F) : ");
				String inputGender = sc.next();
				System.out.println("지역 : ");
				sc.nextLine();
				String inputLoc = sc.nextLine();
				System.out.println("직업 : ");
				String inputJob = sc.next();
				System.out.println("전화번호 : ");
				String inputTel = sc.next();
				System.out.println("이메일 : ");
				String inputEmail = sc.next();

				MemberDto inputDto = new MemberDto(0, inputName, inputAge, 
						inputGender, inputLoc, inputJob, inputTel, inputEmail);

				int inputRes = biz.insert(inputDto);
				if (inputRes > 0) {
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
				System.out.println("수정할 나이 : ");
				int updateAge = sc.nextInt();
				System.out.println("수정할 성별[M/F] : ");
				String updateGender = sc.next();
				System.out.println("수정할 지역 : ");
				sc.nextLine();
				String updateLocation = sc.nextLine();
				System.out.println("수정할 직업 : ");
				String updateJob = sc.next();
				System.out.println("수정할 전화번호 : ");
				String updateTel = sc.next();
				System.out.println("수정할 이메일 : ");
				String updateEmail = sc.next();

				MemberDto updateDto = new MemberDto(updateNo, updateName,
						updateAge, updateGender, updateLocation,
						updateJob, updateTel, updateEmail);
				
				int updateRes = biz.update(updateDto);
				
				if (updateRes > 0) {
					System.out.println("수정 완료");
				} else {
					System.out.println("수정 실패");
				}

				break;
			case 5:
				// 삭제
				System.out.println("삭제할 번호 : ");
				int delNum = sc.nextInt();

				int delRes = biz.delete(delNum); // delete한 row의 갯수가 리턴될 것이다.
				if (delRes > 0) {
					System.out.println("삭제되었습니다.");
				} else {
					System.out.println("삭제 실패하였습니다.");
				}
				break;
			case 6:
				// 종료
				System.out.println("종료되었습니다.");
				sc.close();
				break;
			}
		}
	}
}
