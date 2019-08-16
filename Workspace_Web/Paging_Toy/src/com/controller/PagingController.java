package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PageDao;
import com.dto.PagingDto;
import com.util.Paging;

@WebServlet(urlPatterns = { "/board", "/insert", "/delete" })
public class PagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PageDao dao;

	public PagingController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		this.getRequest(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		this.getRequest(request, response);
	}

	private void getRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getRequestURI();
		dao = new PageDao();

		if (command.endsWith("/board")) {
			_board(request, response);
		} else if (command.endsWith("/insert")) {
			_insert(request, response);
		} else if (command.endsWith("/delete")) {
			_delete(request, response);
		}

	}

	private void _delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		dao.delete("A");
		dao.delete("B");
		dao.delete("C");
		
		response.sendRedirect("index.jsp");
		
	}

	private void _insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		for (int i = 0; i < 8; i++) {
			
			dao.insert("A");
			dao.insert("B");
			dao.insert("C");
			
		}
		
		response.sendRedirect("index.jsp");

	}

	private void _board(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String category = request.getParameter("category");
		String txt_search = request.getParameter("txt_search");

		int totalCount = dao.selectTotalCount(category, txt_search);
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

		Paging paging = new Paging();

		paging.setPageNo(page); // get방식의 parameter값으로 반은 page변수, 현재 페이지 번호
		paging.setPageSize(5); // 한페이지에 불러낼 게시물의 개수 지정
		paging.setTotalCount(totalCount);
		page = (page - 1) * paging.getPageSize(); // select해오는 기준을 구한다.

		List<PagingDto> list = dao.selectList(category, page, paging.getPageSize(), txt_search);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.setAttribute("txt_search", txt_search);
		request.setAttribute("category", category);

		switch (category) {
		case "A":
			this.dispatch("Aboard.jsp", request, response);
			break;
		case "B":
			this.dispatch("Bboard.jsp", request, response);
			break;
		case "C":
			this.dispatch("Cboard.jsp", request, response);
			break;

		}

	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);

		dispatch.forward(request, response);
	}

	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String res = "<script type = 'text/javascript'>" + " alert('" + msg + "');" + " location.href='" + url + "';"
				+ "</script>";
		PrintWriter out = response.getWriter();
		out.println(res);
	}

}
