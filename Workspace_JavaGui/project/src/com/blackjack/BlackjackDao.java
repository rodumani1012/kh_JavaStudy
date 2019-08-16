package com.blackjack;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import com.project.ServiceThread;

public class BlackjackDao {

	private List<String> deck = new ArrayList<String>();

	public BlackjackDao() {
		this.deck = deck();
	}

	public List<String> deck() {

		String[] mark = { "D", "S", "H", "C" };
		String[] num = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J" };

		// re for문은 deck에 트럼프 카드 2벌을 넣기 위함
		for (int re = 0; re < 2; re++) {
			// i for문은 mark를 돌리기 위함
			for (int i = 0; i < 4; i++) {
				// j for문은 num을 돌리기 위함
				for (int j = 0; j < 13; j++) {
					deck.add(mark[i] + num[j]);
				}
			}
		}

		// 셔플한다.
		Collections.shuffle(deck);

		return deck;

	}

	// 카드 뽑기
	public String draw() {

		// deck의 0번지 한 장을 뽑는다
		String drawcard = this.deck.get(0);
		// 뽑은 카드를 덱에서 지운다.
		this.deck.remove(0);

		return drawcard;
	}

	public int Sum(List<String> dealerhand) {
		// hand에 A가 있는지 없는지
		boolean A = false;
		// 리턴 값
		int sum = 0;

		// hand에 들어있는 card 하나하나를 뽑아서
		for (String card : dealerhand) {

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

		return sum;
	}

	public double result(ServiceThread st, int dealersum) {

		if (st.BJinfo.getSum() < 22 && dealersum < 22) {
			if (st.BJinfo.isBlackjack() && dealersum != 21) {
				return 1.5;
			} else if (st.BJinfo.getSum() > dealersum) {
				return 2;
			} else if (st.BJinfo.getSum() == dealersum) {
				return 1;
			} else if (st.BJinfo.getSum() < dealersum) {
				return 0;
			}
		} else if (st.BJinfo.getSum() > 21) {
			return 0;
		} else if (dealersum > 21) {
			if (st.BJinfo.isBlackjack()) {
				return 1.5;
			} else {
				return 2;
			}
		}
		System.out.println("error");
		return 1;

	}

	// blackjack 여부 판별
	public boolean blackjack(ServiceThread st) {

		int sum = 0;

		// 처음 받은 두 카드를 뽑아서 더한다
		for (int i = 0; i < 2; i++) {
			switch (st.BJinfo.getHand().get(i).substring(1)) {
			case "A":
				sum += 11;
				break;
			case "K":
			case "Q":
			case "J":
				sum += 10;
				break;
			default:
				sum += Integer.parseInt(st.BJinfo.getHand().get(i).substring(1));
			}

		}

		// 그 숫자가 21이면 true를 리턴
		return sum == 21;

	}

}
