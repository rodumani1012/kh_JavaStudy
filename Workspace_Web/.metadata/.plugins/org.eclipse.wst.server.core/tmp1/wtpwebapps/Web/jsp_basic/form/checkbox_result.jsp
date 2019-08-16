<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); //한글 처리
%>
<%
	String agree = request.getParameter("agree");
%>

<%
	//요청값에 따라 결과 처리
	String result = "";
	if (agree != null) {
		if (agree.equals("true")) {
			result = "동의함";
		}
	} else {
		result = "동의 안함";
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
	약관 동의 = <%=result%><br>
	<br>
	<a href="checkbox_form.jsp">[ 홈 ]</a>

</body>
</html>