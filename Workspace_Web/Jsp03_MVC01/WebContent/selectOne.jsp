<%@page import="com.mvc.dto.MVCBoardDto"%>
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
	
<%
	MVCBoardDto dto = (MVCBoardDto)request.getAttribute("dto");
%>
	<table border="1">
		<tr>
			<th>이 름</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>제 목</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<th>내 용</th>
			<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent() %></textarea>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="location.href='mycontroller.jsp?command=update&seq=<%=dto.getSeq()%>'">
				<input type="button" value="삭제" onclick="location.href='mycontroller.jsp?command=delete&seq=<%=dto.getSeq()%>'">
				<%-- <input type="button" value="삭제" onclick="location.href='mycontroller.jsp?command=muldel&chk=<%=dto.getSeq()%>'"> --%>
				<input type="button" value="목록" onclick="location.href='mycontroller.jsp?command=boardlist'">
			</td>
		</tr>
	</table>
	
</body>
</html>