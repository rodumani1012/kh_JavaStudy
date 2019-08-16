<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); //한글 처리
%>
<% 
	String color = request.getParameter("color");
%>
<%
	int colorInt = Integer.parseInt(color);
	String colorName = "";
	switch (colorInt) {
	case 1:
		colorName = "노랑";
		break;
	case 2:
		colorName = "핑크";		
		break;
	case 3:
		colorName = "오렌지";		
		break;
	case 4:
		colorName = "회색";		
		break;
	
	default:
		break;
}
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
	<%=colorName%>
	<br>
	<br>
	<a href="select_form.jsp">[ 홈 ]</a>
	
</body>
</html>