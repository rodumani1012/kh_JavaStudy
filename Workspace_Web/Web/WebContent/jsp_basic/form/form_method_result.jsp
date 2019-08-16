<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8"); //한글 처리
%>
<%
	String requestId = request.getParameter("id");
	String requestPassword = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/datacss.css"> 
</head>
<body>
	전송 결과
	<hr width="80%">
	아이디 : <%=requestId%><br>
	패스워드 : <%=requestPassword%><br><br>
	<a href="form_method.jsp">[ 홈 ]</a>
</body>
</html>