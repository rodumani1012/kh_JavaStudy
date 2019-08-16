package com.blackjack;

import java.util.ArrayList;

import java.util.List;

import com.my.dao.ProjectDao;
import com.my.dto.ProjectDto;
import com.project.ServiceThread;

public class BlackjackMethod {

	ProjectDao projectdao = new ProjectDao();
	BlackjackDao blackjackdao = null;

	// 딜러의 패가 저장되면 List
	List<String> dealerhand = new ArrayList<String>();
	// 각 BlackjackClients의 serviceThread가 보관되어 관리 당함
	List<ServiceThread> BlackjackClients = new ArrayList<>();

	// ------------------------------------- 블랙잭 메소드
	public void addBlackjackClients(ServiceThread st) {
		this.BlackjackClients.add(st);
	}
	
	public int sizeUsers() {
		return BlackjackClients.size();
	}

	// 블랙잭 유저 삭제, 삭제 했음 안 했음을 boolean으로 리턴함
	public boolean removeClient(ServiceThread st) {
		return this.BlackjackClients.remove(st);
	}

	// 채팅 메소드
	public void sendMessageAll(String msg) {
		try {
			System.out.println(msg);

			for (int i = 0; i < BlackjackClients.size(); i++) {
				ServiceThread st = BlackjackClients.get(i);
				st.sendMsg(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 게임 시작
	public void start() {
		// dao를 생성하면서 deck을 만든다
		blackjackdao = new BlackjackDao();
		// 플레이어는 각 2장씩 갖는다. (i for 2장을)
		for (int i = 0; i < 2; i++) {
			// j for문은 클라이언트 쓰레드에 각각 한 장씩 준다.
			for (int j = 0; j < BlackjackClients.size(); j++) {
				ServiceThread st = BlackjackClients.get(j);
				st.BJaddHand(this.draw());

			}
			// 각 유저가 받은 패를 화면에
			this.otherUser("hand");
		}

		// 딜러도 2장을 갖는다.
		for (int j = 0; j < 2; j++) {
			dealerhand.add(this.draw());

			for (int i = 0; i < BlackjackClients.size(); i++) {
				ServiceThread st = BlackjackClients.get(i);

				// 그리고 화면에 각자의 hand와 딜러 핸드를 출력한다.
				st.setDealerhand(dealerhand);
			}
		}

	}

	// dao의 덱에서 카드 한장 리턴 받음
	public String draw() {
		return blackjackdao.draw();
	}

	// dealerhand 리셋
	public void dealerreset() {
		dealerhand.clear();
	}

	// 다른 유저의 상태를 띄어주는 메소드(way == hand : 패 / way == name : 이름 / way == state : hit,
	// stay, ready)
	public void otherUser(String way) {

		for (int i = 0; i < BlackjackClients.size(); i++) {
			int cnt = 0;
			ServiceThread head = BlackjackClients.get(i);
			// j for문은 head와 비교할 target에 각 유저를 담기 위함
			for (int j = 0; j < BlackjackClients.size(); j++) {
				ServiceThread target = BlackjackClients.get(j);
				// head와 target이 다르다면
				if (head != target) {
					switch (way) {
					case "hand":
						// 각 유저가 받은 마지막 패 하나를 head의 클라이언트로 보내줌, (hit는 해당 메소드가 끝나면 0으로 초기화가 되기 때문에 stay
						// 변수를 이용함.)
						if (target.BJinfo.getStay() != 1) {
							cnt++;
							List<String> hand = target.BJinfo.getHand();

							head.sendMsg("BJUSER" + cnt + " " + hand.get(hand.size() - 1));
						} else {
							// stay 한 유저를 건너뛰기 위한 cnt++;
							cnt++;
						}
						break;
					case "name":
						cnt++;
						// 각 유저의 이름을 head의 클라이언트로 보내줌
						head.sendMsg("BJUSERNAME" + cnt + " " + target.getDto().getName());
						break;
					case "state":
						cnt++;
						// 각 유저의 hit, stay, ready 여부를 클라이언트로 보내줌
						String state = null;
						if (target.BJinfo.getHit() == 1) {
							state = "HIT";
						} else if (target.BJinfo.getStay() == 1) {
							state = "STAY";
						} else if (target.BJinfo.getReady() == 1) {
							state = "READY";
						} else {
							state = "";
						}
						head.sendMsg("BJUSERSTATE" + cnt + " " + state);
						break;
					}
				}
			}
			// 유저가 나갔을 때 이미 적혀 있던 이름을 지우기 위함.
			if (way.equals("name")) {
				while (cnt < 5) {
					cnt++;
					head.sendMsg("BJUSERNAME" + cnt + "  ");
				}
			}
		}

	}

	// 모든 유저가 HIT 혹은 STAY를 누른 상태이면 턴을 종료하고 새로운 턴을 시작한다. 턴 종료 시엔 각 유저의 HIT 여부를 판별하여
	// 카드를 나눠준다.
	public void turn() {
		int turn = 1;
		for (int i = 0; i < BlackjackClients.size(); i++) {
			ServiceThread st = BlackjackClients.get(i);
			// 각 유저의 hit 혹은 stay가 1이라면 turn에 1을 곱한다.
			if (st.BJinfo.getHit() == 1 || st.BJinfo.getStay() == 1) {
				turn *= 1;
			} else {
				turn *= 0;
			}
		}

		// 모든 유저가 hit 혹은 stay라면 진행한다.
		if (turn == 1) {
			for (int i = 0; i < BlackjackClients.size(); i++) {
				ServiceThread st = BlackjackClients.get(i);
				if (st.BJinfo.getHit() == 1) {
					st.BJaddHand(this.draw());
					st.sendMsg("BJTURNEND");
				}
				// 그리고 turn이 끝났으니 Hit 변수를 0으로 초기화 한다. (stay는 그대로 유지 된다.)
				st.BJinfo.setHit(0);
			}
			this.otherUser("hand");
		}

	}

	// 모든 유저가 STAY를 눌렀을 때 실행되는 메소드
	public void end() {
		int theEnd = 1;
		for (int i = 0; i < BlackjackClients.size(); i++) {
			ServiceThread st = BlackjackClients.get(i);
			theEnd *= st.BJinfo.getStay();
		}

		// 모든 플레이어가 stay를 눌렀을 때
		if (theEnd == 1) {
			// 딜러가 카드를 뽑는다
			while (blackjackdao.Sum(dealerhand) <= 16) {
				dealerhand.add(this.draw());

				for (int i = 0; i < BlackjackClients.size(); i++) {
					ServiceThread st = BlackjackClients.get(i);
					// 뽑은 딜러의 패를 각 BlackjackClients에 set 시킴
					st.setDealerhand(dealerhand);
				}

			}

			for (int i = 0; i < BlackjackClients.size(); i++) {
				ServiceThread st = BlackjackClients.get(i);
				// 각 BlackjackClients의 블랙잭 여부를 확인 set시킴
				st.BJinfo.setBlackjack(blackjackdao.blackjack(st));

				// 최종적으로 각 BlackjackClients들이 각자가 가지고 있는 필드들을 활용하여 결과를 출력함
				double result = blackjackdao.result(st, blackjackdao.Sum(dealerhand));

				// 결과를 가지고 db에 반영
				projectdao.ending(st.getDto(), st.BJinfo.getBetting(), result);

				// 결과 출력(like 2 == WIN, 1.5 == BLACKJACK, 1 == DRAW, 0 == LOSE)
				if (result == 2) {
					st.sendMsg("BJmy: " + "WIN( " + result + "배 )");
				} else if (result == 1.5) {
					st.sendMsg("BJmy: " + "BLACKJACK( " + result + "배 )");
				} else if (result == 1) {
					st.sendMsg("BJmy: " + "DRAW( " + result + "배 )");
				} else if (result == 0) {
					st.sendMsg("BJmy: " + "LOSE( " + result + "배 )");
				}

				// 게임이 끝날때 각자의 배당을 적용 status창을 갱신시킨다.
				st.setDto(projectdao.login("LOGIN " + st.getDto().getName() + " " + st.getDto().getPw()));
				st.BJstatus();

				// 그리고 모든 변동된 데이터들을 리셋시킨다.
				st.BJreset();

			}
			this.dealerreset();

		}
	}

	// 모든 유저가 ready 버튼을 눌렀을 때 진행
	public void ready() {
		int ready = 1;
		for (int i = 0; i < BlackjackClients.size(); i++) {
			ServiceThread st = BlackjackClients.get(i);
			ready *= st.BJinfo.getReady();
		}

		if (ready == 1) {
			this.start();
			// state 창의 오류를 없애기 위해 ready 변수를 임의로 초기화 해줌
			for (int i = 0; i < BlackjackClients.size(); i++) {
				ServiceThread st = BlackjackClients.get(i);
				st.BJinfo.setReady(0);
			}
		}

	}

	// 베팅의 결과를 db에 반영한다.
	public void betting(ProjectDto dto, int betting) {
		projectdao.betting(dto, betting);
	}

}
