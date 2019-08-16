<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 쿠키 처리 --%>
<%
	String loginId = ""; // 사용자 아이디

	Cookie[] cookies = request.getCookies();
	if (cookies != null) {

		for (int i = 0; i < cookies.length; i++) {

			Cookie cookie = cookies[i];
			String cookieName = cookie.getName();

			// 쿠키 이름 "loginId" 가 존재할 경우
			// 쿠키 값을 얻어와 화면 로그인 영역에 나타낸다.
			if (cookieName.equals("loginId")) {

				loginId = cookie.getValue(); // 사용자 아이디 값을 설정한다.
			}
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/lib/css/work.css">
</head>
<body>
	로그인
	<hr width="80%">
	<form action="login_result.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" maxlength="20" name="id" class="w200"
					value="<%=loginId%>" required></td>
				<td rowspan="2"><input type="checkbox" name="idSave"
					value="true">아이디 저장<br></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" maxlength="20" name="password"
					class="w200" required></td>
			</tr>
		</table>
		<br> <input type="submit" value="로그인">
	</form>
</body>
</html>