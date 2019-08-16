<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); //한글 처리
%>
<% 
	String[] cityArray = request.getParameterValues("city");
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
	
	<!-- scriptlet -->
	<%
		if (cityArray != null) {
			for (int i = 0; i < cityArray.length; i++) {
				out.print(cityArray[i] + "<br>");
			}
		}
	%>	
	<hr width="80%">
	
	<!-- expression -->
	<%	
		if (cityArray != null) {
			for (int i = 0; i< cityArray.length; i++) {
	%>
		<%=cityArray[i] %><br>
	<%
			}
		}
	%>
	
	<hr width="80%">
	<a href="checkbox_multi_form.jsp">[ 홈 ]</a>
	
	

</body>
</html>