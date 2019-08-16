<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
<script>
	function alertLogin() {
		alert("로그인 후 이용하세요.")
	}
</script>
</head>
<body>
	{Index} |
	<a href="login.jsp">로그인</a> | 
	<a href="account.jsp">회원가입</a>
	<hr width="80%">
	
	<img src="../image/index.png" onclick="alertLogin()">
</body>
</html>