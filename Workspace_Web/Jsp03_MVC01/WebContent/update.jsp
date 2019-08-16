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
<form action="mycontroller.jsp" method="post">
		<input type="hidden" name="update" value="<%=dto.getSeq()%>">
		<input type="hidden" name="command" value="update_res">
		<table border="1">
			<tr>
				<th>이 름</th>
				<td><%=dto.getWriter() %></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><input type="text" name="title" value="<%=dto.getTitle() %>"></td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea rows="10" cols="60" name="content"><%=dto.getContent() %></textarea>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="취소">
					<input type="button" value="목록" onclick="location.href='mycontroller.jsp?command=boardlist&seq=<%=dto.getSeq()%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>