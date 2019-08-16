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
 
   <h1>회원가입</h1>
   
   <form action="logincontroller.do" method="post">
      <input type="hidden" name="command" value="insertuser">
      <table border="1">
         <tr>
            <th>아이디</th>
            <td>
               <input type="text" name="id" title="n" required="required">
               <input type="button" value="중복체크" onclick="">
            </td>
         </tr>
         <tr>
            <th>비밀번호</th>
            <td><input type="text" name="pw" required="required"></td>
         </tr>
         <tr>
            <th>이   름</th>
            <td><input type="text" name="name" required="required"></td>
         </tr>
         <tr>
            <th>주   소</th>
            <td><input type="text" name="addr" required="required"></td>
         </tr>
         <tr>
            <th>전화번호</th>
            <td><input type="text" name="phone" required="required"></td>
         </tr>
         <tr>
            <th>이메일</th>
            <td><input type="text" name="email" required="required"></td>
         </tr>
         <tr>
            <td colspan="2">
               <input type="submit" value="회원가입">
               <input type="button" value="취소" onclick="location.href='index.jsp'">
            </td>
         </tr>
      </table>
   </form>

</body>
</html>