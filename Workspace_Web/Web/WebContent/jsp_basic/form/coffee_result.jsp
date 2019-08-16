<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% 
	String coffeeName = request.getParameter("name");
	String coffeePrice = request.getParameter("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
<title>Insert title here</title>
</head>
<body>
	전송 결과
	<hr width="80%">
	<table>
		<tr>
			<th>커피명</th>
			<th>가격</th>
		</tr>		
		<tr>
			<td><%=coffeeName %></td>
			<td><%=coffeePrice %></td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<a href="coffee_form.jsp">[ 홈 ]</a>
	
</body>
</html>