package com.project;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import com.blackjack.BlackjackinGameinfo;
import com.my.dto.ProjectDto;
import com.seoda.SeodaGameInfo;
import com.slot.SlotInfo;

public class ServiceThread extends Thread {

	private ProjectDto dto;
	private Server server;
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;

	public SeodaGameInfo seodaInfo = new SeodaGameInfo();
	public BlackjackinGameinfo BJinfo = new BlackjackinGameinfo();
	public SlotInfo SMinfo = new SlotInfo();

	//	DTO를 리턴
	public ProjectDto getDto() {
		return dto;
	}

	//	DTO를 세팅
	public void setDto(ProjectDto dto) {
		this.dto = dto;
	}

	// 생성자
	public ServiceThread(Server server, Socket socket) {
		super();
		this.server = server;
		this.socket = socket;
	}

	// message 전달
	public void sendMsg(String msg) {
		if (out != null) {
			out.println(msg);
		}
	}

	// ---------------------------- 블랙잭

	//	게임 리셋
	public void BJreset() {
		BJinfo = new BlackjackinGameinfo();
		out.println("BJRESET");
	}

	//	게임에 각자의 상태 전달(이름, 돈)
	public void BJstatus() {
		out.println("BJSTATUS " + dto.getName() + " " + dto.getMoney());
	}

	//	카드뽑기
	public void BJaddHand(String card) {
		BJinfo.addHand(card);
		this.BJsendHand();
	}

	//	카드 전달
	public void BJsendHand() {
		List<String> hand = BJinfo.getHand();
		out.println("BJmy: " + hand.get(hand.size() - 1));

	}

	//	딜러카드세팅
	public void setDealerhand(List<String> dealerhand) {
		BJinfo.setDealerhand(dealerhand);
		this.sendDealerHand();
	}

	//	딜러카드 각 유저에게 전달
	public void sendDealerHand() {
		List<String> dealerhand = BJinfo.getDealerhand();
		out.println("BJdealer: " + dealerhand.get(dealerhand.size() - 1));

	}

	// ----------------------------- 섯다
	// 게임 종료 후 리셋
	public void SDreset() {
		seodaInfo = new SeodaGameInfo();
		out.println("SEODARESET");
	}

	// 카드 점수(ex: 38광땡 150점 / 18,13광땡 140점 등등) 저장
	public void setResultCard(String msg) {
		seodaInfo.setResultCard(msg);
	}

	// 카드 점수 불러오기
	public int getResultCard() {
		return seodaInfo.getResult();
	}

	// 이름과 돈 상태 전달
	public void seodaStauts() {
		out.println("SEODAMY " + dto.getName() + " " + dto.getMoney());
	}

	// 카드 받기
	public void SDaddHand(int card) {
		seodaInfo.addCard(card);
		this.SDsendHand();
	}

	// 카드 전달
	public void SDsendHand() {
		List<Integer> card = seodaInfo.getHand();
		out.println("SEODAMYCARD " + card.get(card.size() - 1));
	}

