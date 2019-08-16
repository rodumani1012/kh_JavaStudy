<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
</head>
<body>
	상품 주문
	<hr width="80%">
	
	<form action="item_result.jsp" method="post">
	상품명 : <input type="text" name="name">
	<br> 
	주문개수 :	<input type="text" name="count">
	<br><br>
	<input type="submit" value="전송">
	<input type="reset" value="다시입력"> 
	</form>


</body>
</html>