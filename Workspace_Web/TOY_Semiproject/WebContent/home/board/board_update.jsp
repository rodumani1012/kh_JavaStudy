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
						<h3>글 수정 하기</h3>
					</header>

					<form action="home.do" method="post" onsubmit="se2()">
						<input type="hidden" name="command" value="board_update">
						<input type="hidden" name="normal_num"
							value="${normal_board_dto.normal_num }"> <input
							type="hidden" name="normal_category"
							value="${normal_board_dto.normal_category }">
						<table>
							<thead>

								<tr>
									<th>작성자</th>
									<td><input type="text" name="user_nickname"
										value="${normal_board_dto.user_nickname }" readonly="readonly" /></td>
								</tr>
								<tr>
									<th>제목</th>
									<td><input type="text" name="normal_title"
										value="${normal_board_dto.normal_title }"></td>
								</tr>
								<tr>
									<th>내용</th>
									<td><textarea rows="10" cols="60" id="ir1"
											name="normal_content"></textarea></td>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td><c:if
											test="${user_info_dto.user_num eq normal_board_dto.user_num }">
											<input type="submit" class="small" value="수정" />
											<input type="button" class="small" value="취소"
												onclick="location.href='home.do?command=board_detail&normal_num=${normal_board_dto.normal_num}'">
										</c:if> <input type="button" class="small" value="글 목록"
										onclick="location.href='home.do?command=board_list&normal_category=${normal_board_dto.normal_category}'">
									</td>
								</tr>
							</tfoot>
						</table>
					</form>
				</section>
			</article>

		</div>
	</div>

	<!-- Sidebar -->
	<%@ include file="../../sidebar.jsp" %>

	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="assets/js/main.js"></script>
	<!-- Smart Editor2 -->
	<script type="text/javascript" src="se2/js/service/HuskyEZCreator.js"
		charset="utf-8"></script>
	<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "ir1",
			sSkinURI : "se2/SmartEditor2Skin.html",
			htParams : {
				bUseVerticalResizer : false,
				bUseModeChanger : false
			},
			fOnAppLoad : function() {
				oEditors.getById["ir1"].exec("PASTE_HTML",
						[ "${normal_board_dto.normal_content }" ])
			},
			fCreator : "createSEditor2"
		})

		function se2() {
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", [])
		}
	</script>

</body>

</html>