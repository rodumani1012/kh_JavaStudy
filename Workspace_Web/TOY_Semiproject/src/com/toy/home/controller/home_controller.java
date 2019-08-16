package com.toy.home.controller;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.home.biz.home_biz;
import com.toy.home.biz.home_bizimpl;
import com.toy.home.dto.comment_board_dto;
import com.toy.home.dto.normal_board_dto;
import com.toy.home.dto.user_info_dto;
import com.toy.home.kakaopay.HttpURLConnectionKakao;
import com.toy.util.Paging;

@WebServlet("/home_controller")
public class home_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public home_controller() {

	}

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
		home_biz biz = new home_bizimpl();

		if (command.equals("board_list")) {
			String normal_category = request.getParameter("normal_category");
			String txt_search = request.getParameter("txt_search");

			int totalCount = biz.getTotalCount(normal_category, txt_search);
			int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

			Paging paging = new Paging();
			paging.setPageNo(page); // get방식의 parameter값으로 반은 page변수, 현재 페이지 번호
			paging.setPageSize(3); // 한페이지에 불러낼 게시물의 개수 지정
			paging.setTotalCount(totalCount);
			page = (page - 1) * paging.getPageSize(); // select해오는 기준을 구한다.

			List<normal_board_dto> list = biz.selectList(normal_category, page, paging.getPageSize(), txt_search);
			request.setAttribute("list", list);
			request.setAttribute("paging", paging);
			request.setAttribute("txt_search", txt_search);
			request.setAttribute("normal_category", normal_category);

			switch (normal_category) {
			case "FREE":
				dispatch("home/board/board_free_list.jsp", request, response);
				break;

			case "CREW":
				dispatch("home/board/board_crew_list.jsp", request, response);
				break;

			case "QA":
				dispatch("home/board/board_qa_list.jsp", request, response);
				break;
			}

			// 상세글보기
		} else if (command.equals("board_detail")) {
			int normal_num = Integer.parseInt(request.getParameter("normal_num"));
			// 조회수 증가처리
			biz.plusReadCount(normal_num);

			normal_board_dto dto = biz.selectOne(normal_num);
			List<comment_board_dto> list = biz.comment_list(normal_num);

			request.setAttribute("normal_board_dto", dto);
			request.setAttribute("comment_board_dto", list);

			dispatch("home/board/board_detail.jsp", request, response);

			// update
		} else if (command.equals("board_updateform")) {
			int normal_num = Integer.parseInt(request.getParameter("normal_num"));
			normal_board_dto dto = biz.selectOne(normal_num);

			request.setAttribute("normal_board_dto", dto);
			dispatch("home/board/board_update.jsp", request, response);

		} else if (command.equals("board_update")) {
			int normal_num = Integer.parseInt(request.getParameter("normal_num"));
			String user_nickname = request.getParameter("user_nickname");
			String normal_title = request.getParameter("normal_title");
			String normal_content = request.getParameter("normal_content");
			String normal_category = request.getParameter("normal_category");

			normal_board_dto dto = new normal_board_dto();

			dto.setNormal_num(normal_num);
			dto.setUser_nickname(user_nickname);
			dto.setNormal_title(normal_title);
			dto.setNormal_content(normal_content);
			// dto.setNormal_date_update(normal_date_update);//date 타입인데
			int res = biz.update(dto);

			switch (normal_category) {

			case "FREE":
				if (res > 0) {
					jsResponse("수정성공", "home.do?command=board_list&normal_category=" + normal_category, response);
				} else {
					jsResponse("수정실패", "home.do?command=board_update&normal_num=" + normal_num, response);
				}
				break;
			case "CREW":
				if (res > 0) {
					jsResponse("수정 성공", "home.do?command=board_list&normal_category=" + normal_category, response);
				} else {
					jsResponse("수정 실패", "home.do?command=board_update&normal_num=" + normal_num, response);
				}
				break;
			case "QA":
				if (res > 0) {
					jsResponse("수정 성공", "home.do?command=qa_list&normal_category=" + normal_category, response);
				} else {
					jsResponse("수정 실패", "home.do?command=qa_update&normal_num=" + normal_num, response);
				}
				break;
			}

			// delete
		} else if (command.equals("board_delete")) {
			int normal_num = Integer.parseInt(request.getParameter("normal_num"));
			String normal_category = request.getParameter("normal_category");

			int res = biz.delete(normal_num);

			switch (normal_category) {
			case "FREE":
				if (res > 0) {
					jsResponse("삭제성공", "home.do?command=board_list&normal_category=" + normal_category, response);
				} else {
					jsResponse("삭제실패", "home.do?command=board_detail&normal_num=" + normal_num, response);
				}
				break;

			case "CREW":
				if (res > 0) {
					jsResponse("삭제성공", "home.do?command=board_list&normal_category=" + normal_category, response);
				} else {
					jsResponse("삭제실패", "home.do?command=board_detail&normal_num=" + normal_num, response);
				}
				break;
			case "QA":
				if (res > 0) {
					jsResponse("삭제성공", "home.do?command=qa_list&normal_category=" + normal_category, response);
				} else {
					jsResponse("삭제실패", "home.do?command=board_detail&normal_num=" + normal_num, response);
				}
				break;
			}

		} else if (command.equals("board_insert")) {
			String user_nickname = request.getParameter("user_nickname");
			String user_num = request.getParameter("user_num");
			String normal_title = request.getParameter("normal_title");
			String normal_content = request.getParameter("normal_content");
			String normal_category = request.getParameter("normal_category");

			Map<String, String> map = new HashMap<String, String>();
			map.put("user_nickname", user_nickname);
			map.put("user_num", user_num);
			map.put("normal_title", normal_title);
			map.put("normal_content", normal_content);
			map.put("normal_category", normal_category);

			int res = biz.insert(map);

			if (res > 0) {
				switch (normal_category) {
				case "FREE":
					jsResponse("글 작성 성공", "home.do?command=board_list&normal_category=" + normal_category, response);
					break;
				case "CREW":
					jsResponse("글 작성 성공", "home.do?command=board_list&normal_category=" + normal_category, response);
					break;
				case "QA":
					jsResponse("글 작성 성공", "home.do?command=board_list&normal_category=" + normal_category, response);
					break;
				}

			} else {
				jsResponse("글 작성 실패", "home.do?command=insertform", response);
			}

		} else if (command.equals("insertform")) {

			String normal_category = request.getParameter("normal_category");
			response.sendRedirect("home/board/board_insert.jsp?normal_category=" + normal_category);

		} else if (command.equals("comment_insert")) {
			// 사용자가 입력한 댓글 내용을 dto에 저장
			user_info_dto dto = (user_info_dto) request.getSession().getAttribute("user_info_dto");
			Map<String, String> map = new HashMap<String, String>();
			String normal_num = request.getParameter("normal_num");
			map.put("comment_content", request.getParameter("comment_content"));
			map.put("normal_num", normal_num);
			map.put("user_num", dto.getUser_num() + "");
			map.put("user_nickname", dto.getUser_nickname());

			int res = biz.comment_insert(map);

			if (res > 0) {
				this.jsResponse("댓글 작성 성공", "home.do?command=board_detail&normal_num=" + normal_num, response);
			} else {
				this.jsResponse("댓글 작성 실패", "home.do?command=board_detail&normal_num=" + normal_num, response);
			}

		} else if (command.equals("comment_comment")) {
			// 댓글에 댓글 달기
			String comment_num = request.getParameter("comment_num");
			String normal_num = request.getParameter("normal_num");
			user_info_dto dto = (user_info_dto) request.getSession().getAttribute("user_info_dto");
			Map<String, String> map = new HashMap<String, String>();
			map.put("normal_num", normal_num);
			map.put("user_num", dto.getUser_num() + "");
			map.put("user_nickname", dto.getUser_nickname());
			map.put("comment_comment", request.getParameter("comment_comment"));
			map.put("comment_num", comment_num);

			int res = biz.comment_comment(map);

			if (res > 0) {
				this.jsResponse("댓글 작성 성공", "home.do?command=board_detail&normal_num=" + normal_num, response);
			} else {
				this.jsResponse("댓글 작성 실패", "home.do?command=board_detail&normal_num=" + normal_num, response);
			}

		} else if (command.equals("comment_delete")) {
			int res = biz.comment_delete(Integer.parseInt(request.getParameter("comment_num")));
			String normal_num = request.getParameter("normal_num");

			if (res > 0) {
				this.jsResponse("댓글 작성 성공", "home.do?command=board_detail&normal_num=" + normal_num, response);
			} else {
				this.jsResponse("댓글 작성 실패", "home.do?command=board_detail&normal_num=" + normal_num, response);
			}
		} else if (command.equals("kakaopay")){
			
			
//			// 객체 생성 및 함수 실행
//			try {
//				HashMap<String, String> responseBody = new HttpURLConnectionKakao().readyToPay();
//				response.sendRedirect(responseBody.get("next_redirect_pc_url"));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			int normal_num = Integer.parseInt(request.getParameter("normal_num"));
			String normal_premium = request.getParameter("normal_premium");
			System.out.println(normal_premium);
			normal_board_dto dto = new normal_board_dto();
			dto.setNormal_num(normal_num);
			dto.setNormal_premium(normal_premium);
			
			int res = biz.kakaopay(dto);
			System.out.println(res);
			if(res>0) {
				System.out.println("111");
				out.println("success");
				//jsResponse("결제성공", "home.do?command=insertform&normal_category=CREW", response);
			} else {
				//jsResponse("결제실패", "home.do?command=board_list&normal_category=CREW", response);
			}
		} else if(command.equals("home_error")) {
			jsResponse("로그인 후 이용해 주세요!", "home/member/member_login.jsp", response);
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
	
	public void jsAlert(String msg, HttpServletResponse response) throws IOException {
	      String res = "<script type='text/javascript'>alert('" + msg + "');</script>";

	      PrintWriter out = response.getWriter();
	      out.print(res);
	   }

}