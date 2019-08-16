<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eltest.jsp</title>
</head>
<body>

	<h1>EL page</h1>
	<!-- EL 표현 방식. 자바코드(<% %>) 생략
		${1} : 그냥 숫자 표현
		그외 ${21 * 2} 처럼 사칙연산 가능
		중괄호 안에 값은 작은범위에서 큰 범위로 탐색함. 
		ex) ${score.name}은 pageContext에서 score객체 확인 -> 없으면 request -> session -> application 순 -->
	<table border="1">
		<tr>  <!-- 컨트롤러에서 setAttribute로 넘겨준 이름으로 받아야 한다. -->
			<th colspan="2">${score.name} 님의 점수</th> <!-- getName() 역할을 함 -->
		</tr>
		<tr>
			<th>국어</th>
			<td>${score.kor }</td>
		</tr>
		<tr>
			<th>수학</th>
			<td>${score.math }</td>
		</tr>
		<tr>
			<th>영어</th>
			<td>${score.eng }</td>
		</tr>
		<tr>
			<th>총점</th>
			<td>${score.sum }</td>
		</tr>
		<tr>
			<th>평균</th>
			<td>${score.avg }</td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${score.grade }</td>
		</tr>
	</table>
	
</body>
</html>