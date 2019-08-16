package com.test02;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.test01.FrameTest01;

public class MTest01 extends Frame {
	
	// 객체 생성
	MenuBar mb;
	Menu m_file;
	MenuItem n_frame, n_open, n_save, n_newsave, n_page, n_print, n_end,
		p_open, p_save, p_newsave;
	PopupMenu pm; // 마우스 우클릭 할때 나오는 메뉴.
	TextArea ta;
	
	// 생성자에서 필드 초기화
	public MTest01() {
		m_file = new Menu("파일");
		mb = new MenuBar();
		
		// 키보드에서 쓰는 단축키
		n_frame = new MenuItem("새로 만들기(N)", new MenuShortcut(KeyEvent.VK_N));
		n_open = new MenuItem("열기(O)", new MenuShortcut(KeyEvent.VK_O)); //영문 O
		n_save = new MenuItem("저장(S)", new MenuShortcut(KeyEvent.VK_S));
		n_newsave = new MenuItem("다른 이름으로 저장");
		n_page = new MenuItem("페이지 설정");
		n_print = new MenuItem("인쇄");
		n_end = new MenuItem("끝내기(X)", new MenuShortcut(KeyEvent.VK_X));
		
		pm = new PopupMenu("팝업");
		p_open = new MenuItem("열기", new MenuShortcut(KeyEvent.VK_O)); //영문 O
		p_save = new MenuItem("저장", new MenuShortcut(KeyEvent.VK_S));
		p_newsave = new MenuItem("다른 이름으로 저장");
		
		ta = new TextArea();
	}
	
	public void go() {
		
		// menu 객체에 menuItem을 올린다.
		m_file.add(n_frame);
		m_file.add(n_open);
		m_file.add(n_save);
		m_file.add(n_newsave);
		m_file.addSeparator(); // 다른이름으로 저장과 페이지설정 사이의 선
		m_file.add(n_page);
		m_file.add(n_print);
		m_file.add("-"); // addSeparator와 같은 역할(인쇄와 끝내기 사이의 선)
		m_file.add(n_end);
		
		// menuBar에 menu를 올린다.
		mb.add(m_file);
		
		// frame에 menuBar를 올린다.
		this.setMenuBar(mb);
		
		//--------------------------------
		
		// popupMenu에 menuItem 올린다.
		pm.add(p_open);
		pm.add(p_save);
		pm.add(p_newsave);
		
		// frame에 popupMenu 올린다.
		this.add(pm);
		
		//--------------------------------
		add(ta);
		
		// events
		MTestEvents events = new MTestEvents();
		this.addWindowListener(events); // x버튼 누르면 꺼짐
		
		n_end.addActionListener(events); // 끝내기(X) 누르면 꺼짐
		n_frame.addActionListener(events);
		n_open.addActionListener(events);
		
		ta.addKeyListener(events);
		ta.addMouseListener(events);
		ta.addMouseMotionListener(events);
		
		
		// view
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MTest01().go();
	}
	
	class MTestEvents extends WindowAdapter 
		implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

		// 무언가 클릭할 때
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuItem mi = (MenuItem) e.getSource();			
			
			if(mi.getActionCommand().trim().equals("끝내기(X)")) {
				System.exit(0);
			} 
			
			System.out.println(mi.getShortcut().getKey());
			
			switch (mi.getShortcut().getKey()) {
			case KeyEvent.VK_N:
				ta.setText("\0"); // \0은 아스키코드상에서 null을 의미
				ta.setBackground(Color.white);
				break;
			case KeyEvent.VK_O:
				new FrameTest01().go();
				break;
			case KeyEvent.VK_S:
				
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			ta.append("\n" + "Typed key is '" + e.getKeyChar() + "' \n");
			if(e.isShiftDown()) {
				ta.append("-Shift is down!!! \n");
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton() == 3) {
				pm.show(ta, e.getX(), e.getY());
			}			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			ta.setBackground(Color.pink);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			ta.setBackground(Color.yellow);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			String str = String.format("x = %3d, y = %3d \n", e.getX(), e.getY());
			ta.append(str);
		}
		
		
	}
}