	// 메시지 주고 받기
	@Override
	public void run() {
		try {
			System.out.println("클라이언트\n" + socket + "\n에서 접속하였습니다.");

			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// Clients에서 파생된 각 게임이나 클라이언트창 등등에서 보내는 메시지 저장
			String inputLine;

			while ((inputLine = in.readLine()) != null) {		//	클라이언트쪽에서 전달한 메시지가 존재 할 경우
				// contains() : ()안에 있는 단어가 있으면 무조건 실행 , eqauls() : ()안에 있는 단어와 동일할 경우 실행 

				// ------------------------- 회원 가입, 로그인 ------------------------------------
				if (inputLine.contains("REGISTRY")) {
					// 회원가입(server의 newId()에 메시지 전달
					if (server.newId(inputLine)) {
						// 성공하면 true가 리턴 되어 클라이언트에 "REGISTRY SUCESS" 전달
						out.println("REGISTRY SUCESS");
					}
					
				} else if (inputLine.contains("LOGIN")) {
					// 로그인 성공하면 dto에 각 유저의 데이터가 담기게 된다.
					dto = server.login(inputLine);
					if (dto != null) {			//	로그인이 성공하면 dto에 값이 저장되기 때문에 null이 아니다
						out.println("SUCESS");
					} else {
						out.println("FAIL");
					}
					
					// ------------------------- 블랙잭 ------------------------------------
				} else if (inputLine.trim().equals("BJHIT")) {
					// HIT 시엔 hit 변수에 1을 담고 turn이 종료되는 지 확인함
					this.BJinfo.setHit(1);
					server.BJMethod.otherUser("state");
					server.BJMethod.turn();
				} else if (inputLine.trim().equals("BJSTAY")) {
					// STAY 시엔 stay변수에 1을 담고 각자의 hand를 더해 sum에 set시킨다. 그리고 turn이 종료되는 지 확인함
					// 그 후에 server의 end를 메소드를 실행시켜 모든 유저가 stay를 눌렀는지도 확인한
					BJinfo.setStay(1);
					this.BJinfo.setSum();
					server.BJMethod.otherUser("state");
					server.BJMethod.turn();
					server.BJMethod.end();
					
				} else if (inputLine.trim().equals("BJREADY")) {
					// READY를 누르면 status 창을 갱신, 더불어 server.ready()를 실행, 유저 모두가 READY를 눌렀는지 체크한다.
					this.BJstatus();
					BJinfo.setReady(1);
					server.BJMethod.otherUser("state");
					server.BJMethod.ready();
					
				} else if (inputLine.contains("BJBET")) {
					// 베팅 메소드, 베팅 금액을 넘겨받아 info에 세팅한다, 그리곤 db에 반영한다. (보유 금액에 베팅 금액 뺀다)
					String betting = inputLine;
					this.BJinfo.setBetting(Integer.parseInt(betting.split(" ")[1]));
					server.BJMethod.betting(dto, BJinfo.getBetting());
					// db에 반영한 내용을 dto에도 반영함, LOGIN 메소드 재활용함
					dto = server.login("LOGIN " + dto.getName() + " " + dto.getPw());
					
				} else if (inputLine.equals("BJSTART")) {
					// 블랙잭 화면이 커졌을 때 status 창 갱신, 각 유저의 이름 갱신, 각 유저 입장 시 채팅 출력
					this.BJstatus();
					server.BJMethod.otherUser("name");
					server.BJMethod.sendMessageAll("BJchat " + dto.getName() + "님이 입장하셨습니다.");
					
				} else if (inputLine.contains("BJchat")) {
					// 블랙잭 내부 채팅을 위한
					String[] msgArr = inputLine.split(" ");
					String msg = "";
					for (int i = 1; i < msgArr.length; i++) {
						msg += inputLine.split(" ")[i] + " ";
					}
					server.BJMethod.sendMessageAll("BJchat " + dto.getName() + ": " + msg);
					
				} else if (inputLine.equals("BJIN")) {
					// 블랙잭 서버에 접속했음을 알리는 메소드, 유저를 각 게임별로 관리하기 위함
					server.deliverUser("blackjack", dto.getName());
					
				} else if (inputLine.equals("BJBACK")) {
					this.sendMsg("BACK");
					server.BJMethod.removeClient(this);
					server.BJMethod.otherUser("name");
					server.BJMethod.turn();
					server.BJMethod.ready();

					// ------------------슬롯머신----------------------------------
				} else if (inputLine.equals("SLOTSTART")) {
					//	슬롯머신에 자신의 돈 전달
					out.println("SLOTSTART " + dto.getMoney());
					
				} else if (inputLine.contains("SLOTENDING")) {
					//	슬롯머신을 돌려 배팅한 값에 대한 결과를 디비에 업데이트를 하고 다시 자신의 돈을 전달
					System.out.println(dto.getName());
					System.out.println(inputLine);
					server.projectdao.slotending(dto, Integer.parseInt(inputLine.split(" ")[1]));
					dto = server.projectdao.login("LOGIN " + dto.getName() + " " + dto.getPw());
					out.println("SLOTENDING " + dto.getMoney());
					
				} else if (inputLine.equals("SLOTBACK")) {
					//	BACK 버튼 클릭시 뒤로 돌아가기
					this.sendMsg("BACK");
					
					// ------------------------ 섯다----------------------
				} else if (inputLine.contains("SEODACHAT")) {
					// 내부 채팅
					// 받은 메시지를 잘라서 0번지 값은 제외하고 나머지를 붙여서 유저이름과 함께 다시 전달
					String[] msgArr = inputLine.split(" ");
					String msg = "";
					for (int i = 1; i < msgArr.length; i++) {
						msg += inputLine.split(" ")[i] + " ";
					}
					server.seodaMethod.sendMessageAll("SEODACHAT " + dto.getName() + ": " + msg);

				} else if (inputLine.contains("SEODASTART")) {
					// 게임 접속시 자신의 상태와 다른사람의 상태 전달
					this.seodaStauts();
					server.seodaMethod.otherUser("name");
					server.seodaMethod.sendMessageAll("SEODACHAT " + dto.getName() + "님이 입장하셨습니다!");

				} else if (inputLine.contains("SEODAREADY")) {
					// 레디를 누르면 server.ready() 실행 후 모두 ready를 눌렀는지 확인
					seodaInfo.setReady(1);
					server.seodaMethod.gameTotalBattingMoney(); 		// 배팅 금액 한번 추가(입장료)
					server.seodaMethod.sendMessageAll(inputLine); 	// 각 유저에게 레디를 눌렀다고 표시
					server.seodaMethod.sendGameTotalBattingMoney();	// 각 유저에게 현재 배팅액 출력 메소드
					server.seodaMethod.ready();						// 레디 실행

				} else if (inputLine.contains("SEODACALL")) {
					// CALL를 누르면 배팅액 추가
					server.seodaMethod.gameTotalBattingMoney(); 		// 배팅액 증가
					server.seodaMethod.sendMessageAll(inputLine); 	// 각 유저에게 메시지 전달(ex: 00님 콜!)
					server.seodaMethod.sendGameTotalBattingMoney(); 	// 각 유저에게 현재 배팅액 출력 메소드

				} else if (inputLine.contains("SEODADIE")) {
					// DIE를 누르면 점수를 0점으로 만들고 RESULT 추가
					seodaInfo.setResult_Count(1);
					setResultCard(inputLine);						// 점수를 0점으로 전달
					server.seodaMethod.sendMessageAll(inputLine);		// 각 유저에게 메시지 전달(ex: 00님 DIE)
				
				} else if (inputLine.contains("SEODARESULT")) {
					// 게임 결과 보기
					seodaInfo.setResult_Count(1);
					setResultCard(inputLine);						// 각 유저에게 메시지 전달
					server.seodaMethod.end();						// 모두 결과보기를 누르면 실행
					
				} else if (inputLine.equals("SEODAIN")) {
					// 섯다 서버에 접속했음을 알리는 메소드, 유저를 각 게임별로 관리하기 위함
					server.deliverUser("seoda", dto.getName());
					
				} else if (inputLine.equals("SEODABACK")) {
					// BACK버튼 클릭시 뒤로가기
					this.sendMsg("BACK");
					server.seodaMethod.removeClient(this);			// 섯다에서 그 유저를 삭제
					server.seodaMethod.otherUser("name");			// 나갓다는 메시지 전달
					server.seodaMethod.ready();
				}
			}
			out.close();
			in.close();
			socket.close();

		} catch (IOException e) {
			server.removeClient(this);
			System.out.println("클라이언트 \n" + socket + "\n에서 접속이 끊겼습니다...");
		}
	}
}
