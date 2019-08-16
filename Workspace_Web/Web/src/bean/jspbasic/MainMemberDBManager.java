package bean.jspbasic;

import java.util.ArrayList;
import project.login.Member;
import project.login.MemberDBManager;

public class MainMemberDBManager {

	public static void main(String[] args) {

		// Object
		String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbId = "hr";
		String dbPassword = "hr";
		MemberDBManager memberDBManager = new MemberDBManager(dbUrl, dbId, dbPassword);

		// selectMemberListAll()
//		ArrayList<Member> memberList = memberDBManager.selectMemberListAll();
//		for (int i = 0; i < memberList.size(); i++) {
//					Member member = memberList.get(i);
//					member.printInfo();
//				}

		// selectMemberById()
		Member member = memberDBManager.selectMemberById("park");
		if (member != null) {
			System.out.println("selectMemberById() : 회원 정보 있음");
			member.printInfo();
		} else {
			System.out.println("selectMemberById() : 회원 정보 없음");
		}

		// selectMemberByIdPassword()
//		Member member = memberDBManager.selectMemberByIdPassword("lee", "lee");
//		if (member != null) {
//			System.out.println("selectMemberByIdPassword() : 회원 정보 있음");
//			member.printInfo();
//		} else {
//			System.out.println("selectMemberByIdPassword() : 회원 정보 없음");
//		}


		// insertMember()
//		Member member = new Member("han", "han", "한서현", "han@email.com");
//		boolean result = memberDBManager.insertMember(member);
//		if (result) {
//			System.out.println("insertMember() : 입력 성공");
//		} else {
//			System.out.println("insertMember() : 입력 실패");
//		}
		
		// updateMember()


		// updateMemberPassword()
//		String id = "lee";
//		String password = "lee3";
//		boolean result = memberDBManager.updateMemberPassword(id, password);
//		if (result) {
//			System.out.println("updateMemberPassword() : 수정 성공");
//		} else {
//			System.out.println("updateMemberPassword() : 수정 실패");
//		}

		// deleteMemberById()
//		boolean result = memberDBManager.deleteMember("lee");
//		if (result) {
//			System.out.println("deleteMember() : 삭제 성공");
//		} else {
//			System.out.println("deleteMember() : 삭제 실패");
//		}
	}

}
