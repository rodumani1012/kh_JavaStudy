<%@page import="com.my.dto.MyBoardDto"%>
<%@page import="com.my.dao.MyBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% 
	int myno = Integer.parseInt(request.getParameter("myno"));
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(myno);
%>
<script type="text/javascript">
	function del(){
		if(confirm("진짜로?")==true) {
			location.href="mydelete.jsp?myno=<%= dto.getMyno()%>";
		} else {
			location.href="myselect.jsp?myno=<%= dto.getMyno()%>";
		}
	}

</script>

</head>
<body>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<td><%=dto.getMyname() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%= dto.getMytitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="60" readonly="readonly"><%= dto.getMycontent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="location.href='myupdate.jsp?myno=<%= myno%>'"> 
														<!-- myno로 하든 dto.getMyno()로 하든 상관없음 -->
				<input id="del" type="button" value="삭제" onclick="del()">
				<input type="button" value="목록" onclick="location.href='myboard.jsp'">
			</td>
		</tr>
	</table>	
</body>
</html>