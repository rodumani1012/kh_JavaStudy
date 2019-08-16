package main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import dao.AllDao;
import dao.DrinkDao;
import dao.HamDao;
import dao.RamenDao;
import dto.fooddto;
import dto.invendto;
import dto.rowdto;
import dto.selldto;
import dto.food.FoodDrinkDto;
import dto.food.FoodHamDto;
import dto.food.FoodRamenDto;
import dto.inven.InvenDrink;
import dto.inven.InvenHam;
import dto.inven.InvenRamen;
import dto.sellist.SellistDrink;
import dto.sellist.SellistHam;
import dto.sellist.SellistRamen;

//재고창을 만들면 완전히 다른걸 만들어야 한다. 그래서 그걸 어떻게 만들지 고민해봐야될듯
//일단 메인에서 만들어 줘야 함 입력데이터는 여기서 전부 받아서 서버로 어넣어주는 ㅈ쪽으로 만들자
public class DrinkMainUI {
	ArrayList<fooddto> list = new ArrayList<fooddto>();
	fooddto food = null;
	invendto inven = null;
	selldto sell = null;
	AllDao dao = null;
	rowdto rdto = null;

	List<FoodDrinkDto> FDD = new ArrayList<FoodDrinkDto>();
	List<FoodHamDto> FHD = new ArrayList<FoodHamDto>();
	List<FoodRamenDto> FRD = new ArrayList<FoodRamenDto>();

	FoodDrinkDto drinkdto = null;
	FoodHamDto hamdto = null;
	FoodRamenDto ramendto = null;

	InvenDrink invendrink = null;
	InvenHam invenham = null;
	InvenRamen invenramen = null;

	SellistDrink sellistdrink = null;
	SellistHam sellistham = null;
	SellistRamen sellistramen = null;

	DrinkDao drinkdao = null;
	HamDao hamdao = null;
	RamenDao ramendao = null;

	JLabel lblNewLabel_1;
	String menu = "";
	String menu_1 = "";

	private JTable table;

	String colNames[] = { "번호", "상품명", "단가", "수량", "합계" };
	Object data[] = new Object[10];

	DefaultTableModel tableModel;
	JScrollPane sp;

	// private JTextArea guiEdit = new JTextArea();
	JPanel panel = new JPanel();
	private JScrollPane utilScrollbar = new JScrollPane(panel);
	private JTabbedPane guiOverviewTabPanel = new JTabbedPane();
	private JPanel guiOverviewTabIncludes = new JPanel();
	private JPanel guiOverviewTabFunctions = new JPanel();
	private JPanel pTab1 = new JPanel(new BorderLayout());
	private JPanel pTab2 = new JPanel(new BorderLayout());
	private JPanel pTab3 = new JPanel(new BorderLayout());
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JPanel contentPane;

	int count = 0;
	int count3 = 0;

	//
	int k = 0;

	public static void main(String[] args) {
		DrinkMainUI ui = new DrinkMainUI();
	}

	public DrinkMainUI() {
		// super("상품주문");
		initialize();

	}

