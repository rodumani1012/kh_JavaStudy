<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
  	<% request.setCharacterEncoding("UTF-8"); %>
  	<% response.setContentType("text/html; charset=UTF-8"); %>
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
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="assets/css/main.css" />
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
</head>

<body class="is-preload">
	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a>
		<span class="title"><a href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<article class="box post post-excerpt">
				<!--
									Note: Titles and subtitles will wrap automatically when necessary, so don't worry
									if they get too long. You can also remove the <p> entirely if you don't
									need a subtitle.
								-->
				<section class="box recent-posts">
					<header>
						<h3>자유게시판</h3>
						<% HttpSession session1 = request.getSession(false);
						String email = (String)session1.getAttribute("email");
						%>
						<h3><%= email %></h3>
					</header>
					<ul>
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">Feugiat nisl aliquam</a></li>
						<li><a href="#">Sed dolore magna</a></li>
						<li><a href="#">Malesuada commodo</a></li>
						<li><a href="#">Ipsum metus nullam</a></li>
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
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">Feugiat nisl aliquam</a></li>
						<li><a href="#">Sed dolore magna</a></li>
						<li><a href="#">Malesuada commodo</a></li>
						<li><a href="#">Ipsum metus nullam</a></li>
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
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">Feugiat nisl aliquam</a></li>
						<li><a href="#">Sed dolore magna</a></li>
						<li><a href="#">Malesuada commodo</a></li>
						<li><a href="#">Ipsum metus nullam</a></li>
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
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">Feugiat nisl aliquam</a></li>
						<li><a href="#">Sed dolore magna</a></li>
						<li><a href="#">Malesuada commodo</a></li>
						<li><a href="#">Ipsum metus nullam</a></li>
					</ul>
				</section>
			</article>

			<!-- Pagination -->
			<div class="pagination">
				<!--<a href="#" class="button previous">Previous Page</a>-->
				<div class="pages">
					<a href="#" class="active">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<span>&hellip;</span>
					<a href="#">20</a>
				</div>
				<a href="#" class="button next">Next Page</a>
			</div>

		</div>
	</div>

	<!-- Sidebar -->
	<div id="sidebar">

		<!-- Logo -->
		<h1 id="logo"><a href="#">STRIPED</a></h1>

		<!-- Search -->
		<section class="box search">
			<form method="post" action="#">
				<ul>
					<li><a href="login.jsp">로그인</a></li>
					<li><a href="#">회원가입</a></li>
				</ul>
				<!-- <input type="text" class="text" name="ID" placeholder="ID" />
				<input type="text" class="text" name="PASSWORD" placeholder="PASSWORD" /> -->
			</form>
		</section>

		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li class="current"><a href="#">프로젝트</a></li>
				<li><a href="#">자유게시판</a></li>
				<li><a href="#">인원모집</a></li>
				<li><a href="#">질문게시판</a></li>
			</ul>
		</nav>

		<!-- Text -->

		<!-- Recent Posts -->
		<section class="box recent-posts">
			<header>
				<h2>Recent Posts</h2>
			</header>
			<ul>
				<li><a href="#">Lorem ipsum dolor</a></li>
				<li><a href="#">Feugiat nisl aliquam</a></li>
				<li><a href="#">Sed dolore magna</a></li>
				<li><a href="#">Malesuada commodo</a></li>
				<li><a href="#">Ipsum metus nullam</a></li>
			</ul>
		</section>

		<!-- Recent Comments -->
		<section class="box recent-comments">
			<header>
				<h2>Recent Comments</h2>
			</header>
			<ul>
				<li>case on <a href="#">Lorem ipsum dolor</a></li>
				<li>molly on <a href="#">Sed dolore magna</a></li>
				<li>case on <a href="#">Sed dolore magna</a></li>
			</ul>
		</section>

		<!-- Copyright -->
		<ul id="copyright">
			<li>&copy; TOY.</li>
			<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
		</ul>

	</div>

	<!-- Scripts -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js">
	</script>
	<script src="assets/js/main.js"></script>

</body>

</html>