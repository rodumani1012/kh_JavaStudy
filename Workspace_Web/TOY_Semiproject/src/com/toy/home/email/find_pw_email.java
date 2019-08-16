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

public class find_pw_email {
	
	public static String getRandomPassword() {
		char[] charSet = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		int arr = 0;
		StringBuffer sb = new StringBuffer();
		for (int i=0 ; i<7 ; i++) {
			arr = (int)(charSet.length * Math.random());
			sb.append(charSet[arr]);
		}
		
		return sb.toString();
	}
	
	public static void findPassward(String email, String randompass) {
		
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
		
			message.setSubject("[Toy] 변경된 비밀번호");
		
			message.setContent("["+randompass+"] 로 비밀번호가 임시 변경되었습니다.<br>추후 비밀번호를 다시 변경해 주세요!","text/html; charset=UTF-8");
		
			Transport.send(message);
			System.out.println("메시지보냄. 확인바람");
	
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
