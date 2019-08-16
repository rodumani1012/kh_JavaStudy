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
	<a href="home.jsp">Home</a> |
	<a href="logout.jsp">로그아웃</a> | 
	{비밀번호 변경}
	<hr width="80%">

	<form action="update_pw_result.jsp" method="post">
	<label for="userId">아이디 : </label>
	<input type="text" size="20" name="id" id="userId" maxlength="20" required>
	<br>
	<label for="userPassword">변경 비밀번호 : </label>
	<input type="password" size="20" name="password" id="userPassword" maxlength="15" required>
	<br><br>
	<input type="submit" value="변경">
	<input type="reset" value="취소">
	</form>
</body>
</html>