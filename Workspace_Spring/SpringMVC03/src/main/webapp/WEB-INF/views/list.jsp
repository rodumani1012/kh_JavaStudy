<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전체 목록</h1>
	
	<c:choose>
		<c:when test="${empty list }">
			<h3>고객 정보가 없습니다...</h3>
		</c:when>
		<c:otherwise>
			<table border="1">
				<col width="100">
				<col width="300">
				<col width="200">
				<tr>
					<th>ID</th>
					<th>PASSWORD</th>
					<th>NAME</th>
				</tr>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td><a href="selectOne.do?id=${dto.id }">${dto.id }</a></td>
						<td>${dto.password }</td>
						<td>${dto.name }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3">
						<input type="button" value="처음으로" 
						onclick="location.href='index.jsp'">
						<input type="button" value="회원가입"
						onclick="location.href='registform.do'">
					</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>

</body>
</html>