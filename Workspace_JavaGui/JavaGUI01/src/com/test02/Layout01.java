package com.test02;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Layout01 extends Frame {
	
	// GridBagConstraints 클래스는 GridBagLayout 클래스를 사용하여 
	// 배치되는 구성요소에 대한 구속조건을 지정한다.
	public void makeButton(String name, GridBagLayout gridBag,
			GridBagConstraints constraints) {
		
		Button btn = new Button(name);

		// GridBagLayout에 속성 지정(component, 속성)
		gridBag.setConstraints(btn, constraints);

		// 해당 속성을 가지고 추가하자
		add(btn);
	}

	public void go() {

		// 격자무늬 layout
		GridBagLayout gridBag = new GridBagLayout();
		// 속성(제약조건)
		GridBagConstraints constraints = new GridBagConstraints();
		// 프레임(this)에게 레이아웃 설정.
		setLayout(gridBag);

		// fill : component의 크기를 채워주는 역할. (NONE, HORIZONTAL, VERTICAL, BOTH..)
		// NONE : 자기 자신 만큼만.
		constraints.fill = GridBagConstraints.BOTH;

		// weightx : 한 칸에 여러 component가 있을 때 각각의 비중
		constraints.weightx = 1.0; // 비중을 1로 주겠다. 1 : 1 : 1
		makeButton("Btn01", gridBag, constraints);
		makeButton("Btn02", gridBag, constraints);
		makeButton("Btn03", gridBag, constraints);

		//gridwidth : row 속성 (행의 cell 갯수)
		//REMAINDER : 현재 행의 마지막 셀(∴ 끝자락에 채우겠다.)
		constraints.gridwidth = GridBagConstraints.REMAINDER; 
		makeButton("Btn04", gridBag, constraints);

		constraints.weightx = 0.0; // 여백을 없애겠다.
		makeButton("Btn05", gridBag, constraints);

		// RELATIVE : 해당 row의 마지막 component 옆에
		//(이전 컴포넌트의 오른쪽/아래쪽) 사용하고자 할 때
		// ∴ 이전 셀 다음부터 쓰겠다.
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		makeButton("Btn06", gridBag, constraints);

		constraints.gridwidth = GridBagConstraints.REMAINDER;
		makeButton("Btn07", gridBag, constraints);

		constraints.gridwidth = 2; // 가로셀 병합
		constraints.gridheight = 2; // 세로셀 병합
		constraints.weighty = 1.0;
		makeButton("Btn08", gridBag, constraints);

		constraints.weighty = 0.0;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridheight = 1;
		makeButton("Btn09", gridBag, constraints);
		makeButton("Btn10", gridBag, constraints);

		constraints.gridwidth = 2;
		makeButton("Btn11", gridBag, constraints);
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		makeButton("Btn12", gridBag, constraints);

		setSize(400, 180);
	}

	public static void main(String[] args) {
		Layout01 f = new Layout01();
		f.setVisible(true);
		f.go();
	}

}
