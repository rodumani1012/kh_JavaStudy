package com.seoda;

import java.util.*;

public class SeodaGameInfo {
	private int myno;
	private String myname;
	private int ready = 0;			//	0이면 ready 안함, 1이면 ready
	private int Result_Count = 0;
	private int result_name;
	private int battingMoney;		//	배팅 머니	
	private int result;				//	결과 점수 저장
	
	List<Integer> card = new ArrayList<Integer>();	//	각자의 카드 저장

	public int[] card_num = new int[2];	//	받은 카드 번호 저장
	
	private boolean seoda = false;	//	결과 확인하는 변수
	
	//	기본 생성자
	public SeodaGameInfo() {
		super();
	}

	//	ready(1) 리턴
	public int getReady() {
		return ready;
	}

	//	ready(1) 세팅
	public void setReady(int ready) {
		this.ready = ready;
	}

	//	result(1) 리턴
	public int getResult_Count() {
		return Result_Count;
	}
	
	//	result(1) 세팅
	public void setResult_Count(int Result_Count) {
		this.Result_Count = Result_Count;
	}

	//	카드 전달
	public List<Integer> getHand() {
		return card;
	}

	//	카드 세팅
	public void setHand(List<Integer> card) {
		this.card = card;
	}
	
	//	결과 점수 세팅
	public void setResultCard(String resultMessage) {
		//	메시지를 전달 받아 split으로 나누어 점수와 그 유저가 배팅한 금액을 저장
		String splitMsg[] = resultMessage.split(" ");

		this.result = Integer.parseInt(splitMsg[2]);
		this.battingMoney = Integer.parseInt(splitMsg[3]);
	}
	
	//	배팅액 리턴
	public int getBattingMoney() {
		return battingMoney;
	}
	
	//	결과 점수 리턴
	public int getResult() {
		return result;
	}
	
	//	카드 추가
	public void addCard(int card) {
		this.card.add(card);
	}
}
