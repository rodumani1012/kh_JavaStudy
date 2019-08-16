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
	<title>TOY</title>
	<meta charset="utf-8" />
</head>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js">
</script>
<script type="text/javascript">
	function PageMove(page, data) {
		location.href = "<%=request.getContextPath()%>/board?category=${category }&page=" + page + "&txt_search=" + $('input#txt_search').val();
	}
</script>

<body class="is-preload">

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<header class="subhead">
				<h2>Aboard</h2>
				<a href="index.jsp">뒤로</a>
			</header>

			<table border="1">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>내용</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty list }">
							<tr>
								<td class="insert_class">작성된 글이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${list }" var="dto">
								<tr>
									<td>${dto.seq }</td>
									<td>${dto.title }</td>
									<td>${dto.content }</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>

			<table>
				<tr>
					<td colspan="5"><input type="text" id="txt_search" value="${txt_search }"> <input type="button"
							class="small" value="검색" onclick="javascript:PageMove(${paging.pageNo})">
					</td>
				</tr>
			</table>


			<!-- Pagination -->
			<div class="pagination">
				<a href="javascript:PageMove(${paging.firstPageNo})" class="button previous">&laquo;</a> <a
					href="javascript:PageMove(${paging.prevPageNo})" class="button previous">&lt;</a>
				<div class="pages">
					<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
						<c:choose>
							<c:when test="${i eq paging.pageNo}">
								<a href="javascript:PageMove(${i})" class="active">${i}</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:PageMove(${i})">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
				<a href="javascript:PageMove(${paging.nextPageNo})" class="button next">&gt;</a> <a
					href="javascript:PageMove(${paging.finalPageNo})" class="button next">&raquo;</a>
			</div>

		</div>
	</div>


</body>

</html>