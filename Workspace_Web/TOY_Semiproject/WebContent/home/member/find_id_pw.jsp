<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Striped by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>

<head>
<title>Striped by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/main.css" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<style type="text/css">
#kakao-login-btn>img {
	width: 234.4px;
}
</style>

</head>

<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a
			href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<section class="box search">
				<form method="post"
					action="${pageContext.request.contextPath}/login.do">
					<input type="hidden" value="find_id" name="command">
					<header>
						<h3>아이디 찾기</h3>
					</header>
					<table>
						<tr>
							<th>이름</th>
							<td>
								<input type="text" class="text" name="id_name" placeholder="이름" required/>
							</td>
						</tr>
						<tr>
							<th>닉네임</th>
							<td>
								<input type="text" class="text" name="find_nickname" placeholder="닉네임" required/>
							</td>
						</tr>
						<tr>
							<td colspan="2" >
								<input type="submit" value="아이디 찾기" style="margin-left: 10em;"/>
							</td>
						</tr>
					</table>
				</form>
				
				<br/><br/>
				
				<form method="post"
					action="${pageContext.request.contextPath}/login.do">
					<input type="hidden" value="find_pw" name="command">
					<header>
						<h3>비밀번호 찾기</h3>
					</header>
					<table>
						<tr>
							<th>이름</th>
							<td>
								<input type="text" class="text" name="pw_name" placeholder="이름" required/>
							</td>
						</tr>
						<tr>
							<th>아이디</th>
							<td>
								<input type="text" class="text" name="pw_id" placeholder="아이디" required/>
							</td>
						</tr>
						<tr>
							<td colspan="2" >
								<input type="submit" value="비밀번호 찾기" style="margin-left: 10em;"/>
							</td>
						</tr>
					</table>
				</form>	
			</section>
		</div>
	</div>

	<!-- Sidebar -->
	<%@ include file="../../sidebar.jsp"%>

	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js">
	</script>
	<script src="${pageContext.request.contextPath }/assets/js/main.js"></script>



</body>

</html>