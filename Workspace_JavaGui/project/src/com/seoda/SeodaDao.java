package com.seoda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.JDBCTemplate;

public class SeodaDao extends JDBCTemplate{
	
private List<Integer> deck = new ArrayList<Integer>();
	
	//	기본 생성자 호출 시 카드덱 생성
	public SeodaDao() {
		this.deck = createDeck();
	}
	
	//	카드덱 생성
	public List<Integer> createDeck() {
		int[] special = {1,2,3,4,5,6,7,8,9,10};
		int[] normal= {11,22,33,44,55,66,77,88,99,110};
		
		for(int i = 0 ; i<10 ; i++) {
			deck.add(special[i]);
		}
		for(int i = 0 ; i<10 ; i++) {
			deck.add(normal[i]);
		}
		
		//	덱을 섞는다
		Collections.shuffle(deck);
		
		return deck;
	}
	
	//	카드 뽑기(2장씩)
	public int draw() {
		//	덱의 0 번지 카드를 한 장 뽑는다
		Integer drawCard = this.deck.get(0);
		
		//	뽑은 카드는 리스트에서 지운다
		this.deck.remove(0);
		
		return drawCard;
	}
	
	//	승리자 돈 업데이트
	public int moneyWinUpdate(String name, int money) {
		Connection con = getconnection();
		PreparedStatement pstm = null;
		int res = 0;
		System.out.println(name);
		
		String sql = " UPDATE PROJECTBOARD SET MONEY = MONEY + ? WHERE NAME = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, money);
			pstm.setString(2, name);
			
			res = pstm.executeUpdate();
						
			System.out.println("03 / 04 쿼리 실행 및 리턴 : " + sql);
			
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("03 / 04 쿼리 에러");
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	//	패배자 돈 업데이트
	public int moneyLoseUpdate(String name, int money) {
		Connection con = getconnection();
		PreparedStatement pstm = null;
		int res = 0;
		System.out.println(name);
		
		String sql = " UPDATE PROJECTBOARD SET MONEY = MONEY - ? WHERE NAME = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, money);
			pstm.setString(2, name);
			
			res = pstm.executeUpdate();
			
			System.out.println("03 / 04 쿼리 실행 및 리턴 : " + sql);
			
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("03 / 04 쿼리 에러");
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}
