<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
</head>
<body>
	<a href="home.jsp">Home</a> |
	<a href="logout.jsp">로그아웃</a> | 
	{비밀번호 변경}
	<hr width="80%">
	
	비밀번호 변경이 정상적으로 처리되었습니다. <br><br>
	아이디 : <%=id %><br>
	신규 비밀번호 : <%=password %>


</body>
</html>