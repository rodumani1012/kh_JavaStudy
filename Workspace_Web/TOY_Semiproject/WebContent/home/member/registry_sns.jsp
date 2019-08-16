<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE HTML>
<!--
	Striped by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		alert("회원추가정보가 필요합니다.");
	});
</script>
<head>
	<title>Striped by HTML5 UP</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="assets/css/main.css" />
	<script type="text/javascript" src="assets/js/signup.js?ver=1"></script>
</head>

<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<section class="box search">
				<form method="post" action="${pageContext.request.contextPath}/login.do" onsubmit="return formsubmit();">
					<header>
						<h3>회원 추가 정보 입력</h3>
					</header>
					<input type="hidden" name="command" value="registry_sns">
					<input type="hidden" class="text" name="id" value="${id }" />
					<input type="text" class="text" name="name" placeholder="이름" required />
					<input type="text" class="text" name="nickname" placeholder="닉네임" required />
					<div id="nick_confirm"></div>
					<input type="button" name="btn_nickcheck" value="중복확인" onclick="nick_check()"/>
					<input type="email" class="text" name="email" placeholder="이메일" required/>
					<input type="button" id="btn_sendemail" value="인증번호발송" onclick="send_email()"/><p></p>
					<input type="text" class="text" name="code" placeholder="인증번호" required/><div id="confirm"></div>
					<div id="example1"></div>
					<p></p>
					<input type="submit" value="회원가입" >
				</form>
			</section>

		</div>
	</div>

	<!-- Sidebar -->
	<%@ include file="../../sidebar.jsp" %>

	<!-- Scripts -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js">

	</script>
	<script src="assets/js/main.js"></script>

</body>

</html>