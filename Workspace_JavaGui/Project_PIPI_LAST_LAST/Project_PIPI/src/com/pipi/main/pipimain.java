package com.pipi.main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.pipi.dto.pipiDto;
import com.pipi.progressBar.pipiProgressBar;

public class pipimain extends JFrame implements ActionListener {
	  public static String imageurl = "./image/PIPI03.png";
	   // public static String imageurl = "./image/EGG.png";
	   public static int cnt = 30;
	   JScrollPane scrollPane;
	   ImageIcon icon;
	   ImageIcon icon1;
	   ImageIcon eg = new ImageIcon(imageurl);
	   JButton EGG = new JButton(eg);

	   public pipimain() {
	      icon = new ImageIcon("./image/Main_Day1.png");
	      // icon = new ImageIcon("./image/EGG_Background");
	      // 배경 Panel 생성후 컨텐츠페인으로 지정
	      if (cnt == 0) {
	         imageurl = "./image/pipi01.png";
	      }
	      JPanel background = new JPanel() {
	         public void paintComponent(Graphics g) {
	            Dimension d = getSize();
	            g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
	            setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
	            super.paintComponent(g);
	         }
	      };

	      EGG.setBorderPainted(false); // egg버튼 외곽선 삭제
	      EGG.setFocusPainted(false); // focus시 테두리 사용안함
	      EGG.setContentAreaFilled(false);
	      background.add(EGG);

	      background.setLayout(null);

	      JButton button = new JButton("먹이주기");
	      JButton button1 = new JButton("놀아주기");
	      JButton button2 = new JButton("목욕하기");
	      JButton button3 = new JButton("꿈나라로");
	      JButton button4 = new JButton("약주기");

	      button.setBackground(Color.blue);
	      button1.setBackground(Color.pink);
	      button2.setBackground(Color.CYAN);
	      button3.setBackground(Color.green);
	      button4.setBackground(Color.red);

	      button.setBounds(1200, 150, 100, 30);
	      button1.setBounds(1200, 200, 100, 30);
	      button2.setBounds(1200, 250, 100, 30);
	      button3.setBounds(1200, 300, 100, 30);
	      button4.setBounds(1200, 350, 100, 30);
	      EGG.setBounds(500, 200, 300, 500);

	      background.add(button);
	      background.add(button1);
	      background.add(button2);
	      background.add(button3);
	      background.add(button4);
	      
	      background.add(EGG);

	      scrollPane = new JScrollPane(background);
	      setContentPane(scrollPane);
	      EGG.addActionListener(this);
	   }

	   public static void main(pipiDto dto) {
	      pipimain frame = new pipimain();

	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setSize(1500, 1000);
	      frame.setVisible(true);
	      System.out.println(cnt);
	   }

	   @Override
	   public void actionPerformed(ActionEvent e) {
	      if (cnt > 0) {

	         EGG = (JButton) e.getSource();
	         cnt--;
	         System.out.println(cnt);
	      }
	      if (cnt == 0) {
	         EGG = (JButton) e.getSource();

	      }


	

	   }
}
