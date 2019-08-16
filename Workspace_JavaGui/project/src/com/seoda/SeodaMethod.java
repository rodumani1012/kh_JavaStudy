package com.seoda;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

import com.my.dao.ProjectDao;
import com.project.ServiceThread;

public class SeodaMethod {

	ProjectDao pj_dao = new ProjectDao();		 //	projectdao 생성
	SeodaDao seodaDao = null;

	Integer[] compare_Result = { 0, 0, 0, 0, 0 };	 // 각 결과 점수를 받아서 정렬하기 위한 배열

	int gameTotalBattingMoney = 0; // 초기 기본 판돈
	
	List<ServiceThread> SeodaClients = new ArrayList<>(); // 각 클라이언트(유저)의 스레드를 보관하여 관리

	// 클라이언트(스레드) 세팅
	public void addSeodaClients(ServiceThread st) {
		this.SeodaClients.add(st);
	}
	
	// seoda에 접속한 클라이언트들의 총 사이즈를 리턴
	public int sizeUsers() {
		return SeodaClients.size();
	}

	// 섯다 유저 삭제, 삭제 했음 안 했음을 boolean으로 리턴함
	public boolean removeClient(ServiceThread st) {
		return this.SeodaClients.remove(st);
	}

	// 채팅메소드
	public void sendMessageAll(String msg) {
		try {
			System.out.println(msg);

			for (int i = 0; i < SeodaClients.size(); i++) {
				ServiceThread st = SeodaClients.get(i);
				st.sendMsg(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 모든 유저가 ready 버튼을 눌렀을 때 진행
	public void ready() {
		int ready = 1;
		for (int i = 0; i < SeodaClients.size(); i++) {
			ServiceThread st = SeodaClients.get(i);
			ready *= st.seodaInfo.getReady();		//	만약 1명이라도 안누르면 ready = 0이기 때문에 밑에 if문이 실행되지 않음
		}

		if (ready == 1) {
			this.start();		//	SeodaMethod의 start() 실행

			for (int i = 0; i < SeodaClients.size(); i++) {
				ServiceThread st = SeodaClients.get(i);
				st.seodaInfo.setReady(0);
			}
		}
	}

	// 게임 시작
	public void start() {
		// dao를 생성하면서 새로운 카드덱을 만든다
		seodaDao = new SeodaDao();

		// 플레이어는 각각 카드 2장을 받는다(i는 2장을 받기 위해 , j는 각 스레드에 전달하기위해)
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < SeodaClients.size(); j++) {
				ServiceThread st = SeodaClients.get(j);
				st.SDaddHand(this.draw());
			}
		}
		
		// 다른유저에게 카드 전달
		this.otherUser("hand");
	}

	// seodaDao에서 카드 한장 리턴
	public int draw() {
		return seodaDao.draw();
	}

	// 다른 유저의 상태(이름 , 돈 , 카드) 전달
	// way == hand : 카드 / way == name : 이름
	public void otherUser(String way) {
		for (int i = 0; i < SeodaClients.size(); i++) {
			int cnt = 0;
			ServiceThread head = SeodaClients.get(i);
			
			for (int j = 0; j < SeodaClients.size(); j++) {
				ServiceThread target = SeodaClients.get(j);

				// head와 target이 다르다면(즉, 자기자신이 아니라면)
				if (head != target) {
					switch (way) {
					case "hand":
						// 각 유저가 받은 마지막 패 하나를 head의 클라이언트에 전달
						cnt++;
						List<Integer> card = target.seodaInfo.getHand();

						head.sendMsg("USERCARD" + cnt + " " + card.get(0) + " " + card.get(1));
						break;
					case "name":
						cnt++;
						// 각 유저의 이름과 돈을 head의 클라이언트에 전달
						head.sendMsg("SEODAUSERSTATUS" + cnt + " " + target.getDto().getName() + " " + target.getDto().getMoney());
						break;
					}
				}
			}

			// 유저가 나갔을 때 이미 적혀있던 이름을 지우기 위함
			if (way.equals("name")) {
				while (cnt < 5) {
					cnt++;
					head.sendMsg("SEODAUSER" + cnt + " ");
				}
			}
		}
	}

	// 다른사람 카드 전달
	public void otherUserCard() {
		for (int i = 0; i < SeodaClients.size(); i++) {
			int cnt = 0;
			ServiceThread head = SeodaClients.get(i);
			for (int j = 0; j < SeodaClients.size(); j++) {
				ServiceThread target = SeodaClients.get(j);
				
				//	자기 자신이 아니라면
				if (head != target) {
					cnt++;
					List<Integer> card = target.seodaInfo.getHand();
					head.sendMsg("SEODAUSERCARD" + cnt + " " + card.get(0) + " " + card.get(1));
				}
			}
		}
	}

	// 모든 유저가 RESULT를 눌렀을 때 실행되는 메소드
	public void end() {
		int theEnd = 1;
		for (int i = 0; i < SeodaClients.size(); i++) {
			ServiceThread st = SeodaClients.get(i);
			theEnd *= st.seodaInfo.getResult_Count();
		}
		
		// 모든 유저가 Result를 눌렀을경우
		if (theEnd == 1) {
			// 결과 출력
			System.out.println("결과 확인!!!");
			this.gameResult();	//	SeodaMethod의 gameResult() 실행
		}
	}

	// 모든 유저가 결과보기를 하여 정렬하고 1등인 사람을 찾는다
	public void gameResult() {

		// 다른 유저 카드 출력(각 유저 GUI에 자신을 제외한 다른 유저의 카드를 보여준다)
		this.otherUserCard();

		// 모든 유저의 결과 점수를 배열에 저장
		for (int i = 0; i < SeodaClients.size(); i++) {
			ServiceThread st = SeodaClients.get(i);
			compare_Result[i] = (Integer) st.getResultCard();
		}
		System.out.println("각 점수 배열에 저장 완료");

		// 점수가 높은 순에서 낮은순으로 정렬
		Arrays.sort(compare_Result, Collections.reverseOrder());
		System.out.println("정렬 완료");

		for (int i = 0; i < SeodaClients.size(); i++) {
			ServiceThread st = SeodaClients.get(i);

			if (compare_Result[0].equals(st.getResultCard())) {
				// 가장 높은 점수의 사람은 돈을 업데이트 해준다
				if ((seodaDao.moneyWinUpdate(st.getDto().getName(), 
						this.gameTotalBattingMoney - st.seodaInfo.getBattingMoney())) > 0) {
					//	업데이트가 성공했으면 그 업데이트 한 dto를 새로 세팅을 해준다
					st.setDto(pj_dao.login("LOGIN " + st.getDto().getName() + " " + st.getDto().getPw()));
					
					st.sendMsg("SEODARESULT 당신이 승리하였습니다!!!");	//	승리 메시지 전달
					st.seodaStauts();	//	업데이트 되었으므로 새로 상태창 전달
				}
				
			} else {
				// 패배자이면 잃은 돈을 업데이트 해준다
				if (seodaDao.moneyLoseUpdate(st.getDto().getName(), st.seodaInfo.getBattingMoney()) > 0) {
					st.setDto(pj_dao.login("LOGIN " + st.getDto().getName() + " " + st.getDto().getPw()));
					
					st.sendMsg("SEODARESULT 당신은 패배하였습니다!!");		//	패배 메시지 전달
					st.seodaStauts();	//	업데이트 되었으므로 새로 상태창 전달
				}
			}
			st.SDreset();	//	게임 리셋
		}
		gameTotalBattingMoney = 0;	// 게임 총 배팅액도 0으로 초기화

		// 변경된 내용을 전달하여 다시 출력
		this.otherUser("name");

	}

	// 각 유저가 CALL을 눌렀을 경우 전체 배팅액을 증가시켜준다
	public void gameTotalBattingMoney() {
		this.gameTotalBattingMoney += 1000000;
	}

	// 전체 유저에게 현재 총 배팅액 전달
	public void sendGameTotalBattingMoney() {
		for (int i = 0; i < SeodaClients.size(); i++) {
			ServiceThread st = SeodaClients.get(i);

			st.sendMsg("SEODATOTALMONEY 총배팅액: " + gameTotalBattingMoney);
		}
	}
}
