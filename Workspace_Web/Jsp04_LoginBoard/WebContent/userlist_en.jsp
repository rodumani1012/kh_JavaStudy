<%@page import="com.login.dto.LoginDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function updateRole(myno) {
		location.href="logincontroller.jsp?command=updateroleform&myno="+myno;
	}
</script>
</head>
<body>
<%
	List<LoginDto> list = (List<LoginDto>)request.getAttribute("list");
%>
	<h1>회원정보 조회(myenabled='y')</h1>
	
	<table border="1">
		<col width="50">
		<col width="100">
		<col width="100">
		<col width="50">
		<col width="100">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>등급</th>
			<th>등급 변경</th>
		</tr>
<%
		for(LoginDto dto : list) {
%>
			<tr>
				<td><%=dto.getMyno() %></td>
				<td><%=dto.getMyid() %></td>
				<td><%=dto.getMyname() %></td>
				<td><%=dto.getMyrole() %></td>
				<td><button onclick="updateRole(<%=dto.getMyno()%>)">변경</button></td>
			</tr>
<%
		}
%>
		<tr>
			<td colspan="5">
				<input type="button" value="메인" onclick="location.href='adminmain.jsp'">
			</td>
		</tr>
	</table>

</body>
</html>