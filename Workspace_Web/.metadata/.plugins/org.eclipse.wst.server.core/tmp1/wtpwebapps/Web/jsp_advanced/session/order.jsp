<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/lib/css/work.css">
<script>

// 장바구니보기 버튼을 클릭하면,
// 폼이 전송될 목적지를 재설정하고 전송한다.
function viewCart() {	
	var formObj = document.getElementById("addForm");	// 폼 객체 변수
	formObj.action = "cart_view.jsp";	// 목적지 설정
	formObj.submit();	// 서버로 폼 내용을 전송한다. 	
}
</script>
</head>
<body>
	상품 주문
	<hr width="80%">
	<form action="cart_add.jsp" method="post" id="addForm">
		상품명 : <input type="text" name="name" required><br> 
		주문개수 : <input type="text" name="count" required><br><br>
		 <input type="submit" value="장바구니 담기"> 
		 <input type="reset" value="다시입력">
		 <input type="button" value="장바구니 보기" onclick="viewCart()"> 
	</form>
</body>
</html>