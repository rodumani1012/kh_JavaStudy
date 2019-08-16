package main;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class Jtab01 extends JFrame{
 
    /*필요한 콤포넌트 준비*/
   
    JTabbedPane t = new JTabbedPane();  //JTabbedPane생성
   
    JPanel p1 = new JPanel(); //JPanel 생성
   
    JButton btn1 = new JButton("탭 연습1");
    JButton btn2 = new JButton("탭 연습2");
    JButton btn3 = new JButton("탭 연습3");
    JTextField txt_1 = new JTextField("기본값",25);
   
         
    public Jtab01() {  //생성자
       
        super("TabTitleTextPosition"); //프레임 타이틀 제목 지정
       
        /*try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //원래 자바 고유의 룩앤필을 쓰는데 이것을 사용할 경우 자신의 오에스의 룩앤필을 사용하게 된다.
        }catch(Exception e) {
            e.printStackTrace();
        }*/
       
        p1.add(btn1); //패널에 버튼추가
        p1.add(btn2); //패널에 버튼추가
        p1.add(btn3); //패널에 버튼추가
        p1.add(txt_1); //패널에 텍스트필드추가
               
        t.add("기록 일지", new JTextArea()); //JTabbedPane에 탭추가
        //Component javax.swing.JTabbedPane.add(String title, Component component)
       
        t.add("상태 보기", p1);
        t.add("회원정보변경", new JTextArea());
        t.add("About",new JTextArea());
       
        add(t);
     
        //frame.pack();
        setSize(450, 350);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
    }//생성자 끝
 
    public static void main(String[] args) {
        new Jtab01();
       
    }//메인메소드 끝
 
}//클래스 끝