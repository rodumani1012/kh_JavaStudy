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
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

	<link rel="stylesheet" href="http://localhost:8787/TOY_Semiproject/assets/css/main.css" />

</head>

<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a
			href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">

		<header class="subhead">
			<h2>Project</h2>
			<p>Project List</p>
			<h3>${user_info_dto.user_num }</h3>
			<input type="button" id="prj_plus" class="small" value="+" name=""
				id="">
		</header>


		<c:forEach items="${project_list }" var="dto">
			<article class="box post post-excerpt">
				<!-- Text -->
				<section class="box text-style1">
					<div class="inner prj_in">
						<input type="hidden" value="${dto.prj_num}" class="prj_num">
						<p>
							<strong>${dto.prj_name }</strong><br> ${dto.prj_loc }
							<strong>${user_info_dto.user_nickname }</strong>
						</p>
					</div>
				</section>
			</article>
		</c:forEach>

	</div>

	<!-- Sidebar -->
	<%@ include file="../sidebar.jsp" %>

	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js">
		
	</script>
	<script src="http://localhost:8787/TOY_Semiproject/assets/js/main.js?ver=1"></script>


</body>

</html>