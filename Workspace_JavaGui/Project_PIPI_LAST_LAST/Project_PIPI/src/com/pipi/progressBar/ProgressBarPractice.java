package com.pipi.progressBar;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarPractice extends JFrame {
	
 JProgressBar myheart;
 //	JProgressBar 클래스 특징: 오랜시간 걸리는 작업을 할 때 일이 진행상황을 시각적으로 표현하기위한 용도로 사용
 
 public ProgressBarPractice() {
	 setLayout(new FlowLayout());//배치관리자 설정
	 myheart = new JProgressBar();
	 //최소값이 0, 최대값이 100까지 표시
	 myheart.setValue(0);//시작 지점을 표시
	 myheart.setStringPainted(true);//true로 설정하면 진행상황을 %로 표시
	 add(myheart); //스윙 프레임 윈도우에 프로그래스바 배치
	 
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 setSize(300,150);
	 setVisible(true);
	 
	 progress_start();
 
 }

 public void progress_start() {
	 int i=0;
	
	 try {
		 for(i=51; i<51; i++) {
			 myheart.setValue(i);
			 Thread.sleep(37);//밀레세컨드 단위로 지연시간을 설정 
		 }
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
 }//progress_start 끝 
 
 public static void main(String[] args) {
	new ProgressBarPractice();
}

}
