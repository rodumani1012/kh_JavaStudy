<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/datacss.css"> 
</head>
<body>
	<!-- method : post -->
	Post 방식
	<br>
	<form action="form_method_result.jsp" method="post">
		아이디 : <input type="text" name="id" required><br>
		패스워드 : <input type="password" name="password" required><br><br>
		<input type="submit" value="전송">
		<input type="reset" value="다시입력">
	</form>
	<br>
	<br>
</body>
</html>