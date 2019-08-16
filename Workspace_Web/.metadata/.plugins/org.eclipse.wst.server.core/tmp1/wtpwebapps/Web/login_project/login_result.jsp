<%@ page import="project.login.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
%>
<!-- Database -->
<%
	MemberDBManager memberDBManager = new MemberDBManager("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
	Member member = memberDBManager.selectMemberByIdPassword(id, password);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
</head>
<body>
	<%
		if (member != null) {
	%>
	
	<!-- Menu -->
	<a href="home.jsp">Home</a> | {로그인}
	<hr width="80%">
		
	로그인에 성공하셨습니다.
	
	<%
		} else {
	%>
	
	<!-- Menu -->
	<a href="index.jsp]">Index</a>
	| {로그인} |
	<a href="account.jsp">회원가입</a>
	<hr width="80%">
	
	로그인에 실패하였습니다.
	<br> 다시 로그인 하세요.
	<br><br>
	<a href="login.jsp">
		<input type="button" value="로그인">
	</a>
	<br><br>
	<%
		}
	%>
	회원정보
	<br><br>
	아이디 : <%=id %>
	<br>
	비밀번호 : <%=password %>
</body>
</html>