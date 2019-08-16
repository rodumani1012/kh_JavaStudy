<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="bean.jspbasic.Coffee" %>

<%
	Coffee coffee1 = new Coffee("아메리카노", 1500);
	Coffee coffee2 = new Coffee("카페라떼", 2000);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
body {
	text-align: center;
	font-size: 25px;
}
table {
	margin: 0 auto;
}
</style>
<title>Insert title here</title>
</head>
<body>
	커피 정보
	<hr width="80%">
	<table>
		<tr>
			<th>커피명</th>
			<th>가격</th>
		</tr>
		<tr>
			<td><%=coffee1.getName() %></td>
			<td><%=coffee1.getPrice() %></td>
		</tr>
		<tr>
			<td><%=coffee2.getName() %></td>
			<td><%=coffee2.getPrice() %></td>
		</tr>
		
	</table>
	
</body>
</html>