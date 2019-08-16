	window.fbAsyncInit = function() {
			FB.init({
				appId : '331335784179263',
				cookie : true, // enable cookies to allow the server to access the session
				xfbml : true, // parse social plugins on this page
				version : 'v3.0' // use graph api version 2.8
			});
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		};

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

		function statusChangeCallback(response) {

			console.log('statusChangeCallback');

			if (response.status === 'connected') {
				console.log(response.authResponse.accessToken);
				// Logged into your app and Facebook.
				testAPI();
			} else if (response.status === 'not_authorized') {
				document.getElementById('status').innerHTML = 'Please log '
						+ 'into this app.';
			} else {
				document.getElementById('status').innerHTML = 'Please log '
						+ 'into Facebook.';
			}

		}

		function checkLoginState() {
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		}

		function testAPI() {
			console.log('Welcome! Fetching your information.... ');
			FB.api('/me', {
				"fields" : "id,name,email,birthday,gender"
			}, function(response) {
				// Insert your code here
				console.log('Successful login for: ' + response.name);

				document.getElementById('status').innerHTML = JSON
						.stringify(response);
			});
		}
