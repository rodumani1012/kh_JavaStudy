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
	LoginDto dto = (LoginDto)request.getAttribute("dto");
%>
	<h1>내 정보 조회</h1>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><%=dto.getMyid() %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=dto.getMypw() %></td>
		</tr>
		<tr>
			<th>이 름</th>
			<td><%=dto.getMyname() %></td>
		</tr>
		<tr>
			<th>주 소</th>
			<td><%=dto.getMyaddr() %></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=dto.getMyphone() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=dto.getMyemail() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="뒤로가기" 
				onclick="location.href='logincontroller.jsp?command=login&myid=<%=dto.getMyid()%>&mypw=<%=dto.getMypw()%>'">
			</td>
		</tr>
	</table>
	
</body>
</html>