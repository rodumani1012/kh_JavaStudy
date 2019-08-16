package com.board.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;
import com.page.dto.PageMaker;


@WebServlet("/boardController")
public class boardController extends HttpServlet {
      

	public boardController() {
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
	    String command = request.getParameter("command");
	    System.out.println("<" + command + ">");
	    
	    BoardDao dao = new BoardDao();
	    
	    if(command.equals("selectlist")) {
	    	 int pagenum = Integer.parseInt(request.getParameter("pagenum"));//현재페이지
	         int contentnum = Integer.parseInt(request.getParameter("contentnum"));//한페이지에 보이는 게시글 갯수
	         System.out.println("page:"+pagenum+"content:"+contentnum);
	         
	         int totalcount = dao.getTotalCount(); //게시물 전체 갯수 가져오기 
	         System.out.println("토탈갯수는"+totalcount);
	         PageMaker pag = new PageMaker(totalcount,pagenum,contentnum);     
	         System.out.println("시작끝"+pag.getStartCon()+"/"+pag.getEndCon());
	       
	         List<BoardDto> list = dao.selectList(pag.getStartCon(), pag.getEndCon());
	         
	         request.setAttribute("list", list);
	         request.setAttribute("pag", pag);
	         
	         dispatch(request, response, "boardlist.jsp");
	    }else if(command.equals("insertDB")) {
	    	int res =dao.insertData();
	         int contentnum = Integer.parseInt(request.getParameter("contentnum"));//한페이지에 보이는 게시글 갯수
	    	 int totalcount = dao.getTotalCount();
	         PageMaker pag = new PageMaker(totalcount,1,contentnum);    
	         if(res>0) {
	    		System.out.println("데이터추가됐슈");
	    		response.sendRedirect("boardController.do?command=selectlist&contentnum=3&pagenum="+pag.calcpage(totalcount, contentnum));
	    	}
	    }

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}
	public void dispatch(HttpServletRequest request,HttpServletResponse response,String url) throws ServletException, IOException {
		
		RequestDispatcher dispatch=request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

}
