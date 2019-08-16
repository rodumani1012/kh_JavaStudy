<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>

	<!-- Aboard -->
	<a href="<%=request.getContextPath()%>/board?category=A">Aboard</a>
	<!-- Bboard -->
	<a href="<%=request.getContextPath()%>/board?category=B">Bboard</a>
	<!-- Cboard -->
	<a href="<%=request.getContextPath()%>/board?category=C">Cboard</a>
	<!-- insert -->
	<a href="<%=request.getContextPath()%>/insert">각 보드에 글 8개씩 추가</a>
	<!-- delete -->
	<a href="<%=request.getContextPath()%>/delete">각 보드의 글 5개 지우기</a>
</body>

</html>