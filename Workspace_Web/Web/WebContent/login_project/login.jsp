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
</head>
<body>
	<a href="index.jsp">Index</a> |
	{로그인} | 
	<a href="account.jsp">회원가입</a>
	<hr width="80%">
	
	<form action="login_result.jsp" method="post">
	<label for="userId">아이디 : </label>
	<input type="text" size="20" name="id" id="userId" maxlength="20" required>
	<br>
	<label for="userPassword">패스워드 : </label>
	<input type="password" size="20" name="password" id="userPassword" maxlength="15" required>
	<br><br>
	<input type="submit" value="로그인">
	<input type="reset" value="취소">
	</form>
	
</body>
</html>