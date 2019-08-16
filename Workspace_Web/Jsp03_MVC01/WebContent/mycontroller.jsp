<%@page import="com.mvc.dao.MVCBoardDao"%>
<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<!-- controller의 역할 : 커맨드 값을 읽어서 값에 따른 뷰를 보여주는 역할을 한다. -->
	<!-- client가 request 객체로 server에 요청을 하는데
		서버는 mycontroller.jsp를 forward한 boardlist.jsp를 response객체로 돌려줌 -->
<%
	String command = request.getParameter("command"); //boardlist 문자열 넣어줌
	System.out.println("command : " + command);
	
	MVCBoardBiz biz = new MVCBoardBiz();
	
	if(command.equals("boardlist")) { // command 의 값(boardlist)가 문자열 "boardlist" 와 같은지 비교.
		List<MVCBoardDto> list = biz.selectList();
		request.setAttribute("list", list); // list 파라미터에 List<MVCBoardDto> list = biz.selectList(); 를 넣음
											// 즉, request 객체에 값을 담음(Object 객체로 형변환 된다.)
		
		pageContext.forward("boardlist.jsp"); // forward 때문에 request 값 들고 boardlist로 전송
											// boardlist.jsp?list=List<MVCBoard Dto> list = biz.selectList();
							// 주소창 보면 http://localhost:8787/Jsp03_MVC01/mycontroller.jsp?command=boardlist
							// client가 boardlist.jsp로 인식한게 아닌 mycontroller.jsp로 인식함
		/* 
			forward : request, response가 유지되면서 화면 전환(즉, 그대로 request랑 response를 들고 감)
			redirect : 새로운 request, response(기존것을 안 들고 가고 이동한 창에서 다른 걸로 새로 만듦)
		*/
		
		// redirece : client가 server에 request해서 mycontroller.jsp를 response 해주다가 
			//도중에 request객체를 재생성해서 다른 것(boardwrite.jsp)을 response 해준다.
	} else if(command.equals("boardwriteform")) { // command 의 값(boardwriteform)가 문자열 "boardwriteform" 와 같은지 비교.
		response.sendRedirect("boardwrite.jsp"); // 이전의 request 값은 버리고 boardwrite.jsp로 이동
	} else if(command.equals("boardwrite")) {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto(0,writer,title,content,null); // 0과 null자리는 sequence랑 sysdate로 대체될 거니까.
		
		int res = biz.insert(dto);
		if(res > 0) {
%>
	<script type="text/javascript">
		alert("글 작성 완료");
		location.href="mycontroller.jsp?command=boardlist";
	</script>
<%
		} else {
%>
	<script type="text/javascript">
		alert("글 작성 실패");
		history.back();
	</script>
<%
		}
	} else if(command.equals("selectOne")) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = biz.selectOne(seq);
		
		request.setAttribute("dto", dto);
		pageContext.forward("selectOne.jsp");

	} else if(command.equals("update")) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = biz.selectOne(seq);
		
		request.setAttribute("dto", dto);
		pageContext.forward("update.jsp");
				
	} else if(command.equals("update_res")) {
		int seq = Integer.parseInt(request.getParameter("update"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.update(dto);
		if(res > 0) {
%>
		<script type="text/javascript">
			alert("수정되었습니다!!");
			location.href="mycontroller.jsp?command=selectOne&seq=<%=dto.getSeq()%>";
		</script>	
<%
		} else {
%>	
		<script type="text/javascript">
			alert("수정 실패 ㅜㅠㅠ");
			location.href="mycontroller.jsp?command=update&seq=<%=dto.getSeq()%>"
		</script>
<%
		}
	} else if (command.equals("delete")) {
		String[] seq = new String[1];
		seq[0] = request.getParameter("seq");
		
		int res = biz.multiDelete(seq);
		if(res > 0) {
%>
		<script type="text/javascript">
			alert("삭제 성공!!");
			location.href="mycontroller.jsp?command=boardlist";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("삭제 실패 ㅠㅠ");
			history.back();
		</script>
<%
		}
	} else if (command.equals("muldel")) {
		String[] seq = request.getParameterValues("chk");
		MVCBoardDao dao = new MVCBoardDao();
		int res = dao.multiDelete(seq);
		if(res > 0) {
%>
		<script type="text/javascript">
			alert("체크항목을 삭제하였습니다.")
			location.href="mycontroller.jsp?command=boardlist";
		</script>
<%		
		} else {			
%>
		<script type="text/javascript">
			alert("체크항목 삭제 실패 ㅜㅠ");
			location.href="mycontroller.jsp?command=boardlist";
		</script>	
<%
		}
	}
%>

	<h1>controller. 이 글자가 보이면 안됨!</h1>

</body>
</html>