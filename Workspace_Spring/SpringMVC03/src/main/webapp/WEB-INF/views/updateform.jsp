<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 정보 수정</h1>
	
	<form action="update_res.do" method="post">
		<table border="1">
			<col width="100">
			<col width="300">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" value="${dto.id }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="password" value="${dto.password }"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${dto.name }"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="button" value="삭제" onclick="location.href='delete.do?id=${dto.id}'">
					<input type="button" value="뒤로가기" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>