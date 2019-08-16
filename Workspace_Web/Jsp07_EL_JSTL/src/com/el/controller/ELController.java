package com.el.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.el.dto.Score;

@WebServlet("/controller.do") // 해당 url(controller.do)로 맵핑 해줌
public class ELController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ELController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("<" + command + ">");
		
		if(command.equals("basic")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("basic-arithmetic.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("eltest")) {
			// Score 객체에 홍길동, 100, 90, 89 넣어서
			// request에 담아서
			// eltest.jsp로 보내자
			Score sc = new Score("홍길동",100,90,89);
			
			request.setAttribute("score", sc);
			RequestDispatcher dispatcher = request.getRequestDispatcher("eltest.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("jstltest")) {
			
			List<Score> list = new ArrayList<Score>();
			
			for (int i = 10; i < 50; i+=10) {
				Score sc = new Score("이름" + i, 50+i, 50+i, 50+i);
				list.add(sc);
			}
			
			request.setAttribute("list", list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("jstltest.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		doGet(request, response);
	}

}
