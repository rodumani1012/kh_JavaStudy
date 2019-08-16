package com.blackjack;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.my.client.client;

public class BlackjackClient {
	private Image blackjackchip1;// 칩이미지
	private client client;

	private int betCount = 0;// 칩 초기화
	private String bettingMoney = "";// 배팅할때마다 돈
	int betres = 0;// 배팅액
	private boolean gameEnd;// 딜러카드 뒤집기위한 불리언

	// 카드이미지를 맵에 담음
	private Map<String, Image> cardimg = new HashMap<String, Image>();

	// 카드연속출력하기위해 HAND를 LIST에
	List<String> listhandMy = new ArrayList<String>();
	List<String> listhandDealer = new ArrayList<String>();
	List<String> listhandUser1 = new ArrayList<String>();
	List<String> listhandUser2 = new ArrayList<String>();
	List<String> listhandUser3 = new ArrayList<String>();
	List<String> listhandUser4 = new ArrayList<String>();

	// gui구성
	JFrame frame;
	DrawFrame drawPanel;
	JButton ready;
	JButton hit;
	JButton stay;
	JButton bet;
	JButton back;
	TextArea chatout;
	JTextField chatin;
	JTextField status;

	JTextField user1name;
	JTextField user2name;
	JTextField user3name;
	JTextField user4name;

	JTextField user1nameDO;
	JTextField user2nameDO;
	JTextField user3nameDO;
	JTextField user4nameDO;

