<%@page import="com.cal.dto.CalDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	CalDto dto = (CalDto)request.getAttribute("dto");
	String year = dto.getMdate().substring(0,4);
	String month = dto.getMdate().substring(4,6);
	String date = dto.getMdate().substring(6,8);
%>
</head>
<body>

	<jsp:useBean id="util" class="com.cal.util.Util"></jsp:useBean>

	<h1>상세 일정 보기</h1>
	
	<table border="1">
		<tr>
			<th>번  호</th>
			<td>${dto.seq }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${dto.id }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
				<jsp:setProperty property="toDates" name="util" value="${dto.mdate }"/>
				<jsp:getProperty property="toDates" name="util"/>
			</td>
		</tr>
		<tr>
			<th>제  목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>내  용</th>
			<td><textarea rows="10" cols="60" readonly="readonly">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="location.href='calendar.do?command=update&seq=${dto.seq}'">
				<input type="button" value="삭제" onclick="location.href='calendar.do?command=delete&seq=${dto.seq}&year=<%=year %>&month=<%=month %>&date=<%=date %>'">
				<input type="button" value="뒤로가기" onclick="location.href='calendar.do?command=callist&year=<%=year %>&month=<%=month %>&date=<%=date %>'">
			</td>
		</tr>
	</table>
</body>
</html>