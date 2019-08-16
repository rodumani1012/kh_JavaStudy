<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- bean : bean이라고 써있는 것은 객체를 만드는 것이라고 보면 된다.
	jsp:bean => jsp에서 객체 만들어서 쓸거야~ -->
	<h1>jsp:useBean 을 통한 객체생성</h1>
	
	<!-- scope : 범위 지정도 가능. dtos라는 아이디로 객체 생성.
		ex) MyMVCDto dtos = new MyMVCDto(); 와 같음 -->
	<jsp:useBean id="dtos" class="com.mvc.dto.MyMVCDto" scope="page"></jsp:useBean>
	
	<!-- setter.  dtos가 가진 객체 seq에 123을 셋팅해주세요.
		dtos.setSeq(123); -->
	<jsp:setProperty property="seq" name="dtos" value="123"/>
	<jsp:setProperty property="writer" name="dtos" value="홍길동"/>
	
	<!-- getter.  dtos가 가진 seq를 출력해주세요. -->
	<jsp:getProperty property="seq" name="dtos"/>
	<jsp:getProperty property="writer" name="dtos"/>
	
	<jsp:useBean id="abc" class="com.mvc.dto.MyMVCDto" scope="session"></jsp:useBean>
	<jsp:setProperty property="writer" name="abc" value="김선달"/>
	<!-- abc로 set 해준 값(value)를 res.jsp로 전달 -->
	<input type="button" value="값 전달" onclick="location.href='res.jsp'">
	
	
</body>
</html>