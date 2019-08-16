<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="bean.jspbasic.Item" %>


<%
	Item item1 = new Item("커피믹스", 10);
	Item item2 = new Item("사과", 25);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	text-align: center;
	font-size: 25px;
}
table {
	margin: 0 auto;
	border: 1px solid #000000;
	border-collapse: collapse;
}
th {	
	padding: 5px 10px;
	border: 1px gray solid;	
	background-color: #D5DBDB;
}
tr {
	padding: 5px 10px;
	border: 1px solid #000000;
}
td {
	padding: 5px 10px;
	border: 1px solid #000000;
}
</style>
</head>
<body>
	주문 정보
	<hr width="80%">
	<table>
		<tr>
			<th>상품명</th>
			<th>주문개수</th>
		</tr>
		<tr>
			<td><%=item1.getName() %></td>
			<td><%=item1.getCount() %></td>
		</tr>
		<tr>
			<td><%=item2.getName() %></td>
			<td><%=item2.getCount() %></td>
		</tr>
	</table>

</body>
</html>