<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
		$("#muldelform").submit(function(){
			if($("#muldelform input:checked").length == 0) {
				alert("삭제할 글을 하나 이상 체크해주세요.");
				return false;
			} 
		});
		
		$("input[name=chk]").click(function(){
			if($("input[name=chk]").length ==
				$("input[name=chk]:checked").length) {
				$("input[name=all]").prop("checked", true);
			} else {
				$("input[name=all]").prop("checked", false);
			}
		}); 
	});
	
	function allChk(bool) {
		$("input[name=chk]").each(function(){
			$(this).prop("checked",bool);
		});
	}
</script>
</head>
<body>

	<h1>글 목록</h1>
	
	<form action="muldel.spr" method="post" id="muldelform">
	<input type="hidden" id="dellist">
		<table border="1">
			<col width="50">
			<col width="100">
			<col width="100">
			<col width="300">
			<col width="100">
			
			<tr>
				<th>
					<input type="checkbox" name="all" onclick="allChk(this.checked)">
				</th>
				<th>번  호</th>
				<th>작성자</th>
				<th>제  목</th>
				<th>작성일</th>
			</tr>
			
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="4" align="center">-----------작성된 글이 존재하지 않습니다.-----------</td>
					</tr>
				</c:when>
				<c:otherwise> <%-- list가 null이 아닌 무언가 있을 경우 --%>
					<c:forEach items="${list }" var="dto">
						<tr>
							<td><input type="checkbox" name="chk" value="${dto.seq }"></td>
							<td>${dto.seq } </td>
							<td>${dto.writer } </td>
							<td><a href="selectOne.spr?seq=${dto.seq }">${dto.title } </a></td>
							<td>${dto.regdate } </td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
			<tr>
				<td colspan="5">
					<input type="button" value="글쓰기" onclick="location.href='insert.spr'">
					<input type="submit" value="선택삭제">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>