	public void initialize() {

		food = new fooddto();
		dao = new AllDao();
		inven = new invendto();
		sell = new selldto();
		rdto = new rowdto();

		drinkdto = new FoodDrinkDto();
		hamdto = new FoodHamDto();
		ramendto = new FoodRamenDto();

		drinkdao = new DrinkDao();
		hamdao = new HamDao();
		ramendao = new RamenDao();

		invendrink = new InvenDrink();
		invenham = new InvenHam();
		invenramen = new InvenRamen();

		sellistdrink = new SellistDrink();
		sellistham = new SellistHam();
		sellistramen = new SellistRamen();

		FDD = drinkdao.DrinkfoodAll(); // fooddrink arraylist
		FHD = hamdao.HamfoodAll(); // foodham arraylist
		FRD = ramendao.RamenfoodAll(); // foodramen arraylist

		// sell = dao.SelList(sell); // 서버에서 재고 데이터 넣어주기
		// System.out.println(stock); // 재고 데이터 확인
		JFrame fm = new JFrame();

//      fmsetDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      setBounds(150, 0, 1200, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//      setContentPane(contentPane);
		contentPane.setLayout(null);

//      setVisible(true);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1200, 620);
		contentPane.add(tabbedPane);

		JPanel pTab1 = new JPanel();
		tabbedPane.add("라면", pTab1);
		pTab1.setBackground(new Color(50, 50, 50));
		pTab1.setLayout(null);

		JPanel pTab2 = new JPanel();
		tabbedPane.add("햄버거", pTab2);
		pTab2.setBackground(new Color(50, 50, 50));
		pTab2.setLayout(null);

		JPanel pTab3 = new JPanel();
		tabbedPane.add("음료", pTab3);
		pTab3.setBackground(new Color(50, 50, 50));
		pTab3.setLayout(null);

		// 하단 panel
		JPanel b_pan = new JPanel();
		b_pan.setBounds(0, 620, 850, 380);
		b_pan.setBackground(new Color(50, 50, 50));
		contentPane.add(b_pan);
		b_pan.setLayout(null);

		// 하단 오른쪽 panel
		JPanel b_right = new JPanel();
		b_right.setBounds(840, 620, 360, 380);
		b_right.setBackground(new Color(50, 50, 50));
		contentPane.add(b_right);
		b_right.setLayout(null);

		// 합계 panel
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 20, 300, 110);
		panel_3.setBackground(new Color(100, 100, 100));
		panel_3.setLayout(null);
		b_right.add(panel_3);

//===========================하단 테이블=============================================

		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		table = new JTable(model);

		// 2. Model을 매개변수로 설정, new JTable(b,a)도 가능하지만
		// 삽입 삭제를 하기 위해 해당 방법을 사용합니다
//         JTable table = new JTable(model); //
//         getContentPan().add(new JScrollPane(table));
//      setVisible(true);

		table.setRowHeight(30); // 열 높이
		table.setFont(new Font("", Font.PLAIN, 20));
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(100, 100, 100));
		table.setBounds(20, 20, 800, 300);

		// model.addRow(new Object[] { "상품명", "단가", "수량", "합계" });
		b_pan.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 20, 800, 300);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getViewport().setBackground(new Color(100, 100, 100));

		// 테이블 헤더
		JTableHeader anHeader = table.getTableHeader();
		anHeader.setForeground(new Color(255, 255, 255));
		anHeader.setBackground(new Color(130, 130, 130));
		anHeader.setFont(new Font("", Font.BOLD, 20));

		b_pan.add(scrollPane);

		// 테이블 가운데 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

		TableColumnModel tcm = table.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴

		// 전체 열에 지정
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}

		// 테이블 컬럼의 이동 방지
		table.getTableHeader().setReorderingAllowed(false);

		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(162);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);

// ======================합계 라벨===========================================
		JLabel tx = new JLabel();
		tx.setFont(new Font("", Font.BOLD, 30));
		tx.setForeground((new Color(255, 255, 255)));
		tx.setBounds(65, 40, 240, 35);

// ======================삭제하기 버튼=========================================
		JButton DelRow = new JButton("선택취소");
		DelRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// rowdto rdto = new rowdto();

				int row = table.getSelectedRow();

				// String value = table.getValueAt(row, 0).toString();
				// System.out.println("테이블의 삭제할 값:" + value);
				// rdto.setName(value);

				// dao.deleteOne(rdto);

				Object rs = table.getValueAt(table.getSelectedRow(), 0);
				System.out.println(rs);
				dao.deleteTwo(rs);

				if (row < 0)
					return;
				model.removeRow(row);
				if (row == 0) {
					tx.setText("");
				}
				int count4 = 0;
				for (int k = 0; k < model.getRowCount(); k++) {
					count4 += ((int) model.getValueAt(k, 4));
					System.out.println(count4);
					tx.setText("합계: " + count4);
					panel_3.add(tx);
					panel_3.revalidate();
					panel_3.repaint();
				}

			}
		});
		DelRow.setBounds(215, 80, 75, 25);
		DelRow.setBackground(new Color(155, 155, 155));
		DelRow.setFont(new Font("", Font.PLAIN, 10));

		panel_3.add(DelRow);
		// 삭제하기 끝

