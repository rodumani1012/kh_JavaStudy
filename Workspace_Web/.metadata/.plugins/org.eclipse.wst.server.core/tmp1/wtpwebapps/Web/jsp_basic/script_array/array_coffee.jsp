<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="bean.jspbasic.Coffee" %>

<%
	Coffee[] arrayObj = new Coffee[3];
	arrayObj[0] = new Coffee("아메리카노", 1500);
	arrayObj[1] = new Coffee("라떼", 3000);
	arrayObj[2] = new Coffee("모카", 2500);
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
	커피 정보
	<hr width="80%">
	
	<!-- scriptlet -->
	<%
		for (int i = 0; i < arrayObj.length; i++) {
			
			Coffee coffee = arrayObj[i];
			out.print(i + ", ");
			out.print(coffee.getName() + ", ");
			out.print(coffee.getPrice() + "<br>");
		}
	%>
	<br>	
	<hr width="80%">
	
	<!-- expression -->
	<%
		for (int i = 0; i< arrayObj.length; i++) {
			Coffee coffee = arrayObj[i];
	%>
		<%=i %>,
		<%=coffee.getName() %>,
		<%=coffee.getPrice() %><br>
	<%
		}
	%>
	
</body>
</html>