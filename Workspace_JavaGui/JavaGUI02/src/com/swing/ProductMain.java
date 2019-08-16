package com.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ProductMain extends JFrame{

	private JTabbedPane tabbedPane;
	private JToolBar toolBar;
	private JPanel pTab1, pTab2, pBottom, pNorth, pN1, pN2;
	private JTable table1, table2;
	private JScrollPane scrollPane1, scrollPane2;
	private JRadioButton rdPdName, rdPrice;
	private ButtonGroup btGroup;
	private JComboBox<String> cbPdName;
	private JLabel lbId, lb1;
	private JTextField tfId, tfPrice1, tfPrice2;
	private JButton btSearch, btAdd, btEdit, btExit;
	private DefaultTableModel model1 = new DefaultTableModel();
	private DefaultTableModel model2 = new DefaultTableModel();
	
	String[] colNames = {"번호","상품명","가격","상품설명","등록일"};
	
	public ProductMain() {
		super("상품 관리"); // 프로그램 이름
		
		toolBar = new JToolBar();
		btAdd = new JButton("등록");
		btEdit = new JButton("수정");
		btExit = new JButton("종료");

		tabbedPane = new JTabbedPane();
		pTab1 = new JPanel(new BorderLayout());
		pTab2 = new JPanel(new BorderLayout());

		pBottom=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		lbId=new JLabel("아이디 : ");
		tfId=new JTextField(10);

		table1 = new JTable();

		scrollPane1=new JScrollPane();
		scrollPane1.setPreferredSize(new Dimension(300, scrollPane1.getHeight()));

		pNorth = new JPanel(new GridLayout(2, 1, 5,5));
		pN1 = new JPanel();

		rdPdName = new JRadioButton("상품명으로 검색", true);
		cbPdName = new JComboBox<String>();

		pN2=new JPanel();

		rdPrice = new JRadioButton("가격으로 검색");
		tfPrice1=new JTextField(10);
		tfPrice2=new JTextField(10);
		lb1=new JLabel("~");
		btSearch = new JButton("검색");
		
		btGroup = new ButtonGroup();
		
		
		go();
	}
	
	private void go(){		

		toolBar.add(btAdd);
		toolBar.add(btEdit);
		toolBar.add(btExit);
		add(toolBar,"North");
		
		tabbedPane.addTab("상품등록", pTab1);
		tabbedPane.addTab("상품검색", pTab2);
		add(tabbedPane,"Center");

		pBottom.add(lbId);
		pBottom.add(tfId);
		add(pBottom, "South");

		pBottom.add(lbId);
		pBottom.add(tfId);
		add(pBottom, "South");

		// tab1
		model1.addColumn("번호");
		model1.addColumn("상품명");
		model1.addColumn("가격");

		table1.setModel(model1);
		scrollPane1.setViewportView(table1);
		pTab1.add(scrollPane1, "West");

		// tab2
		pNorth.setBorder(new TitledBorder("조회조건"));
		FlowLayout fLayout = (FlowLayout)pN1.getLayout();
		fLayout.setAlignment(FlowLayout.LEFT);

		cbPdName.addItem("라벤다");
		cbPdName.addItem("자스민");
		cbPdName.setPreferredSize(
				new Dimension(170, 25));
		pN1.add(rdPdName);
		pN1.add(cbPdName);

		pNorth.add(pN1);
		pTab2.add(pNorth, "North");

		FlowLayout fLayout2 = (FlowLayout) pN2.getLayout();
		fLayout2.setAlignment(FlowLayout.LEFT);

		btGroup.add(rdPdName);
		btGroup.add(rdPrice);
		
		pN2.add(rdPrice);
		pN2.add(tfPrice1);
		pN2.add(lb1);
		pN2.add(tfPrice2);
		pN2.add(btSearch);
		
		pNorth.add(pN2);
		
		model2.addColumn("번호");
		model2.addColumn("상품명");
		model2.addColumn("가격");
		model2.addColumn("상품 설명");
		model2.addColumn("등록일");

		table2 = new JTable();
		table2.setModel(model2);
		
		scrollPane2 = new JScrollPane();

		table2.getTableHeader().setBackground(Color.black);
		table2.getTableHeader().setForeground(Color.yellow);
		table2.getTableHeader().setReorderingAllowed(false);
		table2.getTableHeader().setPreferredSize(
			new Dimension(scrollPane2.getWidth(), 28));
		table2.setRowHeight(24);
		
		scrollPane2.setViewportView(table2);
		
		pTab2.add(scrollPane2,"Center");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ProductMain();
	}
}







































