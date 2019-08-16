package com.pipi.login;



import java.awt.Dimension;
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
//import com.pipi.main.pipimain;
import com.pipi.progressBar.pipiProgressBar;



public class pipilogin extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	class ImagePanel {
//		private Image img;
//		
//		public ImagePanel(Image img) {
//			this.img=img;
//			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
//			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
//			setLayout(null);
//		}
//		
//		public void painComponent(Graphics g) {
//			g.drawImage(img, 0, 0, null);
//		}
//	}
	
	JPanel PN_login;//로그인 판넬
	JLabel LB_id, LB_pw; //id 레이블, pw레이블
	JTextField TF_id; // id 텍스트필드
	JPasswordField TF_pw; //pw 텍스트필드
	JButton BTN_login, BTN_join, BTN_change_pw; //로그인버튼, 가입버튼, 비밀번호 번경 버튼 
	
	//ImagePanel PN_img;
	
	
	pipilogin(){
//		PN_img = new ImagePanel(new ImageIcon("./sc/login_IMG.png").getImage());
//		this.pack();	
//		
		
		PN_login = new JPanel();		
		LB_id = new JLabel("I D");
		LB_pw = new JLabel("P W");
		TF_id = new JTextField(10);
		TF_pw = new JPasswordField(10);
		
		
		BTN_login = new JButton("로그인");
		BTN_join = new JButton("가입");
		BTN_change_pw= new JButton("비밀번호 변경");
		
	}
	
	public void go() {
	
		PN_login.add(LB_id);
		PN_login.add(TF_id);
		
		PN_login.add(LB_pw);
		PN_login.add(TF_pw);
		
		
		PN_login.add(BTN_login);
		PN_login.add(BTN_join);
		PN_login.add(BTN_change_pw);
		
		BTN_login.addActionListener(this);
		BTN_join.addActionListener(this);
		
		
		add(PN_login);
		
		
		
		setLocationRelativeTo(null);// 창이 가운데서 뜨게
		setResizable(false);//사이즈 조정 못하게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//완전히 끄기 
		setSize(600,400);
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
				//JOptionPane.showMessageDialog(this, "로그인 성공");
				//pipimain.main(dto); 
				//pipiProgressBar.main(dto);
				Main.setDto(dto);
				Main.main(null);
				setVisible(false);
				
				
				
			}else {
			 JOptionPane.showMessageDialog(this, "로그인 실패");
			}
			
		}
		if(e.getSource().equals(BTN_join)) {
			pipijoin join = new pipijoin();
			join.go();
			
		}
		
	}
	
	

}
