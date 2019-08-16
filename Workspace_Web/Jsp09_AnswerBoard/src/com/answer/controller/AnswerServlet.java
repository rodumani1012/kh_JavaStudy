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

@WebServlet("/answer.do")
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
		
		PrintWriter out = response.getWriter();
		
		String command = request.getParameter("command");
		System.out.println("<" + command + ">");
		
		AnswerBiz biz = new AnswerBizImpl();
		
		// 게시판 목록 보기
		if (command.equals("list")) {
			List<AnswerDto> list = biz.selectList();
			request.setAttribute("list", list);
			
			dispatch("boardlist.jsp", request, response);
			//게시판 글 상세 보기
		} else if (command.equals("boarddetail")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch("boarddetail.jsp", request, response);
			//글 쓰기
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
			
			int res = biz.insertBoard(dto);
			if (res > 0) {
				out.println("<script>"
						+ "alert('글이 작성되었습니다.');"
						+ "location.href='answer.do?command=list';"
						+ "</script>");							
			} else {
				out.println("<script>"
						+ "alert('글 작성 실패 ㅠㅠ');"
						+ "history.back();"
						+ "</script>");					
			}
			//게시글 수정
		} else if (command.equals("updateBoard")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch("boardupdate.jsp", request, response);
		} else if (command.equals("updateBoard_res")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			AnswerDto dto = new AnswerDto();
			dto.setBoardno(boardno);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = biz.updateBoard(dto);
			if (res > 0) {
				out.println("<script>"
						+ "alert('글이 수정되었습니다.');"
						+ "location.href='answer.do?command=boarddetail&boardno=" + boardno + "';"
						+ "</script>");				
			} else {
				out.println("<script>"
						+ "alert('수정 실패 ㅠㅠ');"
						+ "history.back();"
						+ "</script>");		
			}
			// 게시글 삭제
		} else if (command.equals("delete")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			int res = biz.delete(boardno);
			if (res > 0) {
				out.println("<script>"
						+ "alert('글이 삭제되었습니다.');"
						+ "location.href='answer.do?command=list';"
						+ "</script>");
			} else {
				out.println("<script>"
						+ "alert('삭제 실패 ㅠㅠ');"
						+ "location.href='answer.do?command=boarddetail&boardno=" + boardno + "';"
						+ "</script>");				
			}
			// 답변 작성
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
			
			int res = biz.answerProc(dto);
			System.out.println(res);
			if (res > 0) {
				out.println("<script>"
						+ "alert('댓글이 작성되었습니다.');"
						+ "location.href='answer.do?command=list';"
						+ "</script>");
			} else {
				out.println("<script>"
						+ "alert('댓글 작성 실패 ㅠㅠ');"
						+ "history.back();"
						+ "</script>");				
			}
		}
	}
	
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