//===================상단 MENU 라벨=========================================      
		JLabel tx1 = new JLabel("< M E N U >");
		tx1.setFont(new Font("", Font.BOLD, 25));
		tx1.setForeground((new Color(255, 255, 255)));
		tx1.setBounds(520, 30, 240, 35);
		pTab1.add(tx1);

		JLabel tx2 = new JLabel("< M E N U >");
		tx2.setFont(new Font("", Font.BOLD, 25));
		tx2.setForeground((new Color(255, 255, 255)));
		tx2.setBounds(520, 30, 240, 35);
		pTab2.add(tx2);

		JLabel tx3 = new JLabel("< M E N U >");
		tx3.setFont(new Font("", Font.BOLD, 25));
		tx3.setForeground((new Color(255, 255, 255)));
		tx3.setBounds(520, 30, 240, 35);
		pTab3.add(tx3);

// ========================라면 상단========================================

		String menu1[] = new String[10];
		int price1[] = new int[10];
		int count12[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < FRD.size(); i++) {
			menu1[i] = FRD.get(i).getName();
			price1[i] = FRD.get(i).getPrice();
		}
		JButton bt[] = new JButton[menu1.length];
		TextField suja1[] = new TextField[menu1.length];
		Button minus1[] = new Button[menu1.length];
		Button plus1[] = new Button[menu1.length];
		JButton ok[] = new JButton[menu1.length];
		Label l[] = new Label[menu1.length];
		ImageIcon icon[] = new ImageIcon[menu1.length];
		Label la[] = new Label[menu1.length];

		// 버튼 설정 부분
		for (int i = 0; i < menu1.length; i++) {

			// 메뉴 버튼
			bt[i] = new JButton(menu1[i]);
			if (i < 5) {
				bt[i].setBounds(80 + i * 210, 87, 180, 150);
			} else {
				bt[i].setBounds(80 + (i - 5) * 210, 328, 180, 150);
			}
			icon[i] = new ImageIcon("image/" + i + ".png");
			bt[i].setIcon(icon[i]);

			// 숫자 txt 버튼
			suja1[i] = new TextField("0");
			suja1[i].setBackground(Color.white);
			suja1[i].setEditable(false);
			suja1[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 180, 30, 20);

			// "-" 버튼
			minus1[i] = new Button("-");
			minus1[i].setBounds(bt[i].getX(), suja1[i].getY(), 20, 20);
			minus1[i].setEnabled(false);

			// "+" 버튼
			plus1[i] = new Button("+");
			plus1[i].setBounds(bt[i].getX() + (100 - 30), suja1[i].getY(), 20, 20);
			plus1[i].setEnabled(false);

			// 가격
			l[i] = new Label(menu1[i] + "     " + price1[i] + "원 ");
			l[i].setBounds(bt[i].getX() + 10, bt[i].getY() + 155, 180, 20);
			l[i].setFont(new Font("", Font.PLAIN, 15));
			l[i].setForeground(new Color(255, 255, 255));

			// 확인 버튼
			ok[i] = new JButton("확인");
			ok[i].setBounds(plus1[i].getX() + 30, plus1[i].getY(), 80, 20);
			ok[i].setEnabled(false);

			pTab1.add(bt[i]);
			pTab1.add(suja1[i]);
			pTab1.add(minus1[i]);
			pTab1.add(plus1[i]);
			pTab1.add(l[i]);
			pTab1.add(ok[i]);
		}

		// 이벤트단
		for (int i = 0; i < menu1.length; i++) {
			int j = i;

			// 메뉴 버튼 이벤트
			bt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minus1[j].setEnabled(true);
					plus1[j].setEnabled(true);
					bt[j].setEnabled(false);
					ok[j].setEnabled(true);

					count = 0;
				}
			});

			// "-" 버튼 이벤트
			minus1[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (count > 0) {
						count = count - 1;
						suja1[j].setText(count + "");
						ok[j].setEnabled(true);
					} else {
						minus1[j].setEnabled(false);
					}
				}
			});

			// "+" 버튼 이벤트
			plus1[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					count = count + 1;
					suja1[j].setText(count + "");
					ok[j].setEnabled(true);
					if (count > 0) {
						minus1[j].setEnabled(true);
					}
				}
			});
		}

		// 확인 버튼 이벤트

		// 문자 길이 맞추려고 3번 반복 (ex.단무지 / 짜파게티 / 짜파게티(컵))