	//
	public void init() {
		gameEnd = false;
		// FRAME과 DRAWPANEL
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 종료

		drawPanel = new DrawFrame();
		drawPanel.setBounds(0, 0, 1500, 1500);
		drawPanel.setLayout(null);

		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(drawPanel);
		frame.setSize(1500, 1500);
		frame.setVisible(true);
		frame.setTitle("BlackJack♣");

		// ready버튼
		ready = new JButton("READY");
		ready.setBounds(500, 700, 100, 35);
		drawPanel.add(ready);
		// hit버튼
		hit = new JButton("HIT");
		hit.setBounds(622, 700, 60, 35);
		drawPanel.add(hit);
		// stay버튼
		stay = new JButton("STAY");
		stay.setBounds(800, 700, 75, 35);
		drawPanel.add(stay);
		// bet버튼
		bet = new JButton("BET");
		bet.setBounds(700, 700, 75, 35);
		drawPanel.add(bet);
		// back버튼
		back = new JButton("BACK");
		back.setBounds(50, 20, 100, 30);
		drawPanel.add(back);
		// 초기 버튼상태
		hit.setEnabled(false);
		stay.setEnabled(false);
		bet.setEnabled(true);
		ready.setEnabled(false);
		back.setEnabled(true);
		// 채팅창
		chatout = new TextArea();
		chatout.setEditable(false);
		chatout.setBounds(1200, 600, 400, 300);
		drawPanel.add(chatout);
		// 채팅입력창
		chatin = new JTextField();
		chatin.setBounds(1200, 900, 400, 100);
		drawPanel.add(chatin);
		// 상태창
		status = new JTextField();
		status.setEditable(false);
		status.setBounds(50, 700, 300, 50);
		drawPanel.add(status);
		// 유저이름 띄우는 필드
		user1name = new JTextField();
		user1name.setEditable(false);
		user1name.setBounds(150, 100, 100, 30);
		drawPanel.add(user1name);

		user2name = new JTextField();
		user2name.setEditable(false);
		user2name.setBounds(150, 550, 100, 30);
		drawPanel.add(user2name);

		user3name = new JTextField();
		user3name.setEditable(false);
		user3name.setBounds(900, 100, 100, 30);
		drawPanel.add(user3name);

		user4name = new JTextField();
		user4name.setEditable(false);
		user4name.setBounds(900, 550, 100, 30);
		drawPanel.add(user4name);

		// 유저가 stay hit 누른상태를 출력해주는필드
		user1nameDO = new JTextField();
		user1nameDO.setEditable(false);
		user1nameDO.setBounds(300, 100, 100, 30);
		drawPanel.add(user1nameDO);

		user2nameDO = new JTextField();
		user2nameDO.setEditable(false);
		user2nameDO.setBounds(300, 550, 100, 30);
		drawPanel.add(user2nameDO);

		user3nameDO = new JTextField();
		user3nameDO.setEditable(false);
		user3nameDO.setBounds(1050, 100, 100, 30);
		drawPanel.add(user3nameDO);

		user4nameDO = new JTextField();
		user4nameDO.setEditable(false);
		user4nameDO.setBounds(1050, 550, 100, 30);
		drawPanel.add(user4nameDO);

		// event
		Events event = new Events();
		hit.addActionListener(event);
		stay.addActionListener(event);
		bet.addActionListener(event);
		ready.addActionListener(event);
		back.addActionListener(event);
		// 채팅 event
		chatin.addActionListener(new InputListener());

		// map에 카드이미지저장
		String[] mark = { "D", "S", "H", "C" };
		String[] num = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J" };

		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 13; j++) {
				cardimg.put(mark[i] + num[j], new ImageIcon("src/cardimages/" + mark[i] + num[j] + ".png").getImage());

			}
		}

	}

	public BlackjackClient(client client) {

		init();
		this.client = client;
	}

	// selectGame에서 넘겨받은 메세지 즉, 서버에서 받은 메시지를 split으로 나눠서
	public void showhand(String msg) {

		String[] msgArr = msg.split(" ");
		String hand = "";
		for (int i = 1; i < msgArr.length; i++) {
			hand += (msgArr[i] + " ");
		}
		// 승리/패배/비김/첫두장블랙잭 이미지출력
		if (msg.equals("BJmy: LOSE( 0.0배 )")) {
			Image loseimage = new ImageIcon("src/cardimages/blackjacklose.png").getImage();
			drawPanel.setWinLose(loseimage);
			frame.repaint();
		} else if (msg.equals("BJmy: WIN( 2.0배 )")) {
			Image winimage = new ImageIcon("src/cardimages/blackjackwin.png").getImage();
			drawPanel.setWinLose(winimage);
			frame.repaint();
		} else if (msg.equals("BJmy: DRAW( 1.0배 )")) {
			Image drawimage = new ImageIcon("src/cardimages/blackjackdraw.png").getImage();
			drawPanel.setWinLose(drawimage);
			frame.repaint();
		} else if (msg.equals("BJmy: BLACKJACK( 1.5배 )")) {
			Image drawimage = new ImageIcon("src/cardimages/blackjack21.png").getImage();
			drawPanel.setWinLose(drawimage);
			frame.repaint();
		}

		switch (msgArr[0]) {
		case "BJmy:":
			// 나의 댁
			if (!hand.equals("")) {
				listhandMy.add(hand);// hand를 list에 담음
				drawPanel.setListhandMy(listhandMy);// hand를 담은 lsithandmy 를drawpanel로
				drawPanel.setHand(hand);
				drawPanel.setCardImg(cardimg);
				frame.repaint();// paintcomponent를 호출하기위한
			}
			break;
		case "BJdealer:":
			// 딜러 댁
			if (!hand.equals("")) {
				listhandDealer.add(hand);
				drawPanel.setListhandDealer(listhandDealer);
				drawPanel.setHand(hand);
				drawPanel.setCardImg(cardimg);
				frame.repaint();
			}
			break;
		case "BJRESET":
			// BJRESET 이란 메세지가 도착하면 betres를 0으로 초기화, 각 버튼들 비활성화 혹은 활성화
			betres = 0;
			this.gameEnd = true;
			hit.setEnabled(false);
			stay.setEnabled(false);
			bet.setEnabled(true);
			ready.setEnabled(false);
			drawPanel.setgameEnd(true);
			frame.repaint();
			break;
		case "BJSTATUS":
			// BJSTATUS 란 메세지가 도착하면 status 창 갱신 시킴
			status.setText("이름: " + msgArr[1] + "\n보유금액: " + msgArr[2]);
			break;
		case "BJTURNEND":
			// 턴이 끝나면 hit와 stay 버튼을 활성화
			hit.setEnabled(true);
			stay.setEnabled(true);
			break;

		// 각 유저의 패를 띄움
		case "BJUSER1":
			if (!hand.equals("")) {
				listhandUser1.add(hand);
				drawPanel.setListhandUser1(listhandUser1);
				drawPanel.setHand(hand);
				drawPanel.setCardImg(cardimg);
				frame.repaint();
			}
			break;
		case "BJUSER2":
			if (!hand.equals("")) {
				listhandUser2.add(hand);
				drawPanel.setListhandUser2(listhandUser2);
				drawPanel.setHand(hand);
				drawPanel.setCardImg(cardimg);
				frame.repaint();
			}
			break;
		case "BJUSER3":
			if (!hand.equals("")) {
				listhandUser3.add(hand);
				drawPanel.setListhandUser3(listhandUser3);
				drawPanel.setHand(hand);
				drawPanel.setCardImg(cardimg);
				frame.repaint();
			}
			break;
		case "BJUSER4":
			if (!hand.equals("")) {
				listhandUser4.add(hand);
				drawPanel.setListhandUser4(listhandUser4);
				drawPanel.setHand(hand);
				drawPanel.setCardImg(cardimg);
				frame.repaint();
			}
			break;
		// 각 유저의 이름을 띄움
		case "BJUSERNAME1":
			user1name.setText(hand);
			break;
		case "BJUSERNAME2":
			user2name.setText(hand);
			break;
		case "BJUSERNAME3":
			user3name.setText(hand);
			break;
		case "BJUSERNAME4":
			user4name.setText(hand);
			break;
		// 각 유저의 state을 띄움
		case "BJUSERSTATE1":
			user1nameDO.setText(hand);
			break;
		case "BJUSERSTATE2":
			user2nameDO.setText(hand);
			break;
		case "BJUSERSTATE3":
			user3nameDO.setText(hand);
			break;
		case "BJUSERSTATE4":
			user4nameDO.setText(hand);
			break;
		// 채팅
		case "BJchat":
			chatout.append(hand + "\n");
			break;
		}
	}

	public void go() {

		// BlackjackClient 창을 띄우면 status 창을 띄움
		client.out.println("BJIN");

		client.out.println("BJSTART");
	}

	// hit 버튼 눌렀을때 HIT 전송 , stay 버튼 눌렀을때 STAY 전송
	class Events implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();

			if (b.getLabel().trim().equals("HIT")) {
				// HIT를 눌렀을 때, BJHIT 메세지 서버쪽으로 제출, turn이 끝나기 전까지 hit와 stay 버튼을 비활성화 시킨다.
				hit.setEnabled(false);
				stay.setEnabled(false);
				client.out.println("BJHIT");
				frame.repaint();
			} else if (b.getLabel().trim().equals("STAY")) {
				// STAY 버튼을 눌렀을 때 서버 쪽으로 BJSTAY 메시지 out 해주고 다른 버튼 모두 비활성화시킴
				hit.setEnabled(false);
				stay.setEnabled(false);
				bet.setEnabled(false);
				ready.setEnabled(false);
				client.out.println("BJSTAY");
				frame.repaint();
				betCount = 0;// 배팅칩 초기화하기위함

			} else if (b.getLabel().trim().equals("READY")) {
				// READY를 눌렀을 때, area 전부를 정리 해주고 버튼 활성화 및 비활성화 시켜준다. 그리고 bet 금액 서버로 넘겨준다.

				hit.setEnabled(true);
				stay.setEnabled(true);
				bet.setEnabled(false);
				ready.setEnabled(false);
				client.out.println("BJBET " + betres);
				client.out.println("BJREADY");
				drawPanel.reset();
				drawPanel.setgameEnd(false);
				drawPanel.setWinLose(null);// 승리,패배,비김,첫21,이미지 초기화
				frame.repaint();
			} else if (b.getLabel().trim().equals("BET")) {
				// BET 눌렀을 때, BET 에 betres를 setText 해준다
				ready.setEnabled(true);
				betres += 50000;
				betCount++;
				bettingMoney = "betting money: " + Integer.toString(betres);// 배팅액을 string로받아출력
				drawPanel.setBettingMoney(bettingMoney);
				drawPanel.setBetCount(betCount);
				blackjackchip1 = new ImageIcon("src/cardimages/blackjackchip2.png").getImage();
				drawPanel.setChipImg(blackjackchip1);
				drawPanel.setWinLose(null);
				frame.repaint();

				// BACK 눌렀을때
			} else if (b.getLabel().trim().equals("BACK")) {
				frame.setVisible(false);
				client.out.println("BJBACK");
			}

		}

	}

	// 채팅을 위한 이벤트 클래스
	class InputListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String input = chatin.getText();
			chatin.setText("");
			try {
				client.out.println("BJchat " + input);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}

