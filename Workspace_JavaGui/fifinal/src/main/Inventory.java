package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import dao.AllDao;
import dao.DrinkDao;
import dao.HamDao;
import dao.RamenDao;
import dto.food.FoodDrinkDto;
import dto.food.FoodHamDto;
import dto.food.FoodRamenDto;
import dto.inven.InvenDrink;
import dto.inven.InvenHam;
import dto.inven.InvenRamen;
import dto.sellist.SellistDrink;
import dto.sellist.SellistHam;
import dto.sellist.SellistRamen;

public class Inventory extends JFrame {
   ImageIcon img = new ImageIcon("image/0.png");

   Container container = getContentPane();
   Panel pal = new Panel();
   
   List<InvenDrink> FDD = new ArrayList<InvenDrink>();
   List<InvenHam> FHD = new ArrayList<InvenHam>();
   List<InvenRamen> FRD = new ArrayList<InvenRamen>();

   FoodDrinkDto drinkdto = new FoodDrinkDto();
   FoodHamDto hamdto = new FoodHamDto();
   FoodRamenDto ramendto = new FoodRamenDto();

   InvenDrink invendrink = new InvenDrink();
   InvenHam invenham = new InvenHam();
   InvenRamen invenramen = new InvenRamen();

   SellistDrink sellistdrink = new SellistDrink();
   SellistHam sellistham = new SellistHam();
   SellistRamen sellistramen = new SellistRamen();

   DrinkDao drinkdao = new DrinkDao(); 
   HamDao hamdao = new HamDao();
   RamenDao ramendao = new RamenDao();

//   라면
   private JTable table;
//  햄버거
   private JTable table2;
//  음료수
   private JTable table3;
   
// 라면
   private JTextField textField;
// 햄버거
   private JTextField textField2;
// 음료수
   private JTextField textField3;   
   
// 재고(라면,햄버거.음료수)들어갈 이름
   String raname = " ";
   String hamname = " ";
   String drinkname = " ";   
   
   Object columnNames[] = { "이름", "수량" };
   JLabel lblNewLabel;

   
   JButton btn1 = new JButton("탭 연습1");
   JButton btn2 = new JButton("탭 연습2");
   JButton btn3 = new JButton("탭 연습3");

