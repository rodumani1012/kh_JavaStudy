<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String[] arrayObj = new String[3];
	arrayObj[0] = "A";
	arrayObj[1] = "B";
	arrayObj[2] = "C";
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
	<table>
		<tr>
			<th>i</th>
			<th>값</th>
		</tr>
		
		<!-- scriptlet -->
		<%
			for(int i = 0; i<arrayObj.length; i++) {
				out.print("<tr>");
				out.print("<td>" + i + "</td>");
				out.print("<td>" + arrayObj[i] + "</td>");
				out.print("</tr>");				
			}		
		%>
	</table>
	
	<br>
	<hr width="80%">
	
	<table>
		<tr>
			<th>i</th>
			<th>값</th>
		</tr>
		
		<!-- expression -->
		<%
			for(int i = 0; i<arrayObj.length; i++) {
		%>
		<tr>
			<td><%=i%></td>
			<td><%=arrayObj[i]%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>