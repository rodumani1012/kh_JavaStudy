<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="paging.css">
<title>::페이징을 설명하기위한 페이지^^</title>
</head>
<body>
	<div style="text-align: center;">


		<div class="main">
			<c:if test="${pag.prev }">
				<div class="commonL"
					onclick="location.href='boardController.do?command=selectlist&contentnum=3&pagenum=${pag.pagenum-1}'"></div>
			</c:if>
			<c:forEach items="${list }" var="dto">
				<div class="common">${dto.seq }<p class="content">${dto.title }</p></div>
			</c:forEach>
			<c:if test="${pag.next }">
				<div class="commonR"
					onclick="location.href='boardController.do?command=selectlist&contentnum=3&pagenum=${pag.pagenum+1}'"></div>
			</c:if>
		</div>


		<div class="paging">

			<c:forEach begin="${pag.startPage }" end="${pag.endPage }" var="idx">
				<c:choose>
					<c:when test="${pag.pagenum==idx}">
						<span id="now"><b><c:out value="【${idx }】"></c:out></b></span>
					</c:when>
					<c:otherwise>
						<a
							href="boardController.do?command=selectlist&contentnum=3&pagenum=${idx}">
							<span id="notnow"><b><c:out value="【${idx }】"></c:out></b></span>
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>


			<a id="button" href="boardController.do?command=insertDB&contentnum=3">InsertData</a>
		</div>
	</div>
</body>
</html>