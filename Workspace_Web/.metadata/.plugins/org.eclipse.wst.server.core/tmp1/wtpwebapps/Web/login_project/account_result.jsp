<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project.login.*" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	Member member = new Member(id, password, name, email);
%>
<!-- Database -->
<%
	MemberDBManager memberDBManager = new MemberDBManager("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
	boolean insertResult = memberDBManager.insertMember(member);
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
	
	<%
		if (insertResult) {
	%>
	회원 가입에 성공하셨습니다.
	<%
		} else {
	%>
	회원 가입에 실패하였습니다.
	<br>다시 가입하세요.
	<br>
	<br>
	<a href="account.jsp">
		<input type="button" value="회원가입">
	</a>
	<%
		}
	%>
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