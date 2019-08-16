package com.pipi.login;



import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.EGGDisplay.Main;
import com.pipi.dao.pipiDao;
import com.pipi.dto.pipiDto;
import com.pipi.progressBar.pipiProgressBar;



public class pipilogin extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Component button4 = null;
	
	
	public static JPanel PN_login;//로그인 판넬
	JLabel LB_id, LB_pw; //id 레이블, pw레이블
	JTextField TF_id; // id 텍스트필드
	JPasswordField TF_pw; //pw 텍스트필드
	JButton BTN_login, BTN_join; //로그인버튼, 가입버튼, 비밀번호 번경 버튼 
	
	JLabel title;
	ImageIcon titlepan;

	
	
		public pipilogin(){
		
		PN_login = new JPanel();	
		PN_login .setBackground(new Color(255, 255,130)); //RGB
	
		
		LB_id = new JLabel("I D");
		LB_id .setFont(new Font("필기", Font.BOLD, 20));
		
		LB_pw = new JLabel("P W");
		LB_pw .setFont(new Font("필기", Font.BOLD, 20));
		
		TF_id = new JTextField(10);
		TF_pw = new JPasswordField(10);
		
		
		BTN_login = new JButton(" 로그인 ");
		BTN_login .setBackground(new Color(171, 236,19));
		BTN_login .setFont(new Font("굴림", Font.BOLD, 20));
		
		BTN_join = new JButton(" 가  입 ");
		BTN_join .setBackground(new Color(255, 202,228));
		BTN_join .setFont(new Font("굴림", Font.BOLD, 20));
		
		title = new JLabel();
		titlepan = new ImageIcon("./image/titlepan.png");
		title.setIcon(titlepan);
		
	}
	
	public void go() {
	
		PN_login.add(LB_id);
		PN_login.add(TF_id);
		
		PN_login.add(LB_pw);
		PN_login.add(TF_pw);
		
		
		PN_login.add(BTN_login);
		PN_login.add(BTN_join);
		
		PN_login.add(title);

		
		BTN_login.addActionListener(this);
		BTN_join.addActionListener(this);
		
		
		
		add(PN_login);
		
		
		
		setLocationRelativeTo(null);// 창이 가운데서 뜨게
		setResizable(false);//사이즈 조정 못하게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//완전히 끄기 
		setSize(700,250);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		pipilogin p = new pipilogin();
		p.go();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String myid = TF_id.getText();
		String mypw = TF_pw.getText();
		
				
		if(e.getSource().equals(BTN_login)) {
			pipiDto dto = pipiDao.login(myid, mypw);
			
			if(dto !=null) {

				Main.frame = null;
				Main.setDto(dto);
				Main.main(null);
				setVisible(false); // 숨김 - 비활성화
				

			}else {
			 JOptionPane.showMessageDialog(this, "로그인 실패");

			}
			
		}
		if(e.getSource().equals(BTN_join)) {
			pipijoin join = new pipijoin();
			join.go();
			
		}
	}
	
	public void setVisibleM(boolean v){
		setVisible(v);
	}
}
