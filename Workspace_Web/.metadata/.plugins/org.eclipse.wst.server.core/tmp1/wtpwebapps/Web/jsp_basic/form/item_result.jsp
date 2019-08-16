<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% 
	String itemName = request.getParameter("name");
	String itemCount = request.getParameter("count");
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
	<table>
		<tr>
			<th>상품명</th>
			<th>주문개수</th>
		</tr>		
		<tr>
			<td><%=itemName %></td>
			<td><%=itemCount %></td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<a href="item_form.jsp">[ 홈 ]</a>
	
</body>
</html>