package com.pipi.progressBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private static int myheart;
	private static int myfull;
	private static int mystamina;
	private static int myclean;

	public pipiProgressBar(JPanel PGpanel) {

		LB_myheart = new JLabel("애정");
		LB_myfull = new JLabel("포만");
		LB_mystamina = new JLabel("체력");
		LB_myclean = new JLabel("청결");
		LB_mydate = new JLabel("인생 0일"); // 20190507

		PG_myheart = new JProgressBar();
		PG_myfull = new JProgressBar();
		PG_mystamina = new JProgressBar();
		PG_myclean = new JProgressBar();

		// 초기값 dto로 받아서 설정
		PG_myheart.setValue(myheart);
		PG_myfull.setValue(myfull);
		PG_mystamina.setValue(mystamina);
		PG_myclean.setValue(myclean);

		// 진행상황을 %로표시
		PG_myheart.setStringPainted(true);
		PG_myfull.setStringPainted(true);
		PG_mystamina.setStringPainted(true);
		PG_myclean.setStringPainted(true);

		LB_myheart.setBounds(10, 150, 100, 30);
		PG_myheart.setBounds(100, 150, 100, 30);
		LB_myfull.setBounds(10, 180, 100, 30);
		PG_myfull.setBounds(100, 180, 100, 30);
		LB_mystamina.setBounds(10, 210, 100, 30);
		PG_mystamina.setBounds(100, 210, 100, 30);
		LB_myclean.setBounds(10, 240, 100, 30);
		PG_myclean.setBounds(100, 240, 100, 30);
		LB_mydate.setBounds(10, 270, 100, 30); // 20190507

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