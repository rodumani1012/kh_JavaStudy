package com.pipi.progressBar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.pipi.dto.pipiDto;

public class pipiProgressBar extends JFrame {
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   

   JProgressBar PG_myheart, PG_myfull, PG_mystamina, PG_myclean;
   JLabel LB_myheart, LB_myfull, LB_mystamina, LB_myclean;
   JButton BTN_shower, BTN_medicine;
   JLabel LB_mydate; // 20190507
   
   private static int myheart; private static int myfull; private static int mystamina; 
   private static int myclean;
   
   ImageIcon heart, stamina, full, clean;
   
   
   
   public pipiProgressBar(JPanel PGpanel) {
      
     heart = new ImageIcon("./image/heart.png");
      stamina = new ImageIcon("./image/stamina.png");
      full = new ImageIcon("./image/full.png");
      clean = new ImageIcon("./image/clean.png");
     
     LB_myheart = new JLabel(); //애정->하트
     LB_myheart.setIcon(heart);
     
      LB_myfull = new JLabel();//포만->딸기
      LB_myfull.setIcon(full);
      
      LB_mystamina = new JLabel();//체력->물약
      LB_mystamina.setIcon(stamina);
      
      LB_myclean = new JLabel(); //청결->빗자루
      LB_myclean.setIcon(clean);
      
      LB_mydate = new JLabel("인생 0일"); // 20190507
      LB_mydate.setFont(new Font("필기", Font.BOLD, 30));
   
   
      PG_myheart = new JProgressBar();
      PG_myfull = new JProgressBar();
      PG_mystamina = new JProgressBar();
      PG_myclean = new JProgressBar();
      
      //초기값 dto로 받아서 설정 
      PG_myheart.setValue(myheart);
      PG_myfull.setValue(myfull);
      PG_mystamina.setValue(mystamina);
      PG_myclean.setValue(myclean);
      
      //진행상황을 %로표시
      PG_myheart.setStringPainted(true);
      PG_myfull.setStringPainted(true);
      PG_mystamina.setStringPainted(true);
      PG_myclean.setStringPainted(true);
      
      //LB_myheart.setSize(100, 100);
      
         
      LB_myheart.setBounds(10, 150, 100, 30);
      PG_myheart.setBounds(50, 150, 200, 30);
      LB_myfull.setBounds(10, 180, 100, 30);
      PG_myfull.setBounds(50, 180, 200, 30);
      LB_mystamina.setBounds(10, 210, 100, 30);
      PG_mystamina.setBounds(50, 210, 200, 30);
      LB_myclean.setBounds(10, 240, 100, 30);
      PG_myclean.setBounds(50, 240, 200, 30);
      LB_mydate.setBounds(10, 300, 200, 30); // 20190507

      
      PGpanel.add(LB_myheart);
      PGpanel.add(PG_myheart);
      PGpanel.add(LB_myfull);
      PGpanel.add(PG_myfull);
      PGpanel.add(LB_mystamina);
      PGpanel.add(PG_mystamina);
      PGpanel.add(LB_myclean);
      PGpanel.add(PG_myclean);
      PGpanel.add(LB_mydate); // 20190507

   
   }
   
   public static void main(pipiDto dto,JPanel PGpanel) {   
      
      myheart = dto.getMyheart();
      myfull = dto.getMyfull();
      mystamina  = dto.getMystamina();
      myclean = dto.getMyclean();
      
      new pipiProgressBar(PGpanel);

   }
   
}