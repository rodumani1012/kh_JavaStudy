package pagingController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paging.Paging;
import pagingDao.pagingBoardDao;
import pagingDao.pagingMemberDao;
import pagingDto.pagingBoardDto;
import pagingDto.pagingMemberDto;


@WebServlet("/paging.do")
public class pagingcontroller extends HttpServlet {
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
		
		System.out.println("<"+command+">");
		
		pagingMemberDto dto = null;
		
		pagingMemberDao login_dao = new pagingMemberDao();
		pagingBoardDao paging_dao = new pagingBoardDao();
		
		if(command.equals("login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			System.out.println(id + " : " + pw);
			
						
			if((dto = login_dao.login(id, pw)) != null) {
				request.getSession().setAttribute("member", dto);

				jsResponse("환영합니다", "paging.do?command=boardlist",response);
			} else {
				jsResponse("아이디가 없습니다.", "history.back()",response);
			}
			
		} else if (command.equals("boardlist")) {
			int page = 1; // 기본값 1을 준다.
			
			//	원하는 페이지에서 페이지값을 불러온다. 없을 경우 1로 저장
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			Paging paging = new Paging();	//	페이징 클래스 호출
			paging.setPage(page);			//	페이징 클래스에 현재 페이지번호 저장
			int count = paging_dao.getAllcount();	//	페이지 총 수를 계산
			
			paging.setTotalCount(count);		//	페이징 클래스에 총 페이지수 저장
			
			List<pagingBoardDto> list = paging_dao.boardlist(page);	//	현재 페이지 글 목록 저장
			
			request.setAttribute("list", list);
			request.setAttribute("paging", paging);
			
			dispatch("board/board.jsp",request,response);
			
		} else if(command.equals("pagingpagelist")) {
			int page = 1;
			
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			int count = paging_dao.getAllcount();
			paging.setTotalCount(count);
			
			List<pagingBoardDto> list = paging_dao.boardlist(page);
		
			
			request.setAttribute("list", list);
			request.setAttribute("paging", paging);
			
			dispatch("board/board.jsp",request,response);
	
			
		} else if (command.equals("writepages")) {
			if( (paging_dao.insertpage())>0 ) {
				jsResponse("글 추가 완료", "paging.do?command=boardlist", response);
			} else {
				jsResponse("글 추가 실패", "history.back()", response);
			}
		}
		
	}
	
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();

		if (url.contains("history.back()")) {
			String res = "<script type='text/javascript'>" + "alert('" + msg + "');" + url + ";\n" + "</script>";
			out.println(res);
		} else {
			String res = "<script type='text/javascript'>" + "alert('" + msg + "');" + "location.href='" + url + "';"
					+ "</script>";
			out.println(res);
		}
	}

}
