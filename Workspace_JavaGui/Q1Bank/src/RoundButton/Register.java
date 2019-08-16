package RoundButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.biz.BankBiz;
import com.dto.BankDto;

public class Register extends JFrame {

   private BankBiz biz = new BankBiz();
   private JPanel contentPane;
   private JTextField nameField;
   private JTextField accountField;
   private PlaceholderTextField holder;
   private JPasswordField passwordField;
   private UIManager ui = new UIManager();
   private JLabel pwholder;
   private JButton btnNewButton;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Register frame = new Register();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public Register() {
      this.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            dispose(); //본인(자기)만 꺼지게 하는 것
         }
      });
      
      setBounds(100, 100, 800, 600);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      Dimension frameSize = this.getSize(); // 프레임 사이즈
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
      this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
      setContentPane(contentPane);
      contentPane.setLayout(null);
      ImageIcon img = new ImageIcon("images/banner_sign_up.png");
      Image preImg = img.getImage();
      Image afterImg = preImg.getScaledInstance(800, 100, java.awt.Image.SCALE_SMOOTH);
      ImageIcon afterIcon = new ImageIcon(afterImg);
      JLabel bannerTop = new JLabel(afterIcon);
      contentPane.setLayout(null);

      JLabel label = new JLabel("이      름");
      label.setFont(new Font("맑은 고딕", Font.BOLD, 22));
      label.setBounds(232, 138, 100, 30);
      contentPane.add(label);

      nameField = new JTextField();
      nameField.setBounds(346, 138, 200, 30);
      contentPane.add(nameField);
      nameField.setColumns(10);
      nameField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent ke) {
            JTextField src = (JTextField) ke.getSource();
            if (src.getText().length() >= 20) {
               ke.consume();
            }

            if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
               passwordField.requestFocus();
            }
         }
      });

      accountField = new JTextField();
      holder = new PlaceholderTextField();
      LimitFont pwlf = new LimitFont();
      LimitFont lf = new LimitFont();
      pwholder = new JLabel("※ 숫자 4자리로 입력해주세요.");

      JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
      label_2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
      label_2.setBounds(232, 198, 100, 30);
      contentPane.add(label_2);

      pwholder.setForeground(Color.RED);
      pwholder.setFont(new Font("굴림", Font.PLAIN, 13));
      pwholder.setBounds(new Rectangle(352, 233, 200, 20));
      contentPane.add(pwholder);

      passwordField = new JPasswordField();
      passwordField.setDocument(pwlf);
      passwordField.setBounds(346, 198, 200, 30);
      contentPane.add(passwordField);
      passwordField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyReleased(KeyEvent ke) {
            JTextField src = (JTextField) ke.getSource();
            if (src.getText().length() >= 4) {
               ke.consume();
               holder.requestFocus();
            }
            if (!(isNumeric(passwordField.getText()))) {
               pwholder.setText("※ 숫자 4자리로 입력해주세요.");
            } else if (passwordField.getText().length() == 4) {
               pwholder.setText("");
            } else {
               pwholder.setText("※ 숫자 4자리로 입력해주세요.");
            }
         }
      });

      JLabel label_3 = new JLabel("계좌번호");
      label_3.setFont(new Font("맑은 고딕", Font.BOLD, 22));
      label_3.setBounds(232, 257, 100, 30);
      contentPane.add(label_3);
//      accountField.setDocument(lf);
//      accountField.setColumns(10);
//      accountField.setBounds(346, 256, 200, 30);
//      contentPane.add(accountField);
      holder.setPlaceholder("휴대폰 번호 11자리 입력해주세요.");
      holder.setFont(new Font("맑은 고딕", Font.BOLD, 12));
      holder.setDocument(lf);
      holder.setColumns(10);
      holder.setBounds(346, 256, 200, 30);
      contentPane.add(holder);
      holder.addKeyListener(new KeyAdapter() {
         @Override
         public void keyReleased(KeyEvent ke) {
              JTextField src = (JTextField) ke.getSource();
              if (src.getText().length() >= 11) {
                 ke.consume();
                 btnNewButton.requestFocus();
              }
           }
        });

      btnNewButton = new JButton("개   설");
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            String name = nameField.getText();
            String password = passwordField.getText();
            String account = holder.getText();

            if (account.length() == 11 && password.length()==4 ) {
               BankDto insertdto = new BankDto(account, name, password, 0, null);
               int accountinsert = biz.AccountCreate(insertdto);
               if (accountinsert > 0) {
                  System.out.println("계좌개설 성공");
                  JOptionPane.showMessageDialog(contentPane, name + "님의 계좌가 개설되었습니다.");
                  dispose();
                  MainGUI_beforeLogin main = new MainGUI_beforeLogin();
                  main.setVisible(true);
               } else {
                  System.out.println("계좌개설 실패");
                  JOptionPane.showMessageDialog(contentPane, "이미 존재하는 계좌입니다.");
                  accountField.setText("");
                  nameField.setText("");
                  passwordField.setText("");
               }
            } else {
               JOptionPane.showMessageDialog(null,
                     "<html><body><p style=\"text-align: center; font-size: 15pt;\"> 비밀번호 또는 계좌번호를 확인해주세요. <br/>ex) 01012345678 / 0000 </p></body></html>");
            }

         }
      });
      btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 22));
      btnNewButton.setBounds(220, 319, 141, 48);
      contentPane.add(btnNewButton);

      JButton button = new JButton("취   소");
      button.setFont(new Font("맑은 고딕", Font.BOLD, 22));
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            MainGUI_beforeLogin main = new MainGUI_beforeLogin();
            main.setVisible(true);
            dispose();
         }
      });
      button.setBounds(408, 319, 141, 48);
      contentPane.add(button);

      Panel panel_top = new Panel();
      panel_top.add(bannerTop);
      panel_top.setBounds(0, -5, 800, 100);
      getContentPane().add(panel_top);
      getContentPane().add(panel_top);
      getContentPane().setLayout(null);
      contentPane.add(panel_top);

      accountField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent ke) {
            JTextField src = (JTextField) ke.getSource();
            if (src.getText().length() >= 12) {
               ke.consume();
            }

            if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
               btnNewButton.requestFocus();
            }
         }
      });
   }

   public boolean isNumeric(String s) {
      try {
         Integer.parseInt(s);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }
}