<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.jspbasic.Item"%>
<%@ page import="java.util.ArrayList,java.util.List"%>

<%
	request.setCharacterEncoding("utf-8");//한글처리
%>
<%
	// 세션에서 ArrayList<Item> 객체를 가져온다. 
	// 객체가 존재하지 않을 경우, 신규로 생성한다.
	ArrayList<Item> itemList = (ArrayList<Item>) session.getAttribute("itemList");
	if (itemList == null) {
		itemList = new ArrayList<Item>();
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/lib/css/work.css">
<script>
	function modifyCount(nameId, cntId) {

		var formObj = document.getElementById("listForm");
		var nameObj = document.getElementById(nameId); // 변경 상품명
		var cntObj = document.getElementById(cntId); // 변경 주문수량

		var paramNameObj = document.getElementById("paramName"); // 상품명 파라미터
		paramNameObj.value = nameObj.value;

		var paramCountObj = document.getElementById("paramCount"); // 주문수량 파라미터
		paramCountObj.value = cntObj.value;

		formObj.submit();
	}
</script>
</head>
<body>
	장바구니
	<hr width="80%">
	<form id="listForm" action="cart_modify.jsp" method="post">
		<input type="hidden" id="paramName" name="paramName" value="0">
		<input type="hidden" id="paramCount" name="paramCount" value="0">
		<table>
			<tr>
				<th>상품명</th>
				<th>주문개수</th>
				<th>수정</th>
			</tr>
			<%
				for (int i = 0; i < itemList.size(); i++) {
					Item item1 = itemList.get(i);
			%>
			<tr>
				<td><input type="text" value="<%=item1.getName()%>"
					id="name<%=i%>" name="name<%=i%>" readonly></td>
				<td><input type="text" value="<%=item1.getCount()%>"
					id="cnt<%=i%>" name="cnt<%=i%>"></td>
				<td><input type="button" value="수정"
					onclick="modifyCount('name<%=i%>', 'cnt<%=i%>')"></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
	<br>
	<br>
	<a href="order.jsp">[ 상품추가 ]</a>
</body>
</html>