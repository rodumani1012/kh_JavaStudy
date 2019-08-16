package main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;

public class PassWord extends JFrame {
   private static String password = "pass";

   JLabel pwtext;

   JPasswordField field = new JPasswordField(10);

   public PassWord() {

//        타이틀이름
      super("재고관리");
//      FlowLayout사용
      setLayout(new FlowLayout());
//       Border로 영역 생성
      EtchedBorder eborder = new EtchedBorder();
//        레이블 생성
      pwtext = new JLabel("패스워드를 입력해 주세요");
//        레이블 영역 만들기
      pwtext.setBorder(eborder);
//        레이블 추가
      add(pwtext);

//      swing 종료
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//      비밀번호 일치 여부 확인
      field.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.out.println("Field=" + field.getText());
            JPasswordField input = (JPasswordField) e.getSource();
            char[] passy = input.getPassword();
            String p = new String(passy);

            if (p.equals(password)) {
            	new Inventory();
               dispose();
            } else {
               JOptionPane.showMessageDialog(null, "비밀번호가 아닙니다");
//               dispose();
            }
         }
      });

//     비밀번호 창
      getContentPane().add(field);
      pack();
      setVisible(true);
      setSize(300, 102);
   }
}