<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
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
	<form action="controller.do">
	<input type="hidden" value="<%=dto.getSeq() %>" name="seq"/>
	<input type="hidden" name="command" value="update"/>
		<table border="1">
			<tr>
				<th>번호</th>
				<td><%=dto.getSeq() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=dto.getWriter() %></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><%=dto.getRegdate() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" value="<%=dto.getTitle() %>" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="content"><%=dto.getContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정"/>
					<input type="button" value="취소" onclick="location.href='controller.do?command=selectone&seq=<%=dto.getSeq()%>'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>