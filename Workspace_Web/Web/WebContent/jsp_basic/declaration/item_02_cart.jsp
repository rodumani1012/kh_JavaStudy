<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.jspbasic.Item" %>
<%@ page import="java.util.ArrayList, java.util.List" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%!
	ArrayList<Item> itemList = new ArrayList<Item>();
%>
<%
	String name = request.getParameter("name");
	String count = request.getParameter("count");
	int countInt = Integer.parseInt(count);
	
	Item item = new Item(name, countInt);
	itemList.add(item);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
<title>Insert title here</title>
</head>
<body>
	주문 정보
	<hr width="80%">
	<table>
		<tr>
			<th>상품명</th>
			<th>주문개수</th>
		</tr>
		<%
			for (int i = 0; i < itemList.size(); i++) {
				Item item1 = itemList.get(i);
		%>
		<tr>
			<td><%=item1.getName() %></td>
			<td><%=item1.getCount() %></td>
		</tr>
		<%
			}
		%>
		<tr>
	</table>
	<a href="item_01_order.jsp">[ 상품 추가 ]</a>

</body>
</html>