//       1.문자길이 맞출려고 3번 반복 2. 햄버거 메뉴창

		for (int i = 0; i < menu1.length; i++) {
			int j = i;
			ok[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					k++;
					model.addRow(new Object[] { k, menu1[j], price1[j], count, count * price1[j] });

					RamenDao dda = new RamenDao();
					ArrayList<InvenRamen> DL = dda.selectRamenInven12();

					for (int as = 0; as < 10; as++) {

						if ((table.getValueAt(table.getRowCount() - 1, 1)).equals(DL.get(as).getName())) {

							if (DL.get(as).getAmount() <= 0) {
								JOptionPane.showMessageDialog(null,
										table.getValueAt(table.getRowCount() - 1, 1) + "의 수량이 부족합니다.");
								model.removeRow(table.getRowCount() - 1);
								k--;
							}
						}
					}

					int count4 = 0;

					for (int k = 0; k < model.getRowCount(); k++) {

						count4 += ((int) model.getValueAt(k, 4));

						tx.setText("합계: " + count4);

						panel_3.add(tx);
						panel_3.revalidate();
						panel_3.repaint();

					}
					ok[j].setEnabled(false);

					String show = menu1[j];

//               selldto dto = new selldto();
					rowdto dto = new rowdto();
					dto.setNum12(k);
					dto.setKind("라면");
					dto.setName(show);
					dto.setPrice(price1[j]);
					dto.setAmount(count);
					dto.setTotal(price1[j] * count);

//               dao.insert(dto);
					dao.rowinsert(dto);

				}
			});
		}

// ========================= 햄버거 상단======================================

		String menu2[] = new String[10];
		int price2[] = new int[10];
		for (int i = 0; i < FHD.size(); i++) {
			menu2[i] = FHD.get(i).getName();
			price2[i] = FHD.get(i).getPrice();
		}
		JButton bt2[] = new JButton[menu2.length];
		TextField suja2[] = new TextField[menu2.length];
		Button minus2[] = new Button[menu2.length];
		Button plus2[] = new Button[menu2.length];
		JButton ok2[] = new JButton[menu2.length];
		Label l2[] = new Label[menu2.length];

		ImageIcon icon2[] = new ImageIcon[menu2.length];
		Label la2[] = new Label[menu2.length];

		// 버튼 설정 부분
		for (int i = 0; i < menu2.length; i++) {

			// 메뉴 버튼
			bt2[i] = new JButton(menu2[i]);
			if (i < 5) {
				bt2[i].setBounds(80 + i * 210, 87, 180, 150);
			} else {
				bt2[i].setBounds(80 + (i - 5) * 210, 328, 180, 150);
			}
			icon2[i] = new ImageIcon("image/" + (10 + i) + ".png");
			bt2[i].setIcon(icon2[i]);

//                        for(int k =1; k<5; k++) {
//                        count++;
//                     if(count > 1){
//                        total.setNoodle_k(total.getNoodle_k()+1);
//                     }
//                     total.setNoodle_k(total.getNoodle_k()-1); // 원두재고 관리            
//                        }

			// 숫자 txt 버튼
			suja2[i] = new TextField("0");
			suja2[i].setBackground(Color.white);
			suja2[i].setEditable(false);
			suja2[i].setBounds(bt2[i].getX() + 30, bt2[i].getY() + 180, 30, 20);

			// "-" 버튼
			minus2[i] = new Button("-");
			minus2[i].setBounds(bt2[i].getX(), suja2[i].getY(), 20, 20);
			minus2[i].setEnabled(false);

			// "+" 버튼
			plus2[i] = new Button("+");
			plus2[i].setBounds(bt2[i].getX() + (100 - 30), suja2[i].getY(), 20, 20);
			plus2[i].setEnabled(false);

			// 가격
			l2[i] = new Label(menu2[i] + "     " + price2[i] + "원");
			l2[i].setBounds(bt2[i].getX() + 10, bt2[i].getY() + 155, 180, 20);
			l2[i].setFont(new Font("", Font.PLAIN, 15));
			l2[i].setForeground(new Color(255, 255, 255));

			// 확인 버튼
			ok2[i] = new JButton("확인");
			ok2[i].setBounds(plus2[i].getX() + 30, plus2[i].getY(), 80, 20);
			ok2[i].setEnabled(false);

			pTab2.add(bt2[i]);
			pTab2.add(suja2[i]);
			pTab2.add(minus2[i]);
			pTab2.add(plus2[i]);
			pTab2.add(l2[i]);
			pTab2.add(ok2[i]);
		}

		// 이벤트단
		for (int i = 0; i < menu2.length; i++) {
			int j = i;

			// 메뉴 버튼 이벤트
			bt2[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minus2[j].setEnabled(true);
					plus2[j].setEnabled(true);
					bt2[j].setEnabled(false);
					ok2[j].setEnabled(true);

					count = 0;
				}
			});

			// "-" 버튼 이벤트
			minus2[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (count > 0) {
						count = count - 1;
						suja2[j].setText(count + "");
						ok2[j].setEnabled(true);
					} else {
						minus2[j].setEnabled(false);
					}
				}
			});

			// "+" 버튼 이벤트
			plus2[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					count = count + 1;
					suja2[j].setText(count + "");
					ok2[j].setEnabled(true);
					if (count > 0) {
						minus2[j].setEnabled(true);
					}
				}
			});
		}

		// 확인 버튼 이벤트

		for (int i = 0; i < menu2.length; i++) {
			int j = i;
			ok2[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					k++;
					model.addRow(new Object[] { k, menu2[j], price2[j], count, count * price2[j] });

					int count4 = 0;

					HamDao dda = new HamDao();
					ArrayList<InvenHam> HL = dda.selectHamInven12();

					for (int as = 0; as < 10; as++) {

						if ((table.getValueAt(table.getRowCount() - 1, 1)).equals(HL.get(as).getName())) {

							if (HL.get(as).getAmount() <= 0) {
								JOptionPane.showMessageDialog(null,
										table.getValueAt(table.getRowCount() - 1, 1) + "의 수량이 부족합니다.");
								model.removeRow(table.getRowCount() - 1);
								k--;
							}
						}
					}

					for (int k = 0; k < model.getRowCount(); k++) {

						count4 += ((int) model.getValueAt(k, 4));

						tx.setText("합계: " + count4);

						panel_3.add(tx);
						panel_3.revalidate();
						panel_3.repaint();

					}
					ok[j].setEnabled(false);

					String show = menu1[j];

//               selldto dto = new selldto();
					rowdto dto = new rowdto();
					dto.setNum12(k);
					dto.setKind("햄버거");
					dto.setName(show);
					dto.setPrice(price2[j]);
					dto.setAmount(count);
					dto.setTotal(price2[j] * count);

//               dao.insert(dto);
					dao.rowinsert(dto);

				}
			});
		}

