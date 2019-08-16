<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 align = "center">페이징 테스트</h1>
<hr/>

<form action="paging.do" method = "post">
<input type = "hidden" name = "command" value = "login">
	<table align = "center" border = "1">
		<col width = "100">
		<col width = "150">
		<tr>
			<th>아이디: </th>
			<td><input type = "text" name = "id" placeholder = "아이디" /></td>
		</tr>
		<tr>
			<th>비밀번호 : </th>
			<td><input type = "password" name = "pw" placeholder = "비밀번호" /></td>
		</tr>
		<tr>
			<td colspan = "2" align = "center">
			<input type = "submit" value = "로그인" />
			</td>
		</tr>
	</table>
	<hr/>
	<h3 align = "center">DB 파일 전체 실행시
		<br/>
		아이디 : user1 비밀번호 : 1111
		<br/>
		아이디 : user2 비밀번호 : 1111
		<br/>
		아이디 : user3 비밀번호 : 1111
		<br/>
		아이디 : user4 비밀번호 : 1111
	</h3>
	<h3 align = "center">로그인 후 글작성 버튼 클릭시 글 추가가 됨
	</h3>
</form>

</body>
</html>