   public Inventory() {

      super("재고관리1");

     
      FDD = drinkdao.selectDrinkInven();
      FHD = hamdao.selectHamInven();
      FRD = ramendao.selectRamenInven();
      
      setSize(965, 500);
      setVisible(true);
      setLocation(200, 250);
      setLayout(null);

      JTabbedPane tabbedPane = new JTabbedPane();
      tabbedPane.setBounds(10, 0, 925, 360);
      getContentPane().add(tabbedPane);
    

//=================!!!!!!!!!!!!라면!!!!!!!!!!!!!!=================
     
//    화면설정  
      JPanel tab_1 = new JPanel();
      tabbedPane.add("라면", tab_1);
      tab_1.setLayout(null);

//    수량 입력칸
      JLabel label = new JLabel("수     량");
      label.setBounds(505, 270, 54, 28);
      label.setFont(new Font("", Font.BOLD, 15));
      tab_1.add(label);

//    재고 입력해서 전송할값
      textField = new JTextField();
      textField.setBounds(575, 274, 97, 21);
      tab_1.add(textField);
      textField.setColumns(10);

//    라면 label(1~4) , 햄버거 label(5~8), 음료수label(9~12)
      JLabel label_1 = new JLabel("");
      label_1.setBounds(535, 228, 300, 15);
      label_1.setFont(new Font("", Font.BOLD, 15));
      label_1.setForeground(new Color(100, 100, 100));
      tab_1.add(label_1);
      
      
//    라면에서 button12까지 만듬, 햄버거25, 나머지 음료수
//    음식별 버튼
      JButton button = new JButton("단무지");
      button.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            raname = "단무지";
            label_1.setText(raname + "을(를) 주문하실건가요?");
         }
      });

  
      button.setBounds(385, 43, 91, 65);
      tab_1.add(button);

      JButton button_1 = new JButton("공기밥");
      button_1.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            raname = "공기밥";
            label_1.setText(raname + "을(를) 주문하실건가요?");
         }
      });
      button_1.setBounds(488, 43, 91, 65);
      tab_1.add(button_1);

      JButton button_2 = new JButton("신라면");
      button_2.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            raname = "신라면";
            label_1.setText(raname + "을(를) 주문하실건가요?");
         }
      });
      button_2.setBounds(591, 43, 91, 65);
      tab_1.add(button_2);

      JButton button_3 = new JButton("너구리");
      button_3.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            raname = "너구리";
            label_1.setText(raname + "을(를) 주문하실건가요?");
         }
      });
      button_3.setBounds(694, 43, 91, 65);
      tab_1.add(button_3);

      JButton button_4 = new JButton("참깨라면");
      button_4.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            raname = "참깨라면";
            label_1.setText(raname + "을(를) 주문하실건가요?");
         }
      });
      button_4.setBounds(797, 43, 91, 65);
      tab_1.add(button_4);

      JButton button_5 = new JButton("짜파게티");
      button_5.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            raname = "짜파게티";
            label_1.setText(raname + "을(를) 주문하실건가요?");
         }
      });
      button_5.setBounds(385, 124, 91, 65);
      tab_1.add(button_5);

      JButton button_6 = new JButton("신라면(컵)");
      button_6.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            raname = "신라면(컵)";
            label_1.setText(raname + "을(를) 주문하실건가요?");
         }
      });
      button_6.setBounds(488, 124, 91, 65);
      tab_1.add(button_6);

      JButton button_7 = new JButton("너구리(컵)");
      button_7.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            raname = "너구리(컵)";
            label_1.setText(raname + "을(를) 주문하실건가요?");
         }
      });
      button_7.setBounds(591, 124, 91, 65);
      tab_1.add(button_7);

      JButton button_8 = new JButton("참깨라면(컵)");
      button_8.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            raname = "참깨라면(컵)";
            label_1.setText(raname + "을(를) 주문하실건가요?");
         }
      });
      button_8.setBounds(694, 124, 91, 65);
      tab_1.add(button_8);

      JButton button_9 = new JButton("짜파게티(컵)");
      button_9.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            raname = "짜파게티(컵)";
            label_1.setText(raname + "을(를) 주문하실건가요?");
         }
      });
      button_9.setBounds(797, 124, 91, 65);
      tab_1.add(button_9);

 
//    해당 음식(기본100) + 재고 추가
      JButton button_10 = new JButton("완료");
      button_10.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (raname.equals("단무지")) {
               invenramen.setName("단무지");
               invenramen.setAmount(FRD.get(0).getAmount() + (Integer.parseInt(textField.getText())));
            }
            else if (raname.equals("공기밥")) {
               invenramen.setName("공기밥");
               invenramen.setAmount(FRD.get(1).getAmount() + (Integer.parseInt(textField.getText())));
            }
            else if (raname.equals("신라면")) {
               invenramen.setName("신라면");
               invenramen.setAmount(FRD.get(2).getAmount() + (Integer.parseInt(textField.getText())));
            }
            else if (raname.equals("너구리")) {
               invenramen.setName("너구리");
               invenramen.setAmount(FRD.get(3).getAmount() + (Integer.parseInt(textField.getText())));
            }
            else if (raname.equals("참깨라면")) {
               invenramen.setName("참깨라면");
               invenramen.setAmount(FRD.get(4).getAmount() + (Integer.parseInt(textField.getText())));
            }
            else if (raname.equals("짜파게티")) {
               invenramen.setName("짜파게티");
               invenramen.setAmount(FRD.get(5).getAmount() + (Integer.parseInt(textField.getText())));
            }
            else if (raname.equals("신라면(컵)")) {
               invenramen.setName("신라면(컵)");
               invenramen.setAmount(FRD.get(6).getAmount() + (Integer.parseInt(textField.getText())));
            }
            else if (raname.equals("너구리(컵)")) {
               invenramen.setName("너구리(컵)");
               invenramen.setAmount(FRD.get(7).getAmount() + (Integer.parseInt(textField.getText())));
            }
            else if (raname.equals("참깨라면(컵)")) {
               invenramen.setName("참깨라면(컵)");
               invenramen.setAmount(FRD.get(8).getAmount() + (Integer.parseInt(textField.getText())));
            }
            else if (raname.equals("짜파게티(컵)")) {
               invenramen.setName("짜파게티(컵)");
               invenramen.setAmount(FRD.get(9).getAmount() + (Integer.parseInt(textField.getText())));
            }

            System.out.println(FRD);
            ramendao.update(invenramen);
            JOptionPane.showMessageDialog(null, "주문이 성공하였습니다.");

            setVisible(false);
            restart();
            
         }
      });
      
