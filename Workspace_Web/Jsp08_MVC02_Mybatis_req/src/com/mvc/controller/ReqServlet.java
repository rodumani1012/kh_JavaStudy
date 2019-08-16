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

import com.mvc.biz.MyMVCBiz;
import com.mvc.biz.MyMVCBizImpl;
import com.mvc.dto.MyMVCDto;

@WebServlet(urlPatterns = {"/selectlist","/detail","/insert","/insert_res","/delete","/update_form","/update_res"})
public class ReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MyMVCBiz biz;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		getRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		getRequest(request, response);
	}
	// get방식이든 post방식이든 다 getRequest로 전달.
	/*
 	Read : doGet
 	Create : doPost
 	Update : doPut
 	Delete : doDelete
	 */
	private void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		biz = new MyMVCBizImpl();
		
		String command = request.getRequestURI();
		System.out.println("<" + command + ">");
		
		if (command.endsWith("/selectlist")) {
			doSelectList(request, response);
		} else if (command.endsWith("/detail")) {
			doSelectOne(request, response);
		} else if (command.endsWith("/insert")) {
			doInsert(request, response);
		} else if (command.endsWith("/insert_res")) {
			doInsertRes(request, response);
		} else if (command.endsWith("/delete")) {
			doDeleteOne(request, response);
		} else if (command.endsWith("/update_form")) {
			doUpdateForm(request, response);
		} else if (command.endsWith("/update_res")) {
			doUpdateRes(request, response);
		}
	}

	private void doUpdateRes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MyMVCDto dto = new MyMVCDto();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.update(dto);
		
		if (res > 0) {
			jsResponse("수정 성공!", "detail?seq="+seq, response);
		} else {
			historyBack("수정 실패", response);
		}
	}

	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		MyMVCDto dto = biz.selectOne(seq);
		request.setAttribute("dto", dto);
		dispatch("update_res.jsp", request, response);
	}

	private void doDeleteOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int res = biz.delete(seq);
		
		if (res > 0) {
			jsResponse("글이 삭제되었습니다.", "selectlist", response);
		} else {
			jsResponse("글 삭제 오류", "selectlist", response);
		}
	}

	private void doInsertRes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MyMVCDto dto = new MyMVCDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.insert(dto);
		
		if (res > 0) {
			jsResponse("글 작성 성공!", "selectlist", response);
		} else {
			historyBack("글 작성 실패", response);
		}
	}

	private void doInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("insert.jsp");
	}

	private void doSelectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		MyMVCDto dto = biz.selectOne(seq);
		request.setAttribute("dto", dto);
		dispatch("selectOne.jsp", request, response);
	}

	private void doSelectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MyMVCDto> list = biz.selectList();
		request.setAttribute("list", list);
		dispatch("boardlist.jsp", request, response);
	}
	
	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
	      String res = "<script type='text/javascript'>"+"alert('"+msg+"');"+"location.href='"+url+"';"+"</script>";
	      PrintWriter out = response.getWriter();
	      out.println(res);
	}
	
	public void historyBack(String msg, HttpServletResponse response) throws IOException {
		String res = "<script type='text/javascript'>"+"alert('"+msg+"'); history.back(); </script>";
		PrintWriter out = response.getWriter();
		out.println(res);
	}
}
