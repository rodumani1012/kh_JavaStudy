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
					<input type="hidden" value="login_chk" name="command">
					<header>
						<h3>로그인</h3>
					</header>
					<input type="text" class="text" name="id" placeholder="아이디"
						required="required" /> <input type="password" class="text"
						name="pw" placeholder="비밀번호" required="required" /> <input
						type="submit" value="로그인" name="" id="">
				</form>
				<a href="find_id_pw.jsp" style="color:black;">아이디 찾기 / 비밀번호 찾기</a>			
			</section>
			<hr style="width: 17em">
			<div style="margin-left: 1.3em;">
				<a id="kakao-login-btn"></a>
				<script src="../../assets/js/kakaologin.js"></script>
				<br>
				<div class="fb-login-button" data-width="" data-size="large"
					data-button-type="login_with" data-auto-logout-link="false"
					data-use-continue-as="false" scope="public_profile,email"
					onlogin="checkLoginState();" style="margin-bottom: 0.4em;"></div>
				<script src="../../assets/js/facebooklogin.js"></script>
				<script async defer crossorigin="anonymous"
					src="https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v3.3&appId=2443466142555702&autoLogAppEvents=1"></script>
				<br>
				<%@ include file="../member/naverlogin.jsp"%>
			</div>
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