<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.jspbasic.Movie" %>
<% Movie m1 = new Movie("신과함께-인과연", "판타지", "김용화", 141); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	영화 정보
	<hr width="80%">
	카테고리 : <%= m1.getCategory() %><br>
	제목 : <%= m1.getTitle() %><br>
	감독 : <%= m1.getDirector() %><br>
	상영시간 : <%= m1.getRunningTime() %>

</body>
</html>