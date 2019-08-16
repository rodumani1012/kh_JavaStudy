<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%-- 아이디, 패스워드 추출 --%>
<%
	String id = request.getParameter("id"); // 아이디
	String password = request.getParameter("password"); // 패스워드

	// 파라미터 정보를 콘솔에 출력한다. 
	//System.out.println("login_result.jsp>id=[" + id + "]");
	//System.out.println("login_result.jsp>password=[" + password + "]");
%>

<%-- 아이디 저장 체크 여부 --%>
<%
	String idSave = request.getParameter("idSave"); // 아이디 저장 체크

	// idSaveName 의 용도는 
	// 화면에 아이디 저장 체크 여부를 O 혹은 X 로 나타내기 위한 것
	// 0 : 아이디 저장 체크
	// X : 아이디 저장 미체크. 초기값
	String idSaveName = "X"; // 초기값 설정		

	// 아이디 저장이 체크되어 있을 경우,
	// idSaveName 값을 "O" 으로 설정한다.		
	if ("true".equals(idSave)) {
		idSaveName = "O";
	}
%>


<%-- Cookie 처리 --%>
<%
	if ("true".equals(idSave)) { //아이디 저장이 체크되어 있을 경우

		Cookie idCookie = new Cookie("loginId", id); //쿠키 생성. 입력값 : 이름,값

		idCookie.setMaxAge(365 * 24 * 60 * 60); //쿠기 유지 시간. 단위 초(secode). 1년 : 365*24*60*60

		response.addCookie(idCookie);

	} else { //아이디 저장이 체크되어 있지 않을 경우

		Cookie[] cookies = request.getCookies(); // 쿠키를 얻는다. 

		if (cookies != null) { // 쿠키가 존재할 경우

			for (int i = 0; i < cookies.length; i++) {

				Cookie cookie = cookies[i];
				String cookieName = cookie.getName(); // 쿠키 이름 추출

				if (cookieName.equals("loginId")) { // 쿠키 이름이 loginId 일 경우

					cookie.setMaxAge(0); //쿠키 삭제. 쿠키 유효시간을 0으로 설정한다.
					response.addCookie(cookie);
				}

			} // end : for()

		} // end: if (cookies != null) 

	} // end : if ("true".equals(idSave)) ~ else
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/lib/css/work.css">
</head>
<body>
	로그인 결과
	<hr width="80%">
	아이디 :
	<%=id%><br> 패스워드 :
	<%=password%><br> 아이디 저장 :
	<%=idSaveName%><br>
	<br>
	<a href="login.jsp">[로그인]</a>
</body>
</html>