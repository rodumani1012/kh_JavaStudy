<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html; charset=UTF-8");%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- enctype : 파일 업로드를 위한 속성.
	 modelAttribute : @ModelAttribute() 할때 쓸 커맨드 객체 이름.
	 input tag의 name이 file인 애와 textarea의 이름이 desc인에의 값이 UploadFile에 set됨.
-->
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile"
	 action="upload">
		<h3>업로드 할 파일 선택</h3>
		파일 : <input type="file" name="file" /><br/>
		<!-- 파일 업로드 안했을 시 보여줄 에러 문구 -->
		<p style="color: red; font-weight: bold;">
		<!-- form:errors 는 path에 써있는 특정 프로퍼티와 관련된
			 에러정보를 출력할 수 있다.
			 UploadFile에 있는 file이라는 필드에 대해서 에러가 났다!
			 errors.rejectValue에서 file에 에러메세지를 출력함 -->
			<form:errors path="file" />
		</p><br/>
		설명 : <br/>
		<textarea rows="10" cols="40" name="desc" ></textarea><br/>
		<input type="submit" value="전송">
	</form:form>
	<!-- 
		spring form:  tag
		form:form, form:input, form:errors, ...
		form:errors => Erros, BindingResult를 사용할 때 
			command객체의 특정 field에서 발생하는 에러메세지를 출력하게 함.
	 -->
	 
	 <!-- 
	 	form tag의 enctype 속성 3가지
	 	1. application/www-form-urlencoded : (default) 문자들이 encoding 되어 넘어감.
	 	2. multipart/form-data : file upload를 가능하게 해줌. (post)
	 	3. text/plain : encoding 안되고 넘어감
	  -->


</body>
</html>