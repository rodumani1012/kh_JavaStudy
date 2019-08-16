<%@page import="com.toy.project.biz.calendar_bizimpl"%>
<%@page import="com.toy.project.biz.calendar_biz"%>
<%@page import="com.toy.project.dao.calendar_dao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map" %>
<%@page import="com.toy.project.dao.calendar_daoimpl"%>
<%@page import="com.toy.project.dto.calendar_dto"%>
<%@page import="com.toy.util.calendar_util"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	.cPreview{
		position: absolute;
		top: -30px;
		left: 10px;
		background-color: skyblue;
		width: 40px;
		height: 40px;
		text-align: center;
		line-height: 40px;
		border-radius: 40px 40px 40px 1px;
	}
</style>


<link rel="stylesheet" href="assets/css/main.css" />
</head>

<%
	Map<String, Integer> map = (Map<String, Integer>)request.getSession().getAttribute("calendar_map");
	String prj_num = (String)request.getSession().getAttribute("prj_num_session");
	String yyyyMM = String.valueOf(map.get("year"))+
			(String.valueOf(map.get("month")).length() < 2 ? "0"+String.valueOf(map.get("month")) : String.valueOf(map.get("month")));
	calendar_biz biz = new calendar_bizimpl();
	List<calendar_dto> list = biz.selectList(prj_num, yyyyMM);
	int day_of_week = map.get("day_of_week");
%>

<body>
	<div id="content">
			<table id="calendar">
				<caption>
					 <a href="calendar.do?command=new_calendar&button=year_minus&year=${calendar_map.year}&month=${calendar_map.month}" >◁</a> <!-- 1년 전으로 -->
					 <a href="calendar.do?command=new_calendar&button=month_minus&year=${calendar_map.year}&month=${calendar_map.month}">◀</a> <!-- 1달 전으로 -->
					 
					 <span class="y">${calendar_map.year }</span>년
					 <span class="m">${calendar_map.month}</span>월
					 
					 <a href="calendar.do?command=new_calendar&button=month_plus&year=${calendar_map.year}&month=${calendar_map.month}">▶</a> <!-- 1달 뒤로 -->
					 <a href="calendar.do?command=new_calendar&button=year_plus&year=${calendar_map.year}&month=${calendar_map.month}">▷</a> <!-- 1년 뒤로 -->
					 
					 <input type="button" value="이번달" onclick="location.href='calendar.do?command=calendar&prj_num=${prj_num_session }'">
				</caption>
				<tr>
					<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
				</tr>
				<tr>
					<c:forEach begin="1" end="${calendar_map.day_of_week-1 }">
						<td></td>
					</c:forEach>
<%
					for(int i = 1; i < map.get("last_day"); i++) {
%>
						<td>
							<a class="countView" href="calendar.do?command=calendar_list&year=${calendar_map.year}&month=${calendar_map.month}&date=<%=i %>" style="color: <%=calendar_util.fontColor(i, day_of_week)%>">
								<%=i %>
							</a>
							<a href="calendar.do?command=cal_issue_insert">
									<img alt="" src="${pageContext.request.contextPath }/assets/css/images/pen.png" style="width: 10px; height: 10px;"/>
							</a>
							<div class="callist">
								<%=calendar_util.getCalView(i, list) %>
							</div>
						</td>
<%
						// 새로운 줄 (dayOfWeek-1+i) % 7 == 0
						if((map.get("day_of_week")-1+i) % 7 == 0) {
%>
							<tr></tr>
<%				
						}
					}
					for(int i = map.get("end_day_of_week"); i < 7; i++) {
%>
						<td></td>
<%
					}
%>
				</tr>
			</table>
	</div>
	
	<%@ include file= "../project_sidebar.jsp"%>
	
	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="assets/js/prj.js?ver=1"></script>
	<script src="http://localhost:8000/socket.io/socket.io.js"></script>
	<script src="assets/chat/static/js/index.js?ver=1"></script>
</body>
</html>