package com.pipi.progressBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.pipi.dto.pipiDto;

public class pipiProgressBar2 extends JFrame implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JPanel PGpanel;
	JProgressBar PG_myheart, PG_myfull, PG_mystamina, PG_myclean;
	JLabel LB_myheart, LB_myfull, LB_mystamina, LB_myclean;
	JButton BTN_pipi;//메인에 있는 알로 바꿔야함 
	
	private static int myheart; private static int myfull; private static int mystamina; 
	private static int myclean;
	
	
	
	
	public pipiProgressBar2() {
		PGpanel = new JPanel();
		
		LB_myheart = new JLabel("애정");
		LB_myfull = new JLabel("포만");
		LB_mystamina = new JLabel("체력");
		LB_myclean = new JLabel("청결");
		
		PG_myheart = new JProgressBar();
		PG_myfull = new JProgressBar();
		PG_mystamina = new JProgressBar();
		PG_myclean = new JProgressBar();
		
		BTN_pipi = new JButton("pipi");
		
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
		
		//actionevent
		final Thread th = new Thread(this);
		BTN_pipi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				th.start();	
			}
		});
		
		
		PGpanel.add(LB_myheart);
		PGpanel.add(PG_myheart);
		PGpanel.add(LB_myfull);
		PGpanel.add(PG_myfull);
		PGpanel.add(LB_mystamina);
		PGpanel.add(PG_mystamina);
		PGpanel.add(LB_myclean);
		PGpanel.add(PG_myclean);
		PGpanel.add(BTN_pipi);
		
		add(PGpanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setVisible(true);
		
	}
	
	@Override
	public void run() {
		
		
		for(int i=0; i<100; i++) {
			myheart--;
			try {
				Thread.sleep(100);
				PG_myheart.setValue(myheart);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(pipiDto dto) {	
		
		myheart = dto.getMyheart();
		myfull = dto.getMyfull();
		mystamina  = dto.getMystamina();
		myclean = dto.getMyclean();
		
		new pipiProgressBar2();
		
		
	}

	
}
