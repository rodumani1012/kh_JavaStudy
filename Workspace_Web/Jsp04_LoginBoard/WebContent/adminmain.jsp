<%@page import="com.login.dto.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-control", "no-store");
	response.setHeader("Expires", "0");
	
	/*
		데이터가 변경되었을 때, 이전 내용을 화면에 보여주는 이유
		-> 서버값이 아니라 캐시에 저장된 내용을 가져오기 때문
		
		브라우저가 캐시에 응답결과를 저장하지 않도록 설정
		response.setHeader("Pragma", "no-cache");			//http 1.0 일때
		response.setHeader("Cache-control", "no-store");	//http 1.1 일때
		response.setHeader("Expires", "0");					//proxy server 일때
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	LoginDto dto = (LoginDto)session.getAttribute("dto");

	if(dto == null) {
		// 관리자 계정 로그인한 뒤 로그아웃하고서 앞으로가기 누르면
		// 로그인 된 상태가 보이지 않게 됨.
		pageContext.forward("index.html");
		//response.sendRedirect("index.html");
	}
%>
	<div>
		<span><%=dto.getMyname() %>님 환영합니다 (등급 : <%=dto.getMyrole() %>)</span>
		<a href="logincontroller.jsp?command=logout">로그아웃</a>
	</div>
	
	<div>
		<div>
			<a>회원정보 전체 조회</a>
		</div>
		<div>
			<a href="logincontroller.jsp?command=userlist_en">회원정보 조회(enabled)</a>
		</div>
	</div>

</body>
</html>