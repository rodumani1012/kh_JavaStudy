package com.scope.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopeController
 */
@WebServlet("/controller.do") // controller.do라는 요청이 들어오면 
						//ScopeController servlet이 요청을 처리할 것이다.
public class ScopeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScopeController() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("controller 도착!");
		
		// index.jsp 의 request 객체에 setAttribute 해준 것이라 controller.do의 request 객체엔 값이 없음 
		String reqId = (String) request.getAttribute("reqId");
		
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionId");
		
		ServletContext application = getServletContext();
		String appId = (String) application.getAttribute("appId");
		
		System.out.println("reqId : " + reqId); // forward나 include를 사용해야
											// 정보가 넘어간다.
		System.out.println("sessionId : " + sessionId);
		System.out.println("appId : " + appId);
		
		//요청에 대해 응답해주는 객체
		PrintWriter out = response.getWriter();
		String res = "<h1>응답된 페이지</h1>"
				+ "<table border=1>"
				+ "<tr>"
				+ "	<th>page</th>"
				+ "	<td>myPageIdValue_Servlet</td>"
				+ "</tr>"
				+ "<tr>"
				+ " <th>request</th>"
				+ "	<td>myRequestIdValue_Servlet</td>"
				+ "</tr>"
				+ "<tr>"
				+ " <th>session</th>"
				+ "	<td>" + sessionId + "</td>"
				+ "</tr>"
				+ "<tr>"
				+ " <th>application</th>"
				+ "	<td>" + appId + "</td>"
				+ "</tr>"
				+ "</table>";
		out.println(res);
		
		// controller.do -> result.jsp
		request.setAttribute("reqId", "myRequestIdValue_Servlet");
		
		// RequestDispatcher : 내가 원하는 url로 응답(forward) 해주는 객체
		RequestDispatcher dispatch = request.getRequestDispatcher("result.jsp");
		dispatch.forward(request, response); // request에 set 해준 값을 result.jsp로 forward 해줌.
	}
}
