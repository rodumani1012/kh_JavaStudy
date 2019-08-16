<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	#kakao-login-btn > img{
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
				<form method="post" action="${pageContext.request.contextPath }/login.do">
					<input type="hidden" value="mypage" name="command">
					<input type="hidden" value="true" name="mypage_access_pw">
					<header>
						<h3>비밀번호 확인</h3>
					</header>
					<p>회원님의 정보를 안전하게 보호하기 위해 비밀번호를 다시 확인합니다.</p>
					<input type="password" class="text" name="pw" placeholder="암호입력" required="required" />
					<input type="submit" value="로그인">
				</form>
			</section>
		</div>
	</div>

	<%@ include file="../../sidebar.jsp" %>

</body>

</html>