<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 가입</h1>
	
	<form action="regist_res.do" method="post">
		<table border="1">
			<col width="200">
			<col width="200">
			<col width="200">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입하기">
					<input type="button" value="뒤로가기" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>