<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="javax.management.MBeanConstructorInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	
	function allChk(bool){
		if($("input[name=all]:checked")){
			$("input[name=chk]").prop("checked",bool);
		}else{
			$("input[name=chk]").prop("checked",bool);
		}
	}
	$(function(){
		$("input[name=chk]").click(function(){
			if($("input[name=chk]").length == $("input[name=chk]:checked").length){
				$("input[name=all]").prop("checked",true);
			}else {
				$("input[name=all]").prop("checked",false);
			}
		});
		$("#muldelform").submit(function(){
			if($("input[name=chk]:checked").length == 0){
				alert("하나 이상 체크해주세요");
				return false;
			}
		});
	});
</script>

<script type="text/javascript">

	function writeForm(){
		location.href="controller.do?command=boardwriteform";
	}
</script>
</head>
<%
	List<MVCBoardDto> list = (List<MVCBoardDto>)request.getAttribute("list");
	
	//게시판 총개수
	int count = (int)request.getAttribute("count");
	System.out.println(count);
	//int board=0;
%>
<body>

	<h1>글 목록</h1>
	
	<form action="controller.do" method="post" id="muldelform">
		<input type="hidden" name="command" value="muldel"/>
		<table border="1">
			<col width="30px"/>
			<col width="50px"/>
			<col width="100px"/>
			<col width="300px"/>
			<col width="100px"/>
		<tr>
			<th><input type="checkbox" name="all" onclick="allChk(this.checked)"></th>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
<%
		if(list.size() == 0){
%>
			<tr>
				<td colspan="5">===========글이 존재하지 않습니다.===========
			</tr>
<%
		}else{
			for(MVCBoardDto dto : list){
%>
			<tr>
				<td><input type="checkbox" name="chk" value="<%=dto.getSeq() %>"></td>
				<!-- <td><%=dto.getSeq() %></td> -->
				<!-- 게시판 개수 -->
				<td>

					<%=count %>
<%	
						count--;
%>
				</td>
				<td><%=dto.getWriter() %></td>
				<td><a href="controller.do?command=selectone&seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
				<td><%=dto.getRegdate() %></td>
			</tr>
<%
			}
		}
%>

		<tr>
			<td colspan="5">
				<input type="button" value="글쓰기" onclick="writeForm()">
				<input type="submit" value="선택삭제"/>
			</td>
		</tr>
		</table>
			
		
	</form>
</body>
</html>