<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- session에 set해준 값(김선달)이 있어서 바로 get할 수 있다.
			즉, 객체를 새로 생성하는게 아닌 기존에 있는 객체를 계속 사용하는 것. -->
	<jsp:useBean id="abc" class="com.mvc.dto.MyMVCDto" scope="session"></jsp:useBean>
	작성자 : <jsp:getProperty property="writer" name="abc"/>
	${abc.writer }
</body>
</html>