// ===========================음료 상단======================================

		String menu3[] = new String[10];
		int price3[] = new int[10];

		for (int i = 0; i < FDD.size(); i++) {
			menu3[i] = FDD.get(i).getName();
			price3[i] = FDD.get(i).getPrice();
		}

		JButton bt3[] = new JButton[menu3.length];
		TextField suja3[] = new TextField[menu3.length];
		Button minus3[] = new Button[menu3.length];
		Button plus3[] = new Button[menu3.length];
		JButton ok3[] = new JButton[menu3.length];
		Label l3[] = new Label[menu3.length];
		ImageIcon icon3[] = new ImageIcon[menu3.length];
		Label la3[] = new Label[menu3.length];

		// 버튼 설정 부분
		for (int i = 0; i < menu3.length; i++) {

			// 메뉴 버튼
			bt3[i] = new JButton(menu3[i]);
			if (i < 5) {
				bt3[i].setBounds(80 + i * 210, 87, 180, 150);
			} else {
				bt3[i].setBounds(80 + (i - 5) * 210, 328, 180, 150);
			}
			icon3[i] = new ImageIcon("image/" + (20 + i) + ".png");
			bt3[i].setIcon(icon3[i]);

//                           for(int k =1; k<5; k++) {
//                           count++;
//                        if(count > 1){
//                           total.setNoodle_k(total.getNoodle_k()+1);
//                        }
//                        total.setNoodle_k(total.getNoodle_k()-1); // 원두재고 관리            
//                           }

			// 숫자 txt 버튼
			suja3[i] = new TextField("0");
			suja3[i].setBackground(Color.white);
			suja3[i].setEditable(false);
			suja3[i].setBounds(bt3[i].getX() + 30, bt3[i].getY() + 180, 30, 20);

			// "-" 버튼
			minus3[i] = new Button("-");
			minus3[i].setBounds(bt3[i].getX(), suja3[i].getY(), 20, 20);
			minus3[i].setEnabled(false);

			// "+" 버튼
			plus3[i] = new Button("+");
			plus3[i].setBounds(bt3[i].getX() + (100 - 30), suja3[i].getY(), 20, 20);
			plus3[i].setEnabled(false);

			// 가격
			l3[i] = new Label(menu3[i] + "     " + price3[i] + "원");
			l3[i].setBounds(bt3[i].getX() + 10, bt3[i].getY() + 155, 180, 20);
			l3[i].setFont(new Font("", Font.PLAIN, 15));
			l3[i].setForeground(new Color(255, 255, 255));

			// 확인 버튼
			ok3[i] = new JButton("확인");
			ok3[i].setBounds(plus3[i].getX() + 30, plus3[i].getY(), 80, 20);
			ok3[i].setEnabled(false);

			pTab3.add(bt3[i]);
			pTab3.add(suja3[i]);
			pTab3.add(minus3[i]);
			pTab3.add(plus3[i]);
			pTab3.add(l3[i]);
			pTab3.add(ok3[i]);
		}

		// 이벤트단
		for (int i = 0; i < menu3.length; i++) {
			int j = i;

			// 메뉴 버튼 이벤트
			bt3[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minus3[j].setEnabled(true);
					plus3[j].setEnabled(true);
					bt3[j].setEnabled(false);
					ok3[j].setEnabled(true);

					count = 0;
				}
			});

			// "-" 버튼 이벤트
			minus3[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (count > 0) {
						count = count - 1;
						suja3[j].setText(count + "");
						ok3[j].setEnabled(true);
					} else {
						minus3[j].setEnabled(false);
					}
				}
			});

			// "+" 버튼 이벤트
			plus3[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					count = count + 1;
					suja3[j].setText(count + "");
					ok3[j].setEnabled(true);
					if (count > 0) {
						minus3[j].setEnabled(true);
					}
				}
			});
		}

		// 확인 버튼 이벤트

		for (int i = 0; i < menu3.length; i++) {
			int j = i;
			ok3[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					k++;
					model.addRow(new Object[] { k, menu3[j], price3[j], count, count * price3[j] });

					int count4 = 0;

					DrinkDao dda = new DrinkDao();
					ArrayList<InvenDrink> DL = dda.selectDrinkInven12();

					for (int as = 0; as < 10; as++) {

						if ((table.getValueAt(table.getRowCount() - 1, 1)).equals(DL.get(as).getName())) {

							if (DL.get(as).getAmount() <= 0) {
								JOptionPane.showMessageDialog(null,
										table.getValueAt(table.getRowCount() - 1, 1) + "의 수량이 부족합니다.");
								model.removeRow(table.getRowCount() - 1);
								k--;
							}
						}
					}

					for (int k = 0; k < model.getRowCount(); k++) {

						count4 += ((int) model.getValueAt(k, 4));

						tx.setText("합계: " + count4);

						panel_3.add(tx);
						panel_3.revalidate();
						panel_3.repaint();

					}
					ok[j].setEnabled(false);

					String show = menu3[j];

//               selldto dto = new selldto();
					rowdto dto = new rowdto();
					dto.setNum12(k);
					dto.setKind("음료수");
					dto.setName(show);
					dto.setPrice(price3[j]);
					dto.setAmount(count);
					dto.setTotal(price3[j] * count);

//               dao.insert(dto);
					dao.rowinsert(dto);

				}
			});
		}

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setText("\uCEE4\uD53C");

		lblNewLabel_1.setBounds(860, 100, 618, 26);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
