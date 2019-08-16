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

	<a href="<%=request.getContextPath()%>/selectlist">list</a>
	<br>
	<a href="selectlist">list</a> <!-- 상대경로(현재폴더) ./ -->
	<br>
	<a href="/selectlist">list</a> <!-- 최상위(root) localhost:8787 -->
	
<!-- 	<form action="logincontroller.do" method="post"> -->
<!-- 		<input type="hidden" name="command" value="list"> -->
<!-- 		<input type="hidden" name="command" value="login"> -->
<!-- 		<table border="1"> -->
<!-- 			<col width="100"> -->
<!-- 			<col width="100"> -->
<!-- 			<tr> -->
<!-- 				<th>ID</th> -->
<!-- 				<td><input type="text" name="id"></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<th>PW</th> -->
<!-- 				<td><input type="password" name="pw"></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td colspan="2"> -->
<!-- 					<input type="submit" value="로그인"> -->
<!-- 					<input type="button" value="회원가입" onclick="location.href='logincontroller.do?command=registform'"> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
<!-- 	</form> -->

<!-- 	<a href="controller.do?command=usebean">usebean test</a><br> -->
<!-- 	<br> -->
<!-- 	<a href="controller.do?command=list">list</a><br> -->
</body>
</html>