//    완료 버튼
      button_10.setBounds(694, 270, 81, 28);
      tab_1.add(button_10);

//    재고관리 재고현황 테이블 만들어주는 곳
      table = new JTable(ramendao.makeRamenInven(ramendao.selectRamenInven()), columnNames);
      table.setBounds(31, 45, 325, -264);
      tab_1.add(table);

      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setBounds(31, 45, 325, 264);
      tab_1.add(scrollPane);      

      JLabel label_3 = new JLabel("재고현황");
      label_3.setBounds(31, 18, 57, 15);
      tab_1.add(label_3);

      JLabel label_4 = new JLabel("물품주문");
      label_4.setBounds(400, 18, 57, 15);
      tab_1.add(label_4);


      JButton button_100 = new JButton("주문화면");
      button_100.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {// 창닫기
            setVisible(false);
         }
      });
      button_100.setBounds(354, 398, 97, 37);
      getContentPane().add(button_100);

      JButton button_11 = new JButton("판매확인");
      button_11.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // setVisible(false);
            new SellListUI();
         }
      });
      button_11.setBounds(463, 398, 97, 37);
      getContentPane().add(button_11);

      JLabel label_2 = new JLabel("주문이 완료되었습니다.");
      label_2.setBounds(360, 390, 172, 22);
      label_2.setFont(new Font("", Font.BOLD, 15));
     

// ======================= 햄버거 ===============================

//       화면설정
      JPanel tab_2 = new JPanel();
      tabbedPane.addTab("햄버거", null, tab_2, null);
      tab_2.setLayout(null);

//    수량 입력칸
      JLabel label2 = new JLabel("수     량");
      label2.setBounds(505, 270, 54, 28);
      label2.setFont(new Font("", Font.BOLD, 15));
      tab_2.add(label2);

//    재고 입력해서 전송할값
      textField2 = new JTextField();
      textField2.setBounds(575, 274, 97, 21);
      tab_2.add(textField2);
      textField2.setColumns(10);

//    라면 label(1~4) , 햄버거 label(5~8), 음료수label(9~12)
      JLabel label_5 = new JLabel("");
      label_5.setBounds(535, 228, 300, 15);
      label_5.setFont(new Font("", Font.BOLD, 15));
      label_5.setForeground(new Color(100, 100, 100));
      tab_2.add(label_5);
      
      
//    라면에서 button12까지 만듬, 햄버거25, 나머지 음료수
//    음식별 버튼
      JButton button_13 = new JButton("불고기버거");
      button_13.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            hamname = "불고기버거";
            label_5.setText(hamname + "을(를) 주문하실건가요?");
         }
      });



      button_13.setBounds(385, 43, 91, 65);
      tab_2.add(button_13);

      JButton button_14 = new JButton("어니언버거");
      button_14.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            hamname= "어니언버거";
            label_5.setText(hamname + "을(를) 주문하실건가요?");
         }
      });
      button_14.setBounds(488, 43, 91, 65);
      tab_2.add(button_14);

      JButton button_15 = new JButton("치즈버거");
      button_15.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            hamname = "치즈버거";
            label_5.setText(hamname + "을(를) 주문하실건가요?");
         }
      });
      button_15.setBounds(591, 43, 91, 65);
      tab_2.add(button_15);

      JButton button_16 = new JButton("머쉬룸버거");
      button_16.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            hamname = "머쉬룸버거";
            label_5.setText(hamname + "을(를) 주문하실건가요?");
         }
      });
      button_16.setBounds(694, 43, 91, 65);
      tab_2.add(button_16);

      JButton button_17 = new JButton("불고기세트");
      button_17.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            hamname = "불고기세트";
            label_5.setText(hamname + "을(를) 주문하실건가요?");
         }
      });
      button_17.setBounds(797, 43, 91, 65);
      tab_2.add(button_17);

      JButton button_18 = new JButton("어니언세트");
      button_18.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            hamname = "어니언세트";
            label_5.setText(hamname + "을(를) 주문하실건가요?");
         }
      });
      button_18.setBounds(385, 124, 91, 65);
      tab_2.add(button_18);

      JButton button_19 = new JButton("치즈세트");
      button_19.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            hamname = "치즈세트";
            label_5.setText(hamname + "을(를) 주문하실건가요?");
         }
      });
      button_19.setBounds(488, 124, 91, 65);
      tab_2.add(button_19);

      JButton button_20 = new JButton("머쉬룸세트");
      button_20.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            hamname = "머쉬룸세트";
            label_5.setText(hamname + "을(를) 주문하실건가요?");
         }
      });
      button_20.setBounds(591, 124, 91, 65);
      tab_2.add(button_20);

      JButton button_21 = new JButton("토마토머핀");
      button_21.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            hamname = "토마토머핀";
            label_5.setText(hamname + "을(를) 주문하실건가요?");
         }
      });
      button_21.setBounds(694, 124, 91, 65);
      tab_2.add(button_21);

      JButton button_22 = new JButton("에그머핀");
      button_22.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            hamname = "에그머핀";
            label_5.setText(hamname + "을(를) 주문하실건가요?");
         }
      });
      button_22.setBounds(797, 124, 91, 65);
      tab_2.add(button_22);


