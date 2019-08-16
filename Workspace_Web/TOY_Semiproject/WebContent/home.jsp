<%@page import="com.toy.project.biz.project_biz"%>
<%@page import="com.toy.project.biz.project_bizimpl"%>
<%@page import="com.toy.project.dto.prj_info_dto"%>
<%@page import="com.toy.home.biz.home_bizimpl"%>
<%@page import="com.toy.home.biz.home_biz"%>
<%@page import="com.toy.home.dto.normal_board_dto"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="assets/css/main.css" />
</head>

<body class="is-preload">
	<%
		home_biz biz = new home_bizimpl();
	%>

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a
			href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<c:choose>
				<c:when test="${empty user_info_dto}">
					<h3>TOY에 어서오세요</h3>
				</c:when>
				<c:otherwise>
					<h3>${user_info_dto.user_nickname }님어서오세요 ٩(ˊᗜˋ*)و</h3>
				</c:otherwise>
			</c:choose>
			<!-- <h3>${user_info_dto.user_nickname }</h3> -->
			<!-- <h3>${user_info_dto.user_num }</h3> -->
			<article class="box post post-excerpt">
				<!--
									Note: Titles and subtitles will wrap automatically when necessary, so don't worry
									if they get too long. You can also remove the <p> entirely if you don't
									need a subtitle.
								-->
				<section class="box recent-posts">
					<header>
						<h3>자유게시판</h3>
					</header>
					<ul>
						<%
							List<normal_board_dto> free = biz.small_selectList("FREE");
							request.setAttribute("free", free);
						%>
						<c:choose>
							<c:when test="${empty free }">
								<li>작성된 글이 없습니다</li>
							</c:when>
							<c:otherwise>
								<c:forEach items="${free }" var="free">
									<li><a
										href="home.do?command=board_detail&normal_num=${free.normal_num}">${free.normal_title
													}</a></li>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</ul>
				</section>
			</article>

			<!-- Post -->
			<article class="box post post-excerpt">
				<section class="box recent-posts">
					<header>
						<h3>프로젝트</h3>
					</header>
					<ul>
						<%
							List<prj_info_dto> prj = biz.small_prj_selectList();
							request.setAttribute("prj", prj);
						%>
						<c:choose>
							<c:when test="${empty prj }">
								<li>작성된 글이 없습니다</li>
							</c:when>
							<c:otherwise>
								<c:forEach items="${prj }" var="prj">
									<li><a
										href="project.do?command=project_show&prj_num=${prj.prj_num }">${prj.prj_name
													}</a></li>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</ul>
				</section>
			</article>

			<!-- Post -->
			<article class="box post post-excerpt">
				<section class="box recent-posts">
					<header>
						<h3>인원모집</h3>
					</header>
					<ul>
						<%
							List<normal_board_dto> crew = biz.small_selectList("CREW");
							request.setAttribute("crew", crew);
						%>
						<c:choose>
							<c:when test="${empty crew }">
								<li>작성된 글이 없습니다</li>
							</c:when>
							<c:otherwise>
								<c:forEach items="${crew }" var="crew">
									<li><a
										href="home.do?command=board_detail&normal_num=${crew.normal_num}">${crew.normal_title
														}</a></li>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</ul>
				</section>
			</article>

			<!-- Post -->
			<article class="box post post-excerpt">
				<section class="box recent-posts">
					<header>
						<h3>질문게시판</h3>
					</header>
					<ul>
						<%
							List<normal_board_dto> qa = biz.small_selectList("QA");
							request.setAttribute("qa", qa);
						%>
						<c:choose>
							<c:when test="${empty qa }">
								<li>작성된 글이 없습니다</li>
							</c:when>
							<c:otherwise>
								<c:forEach items="${qa }" var="qa">
									<li><a
										href="home.do?command=board_detail&normal_num=${qa.normal_num}">${qa.normal_title
														}</a></li>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</ul>
				</section>
			</article>

		</div>
	</div>

	<!-- Sidebar -->
	<%@ include file="sidebar.jsp"%>


	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js">
		
	</script>
	<script src="assets/js/main.js"></script>

</body>

</html>