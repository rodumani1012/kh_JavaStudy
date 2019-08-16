<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project.login.*" %>

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
	boolean updateYn = memberDBManager.updateMemberPassword(id, password);
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
	
	<%
		if (updateYn) {
	%>
	비밀번호 변경이 정상적으로 처리되었습니다.	
	<br><br>
	아이디 : <%=id %><br>
	신규 비밀번호 : <%=password %>
	<%
		} else {
	%>
	잘못 된 아이디 입니다.<br>
	비밀번호 변경이 실패하였습니다.
	<br><br>
	다시 진행해 주세요.
	<%
		}
	%>


</body>
</html>