//    해당 음식(기본100) + 재고 추가
      JButton button_23 = new JButton("완료");
      button_23.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (hamname.equals("불고기버거")) {// 주문하기
               invenham.setName("불고기버거");
               invenham.setAmount(FHD.get(0).getAmount() + (Integer.parseInt(textField2.getText())));
            }
            else if (hamname.equals("어니언버거")) {
               invenham.setName("어니언버거");
               invenham.setAmount(FHD.get(1).getAmount() + (Integer.parseInt(textField2.getText())));
            }

            else if (hamname.equals("치즈버거")) {
               invenham.setName("치즈버거");
               invenham.setAmount(FHD.get(2).getAmount() + (Integer.parseInt(textField2.getText())));
            }
            else if (hamname.equals("머쉬룸버거")) {
               invenham.setName("머쉬룸버거");
               invenham.setAmount(FHD.get(3).getAmount() + (Integer.parseInt(textField2.getText())));
            }
          
            else if (hamname.equals("불고기세트")) {
               invenham.setName("불고기세트");
               invenham.setAmount(FHD.get(4).getAmount() + (Integer.parseInt(textField2.getText())));
            }
            else if (hamname.equals("어니언세트")) {
               invenham.setName("어니언세트");
               invenham.setAmount(FHD.get(5).getAmount() + (Integer.parseInt(textField2.getText())));
            }
            else if (hamname.equals("치즈세트")) {
               invenham.setName("치즈세트");
               invenham.setAmount(FHD.get(6).getAmount() + (Integer.parseInt(textField2.getText())));
            }
            else if (hamname.equals("머쉬룸세트")) {
               invenham.setName("머쉬룸세트");
               invenham.setAmount(FHD.get(7).getAmount() + (Integer.parseInt(textField2.getText())));
            }
            else if (hamname.equals("토마토머핀")) {
               invenham.setName("토마토머핀");
               invenham.setAmount(FHD.get(8).getAmount() + (Integer.parseInt(textField2.getText())));
            }
            else if (hamname.equals("에그머핀")) {
               invenham.setName("에그머핀");
               invenham.setAmount(FHD.get(9).getAmount() + (Integer.parseInt(textField2.getText())));
            }

            System.out.println(FHD);
            hamdao.update(invenham);
            JOptionPane.showMessageDialog(null, "주문이 성공하였습니다.");

            setVisible(false);
            restart();
         }
      });
//    완료 버튼
      button_23.setBounds(694, 270, 81, 28);
      tab_2.add(button_23);

