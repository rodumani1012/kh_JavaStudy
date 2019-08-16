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
<script type="text/javascript">
	function idChk() {
		var doc = document.getElementsByName("myid")[0];
		if (doc.value.trim() == "" || doc.value == null) {
			//trim : 공백제거.
			alert("아이디를 입력해주세요");
		} else {
			open("logincontroller.jsp?command=idchk&id=" + doc.value, "",
					"width=200, height=200");
			// "" : 새 창에서 열림
			// "asdfasdf~~.html" : asdfsdfasd~~.html 해당 창에서 열림.
		}
	}
	function idChkConfirm() {
		//아이디 중복체크 먼저 해주세요. 하는 역할
		var chk = document.getElementsByName("myid")[0].title;
		if (chk == "n") {
			alert("아이디 중복체크를 확인해주세요");
			document.getElementsByName("myid")[0].focus();
		}
	}
</script>
</head>
<body>

	<h1>회원 가입</h1>

	<form action="logincontroller.jsp" method="post">
		<input type="hidden" name="command" value="insertuser">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="myid" title="n"
					required="required"> 
					<input type="button" value="중복체크"
					onclick="idChk()">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="mypw" onclick="idChkConfirm()"
					required="required">
				</td>
			</tr>
			<tr>
				<th>이 름</th>
				<td><input type="text" name="myname" onclick="idChkConfirm()"
					required="required">
				</td>
			</tr>
			<tr>
				<th>주 소</th>
				<td><input type="text" name="myaddr" onclick="idChkConfirm()"
					required="required">
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="myphone" onclick="idChkConfirm()"
					required="required">
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="myemail" onclick="idChkConfirm()"
					required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입"> 
					<input type="button" value="취소" onclick="location.href='index.html'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>