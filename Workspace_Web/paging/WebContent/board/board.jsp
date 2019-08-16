<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
table.table_css {
	border-collapse: separate;
	text-align: center;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	margin: 20px 10px;
}

/* top-left border-radius */
table.table_css tr:first-child th:first-child {
	border-top-left-radius: 10px;
}

/* top-right border-radius */
table.table_css tr:first-child th:last-child {
	border-top-right-radius: 10px;
}

/* bottom-left border-radius */
table.table_css tr:last-child td:first-child {
	border-bottom-left-radius: 10px;
}

/* bottom-right border-radius */
table.table_css tr:last-child td:last-child {
	border-bottom-right-radius: 10px;
}

table.table_css thead th {
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #fff;
	background: skyblue;
	margin: 20px 10px;
}

table.table_css tbody th {
	padding: 10px;
}

table.table_css td {
	font-weight: normal;
	padding: 10px;
	vertical-align: top;
	padding: 10px;
}

table.table_css .even {
	background: #E0FFFF;
}
</style>

</head>
<body>

	<h1 align = "center">게시판</h1>
	<hr/>
	<div style ="float : right">
		${member.paging_id } 님 환영합니다.
		<input type = "button" value = "글 작성" onclick = "location.href='paging.do?command=writepages'">
	</div>
	<br>
	
	<!-- 게시판 목록 -->
	<div align = "center">
		<table class = "table_css" style="margin-bottom: 10px; TABLE-layout: fixed">
			<col width = "50">
			<col width = "100">
			<col width = "350">
			<col width = "150">
			<col width = "150">
			<tr>
				<th align = "center"><input type = "checkbox" id = "chk" /></th>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan = "5" align = "center">============ 작성된 글이 없습니다. ============</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items = "${list }" var = "dto" varStatus = "status">
						<c:choose>
							<c:when test="${status.count%2 ==0 }">
								<tr>
									<td><input type = "checkbox" id = "chk"></td>
									<td class = "even">${dto.board_seq }</td>
									<td class = "even">${dto.board_title }</td>
									<td class = "even">${dto.board_id }</td>
									<td class = "even">${dto.regdate }</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td><input type = "checkbox" id = "chk"></td>
									<td>${dto.board_seq }</td>
									<td>${dto.board_title }</td>
									<td>${dto.board_id }</td>
									<td>${dto.regdate }</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
	
	
	<!-- 페이징 -->
	<jsp:include page="/paging/paging.jsp">
		<jsp:param value="${paging.page}" name="page" />
		<jsp:param value="${paging.beginPage}" name="beginPage" />
		<jsp:param value="${paging.endPage}" name="endPage" />
		<jsp:param value="${paging.prev}" name="prev" />
		<jsp:param value="${paging.next}" name="next" />
	</jsp:include>
	
	<br/>
	<!-- 검색 -->
	<div align = "center">
		<form action="paging.do" method = "get">
			<input type = "hidden" name = "command" value = "searchpage">
			
			<table>
				<tr>
					<td align = "center">
						<span>
							<select name = "item" style = "width : 95px; height: 25px; border-color: #ccc;">
								<option value="total">제목+내용</option>
	                           	<option value="title">제목</option>
	                           	<option value="content">내용</option>
	                           	<option value="id">작성자</option>
							</select>
						</span>
						<span> 
							<input type="text" name="query" style="width: 200px; height: 20px;">
	                     </span> 
	                     <span> 
	                     	<input type="submit" value="검색">   
	                     </span>
                  	</td>
                </tr>
			</table>
		</form>
	</div>
</body>
</html>