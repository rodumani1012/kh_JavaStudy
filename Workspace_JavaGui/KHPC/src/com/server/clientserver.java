package com.server;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.pc.main.Main;

public class clientserver extends JFrame implements Runnable {

	Socket serversocket = null;
	Socket socket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	JButton btn;

	TextArea outputArea,textfield, jari2;;
		
	//Label 
	public clientserver() {
		
	}
	
		  

	public clientserver(String title) {
		super(title);
		setLayout(null);
		outputArea = new TextArea();
		
		outputArea.setEditable(false);
		add(outputArea, "Center");
		textfield = new TextArea();
		textfield.setBackground(Color.YELLOW);
		textfield.setBounds(150, 46, 150, 150);
		add(textfield);
		jari2 = new TextArea();
		jari2.setBackground(Color.YELLOW);
		jari2.setBounds(500, 46, 150, 150);
		add(jari2);
		
	
	}
	public void addMessage(String msg){
		if(Main.count==1) {
			textfield.setText(msg);
		}
		if(Main.count==2) {
			jari2.setText(msg);
			
		}
	}
	public void connect(String host, int port) {
		try {
			serversocket =new Socket(host,port);
			out = new PrintWriter(serversocket.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(serversocket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void disconnect() {
		try {
			in.close();
			out.close();
			serversocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try{
			while(true){
				addMessage(in.readLine()+"\n");
				
			}
		}catch(IOException e){
			disconnect();
		}
	}
	public static void main(String[] args) {
		clientserver mf = new clientserver("pc¹æ °ü¸®");
		mf.pack();
		mf.setSize(1000,500);
		mf.setVisible(true);
		
		mf.addWindowListener(new WindowAdapter() {
		
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		
		mf.connect("192.168.10.148", 9997);
		
		Thread thread = new Thread(mf);
		thread.start();
	}
	class InputListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String input = textfield.getText();
			textfield.setText("");
			
			try{
				out.println(input);
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}	
	}
	

		
		
	
}