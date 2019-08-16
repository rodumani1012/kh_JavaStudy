<%@page import="com.login.dto.LoginDto"%>
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
	LoginDto dto = (LoginDto)session.getAttribute("dto");
%>
	<div>
		<span><%=dto.getMyname() %>님 환영합니다 (등급 : <%=dto.getMyrole() %>)</span>
		<a href="logincontroller.jsp?command=logout">로그아웃</a>
	</div>
	
	<div>
		<a href="logincontroller.jsp?command=myinfo&myno=<%=dto.getMyno()%>">내 정보 조회</a>
		&nbsp;/&nbsp;
		<a href="logincontroller.jsp?command=myupdate&myno=<%=dto.getMyno()%>">내 정보 수정</a>
		&nbsp;/&nbsp;
		<a href="logincontroller.jsp?command=delete&myno=<%=dto.getMyno()%>">회원 탈퇴</a>
	</div>

</body>
</html>