//      panel_2.add(lblNewLabel_1);

		// 스트링에 문자열을 넣고 액션이 나올떄마다 스트링에 값을 넣어주고 마지막으로 값을 넣어준다.
		lblNewLabel_1.setText(menu_1);

//      panel_2.add(lblNewLabel_1);

//=============================결제 버튼=====================================
		JButton btnNewButton_5 = new JButton("결제하기");// 결제 누르면 서버로 입력
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selldto dto = new selldto();
				dao.insert(dto);

				rowdto rdto = new rowdto();
				dao.delete(rdto);

				count = 0;

				// 음료수 재고 떨어뜨리기
				DropAmountRamen();
				DropAmountHam();
				DropAmountDrink();

				JOptionPane.showMessageDialog(null, "결제 되었습니다");

				int cou = table.getRowCount();

				for (int v = 0; v < cou; v++) {
					model.removeRow(0);
				}

				k = 0;

				tx.setText("");
				panel_3.add(tx);
				panel_3.revalidate();
				panel_3.repaint();

			}
		});
		btnNewButton_5.setBounds(20, 210, 300, 110);
		btnNewButton_5.setBackground(new Color(233, 0, 81));
		btnNewButton_5.setFont(new Font("", Font.BOLD, 30));
		btnNewButton_5.setForeground(new Color(255, 255, 255));

		b_right.add(btnNewButton_5);