//    재고관리 재고현황 테이블 만들어주는 곳
      table2 = new JTable(hamdao.makeHamInven(hamdao.selectHamInven()), columnNames);
      table2.setBounds(31, 45, 325, -264);
      tab_2.add(table2);

      JScrollPane scrollPane1 = new JScrollPane(table2);
      scrollPane1.setBounds(31, 45, 325, 264);
      tab_2.add(scrollPane1);
      
      

      JLabel label_7 = new JLabel("재고현황");
      label_7.setBounds(31, 18, 57, 15);
      tab_2.add(label_7);

      JLabel label_8 = new JLabel("물품주문");
      label_8.setBounds(400, 18, 57, 15);
      tab_2.add(label_8);


      JButton button_24 = new JButton("주문화면");
      button_24.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {// 창닫기
            setVisible(false);
         }
      });
      button_24.setBounds(354, 398, 97, 37);
      getContentPane().add(button_24);

      JButton button_25 = new JButton("판매확인");
      button_25.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // setVisible(false);
            new SellListUI();
         }
      });
      
      button_25.setBounds(463, 398, 97, 37);
      getContentPane().add(button_25);

      JLabel label_6 = new JLabel("주문이 완료되었습니다.");
      label_6.setBounds(360, 390, 172, 22);
      label_6.setFont(new Font("", Font.BOLD, 15));
//       getContentPane().add(label_2);
      
      
//      ========================= 음료수 ===================================

//    화면설정
      JPanel tab_3 = new JPanel();
      tabbedPane.addTab("음료수", tab_3);
      tab_3.setLayout(null);

//    수량 입력칸      
      JLabel label3 = new JLabel("수     량");
      label3.setBounds(505, 270, 54, 28);
      label3.setFont(new Font("", Font.BOLD, 15));
      tab_3.add(label3);

      textField3 = new JTextField();
      textField3.setBounds(575, 274, 97, 21);
      tab_3.add(textField3);
      textField3.setColumns(10);

//    라면 label(1~4) , 햄버거 label(5~8), 음료수label(9~12)
      JLabel label_9 = new JLabel("");
      label_9.setBounds(535, 228, 300, 15);
      label_9.setFont(new Font("", Font.BOLD, 15));
      label_9.setForeground(new Color(100, 100, 100));
      tab_3.add(label_9);
      
      
//    라면에서 button12까지 만듬, 햄버거25, 나머지 음료수
//    음식별 버튼
      JButton button_26 = new JButton("사과드링크");
      button_26.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

           drinkname = "사과드링크";
            label_9.setText(drinkname + "을(를) 주문하실건가요?");
         }
      });

      
      button_26.setBounds(385, 43, 91, 65);
      tab_3.add(button_26);

      JButton button_27 = new JButton("쿠우쿠우");
      button_27.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

           drinkname = "쿠우쿠우";
            label_9.setText(drinkname + "을(를) 주문하실건가요?");
         }
      });
      button_27.setBounds(488, 43, 91, 65);
      tab_3.add(button_27);

      JButton button_28 = new JButton("포카리스웨트");
      button_28.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            drinkname = "포카리스웨트";
             label_9.setText(drinkname + "을(를) 주문하실건가요?");
         }
      });
      button_28.setBounds(591, 43, 91, 65);
      tab_3.add(button_28);

      JButton button_29 = new JButton("비타500");
      button_29.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

           drinkname = "비타500";
            label_9.setText(drinkname + "을(를) 주문하실건가요?");
         }
      });
      button_29.setBounds(694, 43, 91, 65);
      tab_3.add(button_29);

      JButton button_30 = new JButton("파워에이드");
      button_30.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            drinkname = "파워에이드";
            label_9.setText(drinkname + "을(를) 주문하실건가요?");
         }
      });
      button_30.setBounds(797, 43, 91, 65);
      tab_3.add(button_30);

      JButton button_31 = new JButton("수박소다");
      button_31.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

           drinkname = "수박소다";
            label_9.setText(drinkname + "을(를) 주문하실건가요?");
         }
      });
      button_31.setBounds(385, 124, 91, 65);
      tab_3.add(button_31);

      JButton button_32 = new JButton("데미소다");
      button_32.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            drinkname = "데미소다";
            label_9.setText(drinkname + "을(를) 주문하실건가요?");
         }
      });
      button_32.setBounds(488, 124, 91, 65);
      tab_3.add(button_32);

      JButton button_33 = new JButton("솔의눈");
      button_33.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            drinkname = "솔의눈";
             label_9.setText(drinkname + "을(를) 주문하실건가요?");
         }
      });
      button_33.setBounds(591, 124, 91, 65);
      tab_3.add(button_33);

      JButton button_34 = new JButton("사이다");
      button_34.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            drinkname = "사이다";
            label_9.setText(drinkname + "을(를) 주문하실건가요?");
         }
      });
      button_34.setBounds(694, 124, 91, 65);
      tab_3.add(button_34);

      JButton button_35 = new JButton("갈아만든배");
      button_35.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            drinkname = "갈아만든배";
            label_9.setText(drinkname + "을(를) 주문하실건가요?");
         }
      });
      button_35.setBounds(797, 124, 91, 65);
      tab_3.add(button_35);


