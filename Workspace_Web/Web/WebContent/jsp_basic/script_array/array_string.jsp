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
}
</style>
</head>
<body>
	index 사용<br>
	
	<!-- scriptlet 방법 -->
	<%
		out.print(arrayObj[0] + "<br>");
		out.print(arrayObj[1] + "<br>");
		out.print(arrayObj[2]);
	%>
	<br><br>
	
	<!-- expression 방법 -->
	<%= arrayObj[0]%><br>
	<%= arrayObj[1]%><br>
	<%= arrayObj[2]%><br>
	
	<hr width="80%">
	for(), index 사용<br>
	
	<!-- scriptlet 방법 -->
	<%	
		for (int i = 0; i < arrayObj.length; i++) {
			out.print(i + ", " + arrayObj[i] + "<br>");
		}
	%>
	<br>	
	<hr width="80%">
	<!-- expression 방법 -->
	<%
		for (int i = 0; i<arrayObj.length; i++) {
	%>
		<%=i%>, <%=arrayObj[i]%><br>
	<%
		}
	%>
	
</body>
</html>