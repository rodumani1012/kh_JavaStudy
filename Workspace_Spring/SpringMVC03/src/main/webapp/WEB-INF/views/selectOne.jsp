<%@page import="com.my.mvc.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 정보</h1>
	
		<table border="1">
			<col width="100">
			<col width="300">
			<tr>
				<th>아이디</th>
				<td>${dto.id }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${dto.password }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${dto.name }</td>
			</tr>
			<tr>
				<td colspan="2"> <!-- id넘겨줄때 한글 깨지면 id=URLEncoder.encode(dto.getId(), "UTF-8"); -->
					<input type="button" value="수정" onclick="location.href='updateform.do?id=${dto.id}'">
					<input type="button" value="뒤로가기" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>

</body>
</html>