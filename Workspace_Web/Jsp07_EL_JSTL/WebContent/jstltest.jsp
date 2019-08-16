<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSTL page</h1>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>등급</th>
		</tr>
		<%-- forEach는 Iterator로 다양한 컬렉션을 읽어온다. --%>
		<%-- for(Score score : list) 와 같은 의미 --%>
		<c:forEach items="${list }" var="score">
			<tr>
				<td>
					<c:if test="${score.name eq '이름10' }">
						<c:out value="홍길동"></c:out> <%-- c:out은 <%= %>와 같음 --%>
					</c:if>
					<c:choose> <%-- choose/when은 switch/case문과 같음 --%>
						<c:when test="${score.name eq '이름20' }">
							<c:out value="${score.name }님!"></c:out>
						</c:when>
						<c:when test="${score.name eq '이름30' }">
							<c:out value="${score.name }씨!"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="누구지?"></c:out>
						</c:otherwise>
					</c:choose>
				</td>
				<td>${score.kor }</td>
				<td>
					<c:choose>
						<c:when test="${score.eng > 60 && score.eng < 90}">
							<c:out value="멋져!"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="${score.eng}"></c:out>
						</c:otherwise>				
					</c:choose>
				</td>
				<td>${score.math }</td>
				<td>${score.sum }</td>
				<td>${score.avg }</td>
				<td>
					<c:choose>
						<c:when test="${score.grade eq 'A' || score.grade eq 'B' }">
							<c:out value="PASS"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="FAIL"></c:out>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- eq : == / ne : != / empty : null -->
	<!-- var : 변수, begin : 시작, end : 끝 -->
	<c:forEach var="i" begin="1" end="10">
		${i } &nbsp;&nbsp;&nbsp;
	</c:forEach>
	
	<table border="1">
		<tr>
			<th colspan="5">&lt; 구구단 &gt;</th>
		</tr>
		<c:forEach var="i" begin="2" end="9">
			<c:forEach var="j" begin="1" end="9">
				<tr>
					<td>${i }</td>
					<td>×</td>
					<td>${j }</td>
					<td>=</td>
					<td>${i*j }</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
</body>
</html>