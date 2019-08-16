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

	<!-- C:\tomcat\webapps\examples\jsp\jsp2\el -->
	<a href="controller.do?command=basic">Expression Language</a>
	<!-- ${1} : 그냥 숫자 표현
		그외 ${21 * 2} 처럼 사칙연산 가능 -->
	<br><br><br><br>
	<a href="controller.do?command=eltest">EL Test</a>
	
	<br><br><br><br>
	<a href="controller.do?command=jstltest">JSTL test</a>
	
	
	
</body>
</html>