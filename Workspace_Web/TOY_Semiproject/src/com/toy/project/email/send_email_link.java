package com.toy.project.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.toy.project.biz.project_biz;
import com.toy.project.biz.project_bizimpl;

public class send_email_link {
	
	// prj_name : 프로젝트 이름 | prj_num : 프로젝트 번호 | invite_nick : 초대할 분의 닉네임 | invite_email : 초대할 분의 이메일 | prj_user : 프로젝트 생성자 | user_num : 생성자 회원번호
	public static void sendPassward(String prj_name, int prj_num, String invite_nick, String invite_email, String prj_user, int user_num) {
		
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
			project_biz biz = new project_bizimpl();
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(invite_email));
		
			message.setSubject("[Toy] 초대링크 입니다.");
		
			message.setContent(prj_user+"님께서 ["+prj_name+"] 프로젝트에 초대했습니다.<br/>"
							+ "<a href='http://localhost:8787/TOY_Semiproject/invite.do?command=insert_user&prj_num="+prj_num+"&user_num="+biz.bring_num(invite_nick).getUser_num()+"'>toy들어가기</a>",
							"text/html; charset=UTF-8");
		
			Transport.send(message);
			System.out.println("메시지보냄. 확인바람");
	
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
