package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import dto.fooddto;
import dto.invendto;
import dto.rowdto;
import dto.selldto;
import dto.inven.InvenDrink;
import dto.inven.InvenHam;
import dto.inven.InvenRamen;

public class AllDao extends JDBCTemplate {

	private String kinds;
	private String name;
	private int price;
	private int amount;
	private int total;

//   name에 따른 list 가져오기
	public fooddto selectOne(String name) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		fooddto dto = new fooddto();

		String sql = "SELECT * FROM FOOD WHERE NAME=?";

		try {
			pstm = con.prepareStatement(sql);

			pstm.setString(1, name);
			rs = pstm.executeQuery();

			while (rs.next()) {

				dto.setKind(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setPrice(rs.getInt(3));

				System.out.println("03/04 쿼리 실행 :" + sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("03/04 쿼리 실패");
		} finally {
			close(con);
			close(pstm);
			close(rs);
			System.out.println("5.DB 종료");
		}

		return dto;
	}

//  인벤토리에서 재고를 추가하면 값을 추가시킨다.
	public int update(invendto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " UPDATE INVEN SET AMOUNT = ? WHERE NAME = ? ";

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

//   이름에 따른 sellist의 amount값과 total값을 수정해준다.
	public int selUpdate(selldto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " UPDATE SELLIST SET AMOUNT=?, TOTAL=? WHERE NAME=? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getAmount());
			pstm.setInt(2, dto.getTotal());
			pstm.setString(3, dto.getName());

			res = pstm.executeUpdate();

			System.out.println("03/04 쿼리 실행 :" + sql);
		} catch (SQLException e) {
			System.out.println("03/04 쿼리 실패");
			e.printStackTrace();
		} finally {
			close(con);
			close(pstm);
			System.out.println("5.DB 종료");
		}

		return res;
	}

//   sellist를 가져온다
	public selldto SelList(selldto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = " SELECT * FROM SELLIST ";

		try {

			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			System.out.println("03/04 쿼리 실행 :" + sql);

			while (rs.next()) {
				dto.setName(rs.getString(1));
				dto.setPrice(rs.getInt(2));
				dto.setAmount(rs.getInt(3));
				dto.setPrice(rs.getInt(4));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("03/04 쿼리 실패");
		} finally {
			close(con);
			close(pstm);
			close(rs);
			System.out.println("5.DB 종료");
		}

		return dto;
	}

//   food의 값을 arraylist로 받아온다.
	public ArrayList<fooddto> selectAll() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ArrayList<fooddto> list = new ArrayList<fooddto>();
		String sql = " SELECT * FROM FOOD ";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			System.out.println("03/04 쿼리 실행" + sql);
			while (rs.next()) {
				fooddto dto = new fooddto();
				dto.setKind(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setPrice(rs.getInt(3));

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

//   sell을 arraylist로 받아온다.
	public ArrayList<selldto> selectAllSell() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ArrayList<selldto> list = new ArrayList<selldto>();

		String sql = " SELECT * FROM SELLIST ";

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			System.out.println("03/04 쿼리 실행" + sql);
			while (rs.next()) {
				selldto dto = new selldto();
				dto.setKind(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setAmount(rs.getInt(4));
				dto.setTotal(rs.getInt(5));

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

//   sellist에 값을 넣어준다.
	public int insert(selldto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

//      String sql = " INSERT INTO SELLIST VALUES(?,?,?,?,?) ";
		String sql = " INSERT INTO SELLIST SELECT KINDS,NAME,PRICE,AMOUNT,TOTAL FROM ROWLIST";

		try {
			pstm = con.prepareStatement(sql);

			System.out.println("03/04 쿼리 실행" + sql);

			res = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("03/04 쿼리 실패");
		} finally {
			close(pstm);
			close(con);
		}

		return res;
	}

	public int delete(rowdto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " DELETE FROM ROWLIST";

		try {

			pstm = con.prepareStatement(sql);
			System.out.println("03/04 쿼리 실행" + sql);
			res = pstm.executeUpdate();

			if (res > 0) {
				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}

// sellist에 값을 넣어준다.
	public int rowinsert(rowdto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " INSERT INTO ROWLIST VALUES(?,?,?,?,?,?) ";

		try {
			pstm = con.prepareStatement(sql);

			System.out.println("03/04 쿼리 실행" + sql);
			pstm.setInt(1, dto.getNum12());
			pstm.setString(2, dto.getKind());
			pstm.setString(3, dto.getName());
			pstm.setInt(4, dto.getPrice());
			pstm.setInt(5, dto.getAmount());
			pstm.setInt(6, dto.getTotal());

			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("03/04 쿼리 실패");
		} finally {
			close(pstm);
			close(con);
		}

		return res;
	}

//    makeArr - food의 값을 table에 값을 넣어주기 위해 배열로 만들어준다.
	public Object[][] makeArr1(ArrayList<fooddto> lists) {

		Object[][] foodarr = new Object[lists.size()][5];

		for (int i = 0; i < lists.size(); i++) {

			foodarr[i][0] = lists.get(i).getName();
			foodarr[i][1] = lists.get(i).getPrice();

		}

		return foodarr;

	}

//    makeSell - sell의 값을 table에 넣어주기 위해 배열로 만들어준다.
	public Object[][] makeSell(ArrayList<selldto> lists) {

		Object[][] sellarr = new Object[lists.size()][5];

		for (int i = 0; i < lists.size(); i++) {

			sellarr[i][0] = lists.get(i).getKind();
			sellarr[i][1] = lists.get(i).getName();
			sellarr[i][2] = lists.get(i).getAmount();
			sellarr[i][3] = lists.get(i).getPrice();
			sellarr[i][4] = (lists.get(i).getAmount()) * (lists.get(i).getPrice());

		}

		return sellarr;

	}

//    makeInven - 인벤테이블에서 배열을 이용해서 메뉴 30개를 불러와서 인벤토리 재고현황에서 보여준다.
	public Object[][] makeInven(ArrayList<invendto> lists) {

		Object[][] invenarr = new Object[lists.size()][5];

		for (int i = 0; i < lists.size(); i++) {

			invenarr[i][0] = lists.get(i).getName();
			invenarr[i][1] = lists.get(i).getAmount();
			invenarr[i][2] = lists.get(i).getSysdate();

		}

		return invenarr;

	}

//   selectAllInven - 인벤 테이블에서 이름,양,현재날짜를 불러오고 있다.
	public ArrayList<invendto> selectAllInven() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ArrayList<invendto> list = new ArrayList<invendto>();
		String sql = " SELECT * FROM INVEN ";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			System.out.println("03/04 쿼리 실행" + sql);
			while (rs.next()) {
				invendto dto = new invendto();
				dto.setName(rs.getString(1));
				dto.setAmount(rs.getInt(2));
				dto.setSysdate(rs.getDate(3));

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

	public int deleteOne(rowdto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " DELETE FROM ROWLIST WHERE NAME = ?";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getName());

			System.out.println("03/04 쿼리 실행" + sql);
			res = pstm.executeUpdate();

			if (res > 0) {
				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}

	public int deleteTwo(Object rs) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " DELETE FROM ROWLIST WHERE NUM12 = ?";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setObject(1, rs);

			System.out.println("03/04 쿼리 실행" + sql);
			res = pstm.executeUpdate();

			if (res > 0) {
				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}

	public int update12(InvenRamen dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE INVEN_RAMEN SET AMOUNT = ? WHERE NAME = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getAmount());
			pstm.setString(2, dto.getName());

			System.out.println("03/04 쿼리 실행" + sql);
			res = pstm.executeUpdate();

			if (res > 0) {
				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}

	public int update1222(InvenDrink dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " UPDATE INVEN_DRINK SET AMOUNT = ? WHERE NAME = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getAmount());
			pstm.setString(2, dto.getName());

			System.out.println("03/04 쿼리 실행" + sql);
			res = pstm.executeUpdate();

			if (res > 0) {
				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}

	public ArrayList<InvenRamen> s_InvenRamen() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ArrayList<InvenRamen> list = new ArrayList<InvenRamen>();

		String sql = " SELECT NAME, AMOUNT FROM INVEN_RAMEN ";

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			System.out.println("03/04 쿼리 실행" + sql);
			while (rs.next()) {
				InvenRamen dto = new InvenRamen();
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

	public ArrayList<InvenHam> s_InvenHam() {
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

	public ArrayList<InvenDrink> s_InvenDrink() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ArrayList<InvenDrink> list = new ArrayList<InvenDrink>();

		String sql = " SELECT NAME, AMOUNT FROM INVEN_DRINK ";

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			System.out.println("03/04 쿼리 실행" + sql);
			while (rs.next()) {
				InvenDrink dto = new InvenDrink();
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

	public ArrayList<rowdto> s_Rowlist() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ArrayList<rowdto> list = new ArrayList<rowdto>();

		String sql = " SELECT NAME, AMOUNT FROM ROWLIST ";

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			System.out.println("03/04 쿼리 실행" + sql);
			while (rs.next()) {
				rowdto dto = new rowdto();
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

	public int Selldelete() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " DELETE FROM SELLIST ";

		try {
			pstm = con.prepareStatement(sql);

			System.out.println("03/04 쿼리 실행" + sql);
			res = pstm.executeUpdate();

			if (res > 0) {
				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}
}