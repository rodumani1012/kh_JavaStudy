package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 현재 서버에는 controller.do 서블렛과 HelloController 서블렛 두개가 있음

@WebServlet("/HelloController") // web.xml에 있는 url-pattern과 같은 역할
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L; // 직렬화
	
	private String initParam;
	private String contextParam;
       
	// 서블릿의 라이프사이클(생명주기)
	// 객체(생성자) 호출 -> init()실행 -> doGet() 또는 doPost()실행 -> destroy()실행
    public HelloController() {
    	System.out.println("servlet 생성자");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("servlet init!!!");
    	
    	contextParam = config.getServletContext().getInitParameter("url");
    	System.out.println("context param : " +
    			config.getServletContext().getInitParameter("url"));
    	
    	initParam = config.getInitParameter("driver");
    	System.out.println("init param : " + initParam);
    	
    	destroy();
    }    
    
    // get방식으로 요청하면 doGet메소드가 실행됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정보(request)를 헤더에 담음 (보임)
		System.out.println("get방식으로 들어왔음!!");
		
		// 프로젝트 실행하다 글씨(글자)가 깨질 경우 잡아줌
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		System.out.println("init : " + initParam);
		System.out.println("context : " + contextParam);
		
		PrintWriter out = response.getWriter(); // 클라이언트한테 응답해줌
		out.println("<h1 style='color:red'>Hello Servlet</h1>");
		out.println("<h2>계층구조 / 라이프사이클 / url맵핑</h2>");
		out.println("<a href='home.html'>돌아가기</a>");
		
	}

    // post방식으로 요청하면 doPost메소드가 실행됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정보(request)를 바디에 담음. (보이지않음)
		System.out.println("post방식으로 들어왔음!!");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet destroy!!");
	}

}
