<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.muldel.dao.MDBoardDao" %>
<%@ page import="com.muldel.dto.MDBoardDto" %>
<%@ page import="java.util.List" %>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-3.4.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#muldelform").submit(function() {
			if($("#muldelform input:checked").length == 0){
				alert("삭제할 글을 하나 이상 체크해 주세요~");
				return false; // submit의 action을 실행시키지 않음
			}
		});
		
		$("input[name=chk]").click(function(){
            if($("input[name=chk]").length == 
                $("input[name=chk]:checked").length){ //기존 chk와 체크된 chk의 길이가 같은 경우
                    // 전부 다 체크되어 있을 경우
                    $("input[name=all]").prop("checked",true);
            } else {
                $("input[name=all]").prop("checked",false);
            }
        });
	});
	
	function allChk(bool) {
		$("input[name=chk]").each(function(){
			$(this).prop("checked",bool);
		});
	}
	
</script>
<%
	MDBoardDao dao = new MDBoardDao();
	List<MDBoardDto> list = dao.selectList();
%>

<body>

	<%@ include file="./form/header.jsp" %> <!-- 호출한 폴더 기준! -->
	<!-- @ include : 문서를 포함 시킴. -->
	<!-- / root (가장 최상위 폴더)
		./ 같은 폴더
		../ 상위 폴더 -->
	
	<h1>글 목록</h1>
	
	<form action="./muldel.jsp" method="post" id="muldelform">
		<table border="1">
			<col width="30px">
			<col width="50px">
			<col width="100px">
			<col width="300px">
			<col width="100px">			
			<tr>
				<th>
					<input type="checkbox" name="all" onclick="allChk(this.checked)">
				</th>
				<th>번호</th>
				<th>작성자</th>
				<th>제 목</th>
				<th>작성일</th>
			</tr>
<%
			if(list.size() == 0) {
%>
			<tr>
				<td colspan="5">---------글이 존재하지 않습니다.</td>
			</tr>
<%
			} else {
				for(int i = 0; i < list.size(); i++) {
%>
			<tr>
				<td><input type="checkbox" name="chk" value="<%=list.get(i).getSeq() %>"></td>
				<td><%=list.get(i).getSeq() %></td>
				<td><%=list.get(i).getWriter() %></td>
				<td><a href="selectOne.jsp?seq=<%=list.get(i).getSeq() %>"><%=list.get(i).getTitle() %></a></td>
				<td><%=list.get(i).getRegedate() %></td>
			</tr>
<%
				}
			}
%>
		<tr>
			<td colspan="5">
				<input type="button" value="글쓰기" onclick="location.href='insert.jsp'">
				<input type="submit" value="선택삭제">
			</td>
		</tr>
		</table>	
	</form>
	
	
	<%@ include file="./form/footer.jsp" %>

</body>
</html>