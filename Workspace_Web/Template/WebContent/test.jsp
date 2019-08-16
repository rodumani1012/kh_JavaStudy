<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function change() {
		$("#hdd").css("color", "rgba(255,0,0,0.3)");
	}
</script>
</head>
<body>


	<h1 id="hdd">ㅎㅇ</h1>
	<button onclick="change()">변경!</button>
</body>
</html>