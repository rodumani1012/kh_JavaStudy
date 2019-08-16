package com.EGGDisplay;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;


import com.dayandnight.chgStus;
import com.dayandnight.grow;
import com.dayandnight.addMydate;
import com.pipi.dao.pipiDao;
import com.pipi.dto.pipiDto;
import com.pipi.login.pipijoin;
import com.pipi.login.pipilogin;
import com.pipi.progressBar.pipiProgressBar;

public class Main extends JFrame implements ActionListener {



	public static String url;
	public static String born = "";
	public static boolean res = true;
	public static int cnt = 10; // 30
	public static JScrollPane scrollPane; // 20190507
	public static ImageIcon icon; // 20190507
	ImageIcon icon1;
	static ImageIcon eg;
	static JButton EGG;

	JLabel DandN;
	public static JPanel background;

	public static pipiDto dto;
	public static JProgressBar PG_myheart, PG_myfull, PG_mystamina, PG_myclean;
	public static Main frame = null;
	
	ImageIcon eatpan, bathpan, medipan, playpan, sleeppan;

	public static pipiDto getDto() {
		return dto;
	}

	public static void setDto(pipiDto dto) {
		Main.dto = dto;
	}

	public Main() {
		
//		if( dto == null){
//			pipiDto dto = new pipiDto();
//			dto = Main.getDto();
//			int Myno = dto.getMyno();
//			pipiDto retDto = pipiDao.selectData(Myno);
//		}

		if (dto.getMydate() > 0) {
			cnt = 0;
		}

		if (cnt > 0) {
			url = "./image/EGG00.png";

		}

		eg = new ImageIcon(url);

		icon = new ImageIcon("./image/Main_Day1.png");

		// 배경 Panel 생성후 컨텐츠페인으로 지정
		background = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
				// setLocationRelativeTo(null); // 화면 가운데 위치하기

			}
		};


		EGG = new JButton(eg);

		EGG.setBorderPainted(false); // egg버튼 외곽선 삭제
		EGG.setFocusPainted(false); // focus시 테두리 사용안함
		EGG.setContentAreaFilled(false);

		background.add(EGG);

		background.setLayout(null);
		// 메인 메뉴 및 서브 메뉴
		// 먹이주기 ======================
		JButton eat = new JButton("먹이주기");
		eatpan = new ImageIcon("./image/eatpan.png");
		eat.setIcon(eatpan);
		eat.setBorderPainted(false);
		eat.setFocusPainted(false);
		eat.setContentAreaFilled(false);
		
		final JPopupMenu eatMenu = new JPopupMenu();
		JMenuItem rice = new JMenuItem("쌀");
		JMenuItem worms = new JMenuItem("지렁이");
		JMenuItem peach = new JMenuItem("복숭아");
		eatMenu.add(rice);
		eatMenu.add(worms);
		eatMenu.add(peach);

		// 쌀
		rice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pipiDto dto = new pipiDto();
				dto = Main.getDto();
				int Myno = dto.getMyno();
				pipiDto retDto = pipiDao.selectData(Myno);
				pipiDto newDto = new pipiDto();
				newDto.setMyno(dto.getMyno());
				int full;
				int stm;
				if (retDto.getMyfull() < 90) {
					full = retDto.getMyfull() + 10;

				} else {
					full = 100;

				}

				if (retDto.getMystamina() < 90) {
					stm = retDto.getMystamina() + 10;
				} else {
					stm = 100;
				}

				newDto.setMyfull(full);
				newDto.setMystamina(stm);
				newDto.setMyheart(retDto.getMyheart());
				newDto.setMyclean(retDto.getMyclean());

				pipiDao.updateStatus(newDto);

			}
		});

		// 지렁이
		worms.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pipiDto dto = new pipiDto();
				dto = Main.getDto();
				int Myno = dto.getMyno();
				pipiDto retDto = pipiDao.selectData(Myno);
				pipiDto newDto = new pipiDto();
				newDto.setMyno(dto.getMyno());
				int full;
				int stm;
				if (retDto.getMyfull() < 70) {
					full = retDto.getMyfull() + 30;

				} else {
					full = 100;

				}

				if (retDto.getMystamina() < 70) {
					stm = retDto.getMystamina() + 30;
				} else {
					stm = 100;
				}
				newDto.setMyfull(full);
				newDto.setMystamina(stm);
				newDto.setMyheart(retDto.getMyheart());
				newDto.setMyclean(retDto.getMyclean());

				pipiDao.updateStatus(newDto);

			}
		});

		// 복숭아
		peach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pipiDto dto = new pipiDto();
				dto = Main.getDto();
				int Myno = dto.getMyno();
				pipiDto retDto = pipiDao.selectData(Myno);
				pipiDto newDto = new pipiDto();
				newDto.setMyno(dto.getMyno());
				int full;
				int stm;
				if (retDto.getMyfull() < 80) {
					full = retDto.getMyfull() + 20;

				} else {
					full = 100;

				}

				if (retDto.getMystamina() < 80) {
					stm = retDto.getMystamina() + 20;
				} else {
					stm = 100;
				}
				newDto.setMyfull(full);
				newDto.setMystamina(stm);
				newDto.setMyheart(retDto.getMyheart());
				newDto.setMyclean(retDto.getMyclean());

				pipiDao.updateStatus(newDto);

			}
		});

		eat.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == 1) {
					eatMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		// 놀아주기=======================
		JButton joy = new JButton();
		playpan = new ImageIcon("./image/playpan.png");
		joy.setIcon(playpan);
		joy.setBorderPainted(false);
		joy.setFocusPainted(false);
		joy.setContentAreaFilled(false);
				
		
		
		final JPopupMenu joyMenu = new JPopupMenu();
		JMenuItem ball = new JMenuItem("공놀이");
		JMenuItem hug = new JMenuItem("안아주기");
		JMenuItem pat = new JMenuItem("쓰다듬기");
		joyMenu.add(ball);
		joyMenu.add(hug);
		joyMenu.add(pat);

		// 공놀이
		ball.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pipiDto dto = new pipiDto();
				dto = Main.getDto();
				int Myno = dto.getMyno();
				pipiDto retDto = pipiDao.selectData(Myno);
				pipiDto newDto = new pipiDto();
				newDto.setMyno(dto.getMyno());
				int heart;
				int stm;
				int full;
				int clean;
				if (retDto.getMyheart() < 60) {
					heart = retDto.getMyheart() + 40;
				} else {
					heart = 100;
				}

				if (retDto.getMyfull() > 30) {
					full = retDto.getMyfull() - 30;
				} else {
					full = 0;
				}

				if (retDto.getMyclean() > 20) {
					clean = retDto.getMystamina() - 20;
				} else {
					clean = 0;
				}

				if (retDto.getMystamina() > 30) {
					stm = retDto.getMystamina() - 30;
				} else {
					stm = 0;
				}
				newDto.setMyfull(full);
				newDto.setMystamina(stm);
				newDto.setMyheart(heart);
				newDto.setMyclean(clean);

				pipiDao.updateStatus(newDto);

			}
		});

		// 안아주기
		hug.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pipiDto dto = new pipiDto();
				dto = Main.getDto();
				int Myno = dto.getMyno();
				pipiDto retDto = pipiDao.selectData(Myno);
				pipiDto newDto = new pipiDto();
				newDto.setMyno(dto.getMyno());
				int heart;
				int stm;
				int full;
				int clean;
				if (retDto.getMyheart() < 50) {
					heart = retDto.getMyheart() + 50;
				} else {
					heart = 100;
				}

				if (retDto.getMyfull() > 20) {
					full = retDto.getMyfull() - 20;
				} else {
					full = 0;
				}

				if (retDto.getMyclean() > 10) {
					clean = retDto.getMystamina() - 10;
				} else {
					clean = 0;
				}

				if (retDto.getMystamina() > 10) {
					stm = retDto.getMystamina() - 10;
				} else {
					stm = 0;
				}

				newDto.setMyfull(full);
				newDto.setMystamina(stm);
				newDto.setMyheart(heart);
				newDto.setMyclean(clean);

				pipiDao.updateStatus(newDto);

			}
		});

		// 쓰다듬기
		pat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				pipiDto dto = new pipiDto();
				dto = Main.getDto();
				int Myno = dto.getMyno();
				pipiDto retDto = pipiDao.selectData(Myno);
				pipiDto newDto = new pipiDto();
				newDto.setMyno(dto.getMyno());
				int heart;
				int full;
				int clean;
				if (retDto.getMyheart() < 70) {
					heart = retDto.getMyheart() + 30;
				} else {
					heart = 100;
				}

				if (retDto.getMyfull() > 10) {
					full = retDto.getMyfull() - 10;
				} else {
					full = 0;
				}

				if (retDto.getMyclean() > 5) {
					clean = retDto.getMystamina() - 5;
				} else {
					clean = 0;
				}

				newDto.setMyfull(full);
				newDto.setMystamina(retDto.getMystamina());
				newDto.setMyheart(heart);
				newDto.setMyclean(clean);

				pipiDao.updateStatus(newDto);

			}
		});

		joy.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == 1) {
					joyMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});

		JButton button2 = new JButton("목욕하기");
		bathpan = new ImageIcon("./image/bathpan.png");
		button2.setIcon(bathpan);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		button2.setContentAreaFilled(false);
		
		JButton button3 = new JButton("꿈나라로");
		sleeppan = new ImageIcon("./image/sleeppan.png");
		button3.setIcon(sleeppan);
		button3.setBorderPainted(false);
		button3.setFocusPainted(false);
		button3.setContentAreaFilled(false);
		
		
		JButton button4 = new JButton("약주기");
		medipan = new ImageIcon("./image/medipan.png");
		button4.setIcon(medipan);
		button4.setBorderPainted(false);
		button4.setFocusPainted(false);
		button4.setContentAreaFilled(false);
		
		JButton button5 = new JButton();
		button5.setBorderPainted(false);
		button5.setFocusPainted(false);
		button5.setContentAreaFilled(false);
		
		DandN = new JLabel(born);

		eat.setBounds(1200, 150, 170, 60);
		joy.setBounds(1200, 220, 170, 60);
		button2.setBounds(1200, 290, 170, 60); 
		button3.setBounds(1200, 360, 170, 60);
		button4.setBounds(1200, 430, 170, 60);
		button5.setBounds(1300, 500, 100, 30);

		EGG.setBounds(500, 200, 600, 800);

		DandN.setBounds(1300, 50, 100, 30);

		background.add(eat);
		background.add(joy);
		background.add(button2);
		background.add(button3);
		background.add(button4);
		background.add(button5);
		background.add(EGG);
		background.add(DandN);

		pipiProgressBar.main(dto, background);

		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);
		EGG.addActionListener(this);
		eat.addActionListener(this);
		joy.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);

	}

	public static void main(String[] args) {

		//Main frame = new Main();
		frame = new Main();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500, 1000);
		frame.setVisible(true);
		System.out.println(cnt);

	}

	public static void chgBody(int type) {
		String url = new String();
		switch (type) {

		case 40:
			// 엔딩
			url = "./image/end.png";
			break;
		// -------------------------병아리
		case 1:
			// 1)병아리 사망엔딩
			url = "./image/PIPI01_DIE.png";
			break;
		case 2:
			// 2)배고픔+아픔 or 아픈병아리 = 아픈병아리
			url = "./image/PIPI01_D.png";
			break;
		case 3:
			// 3)배고픈병아리
			url = "./image/PIPI01_H.png";
			break;
		case 4:
			// 4)행복한 병아리
			url = "./image/PIPI01_Happy.png";
			break;

		case 5:
			// 5)기본병아리
			url = "./image/PIPI01_M.png";
			break;
		case 6:
			// 6)슬픈병아리
			url = "./image/PIPI01_SAD.png";
			break;
		case 7:
			// 7)화난병아리
			url = "./image/PIPI01_A.png";
			break;
		case 8:
			// 8)병아리 가출엔딩
			url = "./image/PIPI01_BYE.png";
			break;

		// -------------------------중간닭
		case 14:
			// 행복
			url = "./image/PIPI02_HAPPY.png";
			break;
		case 16:
			// 슬픔
			url = "./image/PIPI02_SAD.png";
			break;
		case 17:
			// 화남
			url = "./image/PIPI02_A.png";
			break;
		case 18:
			// 가출
			url = "./image/PIPI02_BYE.png";
			break;
		case 12:
			// 질병
			url = "./image/PIPI02_D.png";
			break;
		case 11:
			// 사망
			url = "./image/PIPI02_DIE.png";
			break;
		case 13:
			// 배고픔
			url = "./image/PIPI02_H.png";
			break;
		case 15:
			// 기본
			url = "./image/PIPI02_M.png";
			break;
		// ------------------------------------------큰닭
		case 24:
			// 1)큰닭 행복
			url = "./image/PIPI03_Happy.png";
			break;
		case 21:
			// 2)큰닭 사망
			url = "./image/PIPI03_DIE.png";
			break;
		case 23:
			// 3)배고픈큰닭
			url = "./image/PIPI03_H.png";
			break;
		case 22:
			// 4)아픈 큰닭
			url = "./image/PIPI03_D.png";
			break;
		case 28:
			// 5)큰닭가출
			url = "./image/PIPI03_BYE.png";
			break;
		case 27:
			// 6)화난큰닭
			url = "./image/PIPI03_A.png";
			break;
		case 26:
			// 7)슬픈큰닭
			url = "./image/PIPI03_SAD.png";
			break;
		case 25:
			// 8)큰닭기본
			url = "./image/PIPI03_M.png";
			break;
		case 80:
			// 샤워
			url = "./image/PIPI_SH.png";
			break;
		case 81:
			// 꿈나라
			url = "./image/PIPI_SLEEP.png";
			break;

		}
		eg = new ImageIcon(url);
		EGG.setIcon(eg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() != EGG) {
			if (cnt > 0 && cnt < 30) {

				JOptionPane.showMessageDialog(null, "알을 클릭해 부화 시켜 주세요");

			}
		}

		if (e.getSource() == EGG) {
			if (cnt > 0) {

				EGG = (JButton) e.getSource();
				System.out.println(cnt); // 20190504 출력순서 바꿈
				cnt--;
				// eg = new ImageIcon(egg01);
				if (cnt == 5) {
					url = "./image/EGG01.png";
					eg = new ImageIcon(url);
					EGG.setIcon(eg);
				} else if (cnt == 2) {
					url = "./image/EGG02.png";
					eg = new ImageIcon(url);
					EGG.setIcon(eg);
				}

			} else if (cnt == 0) {
				cnt--;
				// }else {
				// if (true) {
//            url = "./image/PIPI01.png";
//            eg = new ImageIcon(url);
//            EGG.setIcon(eg);

				EGG = (JButton) e.getSource();

				EGG.removeAll();
				EGG.setBorderPainted(false); // egg버튼 외곽선 삭제
				EGG.setFocusPainted(false); // focus시 테두리 사용안함
				EGG.setContentAreaFilled(false);

				//
				new grow(); // 정해진 주기당 보여주는 값 업데이트
				new addMydate(); // 정해진 주기당 날짜 업데이트
				new chgStus(); // 정해진 주기당 상태 업데이트
				// new DayAndNight(); // 사용시 프로그램 과부화 걸림

			}

		}

		if (e.getActionCommand().trim().equals("목욕하기")) {
			if (cnt <= 0) {
				Main.chgBody(80);
			}
			pipiDto dto = new pipiDto();
			dto = Main.getDto();
			int Myno = dto.getMyno();
			pipiDto retDto = pipiDao.selectData(Myno);
			pipiDto newDto = new pipiDto();
			newDto.setMyno(dto.getMyno());
			int heart;
			if (retDto.getMyheart() > 30) {
				heart = retDto.getMyheart() - 30;
			} else {
				heart = 0;
			}
			newDto.setMyheart(heart);
			newDto.setMyfull(retDto.getMyfull());
			newDto.setMystamina(retDto.getMystamina());
			newDto.setMyclean(100);

			pipiDao.updateStatus(newDto);

		}

		if (e.getActionCommand().trim().equals("꿈나라로")) {
			if (cnt <= 0) {
				Main.chgBody(81);
			}
			pipiDto dto = new pipiDto();
			dto = Main.getDto();
			int Myno = dto.getMyno();
			pipiDto retDto = pipiDao.selectData(Myno);
			pipiDto newDto = new pipiDto();
			newDto.setMyno(dto.getMyno());
			newDto.setMyheart(retDto.getMyheart());
			newDto.setMyfull(retDto.getMyfull());
			newDto.setMystamina(100);
			newDto.setMyclean(retDto.getMyclean());

			pipiDao.updateStatus(newDto);
		}

		if (e.getActionCommand().trim().equals("약주기")) {

			dto = Main.getDto();

			int Myno = dto.getMyno();
			int res = pipiDao.updatemedicine(Myno);
			if (res > 0) {
				System.out.println("success");
			} else {
				System.out.println("fail");
			}

		}

	}

	public static void chgMyheart(pipiDto retDto) {
		JProgressBar PG_myheart = (JProgressBar) background.getComponent(9); // 애정
		JProgressBar PG_myfull = (JProgressBar) background.getComponent(11); // 포만감;
		JProgressBar PG_mystamina = (JProgressBar) background.getComponent(13); // 체력
		JProgressBar PG_myclean = (JProgressBar) background.getComponent(15); // 청결
		PG_myheart.setValue(retDto.getMyheart());
		PG_myfull.setValue(retDto.getMyfull());
		PG_mystamina.setValue(retDto.getMystamina());
		PG_myclean.setValue(retDto.getMyclean());

		/* 20190507 수정 시작 */
		JLabel LB_mydate = (JLabel) background.getComponent(16);
		LB_mydate.setText("인생 " + retDto.getMydate() + "일");

		// 배경화변 변경
		if (retDto.getMyallday().equals("D")) {
			icon = new ImageIcon("./image/Main_Day1.png");
		} else {
			icon = new ImageIcon("./image/Main_Night.png");
		}
		scrollPane.repaint();
		/* 20190507 수정 끝 */

	}
	
	public static void endGame(){
		grow.timer.cancel();
		addMydate.timer2.cancel();
		chgStus.timer.cancel();
		
		
		JOptionPane.showMessageDialog(null, "게임이 재시작 됩니다.");
		cnt = 10;
		pipiDao.updateInit( dto );
		frame.dispose();
		
		pipilogin p = new pipilogin();
		p.go();
	}

}