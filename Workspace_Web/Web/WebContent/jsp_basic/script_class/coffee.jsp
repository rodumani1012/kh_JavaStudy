<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="bean.jspbasic.Coffee" %>

<%
	Coffee coffee1 = new Coffee("아메리카노", 1500);
	//coffee1.printInfo();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	커피 정보
	<hr width="80%">
	커피명 : <%=coffee1.getName() %><br>
	가격 : <%=coffee1.getPrice() %>

</body>
</html>