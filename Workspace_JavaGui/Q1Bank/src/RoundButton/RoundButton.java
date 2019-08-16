package RoundButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class RoundButton extends JFrame {

	private JPanel contentPane;
	JButton button;
	JButton button_1;
	JButton button_2;
	JButton button_3;
	public JButton button_4;

	public JButton getButton_4() {
		return button_4;
	}

	public void setButton_4(JButton button_4) {
		this.button_4 = button_4;
	}

	JButton button_5;
	private JButton button_6;

	/**
	 * Launch the application.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoundButton frame = new RoundButton();
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
	public RoundButton() {
		setBackground(new Color(0, 0, 255));
		setFont(new Font("HY헤드라인M", Font.PLAIN, 99));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hicja\\Pictures\\a.PNG"));
		setTitle("1조 은행");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setToolTipText("");
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("계좌이체");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(contentPane, "로그인이 필요한 기능입니다.");
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 204, 204));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(50, 250, 160, 40);
		panel.add(btnNewButton);

		button = new JButton("출    금");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(contentPane, "로그인이 필요한 기능입니다.");
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(51, 204, 204));
		button.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		button.setBounds(50, 150, 160, 40);
		panel.add(button);

		button_1 = new JButton("무통장입금");
		Nopassbook nopassbook = new Nopassbook();
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nopassbook.setVisible(true);
				dispose();
				
			}
		});
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(51, 204, 204));
		button_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		button_1.setBounds(50, 350, 160, 40);
		panel.add(button_1);

		button_2 = new JButton("계좌조회");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(contentPane, "로그인이 필요한 기능입니다.");
				Login login = new Login();
				login.setVisible(true);
				dispose();
				
				
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setBackground(new Color(51, 204, 204));
		button_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		button_2.setBounds(370, 150, 160, 40);
		panel.add(button_2);

		button_3 = new JButton("계좌개설");
		Register register = new Register();
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				register.setVisible(true);
				dispose();
				
			}
		});
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBackground(new Color(51, 204, 204));
		button_3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		button_3.setBounds(370, 250, 160, 40);
		panel.add(button_3);

		button_4 = new JButton("로그인");
		button_4.setForeground(new Color(255, 255, 255));
		button_4.setBackground(new Color(51, 204, 204));
		Login login = new Login();
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login.setVisible(true); 
				dispose();
			}
		});

		button_4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		button_4.setBounds(370, 350, 160, 40);
		panel.add(button_4);

		button_6 = new JButton("입    금");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(contentPane, "로그인이 필요한 기능입니다.");
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		button_6.setBackground(new Color(51, 204, 204));
		button_6.setBounds(50, 50, 160, 40);
		panel.add(button_6);

	}

}