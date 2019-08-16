package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import dto.food.FoodHamDto;
import dto.inven.InvenDrink;
import dto.inven.InvenHam;
import dto.inven.InvenRamen;
import dto.sellist.SellistHam;

public class HamDao extends JDBCTemplate {
	public ArrayList<FoodHamDto> HamfoodAll() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ArrayList<FoodHamDto> list = new ArrayList<FoodHamDto>();

		String sql = " SELECT * FROM FOOD_HAM ";

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			System.out.println("03/04 쿼리 실행" + sql);
			while (rs.next()) {
				FoodHamDto dto = new FoodHamDto();
				dto.setName(rs.getString(1));
				dto.setPrice(rs.getInt(2));
				dto.setEtc(rs.getDate(3));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("03/04 쿼리 실패");
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5.DB 종료");
		}
		return list;
	}

	public ArrayList<SellistHam> HamSellAll() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ArrayList<SellistHam> list = new ArrayList<SellistHam>();

		String sql = " SELECT * FROM SELLIST_HAM ";

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			System.out.println("03/04 쿼리 실행" + sql);
			while (rs.next()) {
				SellistHam dto = new SellistHam();
				dto.setName(rs.getString(1));
				dto.setPrice(rs.getInt(2));
				dto.setAmount(rs.getInt(3));
				dto.setTotal(rs.getInt(4));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("03/04 쿼리 실패");
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5.DB 종료");
		}
		return list;
	}

	// makeSell - sell의 값을 table에 넣어주기 위해 배열로 만들어준다.
	public Object[][] makeHamSell(ArrayList<SellistHam> lists) {

		Object[][] sellarr = new Object[lists.size()][5];

		for (int i = 0; i < lists.size(); i++) {

			sellarr[i][0] = lists.get(i).getName();
			sellarr[i][1] = lists.get(i).getAmount();

		}

		return sellarr;

	}

	// makeSell - sell의 값을 table에 넣어주기 위해 배열로 만들어준다.
	public Object[][] makeHamInven(ArrayList<InvenHam> lists) {

		Object[][] sellarr = new Object[lists.size()][5];

		for (int i = 0; i < lists.size(); i++) {

			sellarr[i][0] = lists.get(i).getName();
			sellarr[i][1] = lists.get(i).getAmount();

		}

		return sellarr;

	}

	public ArrayList<InvenHam> selectHamInven() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ArrayList<InvenHam> list = new ArrayList<InvenHam>();
		String sql = " SELECT * FROM INVEN_HAM ";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			System.out.println("03/04 쿼리 실행" + sql);
			while (rs.next()) {
				InvenHam dto = new InvenHam();
				dto.setName(rs.getString(1));
				dto.setAmount(rs.getInt(2));
				dto.setEtc(rs.getDate(3));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("03/04 쿼리 실패");
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5.DB 종료");
		}

		return list;
	}

	public int update(InvenHam dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " UPDATE INVEN_HAM SET AMOUNT = ? WHERE NAME = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getAmount());
			pstm.setString(2, dto.getName());

			res = pstm.executeUpdate();
			System.out.println("03/04 쿼리 실행 :" + sql);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("03/04 쿼리 실패");
		} finally {
			close(pstm);
			close(con);
			System.out.println("5.DB 종료");
		}
		return res;
	}

	public int update12(int ss, String name) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " UPDATE INVEN_HAM SET AMOUNT = AMOUNT - ? WHERE NAME = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, ss);
			pstm.setString(2, name);

			res = pstm.executeUpdate();
			System.out.println("03/04 쿼리 실행 :" + sql);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("03/04 쿼리 실패");
		} finally {
			close(pstm);
			close(con);
			System.out.println("5.DB 종료");
		}
		return res;
	}

	public ArrayList<InvenHam> selectHamInven12() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ArrayList<InvenHam> list = new ArrayList<InvenHam>();
		String sql = " SELECT NAME, AMOUNT FROM INVEN_HAM ";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			System.out.println("03/04 쿼리 실행" + sql);
			while (rs.next()) {
				InvenHam dto = new InvenHam();
				dto.setName(rs.getString(1));
				dto.setAmount(rs.getInt(2));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("03/04 쿼리 실패");
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5.DB 종료");
		}

		return list;
	}
}
