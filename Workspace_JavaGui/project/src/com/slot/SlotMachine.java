package com.slot;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import com.my.client.SelectGame;
import com.my.client.client;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine extends JFrame implements ActionListener {
	private client client;

	private final static int[] BETTING_MONEY = { 100000, 1000000, 10000000 }; // 100,000 / 1,000,000 / 10,000,000 //배팅가능한 금액

	private int money = 0;// 가지고 있는 돈
	private int betting = 0;// 배팅한 돈

	private DecimalFormat df = new DecimalFormat("#,##0");// 1000단위 콤마(,)
	
	private static ImageIcon[] picArr = new ImageIcon[5]; // ImageIcon 목록

	private JButton[] btnStop = new JButton[3]; // 스탑버튼
	private JButton[] btnBetting = new JButton[3]; // 배팅버튼
	private JButton buttonStart = new JButton("start");	// 게임 시작
	
	private JButton buttonBack = new JButton("BACK");	// 뒤로가기

	private Timer[] timer = new Timer[3]; // 타이머

	private JLabel[] lb = new JLabel[3]; // 슬롯
	private JLabel bettingLabel = new JLabel("배팅내역:" + df.format(betting) + "원"); // 배팅정보
	private JLabel havingLabel = new JLabel("보유금액: " + df.format(money) + "원"); // 보유정보

	private int stopCount = 0;

	public SlotMachine(client client) {

		this.setSize(1000, 700); // 메인사이즈
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("KH Slot Machine");
		this.client = client;

		JPanel panel = new JPanel(null);

		// 이미지 로딩
		for (int i = 0; i < picArr.length; i++) {
			picArr[i] = new ImageIcon("SlotImages/slot" + (i + 1) + ".png");
		}

		//초기 x좌표를 지정하고 추후에 나오는 슬롯과 버튼들을 이동
		for (int i = 0, labelx = 200, buttonx = 330; i < 3; i++, labelx += 200, buttonx += 120) {
			// Label 초기화
			lb[i] = new JLabel(picArr[0]);
			lb[i].setBounds(labelx, 100, 200, 200);
			panel.add(lb[i]);

			// 정지버튼 초기화
			btnStop[i] = new JButton("stop" + (i + 1));
			btnStop[i].setBounds(buttonx, 300, 100, 50);
			btnStop[i].setEnabled(false);
			btnStop[i].addActionListener(this);
			panel.add(btnStop[i]);

			// 배팅버튼 초기화
			btnBetting[i] = new JButton(new ImageIcon("SlotImages/betting" + (i + 1) + ".png"));
			btnBetting[i].setBounds(buttonx, 400, 100, 50);
			btnBetting[i].addActionListener(this);
			panel.add(btnBetting[i]);
		}
		
		buttonBack.setBounds(50, 20, 100, 30);
		add(buttonBack);
		buttonBack.addActionListener(this);

		// 시작버튼
		buttonStart.setBounds(400, 500, 200, 50);
		panel.add(buttonStart);
		buttonStart.addActionListener(this);

		// 배팅정보
		bettingLabel.setBounds(450, 370, 150, 20);
		panel.add(bettingLabel);

		// 소지금 정보
		havingLabel.setBounds(850, 10, 1000, 20);
		panel.add(havingLabel);

		this.add(panel);

		this.setVisible(true);
	}
	//스타트 메시지 서버에 보내는 용도
	public void slotStart() {
		client.out.println("SLOTSTART");
	}
	//보유액 설정
	public void setMoney(int money) {
		this.money = money;
		this.viewMoney();
	}
	//보유액 보기
	public void viewMoney() {
		havingLabel.setText("보유금액:" + df.format(money) + "원");
	}

	// selectGame에서 넘겨받은 메세지 즉, 서버에서 받은 메시지를 split으로 나눠서
	// 0번지의 이름을 기준으로 if 문으로 나눠 각각 해당하는 위치에 setText 한다.
	public void receiveMsg(String msg) {

		System.out.println(msg);

		String[] msgArr = msg.split(" ");
		String slot = "";
		for (int i = 1; i < msgArr.length; i++) {
			slot += (msgArr[i] + " ");
		}

		switch (msgArr[0]) {
		case "SLOTSTART":
			// SLOTSTART: 로 시작되면 db에서 보유금액 불러오기
			this.setMoney(Integer.parseInt(slot.trim()));
			break;
		case "SLOTENDING"://SLOTENDING 로 시작하면 슬롯머신 게임 후의 돈을 db에 반영
			this.setMoney(Integer.parseInt(slot.trim()));
			this.viewMoney();
			buttonStart.setEnabled(true);//한판 게임 이후 start버튼 다시 누를 수 있게
			break;
		}
	}

	// 이벤트
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		// 시작버튼 실행시 배팅
		if (source == buttonStart) {//스타트 버튼 누를 시
			if (betting > 0) {//배팅 금액이 0보다 클 경우
				stopCount = 0;

				for (int i = 0; i < 3; i++) {
					timer[i] = new Timer();
					timer[i].schedule(new SlotTask(lb[i]), 0, (int) (0.1 * 10));// TimerTask task, delay, period - 슬롯머신이 돌아가는 속도)


					btnStop[i].setEnabled(true);//스타트 버튼 이후 슬롯머신이 돌아가기 시작하면 stop버튼 활성화
					btnBetting[i].setEnabled(false);//스타트 버튼이후 배팅 못하도록 배팅 버튼 비활성화
					buttonStart.setEnabled(false);//스타트 버튼이후 배팅 못하도록 스타트 버튼 비활성화
				}

				bettingLabel.setText("배팅내역:" + df.format(betting) + "원");//배팅금액을 띄워줌
				havingLabel.setText("보유금액:" + df.format(money) + "원");// 보유금액을 띄워줌
			} else {
				JOptionPane.showMessageDialog(null, "배팅을 하세요");// 배팅금액이 0일시에 배팅경고메시지 출력
			}
			
			//	back 눌렀을때
		} else if (source == buttonBack) {
			setVisible(false);	//	창 끄기
			client.out.println("SLOTBACK");	//	셀렉트게임으로 간다
		} else {
			for (int i = 0; i < 3; i++) {
				if (btnStop[i] == source) {//스탑버튼이 이벤트(클릭)발생 하면
					timer[i].cancel();//슬롯머신 돌아가는게 멈춤
					btnStop[i].setEnabled(false);//누른 스탑버튼이 비활성화

					stopCount++;//누른 스탑버튼이 비활성화

					if (stopCount == 3) {//스탑 카운트가 3일시
						// 점수로직
						checkMatched();//checkMatched메소드 실행
					}
					return;
				}
			}
			for (int i = 0; i < 3; i++) {
				if (btnBetting[i] == source) {//배팅 버튼 각 10만 100만, 1000만 누를때
					// 배팅금액 Validation
					if (0 <= money - BETTING_MONEY[i]) {// 보유금액에서 배팅금액버튼만큼 액수 차감한게 0보다 큰 경우(돈이 아직 남아있는 경우)
						// 금액 조절
						betting += BETTING_MONEY[i];//각 버튼에 따른 배팅 금액 가감
						money -= BETTING_MONEY[i];//각 버튼에 따른 보유금액 가감

						bettingLabel.setText("배팅내역:" + df.format(betting) + "원");//배팅금액을 띄워줌
						havingLabel.setText("보유금액:" + df.format(money) + "원");// 보유금액을 띄워줌
					}
					return;
				}
			}
		}
	}

	private void checkMatched() {
		// 전부 일치 안하는 경우
		if (picArr[4] == lb[0].getIcon() && picArr[4] == lb[1].getIcon() && picArr[4] == lb[2].getIcon()) {
			money = money + betting * 3;// picArr4의 그림과 각 슬롯의 이미지가 모두 같을시 3배

		} else {
			int count = 0;// 틀렸으면 count = 0 
			for (int i = 0; i < 3; i++) {// i가 3번 돌면서
				for (int j = i + 1; j < 3; j++) {// i가 0일땐 j는 2번 1일땐 1번 총 6번 돌면서,

					if (lb[i].getIcon() == lb[j].getIcon()) {
						count++;// lb[i] i의 값이 0일때의 값 과 1일때의 값 , 0일때의 값과 2일떄의 값 ,1일때의 값과 2일떄의 값 이 같으면 count 증가 
					}
				}
			}
			// 3 모두일치, 1 하나일치, 0 일치안함 (일치 안하는건 앞에서 걸러짐)
			switch (count) {
			case 1:
				money = money + (int) (betting * 1.2);
				break;// 배당1.2배
			case 3:
				money = money + betting * 2;
				break;// 배당2배
			}
		}

		betting = 0;//배팅금액을 다시 0으로 초기화

		bettingLabel.setText("배팅내역:" + betting + "원");//배팅금액 송출

		// dao의 end이랑 엮임. 슬롯머신이 끝난 후의 금액을 송출
		client.out.println("SLOTENDING " + money);

		for (int j = 0; j < 3; j++) {
			btnBetting[j].setEnabled(true);//배팅버튼 활성화
		}
	}

	// 슬롯돌아가는 메소드
	class SlotTask extends TimerTask {//status값이 0,1,2,3,4 인 SlotTask Class 생성
		private int status = 0;
		private JLabel lb;

		public SlotTask(JLabel lb) {
			this.lb = lb;
		}

		public void run() {//해당 status 값이 0,1,2,3,4 을 가지고 있는 Thread
			status = (status + 1) % 5;//스레드 통해 계속해서 값이 증가하는 구조

			lb.setIcon(picArr[status]);//status값을 picArr 배열에 집어넣어서 lb를 정의
		}

		public int getStatus() {
			return status;
		}
	}
}
