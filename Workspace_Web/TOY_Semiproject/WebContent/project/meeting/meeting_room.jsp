<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<head>
	<title>Striped by HTML5 UP</title>
	<meta charset="utf-8" />
	<!-- <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" /> -->
	<link rel="stylesheet" href="assets/css/main.css?ver=1" />
	<!-- <link rel="stylesheet" href="assets/chat/static/css/index.css"> -->
</head>

<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<header class="subhead">
			<h2>Project name${prj_num_session}</h2>
			<button class="toggle2 small">commubar</button>
		</header>

		<div>
			<article class="box post post-excerpt">

			</article>
		</div>
	</div>

	<!-- Sidebar -->
	<%@ include file= "../project_sidebar.jsp"%>

	<!-- Commubar -->
	<div id="commubar" class="prj_bar">
		<!-- Logo -->
		<h1 id="logo">
			<a href="#">채팅</a>
		</h1>

		<form action="" onclick="user_list(${prj_num_session})">
			<select name="접속자" id="join_user">
				<option id="sel_placeholder" disabled selected>접속자</option>
			</select>
		</form>

		<div id="main">
			<div id="chat">
				<!-- 채팅 메시지 영역 -->
			</div>
			<div>
				<input type="text" id="test" placeholder="메시지를 입력해주세요..">
				<button onclick="send()">전송</button>
			</div>
		</div>
	</div>

	<!-- Scripts -->


	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript">
		var project_num = ${ prj_num_session }
		var user_nickname = '${user_info_dto.user_nickname}'
	</script>
	<script src="http://localhost:8000/socket.io/socket.io.js"></script>
	<script src="assets/commu/static/js/index.js?ver=1"></script>
	<script src="assets/js/prj.js?ver=1"></script>
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="assets/commu/static/js/jquery.event.drag-2.0.js"></script>
	<script type="text/javascript" src="assets/commu/static/js/scripts.js"></script>


</body>

</html>