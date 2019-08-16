<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.jspbasic.Item" %>

<%
	Item item1 = new Item("커피믹스", 10);
	item1.printInfo();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	주문 정보
	<hr width="80%">
	제품 : <%= item1.getName() %><br>
	수량 : <%= item1.getCount() %>
</body>
</html>