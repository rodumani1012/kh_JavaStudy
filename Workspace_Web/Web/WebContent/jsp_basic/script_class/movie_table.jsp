<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="bean.jspbasic.Movie" %>

<% Movie m1 = new Movie("신과함께-인과연", "판타지", "김용화", 141); %>
<% Movie m2 = new Movie("맘마미아", "뮤지컬", "올 파커", 120); %>

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
	영화 정보
	<hr width="80%">
	<table>
		<tr>
			<th>카테고리</th>
			<th>제목</th>
			<th>감독</th>
			<th>상영시간(분)</th>
		</tr>
		<tr>
			<td><%=m1.getCategory() %></td>
			<td><%=m1.getTitle() %></td>
			<td><%=m1.getDirector() %></td>
			<td><%=m1.getRunningTime() + "분" %></td>
		</tr>
		<tr>
			<td><%=m2.getCategory() %></td>
			<td><%=m2.getTitle() %></td>
			<td><%=m2.getDirector() %></td>
			<td><%=m2.getRunningTime() + "분" %></td>
		</tr>
	</table>
</body>
</html>