class DrawFrame extends JPanel {
	String displaydealername = "DEALER";// 딜러위에 이름
	String chattingname = "CHATTING";// 채팅창위에 이름
	String myMoney = "MyMoney";// 상태창 위에 이름
	Image winLose;// 승,패,비김,21(blackjack이미지)
	String hand = "";// 어떤카드가나오는지 패가 들어옴ex)D7=다이아7
	String bettingMoney = "";// 배팅금액 DRAWSTRING출력
	Image blackjackchip1;// 배팅칩이미지
	int betCount;
	boolean gameEnd;

	List<String> listhandMy = new ArrayList<String>();// 계속들어오는 hand를 담기위해
	List<String> listhandDealer = new ArrayList<String>(); //
	List<String> listhandUser1 = new ArrayList<String>();
	List<String> listhandUser2 = new ArrayList<String>(); // 각자 패 뽑아오기위함
	List<String> listhandUser3 = new ArrayList<String>();
	List<String> listhandUser4 = new ArrayList<String>(); //

	Map<String, Image> cardimg = new HashMap<String, Image>();// 카드이미지들을 담은 map

	private static final long serialVersionUID = 1L;

	public void setWinLose(Image winLose) {
		this.winLose = winLose;
	}

	public void setBettingMoney(String bettingMoney) {
		this.bettingMoney = bettingMoney;
	}

