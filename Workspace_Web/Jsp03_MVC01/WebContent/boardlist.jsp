<%@page import="java.util.List"%>
<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.0.min.js"></script>
<script type="text/javascript">
	function writeForm() {
		location.href="mycontroller.jsp?command=boardwriteform";
	}
	
	$(function(){
		$("#muldelform").submit(function() {
			if($("#muldelform input:checked").length == 0){
				alert("삭제할 글을 하나 이상 체크해 주세요");
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
</head>
<%
								// 리턴타입이 오브젝트타입이어서 캐스팅해줌(큰걸 작은걸로 형변환 할땐 강제형변환.)
	List<MVCBoardDto> list = (List<MVCBoardDto>)request.getAttribute("list");
%>
<body>

	<h1>글 목록</h1>
	
	<form action="mycontroller.jsp" method="post" id="muldelform">
		<input type="hidden" name="command" value="muldel">
		<table border="1">
			<col width="30px">
			<col width="50px">
			<col width="100px">
			<col width="300px">
			<col width="100px">
			<tr>
				<th><input type="checkbox" name="all" onclick="allChk(this.checked)"></th>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
<%
			if(list.size() == 0) {
%>
				<tr>
					<td colspan="5">========글이 존재하지 않습니다.</td>
				</tr>
<%
			} else {
				for(MVCBoardDto dto : list){
%>
				<tr>
					<td><input type="checkbox" name="chk" value="<%=dto.getSeq()%>"></td>
					<td><%=dto.getSeq()%></td>
					<td><%=dto.getWriter() %></td>
					<td><a href="mycontroller.jsp?command=selectOne&seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
					<td><%=dto.getRegdate() %></td>
				</tr>
<%
				}
			}
%>

			<tr>
				<td colspan="5">
					<input type="button" value="글쓰기" onclick="writeForm();">
					<input type="submit" value="선택삭제">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>