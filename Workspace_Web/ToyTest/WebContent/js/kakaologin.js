    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('ca5709ca7e956a98cfa95aa77ba0ef14');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function getKakaotalkUserProfile(){
    	  // 이름과 아이디를 요청합니다.
          Kakao.API.request({
              url: '/v1/user/me',
              success: function(res) {
                 console.log("이름 : " + res.properties.nickname);
                 console.log("아이디 : " + res.id); 
              },
              fail: function(error) {
                 console.log(error);
              }
           });
        },
      fail: function(err) {
         alert(JSON.stringify(err));
      }
    });
