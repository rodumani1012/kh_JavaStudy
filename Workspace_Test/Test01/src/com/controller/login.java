package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전송값에 한글이 있을 경우 인코딩처리함
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		  
		//2. 전송값 꺼내서 User 객체에 저장하기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String username = request.getParameter("username");
		
		User user = new User();
		user.setUserId(userId);
		user.setUserPwd(userPwd);
		user.setUsername(username);

		//3. 비즈니스 로직 처리하는 클래스의 해당 메소드를 실행하고, 처리 결과를 받음
		user = dao.loginCheck(user);

		//4. 받은 결과를 가지고 성공/실패에 대한 뷰페이지(파일)을 선택해서 내보냄
		if (user.getUserId != null) {
			//로그인 성공시 해당 클라이언트에 대한 세션 객체를 생성함
			//세션 객체에 Service 를 통해 리턴된 결과인 User 객체를 저장함
			request.getSession().setAttribute("user", user);
			response.sendRedirect("login.html");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script> "
					+ "alert('로그인 실패'); "
					+ "location.href='login.html'; "
					+ "</script>");
		}
		
	}

}
