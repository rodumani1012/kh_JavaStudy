package com.pipi.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.EGGDisplay.Main;
import com.pipi.dao.pipiDao;
import com.pipi.dto.pipiDto;


public class pipijoin extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static JPanel JOIN_panel;
	JLabel LB_join_id, LB_join_pw;//id레이블, pw레이블
	JTextField TF_join_id, TF_join_pw; //id텍스트 필드, pw 텍스트 필드
	JButton BTN_join, BTN_confirm, BTN_cancel;// 가입버튼, 아이디 중복체크버튼
	public static Main pipijoin = null;
	
	public pipijoin() {
		JOIN_panel = new JPanel();
		JOIN_panel .setBackground(new Color(245, 255,174));
		
		LB_join_id = new JLabel("id"); 
		LB_join_id .setFont(new Font("필기", Font.BOLD, 20));
		
		LB_join_pw = new JLabel("pw");
		LB_join_pw .setFont(new Font("필기", Font.BOLD, 20));
		
		TF_join_id = new JTextField(10);
		TF_join_id .setFont(new Font("필기", Font.BOLD, 20));
		
		TF_join_pw = new JTextField(10);
		TF_join_pw .setFont(new Font("필기", Font.BOLD, 20));
		
		
		BTN_join = new JButton("가입하기");
		BTN_join .setBackground(new Color(255, 202,228));
		BTN_join .setFont(new Font("굴림", Font.BOLD, 20));
		
		BTN_confirm = new JButton("중복확인");
		BTN_confirm .setBackground(new Color(83, 251,234));
		BTN_confirm .setFont(new Font("굴림", Font.BOLD, 20));
		
		BTN_cancel = new JButton("취소");
		BTN_cancel .setBackground(new Color(255, 255,0));
		BTN_cancel .setFont(new Font("굴림", Font.BOLD, 20));
		
	}
	
	public void go() {
		
		JOIN_panel.add(LB_join_id);
		JOIN_panel.add(TF_join_id);
		JOIN_panel.add(BTN_confirm);
		
		BTN_confirm.addActionListener(this);
		
		JOIN_panel.add(LB_join_pw);
		JOIN_panel.add(TF_join_pw);
		
		
		JOIN_panel.add(BTN_join);
		JOIN_panel.add(BTN_cancel);
	
		BTN_join.addActionListener(this);
		BTN_cancel.addActionListener(this);
		add(JOIN_panel);
		
		
		setLocationRelativeTo(null);// 창이 가운데서 뜨게
		setResizable(false);//사이즈 조정 못하게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//완전히 끄기 
		
		setSize(900,200);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		pipijoin pipi = new pipijoin();
		pipi.go();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String myid = TF_join_id.getText();
		String mypw = TF_join_pw.getText();
		if(e.getSource().equals(BTN_confirm)) {
						
			pipiDto dto = pipiDao.idchk(myid);
			
			if(dto!=null) {
				JOptionPane.showMessageDialog(this, "사용 불가능한 아이디입니다");
				
			}else {
				JOptionPane.showMessageDialog(this, "사용 가능한 아이디입니다");
			}			
		}else if(e.getSource().equals(BTN_join)) {
			int res = pipiDao.insert(myid, mypw);
			
			if(res>0) {
				JOptionPane.showMessageDialog(this, "가입 성공");
				dispose(); // 가입 성공 하면 창 종료
			}else {
				JOptionPane.showMessageDialog(this, "가입 실패");
			}
			
		}else if(e.getSource().equals(BTN_cancel)) {
		 pipilogin main = new pipilogin();
		 main.setVisible(true);
		 dispose();
		}
	}
}
