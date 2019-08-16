<%@page import="com.cal.dao.CalDao"%>
<%@page import="com.cal.dto.CalDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("form").submit(function(){
			if($("form input:checked").length == 0) {
				alert("하나 이상 체크해주세요.");
				return false;
			}
		});
		
		$("input[name=chk]").click(function(){
			if($("input[name=chk]").length == $("input[name=chk]:checked").length) {
				$("input[name=all]").prop("checked", true);
			} else {
				$("input[name=all]").prop("checked", false);
			}
		});
	});

	function allChk(bool) {
		$("input[name=chk]").each(function(){
			$(this).prop("checked", bool);
		});
	}
</script>
</head>
<body>

	<h1>일정 목록 보기</h1>
	
	<jsp:useBean id="util" class="com.cal.util.Util"></jsp:useBean>	
	
	<form action="calendar.do" method="post">
		<input type="hidden" name="command" value="muldel">
		<table border="1">
			<col width="50px">
			<col width="50px">
			<col width="300px">
			<col width="200px">
			<col width="100px">
			
			<tr>
				<th><input type="checkbox" name="all" onclick="allChk(this.checked)"></th>
				<th>번  호</th>
				<th>제  목</th>
				<th>일  정</th>
				<th>작성일</th>			
			</tr>
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="5">=========일정이 없습니다=========</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="dto">
							<input type="hidden" name="mdate" value="${dto.mdate }">
						<tr>
							<td><input type="checkbox" name="chk" value="${dto.seq }"></td>
							<td>${dto.seq }</td>
							<td><a href="calendar.do?command=caldetail&seq=${dto.seq }">${dto.title }</a></td>
							<td>
								<jsp:setProperty property="toDates" name="util" value="${dto.mdate }"/>
								<jsp:getProperty property="toDates" name="util"/>
							</td>
							<td>
								<fmt:formatDate value="${dto.regdate }" pattern="yyyy/MM/dd"/>
							</td>
						</tr>					
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="5">
					<input type="submit" value="삭제">
					<input type="button" value="돌아가기" onclick="location.href='calendar.do?command=calendar'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>