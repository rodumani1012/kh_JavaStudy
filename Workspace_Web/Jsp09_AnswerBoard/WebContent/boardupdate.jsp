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

  <jsp:useBean id="dto" class="com.answer.dto.AnswerDto" scope="session"></jsp:useBean>

   <h1>글 수정</h1>
   
   <form action="answer.do" method="post">
   <input type="hidden" name="command" value="updateBoard_res">
   <input type="hidden" name="boardno" value="<jsp:getProperty property="boardno" name="dto"/>">
      <table border="1">
         <tr>
            <th>게시글 번호</th>
            <td><jsp:getProperty property="boardno" name="dto"/></td>
         </tr>
         <tr>
            <th>작 성 일</th>
            <td><jsp:getProperty property="regdate" name="dto"/></td>
         </tr>
         <tr>
            <th>글 쓴 이</th>
            <td><jsp:getProperty property="writer" name="dto"/></td>
         </tr>
         <tr>
            <th>제   목</th>
            <td><input type="text" name="title" value="<jsp:getProperty property="title" name="dto"/>"></td>
         </tr>
         <tr>
            <th>내   용</th>
            <td><textarea rows="10" cols="60" name="content"><jsp:getProperty property="content" name="dto"/></textarea></td>
         </tr>
         <tr>
            <td colspan="2">
               <input type="submit" value="수정완료" >
               <input type="button" value="뒤로가기" onclick="location.href='answer.do?command=boarddetail&boardno=${dto.boardno}'">
            </td>
         </tr>
      </table>
   </form>

</body>
</html>