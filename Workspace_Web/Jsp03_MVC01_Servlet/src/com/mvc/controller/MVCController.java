package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.biz.MVCBoardBiz;
import com.mvc.dao.MVCBoardDao;
import com.mvc.dto.MVCBoardDto;

@WebServlet("/MVCController")
public class MVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MVCController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");	

		PrintWriter out = response.getWriter();
		
		String command = request.getParameter("command");
		System.out.println("<"+command+">");
		MVCBoardBiz biz = new MVCBoardBiz();
		
		
		if(command.equals("test")) {
			RequestDispatcher dispatch = request.getRequestDispatcher("test.jsp");
			dispatch.forward(request, response);
		}else if(command.equals("boardlist")) {
			int count = biz.countboard();
			System.out.println("count: "+count);
			request.setAttribute("count", count);
			List<MVCBoardDto> list = biz.selectList();
			request.setAttribute("list", list);//request에 list를 담아서 //object타입 
			
			RequestDispatcher dispatch = request.getRequestDispatcher("boardlist.jsp");
			dispatch.forward(request, response);
		}else if(command.equals("boardwriteform")) {
			RequestDispatcher dispatch = request.getRequestDispatcher("boardwrite.jsp");
			dispatch.forward(request, response);
		}else if(command.equals("boardwrite")) {
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");//form태그에서 받아온값
			
			
			
			MVCBoardDto dto = new MVCBoardDto(0,writer,title,content,null);
			
			int res = biz.insert(dto);
			if(res > 0){
				System.out.println(res);
				String res1 ="<script>" + 
						"alert('글 작성 완료');" + 
						"	location.href='controller.do?command=boardlist';"+
						"</script>";
				out.println(res1);
				System.out.println("글 작성 완료");
			}else{
				String res1="<script>" + 
						"alert('글 작성 실패');" + 
						"	history.back();" + 
						"</script>";
				out.println(res1);
				System.out.println("글 작성 실패");
			}
		}else if(command.equals("selectone")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MVCBoardDto dto = new MVCBoardDto();
			dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			RequestDispatcher dispatch = request.getRequestDispatcher("selectone.jsp");
			dispatch.forward(request, response);
		}else if(command.equals("delete")) {
			String[] seq = request.getParameterValues("seq");
			MVCBoardDao dao = new MVCBoardDao();
			int res = dao.multiDelete(seq);
			if(res > 0){
				String res1="<script>" + 
						"alert('삭제 완료');" + 
						"	location.href='controller.do?command=boardlist';"+
						"</script>";
				out.println(res1);
			}else {
				String res1="<script>" + 
						"alert('삭제 실패');" + 
						"	history.back();" + 
						"</script>";
				out.println(res1);
			}
		}else if(command.equals("updateform")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MVCBoardDto dto = new MVCBoardDto();
			dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			RequestDispatcher dispatch = request.getRequestDispatcher("updateform.jsp");
			dispatch.forward(request, response);
		}else if(command.equals("update")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			MVCBoardDto dto = new MVCBoardDto(seq,null,title,content,null);
			int res = biz.update(dto);
			if(res >0){
				String res1="<script>" + 
						"alert('수정 완료');" + 
						"location.href='controller.do?command=selectone&seq="+seq+"';" + 
						"</script>";
				out.println(res1);
			}else {
				String res1="<script type='text/javascript'>" + 
						"alert('수정 실패');" + 
						"history.back();" + 
						"</script>";
			}
		}else if(command.equals("muldel")) {
			String[] seq = request.getParameterValues("chk");
			MVCBoardDao dao = new MVCBoardDao();
			int res = dao.multiDelete(seq);

			if(res > 0){
				String res1="<script>" + 
						"alert('선택 삭제 완료');" + 
						"location.href='controller.do?command=boardlist';" + 
						"</script>";
				out.println(res1);
			}else {
				String res1="<script type=\"text/javascript\">\r\n" + 
						"alert(\"선택 삭제 실패\");\r\n" + 
						"location.href=\"mycontroller.jsp?command=boardlist\";\r\n" + 
						"	</script>";
				out.println(res1);
			}
		}
		//마지막
		out.println("<h1>잘못왔다.</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}

}
