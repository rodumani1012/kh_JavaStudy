<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/main.css" />
</head>

<body>
	<!-- Sidebar -->
	<div id="sidebar">

		<!-- Logo -->
		<h1 id="logo">
			<a href="${pageContext.request.contextPath}/home.jsp">TOY</a>
		</h1>

		<!-- Search -->
		<section class="box search">
			<form method="post" action="#">
				<ul>
					<c:choose>
						<c:when test="${empty user_info_dto }">
							<li><a href="http://localhost:8787/TOY_Semiproject/home/member/member_login.jsp">로그인</a>
							</li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath }/login.do?command=logout">로그아웃</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${empty user_info_dto }">
							<li><a href="http://localhost:8787/TOY_Semiproject/home/member/member_registry.jsp">회원가입</a>
							</li>
						</c:when>
						<c:otherwise>
							<li><a
									href="${pageContext.request.contextPath }/login.do?command=mypage&mypage_access_pw=${test }">마이페이지</a>
							</li>
						</c:otherwise>
					</c:choose>

				</ul>
			</form>
		</section>

		<!-- Nav -->
		<nav id="nav">
			<ul>
				<c:choose>
					<c:when test="${empty user_info_dto }">
						<li><a href="${pageContext.request.contextPath }/home.do?command=home_error">프로젝트</a></li>
					</c:when>
					<c:otherwise>
						<li><a
								href="${pageContext.request.contextPath }/project.do?command=project_list&user_num=${user_info_dto.user_num }">프로젝트</a>
						</li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${empty user_info_dto }">
						<li><a href="${pageContext.request.contextPath }/home.do?command=home_error">자유게시판</a></li>
					</c:when>
					<c:otherwise>
						<li><a
								href="${pageContext.request.contextPath }/home.do?command=board_list&normal_category=FREE">자유게시판</a>
						</li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${empty user_info_dto }">
						<li><a href="${pageContext.request.contextPath }/home.do?command=home_error">인원모집</a></li>
					</c:when>
					<c:otherwise>
						<li><a
								href="${pageContext.request.contextPath }/home.do?command=board_list&normal_category=CREW">인원모집</a>
						</li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${empty user_info_dto }">
						<li><a href="${pageContext.request.contextPath }/home.do?command=home_error">질문게시판</a></li>
					</c:when>
					<c:otherwise>
						<li><a
								href="${pageContext.request.contextPath }/home.do?command=board_list&normal_category=QA">질문게시판</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>

		<!-- Copyright -->
		<ul id="copyright">
			<li>&copy; TOY.</li>
			<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
		</ul>

	</div>

</body>

</html>