package com.toy.home.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.toy.home.biz.login_biz;
import com.toy.home.biz.login_bizimpl;
import com.toy.home.dto.login_dto;


@WebServlet("/login_controller")
public class login_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login_controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");
		System.out.println("<" + command + ">");

		login_biz biz = new login_bizimpl();

		if (command.equals("login_chk")) {
			String id = request.getParameter("id"); //입력한 아이디
			String pw = request.getParameter("pw"); // 입력한 비밀번호
			
			login_dto dto = biz.login_chk(id, pw); // 아이디,비밀번호 검증 후 모든 정보 리턴

			request.getSession().setAttribute("login_dto", dto);
			
			if (dto.getUser_id() != null) {
				
				if(dto.getUser_grade().equals("ADMIN")) {
					dispatch(request, response, "home.jsp"); // 관리자 페이지(※ 미구현)
				} else if (dto.getUser_grade().equals("USER")) {
					dispatch(request, response, "home.jsp"); // 유저 페이지로
					jsAlert("로그인 성공!", response);
				}
			} else {
				jsResponse("로그인 실패", "login.jsp", response);
			}

		} else if (command.equals("naver")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("callback.jsp");
			dispatcher.forward(request, response);
		}

	}

	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {

		String res = "<script type=\"text/javascript\">\r\n" + "		alert('" + msg + "');\r\n"
				+ "		location.href = '" + url + "'\r\n</script>";

		PrintWriter out = response.getWriter();
		out.println(res);

	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	
	public void jsAlert(String msg, HttpServletResponse response) throws IOException {
		String res = "<script type='text/javascript'>alert('" + msg + "') </script>";
		
		PrintWriter out = response.getWriter();
		out.print(res);
	}

}
