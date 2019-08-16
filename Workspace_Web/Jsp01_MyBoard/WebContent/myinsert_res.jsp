<%@page import="com.my.dto.MyBoardDto"%>
<%@page import="com.my.dao.MyBoardDao"%>
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

<%
	String myname = request.getParameter("myname");
	String mytitle = request.getParameter("mytitle");
	String mycontent = request.getParameter("mycontent");
	
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = new MyBoardDto();
	dto.setMyname(myname);
	dto.setMytitle(mytitle);
	dto.setMycontent(mycontent);
	
	int res = dao.insert(dto);
	
	if(res > 0) {
%>
	<script type="text/javascript">
		alert("입력 완료!!")
		location.href="myboard.jsp";
	</script>
<%
	} else {
%>
	<script type="text/javascript">
		alert("입력 실패 ㅠㅠ")
		location.href="myinsert.jsp";
	</script>
<%
	}
%>

</body>
</html>