<%@page import="java.util.List"%>
<%@page import="com.cal.dao.CalDao"%>
<%@page import="com.cal.dto.CalDto"%>
<%@page import="com.cal.util.Util"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#calendar{
		border-collapse: collapse;
		border: 1px solid gray;
	}
	
	#calendar th{
		width: 80px;
		border: 1px solid gray;
	}
	
	#calendar td{
		width: 80px;
		height: 80px;
		border: 1px solid gray;
		text-align: left;
		vertical-align: top;
		position: relative;
	}
	
	a{
		text-decoration: none;
	}
	
	.clist > p {
		font-size: 5px;
		margin: 1px;
		background-color: skyblue;
	}
	
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

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		$(".countView").hover(function(){ //첫번째 function은 마우스가 올라갔을 때.
			var aCountView = $(this); // 마우스 올린 a태그
			var aDate = aCountView.text().trim(); // 마우스 올린 날짜를 공백제거해서 가져옴
			var year = $(".y").text().trim(); // 최상단에 있는 년
			var month = $(".m").text().trim(); // 최상단에 있는 월
			var yyyyMMdd = year + isTwo(month) + isTwo(aDate);
			
			$.ajax({
				url:"CalCountAjax.do", // 보낼 곳
				data:"id=kh&yyyyMMdd="+yyyyMMdd, // 보내줄 데이터
				dataType:"json", // 받을 데이터 형식
				success:function(msg){
					var cnt = msg.cnt;
					aCountView.after(
							"<div class='cPreview'>" + cnt + 
							"</div>");
				},
				error:function(){
					alert("서버 통신 실패");
				}
			});
			
		}, function(){  //두번째 function은 마우스가 빠졌을 때
			$(".cPreview").remove();
		});
	});
	
	function isTwo(date){
		return (date.length < 2) ? "0"+date : date;
	}
</script>

</head>
<%
	Calendar cal = Calendar.getInstance();

	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH) + 1; // 월은 0부터 시작
	
	String paramYear = request.getParameter("year");
	String paramMonth = request.getParameter("month");
	
	if (paramYear != null) {
		year = Integer.parseInt(paramYear);
	}
	if (paramMonth != null) {
		month = Integer.parseInt(paramMonth);
	}
	
	if (month > 12) {
		month = 1;
		year++;
	}
	if (month < 1) {
		month = 12;
		year--;
	}
	
	// 1. year년 month월 1일 설정
	cal.set(year, month-1, 1);
	
	// 2. 1일의 요일 찾아오기
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	
	// 3. 해당 월의 마지막 일 찾아오기
	int lastDay = cal.getActualMaximum(Calendar.DATE);
	
	// 4. 해당 월의 마지막 요일 찾아오기
	cal.set(Calendar.DATE, lastDay);
	int endDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	
	// 달력에 일정 표현할 리스트
	CalDao dao = new CalDao();
	String yyyyMM = year + Util.isTwo(String.valueOf(month));
	List<CalDto> list = dao.getCalViewList("kh", yyyyMM);
%>
<body>

	<table id="calendar">
		<caption>
			 <a href="calendar.jsp?year=<%=year-1%>&month=<%=month%>">◁</a> <!-- 1년 전으로 -->
			 <a href="calendar.jsp?year=<%=year%>&month=<%=month-1%>">◀</a> <!-- 1달 전으로 -->
			 
			 <span class="y"><%=year %></span>년
			 <span class="m"><%=month %></span>월
			 
			 <a href="calendar.jsp?year=<%=year%>&month=<%=month+1%>">▶</a> <!-- 1달 뒤로 -->
			 <a href="calendar.jsp?year=<%=year+1%>&month=<%=month%>">▷</a> <!-- 1년 뒤로 -->
		</caption>
		<tr>
			<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
		</tr>
		<tr>
<%
			// 공백(1일의 요일만큼 <td>)
			for(int i = 1; i < dayOfWeek; i++) {
%>
				<td></td>
<%
			}
			// 숫자 들어있는 <td>
			for(int i = 1; i < lastDay + 1; i++ ) {
%>
				<td>
					<a class="countView" href="calendar.do?command=callist&year=<%=year %>&month=<%=month %>&date=<%=i %>" style="color: <%=Util.fontColor(i, dayOfWeek)%>"><%=i %></a>
					<a href="insertcalboard.jsp?year=<%=year%>&month=<%=month%>&date=<%=i%>&lastday=<%=lastDay%>">
						<img alt="" src="image/pen.png" style="width: 10px; height: 10px;"/>
					</a>
					<div class="clist">
						<%=Util.getCalView(i, list) %>
					</div>
				</td>
<%
			// 새로운 줄 (dayOfWeek-1+i) % 7 == 0
				if((dayOfWeek-1+i) % 7 == 0) {
%>
				<tr></tr>
<%				
				}
			}
			// 마지막 날의 요일만큼 빈칸 채우기.  강사님 => for(int i = 0; i < (7-(dayOfWeek-1+lastDay)%7)%7; i++) { <td></td> }
			for(int i = endDayOfWeek; i < 7; i++) {
%>
				<td></td>
<%
			}
%>
		</tr>
	</table>

</body>
</html>