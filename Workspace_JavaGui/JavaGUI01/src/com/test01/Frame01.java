package com.test01;

import java.awt.Button;
import java.awt.Frame;

/*
	java.awt라서 UTF-8 encoding 깨질 때 대처법 :
	상단 메뉴에 run -> run configuration -> Arguments tab -> vm arguments에 다음 명령 저장
	-Dfile.encoding=MS949
 */

/*
 * awt 코딩 순서(추천일 뿐임) :
 * 1. 필드에 객체 선언
 * 2. 생성자에서 객체 생성
 * 3. 프레임 레이아웃 설정
 * 4. 패널에 객체를 올린다.
 * 5. 프레임에 패널을 올린다.
 * 6. 이벤트 생성.
 */
public class Frame01 extends Frame {

	Button btn;
	
	public Frame01() {
		btn = new Button("push");
	}
	
	public void go() { //프레임에 넣고
		add(btn);
		
		setSize(500,500);
		setVisible(true); //프레임 실행
	}
	
	public static void main(String[] args) {
		Frame01 f = new Frame01();
		f.go();
	}
}
