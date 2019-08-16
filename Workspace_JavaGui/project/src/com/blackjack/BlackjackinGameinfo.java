package com.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackjackinGameinfo {

	// dealerhand 저장
	List<String> dealerhand = null;

	// 각자의 hand 저장
	List<String> hand = new ArrayList<String>();

	// 0이면 stay를 하지 않음 1이 되면 stay를 함
	private int stay = 0;

	// 각자의 hand의 합을 저장하는 변수
	private int sum;

	// 각자의 blackjack 여부를 확인하여 결과를 담는 변수
	private boolean blackjack = false;

	// 0이면 hit를 하지 않음 1이면 hit를 함.
	private int hit = 0;

	// 0이면 ready 안함, 1이면 ready 함.
	private int ready = 0;

	// 베팅 금액
	private int betting = 0;

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getBetting() {
		return betting;
	}

	public void setBetting(int betting) {
		this.betting = betting;
	}

	public int getReady() {
		return ready;
	}

	public void setReady(int ready) {
		this.ready = ready;
	}

	public BlackjackinGameinfo() {
		super();
	}

	public List<String> getDealerhand() {
		return dealerhand;
	}

	public void setDealerhand(List<String> dealerhand) {
		this.dealerhand = dealerhand;
	}

	public List<String> getHand() {
		return hand;
	}

	public void addHand(String card) {
		this.hand.add(card);
	}

	public int getSum() {
		return sum;
	}

	// 각자의 hand를 해당 메소드를 이용하여 sum에 담음
	public void setSum() {
		// hand에 A가 있는지 없는지
		boolean A = false;
		// 리턴 값
		int sum = 0;

		// hand에 들어있는 card 하나하나를 뽑아서
		for (String card : getHand()) {

			// 각 숫자 별로 값을 sum에 더한다. 서브스트링은 문양을 떼어내기 위함
			switch (card.substring(1)) {
			case "A":
				sum += 11;
				A = true;
				break;
			case "K":
			case "Q":
			case "J":
				sum += 10;
				break;
			default:
				sum += Integer.parseInt(card.substring(1));
			}

		}

		// 합계가 21이 넘고 hand에 A 카드가 있다면 11을 1로 만들어준다.
		if (sum > 21 && A) {
			sum -= 10;
		}

		this.sum = sum;
	}

	public int getStay() {
		return stay;
	}

	public void setStay(int stay) {
		this.stay = stay;
	}

	public boolean isBlackjack() {
		return blackjack;
	}

	public void setBlackjack(boolean blackjack) {
		this.blackjack = blackjack;
	}

}
