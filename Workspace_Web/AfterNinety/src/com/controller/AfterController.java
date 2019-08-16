package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AfterDao;
import com.dto.AfterDto;

@WebServlet(urlPatterns = {"/login"})
public class AfterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AfterDao dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		try {
			getRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		try {
			getRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		dao = new AfterDao();
		
		String command = request.getRequestURI();
		System.out.println("<" + command + ">");
		
		if (command.endsWith("/login")) {
			dologin(request, response);
		}
	}

	private void dologin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 로그인 하기
		AfterDto dto = dao.loginCheck(id, pw);
		
		// 로그인하면서 90일 지났는지 확인하기
		boolean ninety = dao.checkNinety(dto);
		
		if(ninety) {
			response.sendRedirect("changepw.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비번 변경 필요없음');</script>");
		}
	}
}
