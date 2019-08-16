package com.toy.home.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailPassword {
	
	public static String getRandomPassword() {
		char[] charSet = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int arr = 0;
		StringBuffer sb = new StringBuffer();
		for (int i=0 ; i<6 ; i++) {
			arr = (int)(charSet.length * Math.random());
			sb.append(charSet[arr]);
		}
		
		return sb.toString();
	}
//	
//	private static class senderAccount extends javax.mail.Authenticator {
//		public PasswordAuthentication getPasswordAuthentication() {
//			return new PasswordAuthentication("simpolor", "password");
//		}
//	}
	
	public static void sendPassward(String email, String randompass) {
		
		String host = "smtp.naver.com";
		final String user = "toy_project";
		final String password = "1q2wtoy3e4r";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
	
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			    return new PasswordAuthentication(user, password);
			}
		});
	
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		
			message.setSubject("[Toy] 인증번호 입니다.");
		
			message.setText("["+randompass+"] 을(를) 창에 입력해 주세요");
		
			Transport.send(message);
			System.out.println("메시지보냄. 확인바람");
	
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
