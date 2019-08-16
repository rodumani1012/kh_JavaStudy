package main;

import java.awt.Container;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import dao.AllDao;
import dto.fooddto;
import dto.selldto;

public class SellListUI extends JFrame {

   Container container = getContentPane();
   Panel pal = new Panel();
   AllDao dao = null;
   ArrayList<fooddto> food = null;
   ArrayList<selldto> sell = null;
   Object columnNames[] = { "종류", "이름", "양", "금액", "합계" };
   JLabel lblNewLabel_1;
   private JTable table;
   private JTable table_1;

   public SellListUI() {

      super("판매확인");

      dao = new AllDao();

      food = dao.selectAll();
      sell = dao.selectAllSell();

      setSize(550, 700);
      setVisible(true);
      setLocation(900, 100);
      getContentPane().setLayout(null);

      JPanel panel = new JPanel();
      panel.setBounds(20, 41, 500, 505);
      getContentPane().add(panel);
      panel.setLayout(null);

      table = new JTable(dao.makeSell(dao.selectAllSell()), columnNames);
      table.setBounds(1, 40, 500, 505);
      panel.add(table);

      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setBounds(13, 10, 469, 455);
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      panel.add(scrollPane);


      JPanel panel_1 = new JPanel();
      panel_1.setBounds(0, 577, 534, 75);
      getContentPane().add(panel_1);
      panel_1.setLayout(null);

      JPanel panel_2 = new JPanel();
      panel_2.setBounds(0, 524, 534, 43);
      getContentPane().add(panel_2);
      panel_2.setLayout(null);

      lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 25));
      lblNewLabel_1.setBounds(110, 0, 400, 40);
      panel_2.add(lblNewLabel_1);

      JLabel lblNewLabel_2 = new JLabel("판매리스트");
      lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
      lblNewLabel_2.setBounds(220, 16, 100, 20);
      getContentPane().add(lblNewLabel_2);

      JButton button = new JButton("매출확인");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {// 테이블에 전체 매출 리스트 출력
            sell = dao.selectAllSell();
            int sum = 0;
            for (int i = 0; i < sell.size(); i++) {
               sum += (sell.get(i).getAmount()) * (sell.get(i).getPrice());
            }

            lblNewLabel_1.setText("오늘의 매출은 " + Integer.toString(sum) + " 입니다.");

         }
      });
      button.setBounds(40, 10, 100, 37);
      panel_1.add(button);

      JButton button1 = new JButton("초기화");
      button1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {// 테이블에 전체 매출 리스트 출력
            AllDao dao12 = new AllDao();
            dao12.Selldelete();
            setVisible(false);
            restart();

         }
      });
      button1.setBounds(160, 10, 100, 37);
      panel_1.add(button1);

      JButton button_10 = new JButton("주문화면");
      button_10.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {// 창닫기
            setVisible(false);
         }
      });
      button_10.setBounds(280, 10, 100, 37);
      panel_1.add(button_10);

      JButton button_11 = new JButton("재고관리");
      button_11.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 new PassWord();
         }
      });
      button_11.setBounds(400, 10, 100, 37);
      panel_1.add(button_11);

   }

   public static void restart() {

      SellListUI SL = new SellListUI();
      SL.revalidate();
      SL.repaint();
   }
}