<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
<title>Insert title here</title>
</head>
<body>
	커피 등록
	<hr width="80%">
	
	<form action="coffee_result.jsp" method="post">
	커피명 : <input type="text" name="name">
	<br> 
	가격 :	<input type="text" name="price">
	<br><br>
	<input type="submit" value="전송">
	<input type="reset" value="다시입력"> 
	</form>

</body>
</html>