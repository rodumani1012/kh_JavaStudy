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
import javax.servlet.http.HttpSession;

import com.mvc.biz.MyMVCBiz;
import com.mvc.biz.MyMVCBizImpl;
import com.mvc.dao.MyMVCDao;
import com.mvc.dao.MyMVCDaoImpl;
import com.mvc.dto.MyMVCDto;

@WebServlet("/MyMVCController")
public class MyMVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String command = request.getParameter("command");
		System.out.printf("[%s]\n", command);

		MyMVCBiz biz = new MyMVCBizImpl();

		if (command.equals("usebean")) {
			response.sendRedirect("usebeantest.jsp"); // 새로 요청하였기 때문에 주소창에 usebeantest가 나옴
			//전체 목록
		} else if (command.equals("list")) {
			List<MyMVCDto> list = biz.selectList();
			request.setAttribute("list", list);
			dispatch(request, response, "boardlist.jsp");
			//게시글 보기
		} else if (command.equals("selectOne")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MyMVCDto dto = biz.selectOne(seq);
			request.setAttribute("dto", dto);
			dispatch(request, response, "selectOne.jsp");
			// 글작성
		} else if (command.equals("insert")) {
			response.sendRedirect("insert.jsp");
		} else if (command.equals("insert_res")) {
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			MyMVCDto dto = new MyMVCDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			int res = biz.insert(dto);
			if(res > 0) {
				out.println("<script>"
						+ "alert('글 작성 완료');"
						+ "location.href='controller.do?command=list';"
						+ "</script>");
			} else {
				out.println("<script>"
						+ "alert('글 작성 실패 ㅠㅠ');"
						+ "history.back();"
						+ "</script>");
			}
			// 글 수정
		} else if (command.equals("updateform")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MyMVCDto dto = biz.selectOne(seq);
			request.setAttribute("dto", dto);
			dispatch(request, response, "update_res.jsp");
		} else if (command.equals("update_res")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			MyMVCDto dto = new MyMVCDto();
			dto.setSeq(seq);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = biz.update(dto);
			
			if(res > 0) {
				out.println("<script>"
						+ "alert('수정 완료!!');"
						+ "location.href='controller.do?command=selectOne&seq=" + seq + "';"
						+ "</script>");
			} else {
				out.println("<script>"
						+ "alert('수정 실패 ㅠㅠ');"
						+ "history.back();"
						+ "</script>");
			}
			//글 삭제
		} else if (command.equals("delete")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			int res = biz.delete(seq);
			
			if(res > 0) {
//				out.println("<script>"
//						+ "alert('글이 삭제되었습니다.');"
//						+ "location.href='controller.do?command=list';"
//						+ "</script>");
				isResponse("글이 삭제되었습니다.", "controller.do?command=list", response);
			} else {
				out.println("<script>"
						+ "alert('삭제 실패 ㅠㅠ');"
						+ "location.href='controller.do?command=selectOne&seq=" + seq + "';"
						+ "</script>");
			}
		}
		
		out.println("<h1>잘못왔다.</h1>");
		out.println("<a href='controller.do?command=list'>리스트로 돌아가기</a>");
	}

	// dispatch 메소드
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	public void isResponse(String msg, String url, HttpServletResponse response) throws IOException {
	      String res = "<script type='text/javascript'>"+"alert('"+msg+"');"+"location.href='"+url+"';"+"</script>";
	      PrintWriter out = response.getWriter();
	      out.println(res);
	}
}
