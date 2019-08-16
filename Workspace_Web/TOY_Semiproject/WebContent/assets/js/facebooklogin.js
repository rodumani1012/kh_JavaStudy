(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement(s);
	js.id = id;
	js.src = "https://connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

window.fbAsyncInit = function() {
	FB.init({
		appId : '331335784179263',
		cookie : true, // enable cookies to allow the server to access the
		// session
		xfbml : true, // parse social plugins on this page
		version : 'v3.3' // use graph api version 2.8
	});
};

function checkLoginState() {
	FB.getLoginStatus(function(response) {
		statusChangeCallback(response);
	});
}

function statusChangeCallback(response) {

	console.log('response를 통해 다양한 정보를 확인할 수 있습니다.');
	console.log(response);

	if (response.status === 'connected') {
		console.log('사용자가 Facebook에 로그인하고 앱에 로그인 했습니다.');
		console.log(response.authResponse.accessToken);
		console.log(response);
		// Logged into your app and Facebook.
		testAPI();
	} else if (response.status === 'not_authorized') {
		console.log('사용자가 Facebook에 로그인했지만 앱에 로그인하지 않았습니다.');
		document.getElementById('status').innerHTML = 'Please log '
				+ 'into this app.';
	} else {
		console.log('사용자가 Facebook에 로그인하지 않았으므로 앱에 로그인했는지 알 수 없습니다.');
		document.getElementById('status').innerHTML = 'Please log '
				+ 'into Facebook.';
	}

}

function testAPI() {
	console.log('Welcome! Fetching your information.... ');
	FB.api('/me', {
		"fields" : "id,name,email,birthday,gender"
	}, function(response) {
		// Insert your code here
		console.log('페북 아이디 : ' + response.id);
		console.log('페북 이름 : ' + response.name);
		console.log('페북 이메일 : ' + response.email);
	 	 
        var facebookid = response.id;
        var facebookname = response.name;
        var facebookemail = response.email;

        document.write('<form action="../../login.do" id="sub_form" method="post">'+
                    '<input type="hidden" name="command" value="facebook">'+
                    '<input type="hidden" name="id" value="'+facebookid+'">'+
                    '<input type="hidden" name="name" value="'+facebookname+'">'+
                    '<input type="hidden" name="email" value="'+facebookemail+'">'+
                    '</form>');
        document.getElementById("sub_form").submit();
	});
}