	public void setgameEnd(boolean gameEnd) {
		this.gameEnd = gameEnd;
	}

	public void setChipImg(Image blackjackchip1) {
		this.blackjackchip1 = blackjackchip1;
	}

	public void setBetCount(int betCount) {
		this.betCount = betCount;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	// 매시작할때마다 카드 다시 주기위해 화면에보이는 카드 초기화
	public void reset() {
		this.listhandMy.removeAll(listhandMy);
		this.listhandDealer.removeAll(listhandDealer);
		this.listhandUser1.removeAll(listhandUser1);
		this.listhandUser2.removeAll(listhandUser2);
		this.listhandUser3.removeAll(listhandUser3);
		this.listhandUser4.removeAll(listhandUser4);

	}

	public void setCardImg(Map<String, Image> cardimg) {// 이미지 받기위해
		this.cardimg = cardimg;
	}

	public void setListhandMy(List<String> listhandMy) {
		this.listhandMy = listhandMy;
	}

	public void setListhandDealer(List<String> listhandDealer) {
		this.listhandDealer = listhandDealer;
	}

	public void setListhandUser1(List<String> listhandUser1) {
		this.listhandUser1 = listhandUser1;
	}

	public void setListhandUser2(List<String> listhandUser2) {
		this.listhandUser2 = listhandUser2;
	}

	public void setListhandUser3(List<String> listhandUser3) {
		this.listhandUser3 = listhandUser3;
	}

	public void setListhandUser4(List<String> listhandUser4) {
		this.listhandUser4 = listhandUser4;
	}

	// 자동호출함수 실질적으로 모든 image그려줌
	@Override
	public void paintComponent(Graphics g) {

		Dimension d = getSize();// 화면전체 사이즈를 받아오기위한 d
		// 배경화면
		Image blackjacktable = new ImageIcon("src/cardimages/blackjack_table.png").getImage();
		g.drawImage(blackjacktable, 0, 0, d.width, d.height, this);

		// 그려질string font,color
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.setColor(new Color(1.0f, 0.0f, 0.0f));
		g.drawString(displaydealername, 650, 70);
		g.drawString(chattingname, 1200, 585);
		g.drawString(myMoney, 50, 685);

		// 배팅칩 띄우기
		for (int i = 0; i < betCount; i++) {
			g.drawImage(blackjackchip1, 650, 500 - i * 20, this);
			g.drawString(bettingMoney, 600, 650);
			bettingMoney = "";
		}
		// 승패비김블랙잭 이미지
		g.drawImage(winLose, 500, 350, this);

		// 나의 카드 띄우기
		for (int i = 0; i < listhandMy.size(); i++) {
			Image imagewhat;
			imagewhat = cardimg.get(listhandMy.get(i).trim());
			g.drawImage(imagewhat, (650 + i * 20), 800, this);

		}
		// 딜러 카드
		for (int i = 0; i < listhandDealer.size(); i++) {
			Image imagewhat;
			// 처음엔 첫번쨰 카드를 뒤집고 reset들어오면 처음카드를 다시 보여준다
			if (!gameEnd) {
				if (i == 0) {
					imagewhat = new ImageIcon("src/cardimages/b1fv.png").getImage();
				} else {
					imagewhat = cardimg.get(listhandDealer.get(i).trim());
				}
			}

			else {
				imagewhat = cardimg.get(listhandDealer.get(i).trim());
			}
			g.drawImage(imagewhat, (650 + i * 20), 80, this);

		}
		// user1 card
		for (int i = 0; i < listhandUser1.size(); i++) {
			Image imagewhat;
			imagewhat = cardimg.get(listhandUser1.get(i).trim());
			g.drawImage(imagewhat, (150 + i * 20), 200, this);

		}
		// user2 card
		for (int i = 0; i < listhandUser2.size(); i++) {
			Image imagewhat;
			imagewhat = cardimg.get(listhandUser2.get(i).trim());
			g.drawImage(imagewhat, (150 + i * 20), 400, this);

		}
		// user3 card
		for (int i = 0; i < listhandUser3.size(); i++) {
			Image imagewhat;
			imagewhat = cardimg.get(listhandUser3.get(i).trim());
			g.drawImage(imagewhat, (1050 + i * 20), 200, this);

		}
		// user4 card
		for (int i = 0; i < listhandUser4.size(); i++) {
			Image imagewhat;
			imagewhat = cardimg.get(listhandUser4.get(i).trim());
			g.drawImage(imagewhat, (1050 + i * 20), 400, this);

		}

	}
}
