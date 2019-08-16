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
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
   <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
   <script>
      $(document).ready(function(){
         Kakao.init("ca5709ca7e956a98cfa95aa77ba0ef14"); // 자기 JavaScript 키 입력
         function getKakaotalkUserProfile(){
            Kakao.API.request({
               url: '/v1/user/me',
               success: function(res) {
                  $("#kakao-profile").append(res.properties.nickname);
                  $("#kakao-profile").append(res.id);
                  console.log("이름 : " + res.properties.nickname);
                  console.log("아이디 : " + res.id); 
               },
               fail: function(error) {
                  console.log(error);
               }
            });
         }
         function createKakaotalkLogin(){
            $("#kakao-logged-group .kakao-logout-btn,#kakao-logged-group .kakao-login-btn").remove();
            var loginBtn = $("<a/>",{"class":"kakao-login-btn","text":"로그인"});
            loginBtn.click(function(){
               Kakao.Auth.login({
                  persistAccessToken: true,
                  persistRefreshToken: true,
                  success: function(authObj) {
                	 setCookie("kakao_login","done",1); // 쿠키 생성(로그인)
                	 alert("카카오 로그인 성공!");
                     getKakaotalkUserProfile();
                     createKakaotalkLogout();
                  },
                  fail: function(err) {
                     console.log(err);
                  }
               });
            });
            $("#kakao-logged-group").prepend(loginBtn)
         }
         function createKakaotalkLogout(){
            $("#kakao-logged-group .kakao-logout-btn,#kakao-logged-group .kakao-login-btn").remove();
            var logoutBtn = $("<a/>",{"class":"kakao-logout-btn","text":"로그아웃"});
            logoutBtn.click(function(){
               Kakao.Auth.logout();
               alert("카카오 로그아웃 완료!");
               setCookie("kakao_login", "", -1); // 쿠키 삭제(로그아웃)
               createKakaotalkLogin();
               $("#kakao-profile").text("");
            });
            $("#kakao-logged-group").prepend(logoutBtn);
         }
         if(Kakao.Auth.getRefreshToken()!=undefined&&Kakao.Auth.getRefreshToken().replace(/ /gi,"")!=""){
            createKakaotalkLogout();
            getKakaotalkUserProfile();
         }else{
            createKakaotalkLogin();
         }
      });
   </script>
</head>
<body>


   <div id="kakao-logged-group"></div>
   <div id="kakao-profile"></div>

</body>
</html>