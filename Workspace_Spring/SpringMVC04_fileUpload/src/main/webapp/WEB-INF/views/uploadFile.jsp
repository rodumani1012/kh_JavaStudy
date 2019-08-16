<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html; charset=UTF-8");%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	파일명 : ${fileobj.filename }<br/>
	설   명 : ${fileobj.desc }

	<form action="download" method="post">
		<input type="hidden" name="filename" value="${fileobj.filename }" />
		<input type="submit" value="DOWNLOAD" />
	</form>

	<!-- 
		mime(Multipurpose Internet Mail Extension) type : 
			request header에 지정되는
			데이터가 어떤 종류의 stream인지 알려주는 프로토콜.
			서버에서 사용할 수 있는 특정 파일들을 web.xml에 미리 저장해 둠
		
		mime type 은 Servers 폴더에 tomcat web.xml에 있다.
		
		ex)
		한글파일 처리하기
	    <mime-mapping>
	        <extension>hwp</extension>
	        <mime-type>application/unknown</mime-type>
	    </mime-mapping>
	 -->

</body>
</html>


