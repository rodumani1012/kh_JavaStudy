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

	<h1>글 작성</h1>
	
	<form action="answer.do" method="post">
		<input type="hidden" name="command" value="insertBoard_res">
		<table border="1">
			<tr>
				<th>글 쓴 이</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성"> 
					<input type="reset" value="리셋"> 
					<input type="button" value="뒤로가기" onclick="location.href='answer.do?command=list'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>