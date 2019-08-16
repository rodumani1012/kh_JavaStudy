<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="util" class="com.cal.util.Util"></jsp:useBean>

	<h1>일정 수정하기</h1>

	<form action="calendar.do" method="post">
		<input type="hidden" name="command" value="update_res">
		<input type="hidden" name="seq" value="${dto.seq }"> 
		<table border="1">
			<tr>
				<th>번 호</th>
				<td>${dto.seq }</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${dto.id }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>
					<jsp:setProperty property="toDates" name="util" value="${dto.mdate }" /> 
					<jsp:getProperty property="toDates" name="util" />
				</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><input type="text" value="${dto.title }" name="title"></td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea rows="10" cols="60" name="content">${dto.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="수정"> 
				<input type="reset" value="리셋"> 
				<input type="button" value="뒤로가기" onclick="location.href='calendar.do?command=caldetail&seq=${dto.seq}'">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>