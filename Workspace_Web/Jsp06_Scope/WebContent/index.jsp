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
<%
	// scope
	// 1.page
	// 전달 범위 : 현재 페이지에서만.(해당 페이지 내부)
	pageContext.setAttribute("pageId", "myPageIdValue");

	// 2.request
	// 전달 범위 : 현재 페이지 + 요청된 곳(forward 된 곳) 까지.
	request.setAttribute("reqId", "myRequestIdValue");

	// 3.session
	// 전달 범위 : 현재 브라우저에서 세션만료 전까지 모든 테이블에서 가능.
	session.setAttribute("sessionId", "mySessionIdValue");

	// 4.application
	// 전달 범위 : 현재 사용하고 있는 context(전체)에서 객체 유지(web.xml도 가능)
	application.setAttribute("appId", "myApplicationIdValue");
%>
<body>

	<h1>index</h1>
	
	pageId : <%=pageContext.getAttribute("pageId") %><br/>
	reqId : <%=request.getAttribute("reqId") %><br/>
	sessionId : <%=session.getAttribute("sessionId") %><br/>
	applicationId : <%=application.getAttribute("appId") %><br/>
	
	<a href="result.jsp">이동(result.jsp)</a><br/>
	<a href="controller.do">이동(controller)</a>
</body>
</html>