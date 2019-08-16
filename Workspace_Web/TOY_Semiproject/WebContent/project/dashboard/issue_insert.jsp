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
<link rel="stylesheet" href="assets/css/main.css" />
</head>

<body class="is-preload">


	<!-- Content -->

	<div id="issue_content">
		<div class="inner">

			<!-- Post -->
			<article class="box post post-excerpt">
				<section class="box recent-posts">
					<header>
						<h3>이슈 작성</h3>
						
					</header>
				<form action="${pageContext.request.contextPath}/calendar.do?command=cal_issue_insert_res" method="post">
					<table>
						<tr>
							<th>카테고리 선택</th>
							<td>
								 <select name="category">
								 	<c:forEach items="${prj_board_list }" var="prj_board">
								 		<option value="${prj_board.board_title }">${prj_board.board_title }</option>
								 	</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th>중요도</th>
							<td><select name="issue_priority" id="issuepriority">
									<option value="VERY_HIGH">VERY HIGH</option>
									<option value="HIGH">HIGH</option>
									<option value="MEDIUM" selected="selected">MEDIUM</option>
									<option value="LOW">LOW</option>
									<option value="VERY_LOW">VERY LOW</option>
							</select></td>
						</tr>
						<tr>
							<th>이슈 제목</th>
							<td><input type="text" name="issue_title" required="required"></td>
						</tr>
						<tr>
							<th>이슈 내용</th>
							<td><textarea rows="10" cols="60" id="issue_content"
									name="issue_content" required="required"></textarea></td>
						</tr>
						<tr>
							<th>책임자</th>
							<td><input type="text" name="issue_charge" required="required"></td>
						</tr>
						<tr>
							<th>시작일</th>
							<td><input type="date" name="issue_update" required="required"></td>
						</tr>
						<tr>
							<th>마감기한</th>
							<td><input type="date" name="issue_deadline" required="required"></td>
						</tr>
						<tr>
							<td colspan="3">
							<input type="submit" class="small" value="작성" />
							<input type="reset" class="small" value="리셋">
							<input type="button" class="small" value="취소">
							</td>
						</tr>
					</table>
				</form>
				</section>
			</article>
		</div>
	</div>

	<%@ include file= "../project_sidebar.jsp"%>

	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="assets/js/prj.js"></script>
	<script src="assets/js/issue.js?ver=1"></script>
</body>

</html>