<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	text-align: center;
	margin: 0 auto;
	font-size: 25px;
}
	a:link {color:black; text-decoration:none}
	a:visited{color:black; text-decoration:none}
	a:active{color:black; text-decoration:none}
	a:hover{color:blue; text-decoration:none}
</style>
</head>
<body>
	<a href="index.jsp">Index</a> |
	<a href="login.jsp">로그인</a> | 
	{회원가입}
	<hr width="80%">

	회원 가입에 성공하셨습니다.
	<br><br>
	회원 정보
	<br><br>
	아이디 : <%=id %>
	<br>
	패스워드 : <%=password %>
	<br>
	이름 : <%=name %>
	<br>
	Email : <%=email %>
</body>
</html>