//      해당 음식(기본100) + 재고 추가
      JButton button_36 = new JButton("완료");
      button_36.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (drinkname.equals("사과드링크")) {
               invendrink.setName("사과드링크");
               invendrink.setAmount(FDD.get(0).getAmount() + (Integer.parseInt(textField3.getText())));
            }
            else if (drinkname.equals("쿠우쿠우")) {
               invendrink.setName("쿠우쿠우");
               invendrink.setAmount(FDD.get(1).getAmount() + (Integer.parseInt(textField3.getText())));
            }
            else if (drinkname.equals("포카리스웨트")) {
               invendrink.setName("포카리스웨트");
               invendrink.setAmount(FDD.get(2).getAmount() + (Integer.parseInt(textField3.getText())));
            }
            else if (drinkname.equals("비타500")) {
               invendrink.setName("비타500");
               invendrink.setAmount(FDD.get(3).getAmount() + (Integer.parseInt(textField3.getText())));
            }
            else if (drinkname.equals("파워에이드")) {
               invendrink.setName("파워에이드");
               invendrink.setAmount(FDD.get(4).getAmount() + (Integer.parseInt(textField3.getText())));
            }
            else if (drinkname.equals("수박소다")) {
               invendrink.setName("수박소다");
               invendrink.setAmount(FDD.get(5).getAmount() + (Integer.parseInt(textField3.getText())));
            }
            else if (drinkname.equals("데미소다")) {
               invendrink.setName("데미소다");
               invendrink.setAmount(FDD.get(6).getAmount() + (Integer.parseInt(textField3.getText())));
            }
            else if (drinkname.equals("솔의눈")) {
               invendrink.setName("솔의눈");
               invendrink.setAmount(FDD.get(7).getAmount() + (Integer.parseInt(textField3.getText())));
            }
            else if (drinkname.equals("사이다")) {
               invendrink.setName("사이다");
               invendrink.setAmount(FDD.get(8).getAmount() + (Integer.parseInt(textField3.getText())));
            }
            else if (drinkname.equals("갈아만든배")) {
               invendrink.setName("갈아만든배");
               invendrink.setAmount(FDD.get(9).getAmount() + (Integer.parseInt(textField3.getText())));
            }

            System.out.println(FDD);
            drinkdao.update(invendrink);
            JOptionPane.showMessageDialog(null, "주문이 성공하였습니다.");

            setVisible(false);
            restart();
         }
      });
      
//    완료 버튼
      button_36.setBounds(694, 270, 81, 28);
      tab_3.add(button_36);

//    재고관리 재고현황 테이블 만들어주는 곳
      table3 = new JTable(drinkdao.makeDrinkInven(drinkdao.selectDrinkInven()), columnNames);
      table3.setBounds(31, 45, 325, -264);
      tab_3.add(table3);


//    재고 입력해서 전송할값      
      JScrollPane scrollPane2 = new JScrollPane(table3);
      scrollPane2.setBounds(31, 45, 325, 264);
      tab_3.add(scrollPane2);

      JLabel label_11 = new JLabel("재고현황");
      label_11.setBounds(31, 18, 57, 15);
      tab_3.add(label_11);

      JLabel label_12 = new JLabel("물품주문");
      label_12.setBounds(400, 18, 57, 15);
      tab_3.add(label_12);


      JButton button_38 = new JButton("주문화면");
      button_38.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {// 창닫기
            setVisible(false);
         }
      });
      button_38.setBounds(354, 398, 97, 37);
      getContentPane().add(button_38);

      JButton button_39 = new JButton("판매확인");
      button_39.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new SellListUI();
         }
      });
      button_39.setBounds(463, 398, 97, 37);
      getContentPane().add(button_39);

      JLabel label_10 = new JLabel("주문이 완료되었습니다.");
      label_10.setBounds(360, 390, 172, 22);
      label_10.setFont(new Font("", Font.BOLD, 15));
     
   }
   public static void restart() {

      Inventory IV = new Inventory();
      IV.revalidate();
      IV.repaint();
   }
}