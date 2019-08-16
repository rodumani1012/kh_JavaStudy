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

    <h1>result</h1>

    pageId : <%=pageContext.getAttribute("pageId") %><br/> <!-- null -->
	reqId : <%=request.getAttribute("reqId") %><br/> <!-- null
	index.jsp에서 요청한 것은 result.jsp가 아닌 server 이므로 값이 안넘어감 -->
	sessionId : <%=session.getAttribute("sessionId") %><br/> <!-- mySessionIdValue -->
	applicationId : <%=application.getAttribute("appId") %><br/> <!-- myApplicationIdValue -->
	
</body>
</html>