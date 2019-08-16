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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/main.css" />
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
			<article class="box post post-excerpt">
				<section class="box recent-posts">
					<header>
						<h3>프로젝트 보기</h3>
					</header>
					<table>
						<tbody>
							<tr>
								<th>작성자</th>
								<td>${prj_info_dto.user_nickname }</td>
							</tr>
							<tr>
								<th>번호</th>
								<td>${prj_info_dto.prj_num }</td>
							</tr>

							<tr>
								<th>프로젝트 이름</th>
								<td>${prj_info_dto.prj_name }</td>
							</tr>
							<tr>
								<th>프로젝트 장소</th>
								<td>${prj_info_dto.prj_loc }</td>
							</tr>
							
						</tbody>
						<tfoot>
							<tr>
								<td><c:if
										test="${user_info_dto.user_nickname eq prj_info_dto.user_nickname }">
										<input type="button" class="small" value="수정"
											onclick="location.href='project.do?command=project_updateform&prj_num=${prj_info_dto.prj_num}'">
										<input type="button" class="small" value="삭제"
											onclick="location.href='project.do?command=project_delete&prj_num=${prj_info_dto.prj_num}'">
									</c:if> <input type="button" class="small" value="목록"
									onclick="location.href='project.do?command=project_list&user_num=${user_info_dto.user_num}'">
									<input type="button" class="small" value="홈으로"
									onclick="location.href='../TOY_Semiproject/home.jsp'">
								</td>
							</tr>
						</tfoot>


					</table>


				</section>
			</article>


		</div>
	</div>

	<!-- Sidebar -->
	<%@ include file="../../sidebar.jsp"%>

	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js">
		
	</script>
	<script src="assets/js/main.js?ver=1"></script>
	<script type="text/javascript">
		function comment_chk(bool) {
			if (bool) {
				alert("로그인을 해주세요")
				return false
			} else {
				return true
			}
		}
	</script>

</body>

</html>