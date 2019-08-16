<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	onload=function(){
		var id = opener.document.getElementsByName("myid")[0].value;
		document.getElementsByName("id")[0].value = id;
	}
	
	function idConfirm(bool) {
		if(bool == "true") {
			opener.document.getElementsByName("myid")[0].title = "y";
			opener.document.getElementsByName("mypw")[0].focus();
		} else {
			opener.document.getElementsByName("myid")[0].focus();
		}
		
		self.close();
	}
</script>
</head>
<body>

<%
	String idnotused = request.getParameter("idnotused");
%>

	<table border="1">
		<tr>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td><%=idnotused.equals("true")? "아이디 생성 가능" : "중복된 아이디 존재" %></td>
							<!-- 삼항연산자 -->
		</tr>
		<tr>
			<td><input type="button" value="확인" onclick="idConfirm('<%=idnotused%>')"></td>
															<!-- 변수로 구현시키기 위해 ' '로 감싼다. -->
		</tr>
	</table>
</body>
</html>