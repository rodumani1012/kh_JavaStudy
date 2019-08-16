<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="project.login.*"%>
<%@ page import="java.util.*"%>
<%--
	System.out.println("manager.jsp::\t\t세션 Id=" + session.getId());
--%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%-- Database --%>
<%
	MemberDBManager memberDBManager = new MemberDBManager("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
	ArrayList<Member> memberList = memberDBManager.selectMemberListAll();
%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
<title>관리자</title>
</head>
<body>
	<!-- 메뉴 : Start -->
	<a href="home.jsp">Home</a> | {관리자}
	<hr width="80%">
	<!-- 메뉴 : End -->


	<%-- 데이터 출력 --%>
	<%-- 	<%
		for (int i = 0; i < memberList.size(); i++) {
			Member member = memberList.get(i);
			out.print(member.getId());
			out.print("," + member.getPassword());
			out.print("," + member.getName());
			out.print("," + member.getEmail());
			out.print("," + member.getRegdate());
			out.print("<br>");		
	%> --%>

	<%-- 데이터 출력 : 테이블 버전 --%>
	<%
		if (memberList.size() > 0) {

			out.print("<table border='1'>");
			out.print("<caption>회원 명단</caption>");
			out.print("<tr><td>번호</td><td>아이디</td><td>비밀번호</td><td>이름</td><td>Email</td><td>등록일시</td></tr>");

			for (int i = 0; i < memberList.size(); i++) {
				Member member = memberList.get(i);

				out.print("<tr>");
				out.print("<td>" + (i + 1) + "</td>");
				out.print("<td>" + member.getId() + "</td>");
				out.print("<td>" + member.getPassword() + "</td>");
				out.print("<td>" + member.getName() + "</td>");
				out.print("<td>" + member.getEmail() + "</td>");
				out.print("<td>" + member.getRegdate() + "</td>");
				out.print("</tr>");
			}

			out.print("<table>");
		}
	%>
</body>
</html>