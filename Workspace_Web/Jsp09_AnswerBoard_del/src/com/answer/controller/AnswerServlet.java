package com.answer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer.biz.AnswerBiz;
import com.answer.biz.AnswerBizImpl;
import com.answer.dto.AnswerDto;

@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		AnswerBiz biz = new AnswerBizImpl();
		PrintWriter out = response.getWriter();
		
		String command = request.getParameter("command");
		System.out.println("<" + command + ">");
		
		// 글 목록
		if (command.equals("list")) {
			List<AnswerDto> list = biz.selectList();
			request.setAttribute("list", list);
			dispatch("boardlist.jsp", request, response);
			//글 상세보기
		} else if (command.equals("boarddetail")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch("boarddetail.jsp", request, response);
			// 글쓰기
		} else if (command.equals("insertBoard")) {
			response.sendRedirect("insertboard.jsp");
		} else if (command.equals("insertBoard_res")) {
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			AnswerDto dto = new AnswerDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			
			boolean res = biz.insertBoard(dto);
			if(res) {
				jsResponse("글이 작성되었습니다.", "answer.do?command=list", response);
			} else {
				jsResponse("글 작성 실패", "#", response);
				out.println("<script>history.back();</script>");
			}
			// 글 수정
		} else if (command.equals("updateform")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch("updateform.jsp", request, response);
		} else if (command.equals("update_res")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			AnswerDto dto = new AnswerDto();
			dto.setBoardno(boardno);
			dto.setTitle(title);
			dto.setContent(content);
			
			boolean res = biz.updateBoard(dto);
			if (res) {
				jsResponse("수정되었습니다!", "answer.do?command=boarddetail&boardno="+boardno, response);
			} else {
				jsResponse("수정 실패", "#", response);
				out.println("<script>history.back();</script>");
			}
			// 삭제
		} else if (command.equals("delete")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			boolean res = biz.delete(boardno);
			if (res) {
				jsResponse("삭제되었습니다!", "answer.do?command=list", response);
			} else {
				jsResponse("삭제 실패!!", "answer.do?command=boarddetail&boardno="+boardno, response);
			}
			// 답변 달기
		} else if (command.equals("answerform")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch("answer.jsp", request, response);
		} else if (command.equals("answer_res")) {
			int parentboardno = Integer.parseInt(request.getParameter("parentboardno"));
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			AnswerDto dto = new AnswerDto();
			dto.setBoardno(parentboardno);
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			
			boolean res = biz.answerProc(dto);
			if(res) {
				jsResponse("댓글 작성 성공", "answer.do?command=list", response);
			} else {
				jsResponse("댓글 작성 실패", "#", response);
				out.println("<script>history.back();</script>");
			}
		}
	}
	
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String res = "<script type='text/javascript'>alert('"+ msg +"'); location.href='"+ url + "';</script>";
		PrintWriter out = response.getWriter();
		out.println(res);
	}

}
