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

	// 이전 화면에서 전송되어 온 파라미터 값을 추출한다.
	String paramName = request.getParameter("paramName");
	String paramCount = request.getParameter("paramCount");
	int paramCountInt = Integer.parseInt(paramCount);

	// 세션에서 추출한 내용과 이전 화면에서 전송되어 온 파라미터의 값과 같은지 비교하여 처리한하다.
	for (int i = 0; i < itemList.size(); i++) {
		Item item = itemList.get(i);

		// 세션에서 추출한 상품명과 이전 화면에서 전송되어 온 상품명이 동일한 경우
		// 주문수량을 이전 화면에서 전송되어 온 수량으로 설정한다. 
		if (paramName.equals(item.getName())) {
			item.setCount(paramCountInt);
		}
	}

	// 세션에 변경된 ArrayList<Item> 객체를 추가한다.
	// 세션이 이미 존재하는 ArrayList<Item> 객체는 삭제되고 
	// 새로 추가한 객체만 존재하게 된다.
	session.setAttribute("itemList", itemList);

	// JSP 이동 방식. 다음 화면으로 이동한다. 	
	String moveUrl = "order.jsp"; // 이동할 목적지 주소
	request.getRequestDispatcher(moveUrl).forward(request, response); // 이동 명령
%>
