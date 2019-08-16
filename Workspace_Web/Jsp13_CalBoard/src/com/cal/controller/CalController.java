package com.cal.controller;

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

import com.cal.dao.CalDao;
import com.cal.dto.CalDto;
import com.cal.util.Util;

@WebServlet("/CalController")
public class CalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("<" + command + ">");
		
		PrintWriter out = response.getWriter();
		CalDao dao = new CalDao();
			
			// 달력보기
		if (command.equals("calendar")) {
			response.sendRedirect("calendar.jsp");
			// 일정 추가
		} else if (command.equals("insertCal")) {
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
			String hour = request.getParameter("hour");
			String min = request.getParameter("min");

			String id = request.getParameter("id");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			// mdate = 0000 00 00 00 00  12자리의 년, 월, 일, 시, 분이 합쳐진 변수  
			String mdate = year + Util.isTwo(month) + Util.isTwo(date) + Util.isTwo(hour) + Util.isTwo(min);
			
			CalDto dto = new CalDto(0, id, title, content, mdate, null);
			
			int res = dao.insert(dto);
			if(res > 0) {
				response.sendRedirect("calendar.do?command=calendar");
			} else {
				request.setAttribute("msg", "일정 추가 실패");
				dispatch("error.jsp", request, response);
			}
			// 일정 목록보기
		} else if (command.equals("callist")) {
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
			
			String yyyyMMdd = year + Util.isTwo(month) + Util.isTwo(date);
			
			List<CalDto> list = dao.selectList("kh", yyyyMMdd);
			
			request.setAttribute("list", list);
			dispatch("callist.jsp", request, response);
			// 글 상세보기
		} else if (command.equals("caldetail")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			CalDto dto = dao.selectOne(seq);
			
			request.setAttribute("dto", dto);
			dispatch("caldetail.jsp", request, response);
			// 일정 수정
		} else if (command.equals("update")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			CalDto dto = dao.selectOne(seq);
			
			request.setAttribute("dto", dto);
			dispatch("calupdate.jsp", request, response);
		} else if(command.equals("update_res")) {
	         int seq = Integer.parseInt(request.getParameter("seq"));
	         String title = request.getParameter("title");
	         String content = request.getParameter("content");
	         
	         CalDto dto = new CalDto();
	         dto.setSeq(seq);
	         dto.setTitle(title);
	         dto.setContent(content);
	         
	         int res = dao.update(dto);
	         
	         if(res > 0) {
	        	 jsResponse("수정 완료", "calendar.do?command=caldetail&seq=" + seq, response);
	         } else {
				jsResponse("수정 실패", "#", response);
				out.println("<script>history.back();</script>");
	         }
	         // 단일 일정 삭제
	    } else if (command.equals("delete")) {
	    	int seq = Integer.parseInt(request.getParameter("seq"));
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
	    	
	    	int res = dao.delete(seq);
	    	if(res > 0) {
	    		jsResponse("삭제 완료", "calendar.do?command=callist&year="+year+"&month="+month+"&date="+date, response);
	    	} else {
	    		jsResponse("삭제 실패", "calendar.do?command=callist&year="+year+"&month="+month+"&date="+date, response);
	    	}
	    	// 체크 삭제
	    } else if (command.equals("muldel")) {
	    	String mdate = request.getParameter("mdate"); 
	    	String year = mdate.substring(0, 4);
	    	String month = mdate.substring(4, 6);
	    	String date = mdate.substring(6, 8);
	    	
	    	String[] seq = request.getParameterValues("chk");
	    	
	    	int res = dao.muldel(seq);
	    	
	    	if(res > 0) {
	    		jsResponse("체크된 글 삭제 완료", "calendar.do?command=callist&year="+year+"&month="+month+"&date="+date, response);
	    	} else {
	    		jsResponse("체크된 글 삭제 실패", "calendar.do?command=callist&year="+year+"&month="+month+"&date="+date, response);
	    	}
	    }
	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String res = "<script type='text/javascript'>alert('"+ msg +"'); location.href='"+ url + "';</script>";
		PrintWriter out = response.getWriter();
		out.println(res);
	}
}