//===================================================================      
		JButton button_10 = new JButton("\uC120\uD0DD\uCDE8\uC18C");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count = 0;
				food.setKind(null);
				food.setName(null);
				food.setPrice(0);
				lblNewLabel_1.setText("");
				// 버튼 초기화
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
				buttonGroup_2.clearSelection();
				System.out.println(food);
				JOptionPane.showMessageDialog(null, "선택취소되었습니다.");

			}
		});
		button_10.setBounds(431, 121, 123, 38);
		// b_right.add(button_10);

//=========================판매보기=========================================   
		JButton button_11 = new JButton("판매확인");// 판매확인
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new SellListUI();
				// System.out.println(dao.GetAllSellList());

			}
		});
		button_11.setBounds(20, 145, 143, 50);
//      button_11.setBackground(new Color(233,0,81));
		b_right.add(button_11);

//========================재고관리=========================================
		JButton btnNewButton_6 = new JButton("\uC7AC\uACE0\uAD00\uB9AC");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new Inventory();
				new PassWord();
			}
		});
		btnNewButton_6.setBounds(178, 145, 143, 50);
		b_right.add(btnNewButton_6);
		// 재고관리

		fm.setVisible(true);
		fm.setBounds(10, 10, 1200, 1000);
		fm.add(tabbedPane);
		fm.add(contentPane);
	}

//======================================================================
	public void showlabel_noodle(String name1, int price2) {

		food.setName(name1);
		food.setPrice(price2);

		if (food.getName() != null && food.getPrice() != 0) {
			menu_1 = food.getPrice() + " 원";
		}

	}

	public void showlabel(String name, int price) {// 판매 데이터 입력

		food.setName(name);
		food.setPrice(price);

		if (food.getName() != null && food.getPrice() != 0) {
			menu = food.getName() + " / " + food.getPrice() + " 원";
		}
		lblNewLabel_1.setText(menu);

	}// showlabel

	private void init() {

		fooddto dto = new fooddto();
		dto.setKind("");
		dto.setName("");
	}

	public void DropAmountRamen() {

		RamenDao dda = new RamenDao();

		ArrayList<InvenRamen> RL = dda.selectRamenInven12();

		for (int c = 0; c < table.getRowCount(); c++) {
			for (int cc = 0; cc < 10; cc++) {
				if (table.getValueAt(c, 1).equals(RL.get(cc).getName())) {
					dda.update12((int) table.getValueAt(c, 3), RL.get(cc).getName());
				}

			}
		}
	}

	public void DropAmountHam() {

		HamDao dda = new HamDao();

		ArrayList<InvenHam> HL = dda.selectHamInven12();

		for (int c = 0; c < table.getRowCount(); c++) {
			for (int cc = 0; cc < 10; cc++) {
				if (table.getValueAt(c, 1).equals(HL.get(cc).getName())) {
					dda.update12((int) table.getValueAt(c, 3), HL.get(cc).getName());
				}
			}
		}
	}

	public void DropAmountDrink() {

		DrinkDao dda = new DrinkDao();

		ArrayList<InvenDrink> sdaf = dda.selectDrinkInven12();

		for (int c = 0; c < table.getRowCount(); c++) {
			for (int cc = 0; cc < 10; cc++) {
				if (table.getValueAt(c, 1).equals(sdaf.get(cc).getName())) {
					dda.update12((int) table.getValueAt(c, 3), sdaf.get(cc).getName());
				}

			}
		}
	}

}